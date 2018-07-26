package com.kingyea.kim.ui.controller;

import com.kingyea.kim.core.cache.TokenCache;
import com.kingyea.kim.ui.constant.UIConstant;
import com.kingyea.kim.ui.view.browser.BrowserManager;
import com.kingyea.kim.ui.view.browser.BrowserPaneView;
import com.kingyea.kim.ui.view.panel.TitleBarView;
import com.kingyea.kim.ui.util.*;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@FXMLController
public class RootController{

    private final static Logger logger = LoggerFactory.getLogger(RootController.class);

    @FXML
    private BorderPane root;
    @FXML
    private GridPane leftNavigationPane;
    @FXML
    private ScrollPane contentPane;

    @Autowired
    private BrowserPaneView browserPaneView;
    @Autowired
    private TitleBarView titleBarView;
    @Autowired
    private BrowserManager browserManager;
    @Autowired
    private TokenCache tokenCache;

    @FXML
    public void handleHomePageAction(ActionEvent event) {
        logger.info("home page action");

        contentPane.setContent(browserPaneView.getView());
        contentPane.setFitToHeight(true);
        contentPane.setFitToWidth(true);

        String webUrl = UrlUtil.getWebUrl(UIConstant.KEY_HOME_PAGE);

        browserManager.reLoadUrl(webUrl);
    }
    @FXML
    public void handleAppshopPageAction(ActionEvent event) {
        logger.info("appshop page action");
    }

    @FXML
    public void initialize() {
        //初始化stage
        StageUtil.initStage("root");
        //自由拉伸窗口
        StageUtil.addDrawFun(root);
        StageUtil.addDrawFun(browserPaneView.getView());
        StageUtil.addDrawFun(browserManager.getBrowserView());

        //默认点击homepage
        handleHomePageAction(null);

        //设置root子布局大小变化
        resetChildrenSize();

    }

    private void resetChildrenSize() {
        leftNavigationPane.setPrefHeight(root.getHeight());
        contentPane.setPrefSize(root.getPrefWidth()-leftNavigationPane.getPrefWidth(),root.getPrefHeight());
    }
}
