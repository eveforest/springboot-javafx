package com.kingyea.kim.core.services.contactlist.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.kingyea.kim.common.model.contactlist.Organization;
import com.kingyea.kim.common.model.contactlist.UAMApiResult;
import com.kingyea.kim.common.model.contactlist.ContactListUser;
import com.kingyea.kim.common.model.token.Token;
import com.kingyea.kim.common.model.user.User;
import com.kingyea.kim.core.cache.NormalCache;
import com.kingyea.kim.core.cache.TokenCache;
import com.kingyea.kim.core.constant.CoreConstant;
import com.kingyea.kim.core.services.contactlist.ContactListService;
import com.kingyea.kim.core.util.HttpUtil;
import com.kingyea.kim.core.util.SSOUtil;
import com.kingyea.kim.core.util.UamApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContactListServiceImpl implements ContactListService {
    @Autowired
    private TokenCache tokenCache;
    @Autowired
    private NormalCache normalCache;

    @Override
    public List<ContactListUser> getContactListUsers() {
        List<ContactListUser> contactListUsers = null;

        String accessToken = getAccessToken();

        contactListUsers = getContactListUsersFromUAM(accessToken);

        List<Organization> orgnazations = getOrganizations(accessToken);

        return contactListUsers;
    }

    private List<Organization> getOrganizations(String accessToken) {
        List<Organization> organizations = null;

        JSONObject responseData = UamApiUtil.callApi(accessToken);

        UAMApiResult<Organization> organizationsResult = parseOrganization(responseData);

        organizations = organizationsResult.getR();

        return organizations;
    }

    private UAMApiResult<Organization> parseOrganization(JSONObject responseData) {
        UAMApiResult uamApiResult = new UAMApiResult();

        uamApiResult.setCount(responseData.getInteger("count"));
        uamApiResult.setM(responseData.getString("m"));
        uamApiResult.setS(responseData.getInteger("s"));
        uamApiResult.setT(responseData.getDate("t"));

        ArrayList<Organization> organizations = new ArrayList<>();


        return uamApiResult;
    }

    private List<ContactListUser> getContactListUsersFromUAM(String accessToken) {
        List<ContactListUser> contactListUsers = null;

        JSONObject responseData = UamApiUtil.callApi(accessToken);

        UAMApiResult<ContactListUser> contactListResult = parseContactListResponseData(responseData);

        contactListUsers = contactListResult.getR();

        return contactListUsers;
    }


    private String getAccessToken() {
        String currentUserName = normalCache.get(CoreConstant.CURRENT_USERNAME);

        Token token = tokenCache.get(CoreConstant.UAM_TOKEN_PREF + currentUserName);

        return token.getAccessToken();
    }

    private UAMApiResult parseContactListResponseData(JSONObject responseData) {
        UAMApiResult uamApiResult = new UAMApiResult();

        uamApiResult.setCount(responseData.getInteger("count"));
        uamApiResult.setM(responseData.getString("m"));
        uamApiResult.setS(responseData.getInteger("s"));
        uamApiResult.setT(responseData.getDate("t"));
        //r
        List<ContactListUser> contactListUsers = new ArrayList<>();

        JSONArray r = responseData.getJSONArray("r");
        for (int i = 0; i < r.size(); i++) {
            ContactListUser contactListUser = new ContactListUser();
            User user = new User();
            JSONObject userJson = r.getJSONObject(i);
//            "userId": "ee598efe-79f0-11e4-b449-d00d4e0f91a-",
            user.setUserId(userJson.getString("userId"));
//            "name": "在线客服",
            user.setName(userJson.getString("name"));
//            "loginId": "servicer",
            user.setLoginId(userJson.getString("loginId"));
//            "type": 4,
            user.setType(userJson.getString("type"));
//            "orderNo": 0,
            user.setOrderNo(userJson.getInteger("orderNo"));
//            "lastUpdatedDate": 1451049735000,
            user.setLastUpdatedDate(userJson.getDate("lastUpdatedDate"));
//            "isDeleted": false,
            user.setIsDeleted(userJson.getBoolean("isDeleted")? 1:0);
//            "namePinYin": "zaixiankefurenyuan",
            user.setNamePinyin(userJson.getString("namePinYin"));
//            "avatar": "icons/servicer.png||servicer.png||.png",
            contactListUser.setAvatar(userJson.getString("avatar"));
//            "eCode": "localhost",
            contactListUser.seteCode(userJson.getString("eCode"));
//            "isEnable": 1,
            contactListUser.setIsEnable(userJson.getInteger("isEnable"));
//            "keyword": "zaixiankefurenyuan,zxkfry",
            String keywords = userJson.getString("keyword");
            contactListUser.setKeyword(keywords.split(","));
//            "secretLevel": 0,
            contactListUser.setSecretLevel(userJson.getInteger("secretLevel"));
//            "isFriend": 0
            contactListUser.setIsFriend(userJson.getInteger("isFriend"));

            contactListUser.setUser(user);
            contactListUsers.add(contactListUser);
        }

        uamApiResult.setR(contactListUsers);

        return uamApiResult;
    }

    public static void main(String[] args) {
        /*HttpPost httpPost = new HttpPost();
        RequestConfig requestConfig = RequestConfig.custom().setAuthenticationEnabled(true).build();
        httpPost.setConfig(requestConfig);
        CloseableHttpClient aDefault = HttpClients.createDefault();
        CloseableHttpClient build = HttpClients.custom().build();

        HttpClient httpClient = new HttpClient();*/


        String url = CoreConstant.OAUTH_SERVER;
        Map<String, String> headers = SSOUtil.getUAMHeaders();
        Map<String, String> bodyParams = SSOUtil.getUAMBodyParams("even", "123456");

        JSONObject responseData = HttpUtil.httpPost(url, headers, bodyParams);

        url = CoreConstant.GET_CONTACT_USERS_API;
        headers = new HashMap<>();
        headers.put("Authorization", CoreConstant.UAM_AUTHORIZATION_BEARER + responseData.get("ex.oauth_access_token"));

        responseData = HttpUtil.httpGet(url,headers);

        UAMApiResult contactListResult = new ContactListServiceImpl().parseContactListResponseData(responseData);

        List<ContactListUser> contactListUsers = contactListResult.getR();

        System.out.println(contactListUsers);
    }
}
