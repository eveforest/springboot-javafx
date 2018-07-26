package com.kingyea.kim.ui.view.browser;

import com.kingyea.kim.ui.constant.UIConstant;
import com.kingyea.kim.ui.util.StageUtil;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.BrowserType;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;
import javafx.scene.Parent;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.StackPane;
import org.springframework.stereotype.Component;

@Component
public class BrowserManager {
    private StackPane browserStackPane;
    private BrowserView browserView;
    private Browser browser;
    private String webUrl;
    private static double titlePrefWidth = UIConstant.CONTENT_MIN_WIDTH - 14;
    private ToolBar titleBar;

    public BrowserManager() {

    }

    public BrowserManager(String webUrl) {
        init(webUrl);
    }


    public StackPane getBrowserStackPane(String webUrl) {
        init(webUrl);
        return browserStackPane;
    }

    public StackPane getBrowserStackPane() {
        if (this.webUrl == null) {
            browserStackPane = null;
        }
        return browserStackPane;
    }

    public BrowserView getBrowserView(String webUrl) {
        init(webUrl);
        return browserView;
    }

    public BrowserView getBrowserView() {
        if (this.webUrl == null) {
            browserView = null;
        }
        return browserView;
    }

    public void setBrowserStackPane(StackPane browserStackPane) {
        this.browserStackPane = browserStackPane;
    }

    public void setBrowserView(BrowserView browserView) {
        this.browserView = browserView;
    }

    public Browser getBrowser() {
        return browser;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void init(String webUrl) {
        this.webUrl = webUrl;
        if (browser == null) {
            browser = new Browser(BrowserType.LIGHTWEIGHT);
        }
        browser.loadURL(this.webUrl);
        browserView = new BrowserView(browser);
        browserView.setPrefSize(UIConstant.ROOT_STAGE_MIN_WIDTH-80,UIConstant.ROOT_STAGE_MIN_HEIGHT);
        if (browserStackPane == null) {
            browserStackPane = new StackPane();
        }

        browserStackPane.getChildren().clear();
        browserStackPane.getChildren().add(browserView);
        browserStackPane.setPrefSize(UIConstant.ROOT_STAGE_MIN_WIDTH-80,UIConstant.ROOT_STAGE_MIN_HEIGHT);
    }

    public void reLoadUrl(String webUrl) {
        if (browser != null){
            browser.loadURL(webUrl);
        }
    }

    public void clear() {
        if (browser != null) {
            browser.getLocalWebStorage().clear();
            browser.getCacheStorage().clearCache();
        }
    }

    public void close() {
        if (browser != null) {
            browser.dispose();
        }
    }

    public ToolBar getTitleBar(Parent title) {
        this.titleBar = new ToolBar(title);
        title.setStyle("-fx-pref-width: "+titlePrefWidth);
        titleBar.setStyle("-fx-background-color: null;");
        StageUtil.addDragFun(titleBar);
        return titleBar;
    }

    public void setTitleBar(ToolBar titleBar) {
        this.titleBar = titleBar;
    }

}
