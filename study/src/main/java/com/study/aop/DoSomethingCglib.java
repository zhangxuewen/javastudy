package com.study.aop;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com 2015年3月18日
 * 
 */
public class DoSomethingCglib {

    public void dod() {
	// TODO Auto-generated method stub
	System.out.println("dosomething d");

    }

    public static void main(String[] args) {
	
	DoSomethingCglib testc = (DoSomethingCglib) CglibAop.proxy(new DoSomethingCglib());
	testc.dod();

    }
}
