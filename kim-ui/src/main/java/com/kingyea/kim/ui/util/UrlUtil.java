package com.kingyea.kim.ui.util;

import com.kingyea.kim.ui.constant.UIConstant;
import org.apache.commons.lang.StringUtils;

import java.util.Date;

public class UrlUtil {

    public static String getWebUrl(String urlType){
        String url = null;
        switch (urlType){
            case UIConstant.KEY_HOME_PAGE :
                url = ConfigUtil.getConfigByKey(UIConstant.KEY_HOME_PAGE);
                break;
            case UIConstant.KEY_APPSHOP_PAGE :
                url = ConfigUtil.getConfigByKey(UIConstant.KEY_APPSHOP_PAGE);
                break;
            default:
                url = UIConstant.DEFAULT_BROWSER_URL;
        }
        return url;
    }

    private static String contactWithRandom(String url) {
        StringBuffer sb = new StringBuffer();
        sb.append(url).append("?ran=").append(Math.random());
        return sb.toString();
    }


}
