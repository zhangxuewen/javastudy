package com.study.dataSize;

import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com
 * 2015年1月2日
 * 
 */
public class DatasizeTest implements DataSize {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatasizeTest.class);
    /* (non-Javadoc)
     * @see com.study.dataSize.DataSize#getBasicDataSize()
     */
    public void getBasicDataSize() {
	LOGGER.error("int:"+4 +"字节");
	LOGGER.error("short:"+2+"字节");
	LOGGER.error("long:"+8+"字节");
	LOGGER.error("byte:"+1+"字节");
	LOGGER.error("double:"+4+"字节");
	LOGGER.error("float:"+4+"字节");
	LOGGER.error("char:"+2+"字节");
	LOGGER.error("boolean:"+"本来boolean应该只占用1bit也就是1/8字节的，但实际上，由于Java的实际寻址单元最小是byte即1字节，所以所以实际上boolean占用的是可能是1bit，也可能是更多，这个是不确定的");
	
	

    }

    /* (non-Javadoc)
     * @see com.study.dataSize.DataSize#getStringDataSize()
     */
    public void getStringDataSize() {
	 String str= new String("我人");  
         byte[] sbytes=null;  
         try {
            sbytes = str.getBytes("unicode");//实际上，我们用unicode编码查看字符串"我"的字节序列。发现总是多两个字节。其实前两个字节是一个BOM（ByteOrderMark），用于指明高低字节排列顺序的几个字符，。一般情况下，该 BOM值为0xFE 0xFF，即大端字节序（BIG_ENDIAN）。如果BOM值为0xFF 0xFE则为小端字节序（LITTLE_ENDIAN）
 	    LOGGER.error("Unicode编码字符串的大小"+sbytes.length);
	    sbytes = str.getBytes("utf-8");
	    LOGGER.error("UTF-8编码字符串的大小"+sbytes.length);
	    sbytes = str.getBytes("GBK");
	    LOGGER.error("GBK编码字符串的大小"+sbytes.length);
	    sbytes = str.getBytes();// 大小不一定，你当前的OS默认支持的字符集使用的是UTF-8，则是3个字节。如果是gb2312/gbk，则2个字节。如果使用unicode/UTF- 16则4个字节(开头的两个字节是一个mark)。
	    LOGGER.error("默认字符串的大小"+sbytes.length);

	   
	    
	} catch (UnsupportedEncodingException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }
    public  static void main(String args[]){
	DatasizeTest test =new DatasizeTest();
	test.getBasicDataSize();
	test.getStringDataSize();
    }

    /* (non-Javadoc)
     * @see com.study.dataSize.DataSize#getObjectDataSize()
     */
    public void getObjectDataSize() {
	//HotSpot的对齐方式为8字节对齐  内存大小必须是8的背数
        //对象头在 32位系统上占用8bytes，64位系统上占用16bytes
        //（对象头 + 实例数据 + padding） %8等于0    且    0 <= padding < 8
	
	
       // 对象占用的内存大小  受VM参数UseCompressedOops的影响。 
	//对对象头的影响      开启时64 位系统为 12个字节
	//对引用的影响       reference类型占用8个字节，开启指针压缩后占用4个字节。
	//数组对象的对象头占用24个字节，启用压缩之后占用16个字节
	
    }

}
