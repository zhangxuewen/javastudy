package com.study.javasource;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com
 * 2015年1月2日
 * 
 */
public class StringObject {
    Object o =new Object();
     // hashcode  equals toString()   wait  wait(long time)   notify  notifyall    finalize  clone getClass   
    String  o1=new String(); //不可变，线程安钱的， 每次字符串的操作都会生成新的字符串，不会改变原业的字符串，频繁的操作会占用旧内
    //主要是由 final char[] 组成  实现了 序列化接口   serializable 排序接口compare 和字符序列接口
    StringBuffer o2 =new StringBuffer(); //可变字符串对象   线程安全 和StringBuider实现一样。只是他在对应的操作方法加了synchronized
    //主要于char []数组组成，，初始化为16个字符 ，
    StringBuilder o3=new StringBuilder(); //可变字符串 线程不安全  
   
}
