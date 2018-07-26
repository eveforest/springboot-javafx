package com.kingyea.kim.core.util;

import com.alibaba.fastjson.JSONObject;
import com.kingyea.kim.core.constant.CoreConstant;

import java.util.HashMap;
import java.util.Map;

public class UamApiUtil {

    public static JSONObject callApi(String accessToken) {
        Map<String, String> headers = new HashMap<>();
        //Authorization token
        headers.put(CoreConstant.AUTHORIZATION, CoreConstant.UAM_AUTHORIZATION_BEARER + accessToken);

        String url = CoreConstant.GET_CONTACT_USERS_API;

        return HttpUtil.httpGet(url,headers);
    }

}
