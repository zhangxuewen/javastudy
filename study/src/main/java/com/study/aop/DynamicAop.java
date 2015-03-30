package com.study.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com 2015年3月18日
 * 
 */
public class DynamicAop implements InvocationHandler {
    private Object target;

    public DynamicAop(Object target) {
	this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
	// TODO Auto-generated method stub
	//1.记录日志    2.时间统计开始      3.安全检查 
	System.out.println("记录日志1");  
        Object retVal = method.invoke(target, args);  
        System.out.println("记录日志2");  
        return retVal;  
    }

    public static Object proxy(Object target) {
	return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), new DynamicAop(target));
    }
   
}
