package algorithm;
import java.util.Scanner;

public class KMPFF {

	public int[] failureFunction(String sub)
	{
		int[] a = new int[sub.length()];
		char[] c = sub.toCharArray();
		int length=sub.length();
		int i,j;
		a[0] = -1;
		i = 0;
		for(j=1;j<length;j++) {
			i = a[j - 1];
			while(i>=0&&c[j]!=c[i+1]) {
				i = a[i];    
			}
			if(c[j]==c[i+1]) {
				a[j] = i+1;
			}
			else {
				a[j] = -1;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KMPFF kmpff = new KMPFF();
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int[] ff = kmpff.failureFunction(input);
		for(int i = 0;i<ff.length;i++)
		{
			System.out.println(ff[i]);
		}
		in.close();
	}

}
