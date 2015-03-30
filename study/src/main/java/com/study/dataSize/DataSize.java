package com.study.dataSize;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com
 * 2015
 */
public interface DataSize {
    /*
     * 基本类型字节大小
     */
   public void getBasicDataSize();
   /**
    * 字符串类型字节大小
    */
   public void getStringDataSize();
   /**
    * 对象类型字节大小
    */
   public void getObjectDataSize();
}
