package com.study.serializable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com 2015年1月3日
 * 
 */
public class SerializableTestIn implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public static int staticVar = 5;
    private String name;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public static void main(String[] args) {
	try {
	    // 初始时staticVar为5
	     SerializableTestIn test1= new SerializableTestIn();
	    ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("result.obj"));
	    out.writeObject( new SerializableTestIn());
	    System.out.println(new File("result.obj").length());
	    out.writeObject(test1);
	     System.out.println(new File("result.obj").length());
	    out.close();

	    // 序列化后修改为10
	    SerializableTestIn.staticVar = 10;

	    ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
	    SerializableTestIn t = (SerializableTestIn) oin.readObject();
	    oin.close();

	    // 再读取，通过t.staticVar打印新的值
	    System.out.println(t.staticVar);

	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }

}
