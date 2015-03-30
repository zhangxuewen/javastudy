package com.study.algorithm;

import java.util.Arrays;

/**
 * @author zhangxuewe
 * @email zhang1234xuewen@163.com 2015年1月25日
 * 
 */

public class JavaSort {

    // 冒泡排序
    // 冒泡排序比插入排序更简单，把最大的元素逐步推到最高位(当前须处理子数组的最高位)。依我的理解，冒泡排序是一个一层层筑顶的过程。顶筑好了，排序也就好了。冒泡排序的最坏运行时间是O(n2)，效率和插入排序一样。
    public static void bubbleSort(int[] a) {
	for (int i = 0; i < a.length; i++) {
	    for (int j = a.length - 1; j >= i + 1; j--) {
		if (a[j] < a[j - 1]) {
		    int tmp = a[j];
		    a[j] = a[j - 1];
		    a[j - 1] = tmp;
		}
	    }
	}
    }

    // 插入排序
    // 插入排序就是把当前待排序的元素插入到一个已经排好序的列表里面。
    // 一个非常形象的例子就是右手抓取一张扑克牌，并把它插入左手拿着的排好序的扑克里面。插入排序的最坏运行时间是O(n2)，
    // 所以并不是最优的排序算法。特点是简单，不需要额外的存储空间，在元素少的时候工作得好。
    public static void insertSort(int[] a) {
	int i = 0;
	for (int j = 1; j < a.length; j++) {
	    int keys = a[j];
	    i = j - 1;
	    while (i >= 0 && a[i] < keys) {
		a[i + 1] = a[i];
		i--;
	    }
	    a[i + 1] = keys;
	}
    }

    // 选择
    // 选择排序与冒泡排序非常的相似，都是一层层筑顶的过程，不同点在于冒泡排序会频繁的互换位置，而选择排序只是记录最大元素的位置，并与顶互换，只需交换一次。所以选择排序与冒泡排序相比时间常数会更小，更有效率，尽管他们的最坏运行时间都是O(n2)。
    public static void choiceSort(int[] a) {
	if (a == null || a.length <= 0) {
	    return;
	}
	for (int i = 0; i < a.length; i++) {
	    int min = i; /* 将当前下标定义为最小值下标 */

	    for (int j = i + 1; j < a.length; j++) {
		if (a[min] > a[j]) { /* 如果有小于当前最小值的关键字 */
		    min = j; /* 将此关键字的下标赋值给min */
		}
	    }
	    if (i != min) {/* 若min不等于i，说明找到最小值，交换 */
		int tmp = a[min];
		a[min] = a[i];
		a[i] = tmp;
	    }
	}
    }

    // 归并排序是一个分治算法(Divide and
    // Conquer)的一个典型实例，把一个数组分为两个大小相近(最多差一个)的子数组，分别把子数组都排好序之后通过归并(Merge)手法合成一个大的排好序的数组，归并的过程依然用扑克来解释，想象一下桌子上有两堆排好序(从小到大)的牌，每一次从两堆里面各抽取一张，比较一下两张的大小，如果两张一样大，都取出放到目标数组，否则取出较小的放到目标数组，另外一个放回原堆里面。归并排序需要额外的空间来存储临时数据，不过它的最坏运行时间都是O(nlogn)。

    public static void mergeSort(int[] array) {
	sortArray(array, 0, array.length - 1);
    }

    private static void sortArray(int[] array, int start, int end) {
	// 单个元素不需要排序,直接返回
	if (start == end) {
	    return;
	}

	int sortSize = end - start + 1;
	int seperate;
	if (sortSize % 2 == 0) {
	    seperate = start + sortSize / 2 - 1;
	} else {
	    seperate = start + sortSize / 2;
	}

	sortArray(array, start, seperate);
	sortArray(array, seperate + 1, end);

	mergeArray(array, start, seperate, end);
    }

    private static void mergeArray(int[] array, int start, int seperate, int end) {
	int totalSize = end - start + 1;
	int size1 = seperate - start + 1;
	int size2 = end - seperate;

	int[] array1 = new int[size1];
	int[] array2 = new int[size2];

	for (int i = 0; i < size1; i++) {
	    array1[i] = array[start + i];
	}

	for (int i = 0; i < size2; i++) {
	    array2[i] = array[seperate + 1 + i];
	}

	int mergeCount = 0;
	int index1 = 0;
	int index2 = 0;

	while (mergeCount < totalSize) {
	    // 先检查有没有其中的一个数组已经处理完
	    if (index1 == size1) {
		for (int i = index2; i < size2; i++) {
		    array[start + mergeCount] = array2[i];
		    mergeCount++;
		    index2++;
		}
	    } else if (index2 == size2) {
		for (int i = index1; i < size1; i++) {
		    array[start + mergeCount] = array1[i];
		    mergeCount++;
		    index1++;
		}
	    } else {
		int value1 = array1[index1];
		int value2 = array2[index2];

		if (value1 == value2) {
		    array[start + mergeCount] = value1;
		    array[start + mergeCount + 1] = value1;
		    mergeCount += 2;
		    index1++;
		    index2++;
		} else if (value1 < value2) {
		    array[start + mergeCount] = value1;
		    mergeCount++;
		    index1++;
		} else if (value1 > value2) {
		    array[start + mergeCount] = value2;
		    mergeCount++;
		    index2++;
		}
	    }
	}
    }

    
	   


	public static void quickSort(int[] array) {
	    subQuickSort(array, 0, array.length - 1);
	}

	private  static void subQuickSort(int[] array, int start, int end) {
	    if (array == null || (end - start + 1) < 2) {
		return;
	    }

	    int part = partition(array, start, end);

	    if (part == start) {
		subQuickSort(array, part + 1, end);
	    } else if (part == end) {
		subQuickSort(array, start, part - 1);
	    } else {
		subQuickSort(array, start, part - 1);
		subQuickSort(array, part + 1, end);
	    }
	}

	public static  int partition(int[] array, int start, int end) {
	    int value = array[end];
	    int index = start - 1;

	    for (int i = start; i < end; i++) {
		if (array[i] < value) {
		    index++;
		    if (index != i) {
			exchangeElements(array, index, i);
		    }
		}
	    }

	    if ((index + 1) != end) {
		exchangeElements(array, index + 1, end);
	    }

	    return index + 1;
	}
   

    public static void exchangeElements(int[] array, int index1, int index2) {
	int temp = array[index1];
	array[index1] = array[index2];
	array[index2] = temp;
    }

    public static void main(String[] args) {
	int[] a = { 5, 2, 4, 6, 1, 3, 0 };
	JavaSort.bubbleSort(a);
	System.out.println(Arrays.toString(a));

	int[] b = { 5, 2, 4, 6, 1, 3, 0 };
	JavaSort.insertSort(b);
	System.out.println(Arrays.toString(b));

	int[] c = { 5, 2, 4, 6, 1, 3, 0 };
	JavaSort.choiceSort(c);
	System.out.println(Arrays.toString(c));

	int[] d = { 5, 2, 4, 6, 1, 3, 0 };
	JavaSort.mergeSort(d);
	System.out.println(Arrays.toString(c));
	
	int[] e = { 5, 2, 4, 6, 1, 3, 0 };
	JavaSort.quickSort(e);
	System.out.println(Arrays.toString(e));
	;
    }
}