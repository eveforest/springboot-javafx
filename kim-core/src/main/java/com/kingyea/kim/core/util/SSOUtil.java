package com.kingyea.kim.core.util;

import com.kingyea.kim.core.constant.CoreConstant;
import kingyea.sso.client.android.SSOClient;
import kingyea.sso.client.android.SSOClientBuilder;
import org.apache.http.protocol.HTTP;

import java.util.HashMap;
import java.util.Map;

public class SSOUtil {

    public static SSOClient getSSOClient() {
        SSOClient ssoClient = null;
        SSOClientBuilder ssoClientBuilder = new SSOClientBuilder();
        ssoClientBuilder.setClientId("clientId").setClientSecret("clientSecret").setSsoBaseEndpoint(CoreConstant.OAUTH_SERVER);
        ssoClient = ssoClientBuilder.build();
        return ssoClient;
    }

    public static Map<String, String> getAPIHeaders() {
        Map<String,String> headers = HttpUtil.getDefaultHeaders();
        headers.put("Authorization", CoreConstant.OAUTHORIZATION_APITOKEN_CLIENT_PREF + CoreConstant.API_CLIENTID);
        headers.put(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
        headers.put("Accept", "application/json");

        return headers;
    }

    public static Map<String, String> getAPIBodyParams(String userName,String password) {
        Map<String, String> bodyParams = new HashMap<>();
        bodyParams.put("username", userName);
        bodyParams.put("password", password);
        bodyParams.put("grant_type", "password");

        return bodyParams;
    }

    public static Map<String, String> getUAMHeaders() {
        Map<String,String> headers = HttpUtil.getDefaultHeaders();
        headers.put("LoginMode", "manual");
        headers.put("ClientType", "pc");
        headers.put("X-Requested-With", "XMLHttpRequest");
        headers.put(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");
        headers.put("Accept", "text/plain");

        return headers;
    }

    public static Map<String, String> getUAMBodyParams(String userName,String password) {
        Map<String, String> bodyParams = new HashMap<>();
        // openid.ex.client_id=clientId&
        // openid.ex.client_secret=clientSecret&
        // openid.ex.get_oauth_access_token=y&
        // openid.ex.get_service_ticket=y&
        // openid.ex.get_spec_secret=y&
        // openid.mode=checkid_setup&
        // credential_type=password&
        // password=123456&
        // username=even
        bodyParams.put("openid.ex.client_id", "clientId");
        bodyParams.put("openid.ex.client_secret", "clientSecret");
        bodyParams.put("openid.ex.get_oauth_access_token", "y");
        bodyParams.put("openid.ex.get_service_ticket", "y");
        bodyParams.put("openid.ex.get_spec_secret", "y");
        bodyParams.put("openid.mode", "checkid_setup");
        bodyParams.put("credential_type", "password");
        bodyParams.put("username", userName);
        bodyParams.put("password", password);

        return bodyParams;
    }
}
