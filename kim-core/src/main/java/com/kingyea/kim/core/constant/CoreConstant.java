package com.kingyea.kim.core.constant;

public interface CoreConstant {
    //token 缓存名
    public static final String TOKENCACHE_CACHENAME = "TOKENCACHE_CACHENAME";
    public static final String NORMALCACHE_CACHENAME = "NORMALCACHE_CACHENAME";
    //server api
    public final static String OAUTH_SERVER = "http://193.112.49.253:8080/sso/v2";
    public final static String AUTHORIZATION = "Authorization";
    public final static String UAM_AUTHORIZATION_BEARER = "Bearer ";
    public final static String API_OAUTH_TOKEN_SERVER = "http://192.168.0.214:8784/uaa/oauth/token";
    public final static String OAUTHORIZATION_APITOKEN_CLIENT_PREF = "Basic ";
    public final static String API_CLIENTID = "d2ViOndlYg==";
    public final static String GET_CONTACT_USERS_API = "http://192.168.0.235:8080/uam/api/user/getUsersAndFriends";


    //cache key
    public final static String CURRENT_USERNAME = "current_username";

    //token cache key pref
    public final static String API_TOKEN_PREF = "apitoken_";
    public final static String UAM_TOKEN_PREF = "uamtoken_";
}
