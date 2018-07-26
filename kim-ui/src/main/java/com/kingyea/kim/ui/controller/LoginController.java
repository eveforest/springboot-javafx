package com.kingyea.kim.ui.controller;

import com.kingyea.kim.core.cache.TokenCache;
import com.kingyea.kim.core.services.login.LoginService;
import com.kingyea.kim.ui.KimApp;
import com.kingyea.kim.ui.util.StageUtil;
import com.kingyea.kim.ui.view.RootView;
import com.kingyea.kim.ui.view.browser.BrowserManager;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class LoginController {
    final private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RootView rootView;
    @Autowired
    private LoginService loginService;
    @Autowired
    private BrowserManager browserManager;
    @Autowired
    private TokenCache tokenCache;

    @FXML
    private TextField userNameText;
    @FXML
    private PasswordField passwordText;

    @FXML
    public void initialize() {
        logger.info("titlebarPane init ");
        StageUtil.initStage("login");
    }

    @FXML
    public void handleLoginAction(ActionEvent event) {
        if (checkLogin()){
            gotoRootView();
        }
    }

    private boolean checkLogin() {
        boolean tologin = false;
        String userName = userNameText.getText();
        String password = passwordText.getText();

        if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
            boolean toLogin = loginService.checkLogin(userName, password);
            tologin = true;
        }

        return tologin;
    }

    private void gotoRootView() {
        StageUtil.hide();
        KimApp.showView(rootView.getClass());
    }
}
