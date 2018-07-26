package com.kingyea.kim.ui.util;

import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class RootUtil {

    public static void initContentPane(BorderPane contentPane, Parent left, Parent top, Parent center, Parent right, Parent bottom){
        contentPane.getChildren().clear();
        if (left != null) {
            contentPane.setLeft(left);
        }
        if (top != null) {
            contentPane.setTop(top);
        }
        if (center != null) {
            contentPane.setCenter(center);
        }
        if (right != null) {
            contentPane.setRight(right);
        }
        if (bottom != null) {
            contentPane.setBottom(bottom);
        }
    }

}
