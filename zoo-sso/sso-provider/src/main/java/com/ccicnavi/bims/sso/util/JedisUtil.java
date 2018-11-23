package com.ccicnavi.bims.sso.util;

import com.alibaba.dubbo.config.annotation.Reference;
import com.ccicnavi.bims.shiba.api.SetTemplate;
import com.ccicnavi.bims.shiba.api.StringTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.concurrent.TimeUnit;


/**
 * Redis client base on jedis
 *
 * @author xuxueli 2015-7-10 18:34:07
 */
@Component
public class JedisUtil {
    private static Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    @Reference
    StringTemplate stringTemplate;

    @Reference
    SetTemplate setTemplate;


    /**
     * 添加用户登录列表
     * @param key
     * @param value
     */
    public void setSetValue(Object key,Object value){
        setTemplate.add(key,value);
    }

    /**
     * 判断登录用户列表是否存在
     * @param key
     * @return
     */
    public boolean hasKey(Object key){
        return setTemplate.hasKey(key);
    }


    /**
     * Set String
     *
     * @param key
     * @param value
     * @param seconds 存活时间,单位/秒
     * @return
     */
    public void setStringValue(String key, String value, int seconds,TimeUnit timeUnit) {
        try {
            stringTemplate.setTime(key,value,seconds, timeUnit);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Set Object
     *
     * @param key
     * @param obj
     * @param seconds 存活时间,单位/秒
     */
    public void setObjectValue(String key, Object obj, int seconds,TimeUnit timeUnit) {
        try {
            stringTemplate.setTime(key,obj,seconds, timeUnit);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    /**
     * Get String
     *
     * @param key
     * @return
     */
    public String getStringValue(String key) {
        String value = null;
        try {
            value = stringTemplate.get(key).toString();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return value;
    }

    /**
     * Get Object
     *
     * @param key
     * @return
     */
    public Object getObjectValue(String key) {
        Object obj = null;
        try {
            obj = stringTemplate.get(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return obj;
    }

    /**
     * Delete key
     *
     * @param key
     * @return Integer reply, specifically:
     * an integer greater than 0 if one or more keys were removed
     * 0 if none of the specified key existed
     */
    public boolean del(String key) {
        boolean falg = false;
        try {
            falg = stringTemplate.delete(key);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return falg;
    }

    /**
     * 描述 : <byte[]转Object>. <br>
     * <p>
     * <使用方法说明>
     * </p>
     *
     * @param bytes
     * @return
     */
    private Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return obj;
    }

    private byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return bytes;
    }


    /**
     * 将byte[] -->Object
     *
     * @param bytes
     * @return
     */
    private static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            try {
                bais.close();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return null;
    }
}
