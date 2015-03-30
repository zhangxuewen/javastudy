package com.study.aop;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com
 * 2015年3月18日
 * 
 */
public class DoSomething implements DoSomethingA,DoSomethingB {

    /* (non-Javadoc)
     * @see com.study.aop.DoSomethingB#doB()
     */
    @Override
    public void doB() {
	// TODO Auto-generated method stub
	System.out.println("dosomething b");
	
    }

    /* (non-Javadoc)
     * @see com.study.aop.DoSomethingA#doA()
     */
    @Override
    public void doA() {
	// TODO Auto-generated method stub
	System.out.println("dosomething a");
	
    }
    
    public void dod() {
   	// TODO Auto-generated method stub
   	System.out.println("dosomething d");
   	
       }
    public static void main(String[] args) {
   	/*DoSomething ds=new DoSomething();
   	DoSomethingB testa=  (DoSomethingB) DynamicAop.proxy(ds);
   	DoSomethingA testb=  (DoSomethingA) DynamicAop.proxy(ds);
   	testa.doB();
	testb.doA();*/
	
	/*DoSomething ds=new DoSomething();
   	DoSomethingB testa=  (DoSomethingB) CglibAop.proxy(ds);
   	DoSomethingA testb=  (DoSomethingA) CglibAop.proxy(ds);
   	testa.doB();
	testb.doA();*/
	
   	
       }
}
