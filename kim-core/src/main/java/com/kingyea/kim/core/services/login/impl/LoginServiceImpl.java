package com.kingyea.kim.core.services.login.impl;

import com.alibaba.fastjson.JSONObject;
import com.kingyea.kim.common.model.token.ApiToken;
import com.kingyea.kim.common.model.token.Token;
import com.kingyea.kim.common.model.token.UamToken;
import com.kingyea.kim.core.cache.NormalCache;
import com.kingyea.kim.core.cache.TokenCache;
import com.kingyea.kim.core.constant.CoreConstant;
import com.kingyea.kim.core.constant.CoreVariable;
import com.kingyea.kim.core.services.login.LoginService;
import com.kingyea.kim.core.util.HttpUtil;
import com.kingyea.kim.core.util.SSOUtil;
import kingyea.sso.client.android.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private TokenCache tokenCache;
    @Resource
    private NormalCache normalCache;

    @Override
    public boolean checkLogin(String userName, String password) {
        boolean toLogin = false;


        checkLoginByAPISSO("admin", "admin");
        checkLoginByUAMSSO("even", "123456");


        return toLogin;
    }

    private void checkLoginByAPISSO(String userName, String password) {
        String url = CoreConstant.API_OAUTH_TOKEN_SERVER;
        Map<String, String> headers = SSOUtil.getAPIHeaders();
        Map<String, String> bodyParams = SSOUtil.getAPIBodyParams(userName, password);

        JSONObject responseData = HttpUtil.httpPost(url, headers, bodyParams);

        Token token = parseAPIResponseData(responseData);

        //cache currentuser and token
        normalCache.put(CoreConstant.CURRENT_USERNAME,userName,token.getExpires());
        tokenCache.put(CoreConstant.API_TOKEN_PREF + "even",token);

    }

    private void checkLoginByUAMSSO(String userName, String password) {
        String url = CoreConstant.OAUTH_SERVER;
        Map<String, String> headers = SSOUtil.getUAMHeaders();
        Map<String, String> bodyParams = SSOUtil.getUAMBodyParams(userName, password);

        JSONObject responseData = HttpUtil.httpPost(url, headers, bodyParams);

        Token token = parseUAMResponseData(responseData);

        //cache currentuser and token
        normalCache.put(CoreConstant.CURRENT_USERNAME,userName,token.getExpires());
        tokenCache.put(CoreConstant.UAM_TOKEN_PREF + "even",token);
    }

    private Token parseAPIResponseData(JSONObject responseData) {
        ApiToken apiToken = new ApiToken();

//        "access_token": "01642a90-f998-437f-8424-f30aa11eb34f",
        apiToken.setAccessToken(responseData.getString("access_token"));
//        "token_type": "bearer",
        apiToken.setTokenType(responseData.getString("token_type"));
//        "refresh_token": "1d517ce5-b9fc-432c-92d7-685ff4c8bc35",
        apiToken.setRefreshToken(responseData.getString("refresh_token"));
//        "expires_in": 12501,
        apiToken.setExpiresIn(responseData.getInteger("expires_in"));
//        "scope": "xx"
        apiToken.setScope(responseData.getString("scope"));

        return apiToken;
    }

    private Token parseUAMResponseData(JSONObject responseData) {
        UamToken token = new UamToken();
//        ex.service_ticket:ST4c932adaab9f40ab932681e767c70932
        token.setExServiceTicket(responseData.getString("ex.service_ticket"));
//        ex.auth_type:jdbc
        token.setExAuthType(responseData.getString("ex.auth_type"));
//        ex.token:TGT744ac55c1ce444678f1157afca1abb69
        token.setExToken(responseData.getString("ex.token"));
//        ex.spec_secret:kdx0h9hf1b6vjc4n7sabsu1a24d4mrapsr0vvn6p9hhsduvvi93ze5pa185idjk8mxr2j5orzsl7brkglthr612nhg4fyycfbstrylykh1tg0ghoo0hp6zdpi7ysxrov
        token.setExSpecSecret(responseData.getString("ex.spec_secret"));
//        ex.spec_secret_expires:27447752246529
        token.setExSpecSecretExpires(responseData.getLong("ex.spec_secret_expires"));
//        ex.oauth_access_token:3998159d-2c62-4b09-be23-b9ddc5b76e0a
        token.setExOauthAccessToken(responseData.getString("ex.oauth_access_token"));
//        mode:ok
        token.setMode(responseData.getString("mode"));
//        ex.oauth_refresh_token:52d83bf8-3b9b-48b9-9108-b4b8f5545da4
        token.setExOauthRefreshToken(responseData.getString("ex.oauth_refresh_token"));
//        ex.status:1
        token.setExStatus(responseData.getInteger("ex.status"));
//        identity:even
        token.setIdentity(responseData.getString("identity"));
//        ex.token_expires:1528389513422
        token.setExTokenExpires(responseData.getLong("ex.token_expires"));
//        ex.oauth_access_token_expires:43199
        token.setExOauthAccessTokenExpires(responseData.getInteger("ex.oauth_access_token_expires"));
//        ex.login_session_ticket:gShA5kDDqpCo4k8Ax/ox6A==
        token.setExLoginSessionTicket(responseData.getString("ex.login_session_ticket"));
//        ex.uid:7cafa640-85e3-40ec-8132-75b92006e1cc
        token.setExUid(responseData.getString("ex.uid"));

        return token;
    }

    public static void main(String[] args) {
        //api
        /*String url = CoreConstant.API_OAUTH_TOKEN_SERVER;
        Map<String, String> headers = HttpUtil.getDefaultHeaders();
        headers.put("Authorization", "Basic " + CoreConstant.API_CLIENTID);
        headers.put(HTTP.CONTENT_TYPE, "application/x-www-form-urlencoded");

        Map<String, String> bodyParams = new HashMap<>();
        bodyParams.put("username", "admin");
        bodyParams.put("password", "admin");
        bodyParams.put("grant_type", "password");

        JSONObject responseData = HttpUtil.httpPost(url, headers, bodyParams);

        String access_token = responseData.getString("access_token");*/

        //uam
        /*SSOClientBuilder ssoClientBuilder = new SSOClientBuilder();
        ssoClientBuilder.setClientId("clientId").setClientSecret("clientSecret").setSsoBaseEndpoint(CoreConstant.OAUTH_SERVER);
        SSOClient ssoClient = ssoClientBuilder.build();

        try {
            Authentication authentication = ssoClient.login(new UserNamePasswordCredentials("admin", "123123"));
            Principal principal = authentication.getPrincipal();
            String id = principal.getId();
            Map<String, String> attributes = principal.getAttributes();

            kingyea.sso.client.android.Token token = authentication.getToken();
            String serviceTicket = ssoClient.issueServiceTicket(token);

            System.out.println(id+"###"+serviceTicket+"###"+token.getId());
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }*/

//        new LoginServiceImpl().checkLoginByUAMSSO("even", "123456");
    }

}
