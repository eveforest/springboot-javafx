package com.kingyea.kim.ui;

import com.kingyea.kim.ui.constant.UIConstant;
import de.felixroske.jfxsupport.SplashScreen;

public class CustomSplash extends SplashScreen {

    @Override
    public boolean visible() {
        return false;
    }

    @Override
    public String getImagePath() {
        return UIConstant.DEFAULT_CUSTOM_SPLASH_IMAGE;
    }
}
