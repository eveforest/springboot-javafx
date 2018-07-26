package com.kingyea.kim.core.config;

import com.kingyea.kim.core.constant.CoreConstant;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        return CacheManager.getInstance();
    }

    @Bean
    public Ehcache tokenEhCache() {
        Ehcache tokenCache = new Cache(new CacheConfiguration(CoreConstant.TOKENCACHE_CACHENAME, 10)//缓存名称(必须唯一),maxElements内存最多可以存放的元素的数量
                .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)//清理机制：LRU最近最少使用 FIFO先进先出 LFU较少使用
                .eternal(true));//元素是否永久缓存)

        CacheManager manager = cacheManager();
        manager.addCache(tokenCache);

        return manager.getEhcache(CoreConstant.TOKENCACHE_CACHENAME);
    }

    @Bean
    public Ehcache normalEhCache() {
        Ehcache normalCache = new Cache(new CacheConfiguration(CoreConstant.NORMALCACHE_CACHENAME, 10)//缓存名称(必须唯一),maxElements内存最多可以存放的元素的数量
                .memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LFU)//清理机制：LRU最近最少使用 FIFO先进先出 LFU较少使用
                .eternal(true));//元素是否永久缓存)

        CacheManager manager = cacheManager();
        manager.addCache(normalCache);

        return manager.getEhcache(CoreConstant.NORMALCACHE_CACHENAME);
    }

}
