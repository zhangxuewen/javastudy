package com.study.algorithm.consistenthash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
/**
 *  Hash 算法的一个衡量指标是单调性（ Monotonicity ），定义如下：

　　单调性是指如果已经有一些内容通过哈希分派到了相应的缓冲中，又有新的缓冲加入到系统中。哈希的结果应能够保证原有已分配的内容可以被映射到新的缓冲中去，而不会被映射到旧的缓冲集合中的其他缓冲区。

      容易看到，上面的简单 hash 算法 hash(object)%N 难以满足单调性要求。
      
       虚拟节点

考量 Hash 算法的另一个指标是平衡性 (Balance) ，定义如下：

平衡性

　　平衡性是指哈希的结果能够尽可能分布到所有的缓冲中去，这样可以使得所有的缓冲空间都得到利用。 
*/
public class ConsistentHash<T> {
	/** Hash计算对象，用于自定义hash算法 */
	HashFunc hashFunc;
	/** 复制的节点个数 */
	private final int numberOfReplicas;
	/** 一致性Hash环 */
	private final SortedMap<Integer, T> circle = new TreeMap<Integer, T>(); 
	
	/**
	 * 构造，使用Java默认的Hash算法
	 * @param numberOfReplicas 复制的节点个数，增加每个节点的复制节点有利于负载均衡
	 * @param nodes 节点对象
	 */
	public ConsistentHash(int numberOfReplicas, Collection<T> nodes) {
		this.numberOfReplicas = numberOfReplicas;
		this.hashFunc = new HashFunc() {
			
			public Integer hash(Object key) {
				String data = key.toString();
				//默认使用FNV1hash算法
				final int p = 16777619;
				int hash = (int) 2166136261L;
				for (int i = 0; i < data.length(); i++)
					hash = (hash ^ data.charAt(i)) * p;
				    hash += hash << 13;
				    hash ^= hash >> 7;
				    hash += hash << 3;
				    hash ^= hash >> 17;
				    hash += hash << 5;
				return hash;
			}
		};
		//初始化节点
		for (T node : nodes) {
			add(node);
		}
	}

	/**
	 * 构造
	 * @param hashFunc hash算法对象
	 * @param numberOfReplicas 复制的节点个数，增加每个节点的复制节点有利于负载均衡
	 * @param nodes 节点对象
	 */
	public ConsistentHash(HashFunc hashFunc, int numberOfReplicas, Collection<T> nodes) {
		this.numberOfReplicas = numberOfReplicas;
		this.hashFunc = hashFunc;
		//初始化节点
		for (T node : nodes) {
			add(node);
		}
	}

	/**
	 * 增加节点<br>
	 * 每增加一个节点，就会在闭环上增加给定复制节点数<br>
	 * 例如复制节点数是2，则每调用此方法一次，增加两个虚拟节点，这两个节点指向同一Node
	 * 由于hash算法会调用node的toString方法，故按照toString去重
	 * @param node 节点对象
	 */
	public void add(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.put(hashFunc.hash(node.toString() + i), node);
		}
	}

	/**
	 * 移除节点的同时移除相应的虚拟节点
	 * @param node 节点对象
	 */
	public void remove(T node) {
		for (int i = 0; i < numberOfReplicas; i++) {
			circle.remove(hashFunc.hash(node.toString() + i));
		}
	}

	/**
	 * 获得一个最近的顺时针节点
	 * @param key 为给定键取Hash，取得顺时针方向上最近的一个虚拟节点对应的实际节点
	 * @return 节点对象
	 */
	public T get(Object key) {
		if (circle.isEmpty()) {
			return null;
		}
		int hash = hashFunc.hash(key);
		if (!circle.containsKey(hash)) {
			SortedMap<Integer, T> tailMap = circle.tailMap(hash);	//返回此映射的部分视图，其键大于等于 hash
			hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
		}
		//正好命中
		return circle.get(hash);
	}

	/**
	 * Hash算法对象，用于自定义hash算法
	 * @author xiaoleilu
	 *
	 */
	public interface HashFunc {
		public Integer hash(Object key);
	}
	public static void main(String[] args) {
		ArrayList nodelist=new ArrayList(5);
		nodelist.add("a");
		//nodelist.add("b");
		nodelist.add("c");
		nodelist.add("d");
		ConsistentHash chash=new ConsistentHash(2,nodelist);
		
		System.out.println(chash.circle.size());
		System.out.println(chash.get("a1"));
		System.out.println(chash.get("b1"));
		System.out.println(chash.get("c1"));
		System.out.println(chash.get("d1"));
	}
}
