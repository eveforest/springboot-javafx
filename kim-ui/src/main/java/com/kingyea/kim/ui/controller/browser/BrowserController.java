package com.kingyea.kim.ui.controller.browser;

import com.kingyea.kim.common.model.token.ApiToken;
import com.kingyea.kim.common.model.token.Token;
import com.kingyea.kim.core.cache.NormalCache;
import com.kingyea.kim.core.cache.TokenCache;
import com.kingyea.kim.core.constant.CoreConstant;
import com.kingyea.kim.core.constant.CoreVariable;
import com.kingyea.kim.ui.constant.UIConstant;
import com.kingyea.kim.ui.util.UrlUtil;
import com.kingyea.kim.ui.view.browser.BrowserManager;
import com.kingyea.kim.ui.view.panel.TitleBarView;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.WebStorage;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.FrameLoadEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.events.StartLoadingEvent;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class BrowserController {
    private final static Logger logger = LoggerFactory.getLogger(BrowserController.class);

    @FXML
    private StackPane browserPane;

    @Autowired
    private BrowserManager browserManager;
    @Autowired
    private TitleBarView titleBarView;
    @Autowired
    private TokenCache tokenCache;
    @Autowired
    private NormalCache normalCache;

    @FXML
    public void initialize() {
        logger.info("browserPane init");
        browserManager.init(UIConstant.DEFAULT_HOME_URL);

        BrowserView browserViewPane = browserManager.getBrowserView();

        ToolBar titleBar = browserManager.getTitleBar(titleBarView.getView());
        browserViewPane.getChildren().add(titleBar);
        StackPane.setAlignment(titleBar,Pos.TOP_RIGHT);

        browserPane.getChildren().clear();
        browserPane.getChildren().add(browserViewPane);

        //添加浏览器页面加载监听
        saveLoginTokenToBrowser();
    }

    private void saveLoginTokenToBrowser() {
        Browser browser = browserManager.getBrowser();
        browser.addLoadListener(new LoadAdapter() {
            @Override
            public void onStartLoadingFrame(StartLoadingEvent event) {
//                browserManager.clear();
            }

            @Override
            public void onFinishLoadingFrame(FinishLoadingEvent event) {
                String validatedURL = event.getValidatedURL();
                if (StringUtils.equalsIgnoreCase(validatedURL, UrlUtil.getWebUrl(UIConstant.KEY_HOME_PAGE))) {
                    WebStorage localWebStorage = browser.getLocalWebStorage();
                    String token = localWebStorage.getItem("token");
                    System.out.println(token);
                }
            }

            @Override
            public void onDocumentLoadedInFrame(FrameLoadEvent event) {
                WebStorage localWebStorage = browser.getLocalWebStorage();

                String userName = normalCache.get(CoreConstant.CURRENT_USERNAME);

                Token token = tokenCache.get(CoreConstant.API_TOKEN_PREF+"even");
                if (token != null) {
                    ApiToken apiToken = (ApiToken) token;
                    String accessToken = apiToken.getAccessToken();
                    String refreshToken = apiToken.getRefreshToken();

                    localWebStorage.setItem("token", accessToken);
                    localWebStorage.setItem("retoken", refreshToken);
                } else {
                    localWebStorage.clear();
                }
            }
        });
    }

}
