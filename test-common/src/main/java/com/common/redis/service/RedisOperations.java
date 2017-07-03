package com.common.redis.service;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis服务接口
 * 
 * @author：朱艳龙
 * @since：2015年8月5日 下午11:10:41
 * @version:
 */
public interface RedisOperations {

	/**
	 * 将value存入redis中
	 * 
	 * @param key
	 * @param value
	 */
	public void set(String key, String value);

	/**
	 * 将value存入redis中
	 * 
	 * @param key
	 * @param value
	 * @param seconds
	 */
	public void set(String key, String value, Long seconds);

	/**
	 * 设置set值
	 * 
	 * @param key
	 * @param values
	 */
	public Long setHset(String key, String... values);

	/**
	 * 设置不重复的key
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public Boolean setNx(String key, String value);

	/**
	 * 设置hash值
	 * 
	 * @param key
	 * @param fieldName
	 * @param value
	 * @return
	 */
	public void setHashValue(String key, String fieldName, String value);

	/**
	 * 将key的值自增
	 * 
	 * @param key
	 * @return
	 */
	public Long incr(String key);

	/**
	 * hash中的fieldName值自增1
	 * 
	 * @param key
	 * @param fieldName
	 * @return
	 */
	public Long hashIncr(String key, String fieldName);

	/**
	 * 将hash中的fieldName值自增delta
	 * 
	 * @param key
	 * @param fieldName
	 * @param delta
	 * @return
	 */
	public Long hashIncr(String key, String fieldName, Long delta);

	/**
	 * 将key的值自增delta
	 * 
	 * @param key
	 * @param delta
	 * @return
	 */
	public Long incr(String key, Long delta);

	/**
	 * 根据key删除值
	 * 
	 * @param key
	 */
	public void delete(String key);

	/**
	 * 根据key查询值
	 * 
	 * @param key
	 * @return
	 */
	public String get(String key);

	/**
	 * 获取Hash中key值
	 * 
	 * @param key
	 * @return
	 */
	public Object getHashValue(String key, String fieldName);

	/**
	 * 获取Hash中key值
	 * 
	 * @param key
	 * @return
	 */
	public Map<Object, Object> getHashValue(String key);

	/**
	 * 判断key是否存在
	 * 
	 * @param key
	 * @return
	 */
	public Boolean hasKey(String key);

	/**
	 * 匹配所以的key
	 * 
	 * @param patten
	 * @return
	 */
	Set<String> getKeys(String patten);

	void expire(String key, Long timeout);

	/**
	 * redis 分布式锁
	 * 
	 * @param key
	 * @param timeout
	 * @param unit
	 * @return
	 */
	Boolean tryLock(String key, Long timeout, TimeUnit unit);

	/**
	 * 释放锁
	 * 
	 * @param key
	 */
	void unLock(String key);

	/**
	 * 原子操作，设置key的value，返回老的value
	 *
	 * @param key 键
	 * @param value 值
	 * @return
	 */
	String getSet(String key, String value);

	/**
	 * redis 分布式锁
	 *
	 * @param key 键值
	 * @param timeOutSecs 超时时间（s）
	 * @param expireSecs 到期时间（s）
	 * @return
	 */
	Boolean tryLock(String key, Long timeOutSecs, Long expireSecs) throws InterruptedException;
}
