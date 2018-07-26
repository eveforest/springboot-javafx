package com.kingyea.kim.ui.util;

import com.kingyea.kim.common.util.SpringUtil;
import com.kingyea.kim.ui.config.BrowserConfig;

import java.util.Map;

public class ConfigUtil {
    private static Map<String,String> propertiesMap =null;
    public static String getConfigByKey(String key)  {
        if (propertiesMap ==null){
            BrowserConfig browserConfig = SpringUtil.getBean(BrowserConfig.class);
            propertiesMap = browserConfig.getWebUrlMap();
        }
        return propertiesMap.get(key);
    }
}
