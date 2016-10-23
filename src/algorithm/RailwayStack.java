package algorithm;
import java.util.Scanner;

public class RailwayStack {
	public int[] cars;

	private void swap(int j,int k){
		int temp = this.cars[j];
		this.cars[j] = this.cars[k];
		this.cars[k] = temp;
	}

	private static boolean more(int v, int w)
	{ return v>w; }

	private static void exch(int[] a, int i, int j)
	{ int t = a[i]; a[i] = a[j]; a[j] = t; }

	public static void sort(int[] a){
		int N = a.length;
		for(int i=0;i<N;i++)
		{
			int min = i;
			for(int j=i+1;j<N;j++)
			{
				if(more(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
		}
	}

	public void permutation(int[] a,int k,int m)  
	{  
		int j;  
		if(k == m){  
			judge(a);
			//int i;
			//			for(i=0;i<=m;i++){  
			//				System.out.print(a[i]);
			//			}  
			//			System.out.print("\n");  
		}  
		else{  
			for(j=k;j<=m;j++){  
				swap(j,k);  
				permutation(a,k+1,m);  
				swap(j,k);  
			}  
		}  
	}  

	public boolean equal(int[] temp,int[] temp2){
		for(int i=0;i<temp.length&&i<temp2.length;i++){
			if(temp.length!=temp2.length)
				return false;
			if(temp[i]!=temp2[i])
				return false;
		}
		return true;
	}
	public void judge(int[] a){
		for(int i = 0;i<a.length-1;i++){
			int[] temp = new int[a.length];

			for(int j=0;j<temp.length;j++) temp[j]=0;

			for(int j=i+1, k=0;j<a.length;j++){
				if(a[i]>a[j]){
					temp[k]=a[j];
					k++;
				}
			}

			int[] temp2 = new int[a.length];

			for(int j=0;j<temp.length;j++){
				temp2[j]=temp[j];
			}

			sort(temp);

			if(equal(temp, temp2)){
				if (i==a.length-2) {
					for (int b = 0; b < temp.length; b++) {
						System.out.print(a[b]);
					}
					System.out.println(" is okay");
				}
			}
			else{
				for(int b=0;b<temp.length;b++){
					System.out.print(a[b]);
				}
				System.out.println(" is not okay");
				break;
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of cars");
		int size = input.nextInt();
		RailwayStack railwayStack = new RailwayStack();
		railwayStack.cars = new int[size];
		int i=0;
		for(;i<size;i++){
			railwayStack.cars[i]=i+1;
		}
		railwayStack.permutation(railwayStack.cars, 0, size-1);
		//		int[] a={1,3,4,2};
		//		railwayStack.judge(a);
		input.close();
	}
}
