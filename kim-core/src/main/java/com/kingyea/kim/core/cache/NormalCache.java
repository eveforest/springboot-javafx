package com.kingyea.kim.core.cache;

import com.kingyea.kim.common.cache.ICache;
import com.kingyea.kim.common.model.token.Token;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class NormalCache implements ICache<String> {
    @Autowired
    private Ehcache normalEhCache;

    public NormalCache() {
        super();
    }

    @Override
    public Ehcache initData(Map<String,String> data) {
        if(!isEmpty()){
            clear();
        }
        return normalEhCache;
    }

    @Override
    public Ehcache getCache() {
        return normalEhCache;
    }

    @Override
    public Boolean isEmpty() {
        List keys = normalEhCache.getKeys();
        return keys != null && keys.size() > 0 ? false : true;
    }

    @Override
    public void clear() {
        normalEhCache.removeAll();
    }

    @Override
    public boolean remove(String key) {
        return normalEhCache.remove(key);
    }

    @Override
    public void put(String key, String value) {
        Element element = new Element(key, value);
        normalEhCache.put(element);
    }

    @Override
    public void put(String key, String value, int expires) {
        Element element = new Element(key, value);
        element.setTimeToLive(expires);
        element.setTimeToIdle(expires);
        normalEhCache.put(element);
    }

    @Override
    public String get(String key) {
        String value = null;
        Element element = normalEhCache.get(key);
        if(element != null){
            value = (String) element.getObjectValue();
        }
        return value;
    }

}
