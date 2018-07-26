package com.kingyea.kim.core.cache;

import com.kingyea.kim.common.cache.ICache;
import com.kingyea.kim.common.model.token.Token;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TokenCache implements ICache<Token> {
    @Autowired
    private Ehcache tokenEhCache;

    public TokenCache() {
        super();
    }

    @Override
    public Ehcache initData(Map<String,Token> tokens) {
        if(!isEmpty()){
            clear();
        }
        if (tokens != null && tokens.size() > 0) {
            tokens.forEach((userName,token) ->{
                int expiresIn = token.getExpires();
                if (StringUtils.isNotBlank(userName)) {
                    Element element = new Element(userName, token);
                    element.setTimeToIdle(expiresIn);
                    element.setTimeToLive(expiresIn);
                    tokenEhCache.put(element);
                }
            });
        }
        return tokenEhCache;
    }

    @Override
    public void put(String userName, Token token) {
        int expires = token.getExpires();
        put(userName,token,expires);
    }

    @Override
    public void put(String userName, Token token, int expires) {
        if (StringUtils.isNotBlank(userName) && token != null) {
            tokenEhCache.remove(userName);
            Element element = new Element(userName, token);
            element.setTimeToIdle(expires);
            element.setTimeToLive(expires);
            tokenEhCache.put(element);
        }
    }

    @Override
    public Token get(String key) {
        Token token = null;
        Element element = tokenEhCache.get(key);
        if(element != null){
            token = (Token) element.getObjectValue();
        }
        return token;
    }

    @Override
    public Ehcache getCache() {
        return tokenEhCache;
    }

    @Override
    public Boolean isEmpty() {
        List keys = tokenEhCache.getKeys();
        return keys != null && keys.size() > 0 ? false : true;
    }

    @Override
    public void clear() {
        tokenEhCache.removeAll();
    }

    @Override
    public boolean remove(String key) {
        return tokenEhCache.remove(key);
    }

}
