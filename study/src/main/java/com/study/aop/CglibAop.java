package com.study.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com 2015年3月18日
 * 
 */
public class CglibAop implements MethodInterceptor {
    private Object target;

    public CglibAop(Object target) {
	this.target = target;
    }

    /*
     * (non-Javadoc)
     * 
     * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object,
     * java.lang.reflect.Method, java.lang.Object[],
     * net.sf.cglib.proxy.MethodProxy)
     */
    @Override
    public Object intercept(Object proxy, Method method, Object[] args,   MethodProxy invocation) throws Throwable {
	System.out.println("log1");
	//Object rev =invocation.invokeSuper(proxy, args); //如果是invocation京用proxy,args
	
	Object rev =method.invoke(target, args);
	System.out.println("log1");
	return rev;
    }

    public static Object proxy(Object target) {
	return Enhancer.create(target.getClass(), new CglibAop(target));
    }
}
