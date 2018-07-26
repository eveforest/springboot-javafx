package com.kingyea.kim.common.cache;

import java.util.List;
import java.util.Map;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Ehcache;

/**
 * 自定义缓存接口
 * 
 * @author even
 *
 * @param <T> 缓存对象的类型，如APPCODE
 */
public interface ICache<T> {
	/**
	 * 初始化缓存数据
	 * @return
	 */
	Ehcache initData(Map<String,T> data);
	/**
	 * 拿到缓存对象
	 * @return
	 */
	Ehcache getCache();
	/**
	 * 判断缓存为空
	 * @return
	 */
	Boolean isEmpty();
	/**
	 * 清理缓存
	 * @return
	 */
	void clear();
	/**
	 * 存入缓存对象 结构：key-value
	 * @param key
	 * @return
	 */
	void put(String key,T t);
	/**
	 * 存入缓存对象 结构：key-value
	 * @param key
	 * @return
	 */
	void put(String key,T t,int expires);
	/**
	 * 取出缓存对象 结构：key-value
	 * @param key
	 * @return
	 */
	T get(String key);

	/**
	 * 清除元素
	 * @param key
	 */
	boolean remove(String key);
}
