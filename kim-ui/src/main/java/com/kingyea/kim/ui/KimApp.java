package com.kingyea.kim.ui;

import com.kingyea.kim.ui.view.LoginView;
import com.kingyea.kim.common.util.SpringUtil;
import com.kingyea.kim.ui.view.RootView;
import com.teamdev.jxbrowser.chromium.ay;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigInteger;

@SpringBootApplication
@Import({SpringUtil.class})
@ComponentScan(basePackages = { "com.kingyea.kim"})
public class KimApp extends AbstractJavaFxApplicationSupport{
    public static void main(String[] args) {
        launch(KimApp.class, LoginView.class,new CustomSplash(),args);
    }
    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }
    //破解jxbrowser
    static {
        try {
            Field e = ay.class.getDeclaredField("e");
            e.setAccessible(true);
            Field f = ay.class.getDeclaredField("f");
            f.setAccessible(true);
            Field modifersField = Field.class.getDeclaredField("modifiers");
            modifersField.setAccessible(true);
            modifersField.setInt(e, e.getModifiers() & ~Modifier.FINAL);
            modifersField.setInt(f, f.getModifiers() & ~Modifier.FINAL);
            e.set(null, new BigInteger("1"));
            f.set(null, new BigInteger("1"));
            modifersField.setAccessible(false);
        } catch (Exception e1) {
            e1.printStackTrace();
        }

    }
}
