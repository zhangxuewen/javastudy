package com.study.algorithm.bloomfilter;

import java.util.BitSet;

/**
 * 布隆算法，提供给灰度上传的大数据存储使用
 */
public class BloomFilter {
	public static final int DEFAULT_SIZE = 2 << 25;// 布隆过滤器的比特长度
	private static final int[] seeds = { 3, 5, 7, 11, 13, 31, 37, 61 };// 这里要选取质数，能很好的降低错误率
	private static SimpleHash[] func = new SimpleHash[seeds.length];

	static {
		for (int i = 0; i < seeds.length; i++) {
			func[i] = new SimpleHash(DEFAULT_SIZE, seeds[i]);
		}
	}

	public static void addValue(String value, BitSet bits) {
		for (SimpleHash f : func)
			// 将字符串value哈希为8个或多个整数，然后在这些整数的bit上变为1
			bits.set(f.hash(value), true);
	}

	public static void add(String value, BitSet bits) {
		if (value != null)
			addValue(value, bits);
	}

	public static boolean contains(String value, BitSet bits) {
		if (value == null)
			return false;
		boolean ret = true;
		for (SimpleHash f : func)
			// 这里其实没必要全部跑完，只要一次ret==false那么就不包含这个字符串
			ret = ret && bits.get(f.hash(value));
		return ret;
	}
	  public static void  main(String[] args) {
	         String value  = "stone2083@yahoo.cn" ;
	         BitSet set=new BitSet(DEFAULT_SIZE);
	         System.out.println(BloomFilter.contains(value,set));
	         BloomFilter.add(value,set);
	         System.out.println(BloomFilter.contains(value,set));
	   }
}

class SimpleHash {// 这玩意相当于C++中的结构体

	private int cap;
	private int seed;

	public SimpleHash(int cap, int seed) {
		this.cap = cap;
		this.seed = seed;
	}

	public int hash(String value) {// 字符串哈希，选取好的哈希函数很重要
		int result = 0;
		int len = value.length();
		for (int i = 0; i < len; i++) {
			result = seed * result + value.charAt(i);
		}
		return (cap - 1) & result;
	}
}