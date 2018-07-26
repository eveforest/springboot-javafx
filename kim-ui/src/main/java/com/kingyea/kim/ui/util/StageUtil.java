package com.kingyea.kim.ui.util;

import com.kingyea.kim.common.util.SpringUtil;
import com.kingyea.kim.ui.constant.UIConstant;
import com.kingyea.kim.ui.view.browser.BrowserManager;
import de.felixroske.jfxsupport.GUIState;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StageUtil {
    private final static Stage stage = GUIState.getStage();

    public static void initStage(String type){
        switch (type) {
            case "login":
                //取消外部窗口标题栏
                loginInit();
                stage.initStyle(StageStyle.TRANSPARENT);
                break;
            case "root":
                //取消外部窗口标题栏
                rootInit();
                default:
        }
    }

    private static void rootInit() {
        stage.setMinHeight(UIConstant.ROOT_STAGE_MIN_HEIGHT);
        stage.setMinWidth(UIConstant.ROOT_STAGE_MIN_WIDTH);
        //关闭处理
//        winClose();
    }
    private static void loginInit() {
        stage.setMinHeight(UIConstant.LOGIN_STAGE_MIN_HEIGHT);
        stage.setMinWidth(UIConstant.LOGIN_STAGE_MIN_WIDTH);
        //关闭处理
//        winClose();
    }

    public static void addDrawFun(Parent root) {
        DrawUtil.addDrawFunc(stage,root);
    }
    public static void addDragFun(Parent root) {
        DragUtil.addDragListener(stage, root);
    }

    public static void winClose(){
        stage.close();
        BrowserManager browserManager = SpringUtil.getBean(BrowserManager.class);
        browserManager.clear();
        browserManager.close();
        System.exit(0);
    }

    public static void winMini(){
        stage.setIconified(true);
    }

    public static void winMax(){
        if (stage.isMaximized()){
            stage.setMaximized(false);
        }else{
            stage.setMaximized(true);
        }
    }

    public static void hide() {
        stage.hide();
    }
}
