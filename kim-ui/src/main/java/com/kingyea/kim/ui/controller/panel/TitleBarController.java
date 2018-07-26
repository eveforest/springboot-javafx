package com.kingyea.kim.ui.controller.panel;

import com.kingyea.kim.ui.util.StageUtil;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@FXMLController
public class TitleBarController {
    final private Logger logger = LoggerFactory.getLogger(TitleBarController.class);

    @FXML
    private AnchorPane titlebarPane;

    @FXML
    public void initialize() {
        logger.info("titlebarPane init ");
        StageUtil.addDragFun(titlebarPane);
    }

    @FXML
    public void handleWinMiniAction(ActionEvent actionEvent) {
        StageUtil.winMini();
    }

    @FXML
    public void handleWinMaxAction(ActionEvent actionEvent) {
       StageUtil.winMax();
    }

    @FXML
    public void handleWinCloseiAction(ActionEvent actionEvent) {
        StageUtil.winClose();
    }
}
