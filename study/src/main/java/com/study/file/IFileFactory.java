package com.study.file;


/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com
 * 2015年1月2日
 * 
 */
public interface IFileFactory {
    /*
     * 按字节流读取
     * 一般用于二进制的文件读取
     */
    public byte[] readFileByBytes(String fileName) ;
     /*
      * 按离符流读取
      * 一般用于文本文件 的读取
      */
    public char[] readFileByChars(String fileName);
    /*
     * 按按读取，
     * 一般用于有格式的文本文件读取
     */
    public String[] readFileByLines(String fileName);
    public  void WriteFileByBytes(String fileName) ;
    public  void WriteFileByChars(String fileName);
    public  void WriteFileByLines(String fileName);
}
