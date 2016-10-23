package algorithm;

import java.util.Scanner;
public class SelectionSort {
	private static boolean less(int v, int w)
	{ return v<w; }
	private static void exch(int[] a, int i, int j)
	{ int t = a[i]; a[i] = a[j]; a[j] = t; }
	private static void show(int[] a)
	{ // 在单行中打印数组
		for (int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
//		System.out.println();
	}
	public static boolean isSorted(int[] a)
	{ // 测试数组元素是否有序
		for (int i = 1; i < a.length; i++)
			if (less(a[i], a[i-1])) return false;
		return true;
	}

	public static void sort(int[] a)
	{
		int N = a.length;
		for(int i=0;i<N;i++)
		{
			int min = i;
			for(int j=i+1;j<N;j++)
			{
				if(less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}
	
	public static void main(String args[])
	{
		Scanner in = new  Scanner(System.in);
		int[] array = new int[10];
		for(int i=0;i<array.length;i++)
		{
			System.out.println("请输入一个数字");
			array[i] = in.nextInt();
		}
		sort(array);
		assert isSorted(array);
		show(array);
		in.close();
	}
}
