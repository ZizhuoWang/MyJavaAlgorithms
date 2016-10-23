package algorithm;
import java.util.Random;
import java.util.Scanner;


public class RandomWalk {
	public int ibug,jbug,n,m;
	public int[][] count;
	private int[] imove={-1,0,1,1,1,0,-1,-1};
	private int[] jmove={1,1,1,0,-1,-1,-1,0};
	public int countSteps = 1;
	public int allWalked = 0;

	public RandomWalk(int i,int j,int n,int m)
	{
		count = new int[n][m];
		for(int a=0;a<n;a++){
			for(int b=0;b<m;b++)
				count[a][b]=0;
		}

		this.ibug = i;
		this.jbug = j;
		this.n = (n>2&&n<=40)?n:3;
		this.m = (m>=2&&m<=20)?m:2;
	}
	private boolean isValid(int i,int j)
	{
		if(i<0||j<0||i>=n||j>=m)
			return false;
		else
			return true;
	}
	public void move()
	{
		int moveNum = new Random().nextInt(8);
		
		count[ibug][jbug]++;
		allWalked++;
		
		while(countSteps<500000){
			if(isValid(ibug+imove[moveNum], jbug+jmove[moveNum])){
				if(count[ibug+imove[moveNum]][jbug+jmove[moveNum]]==0){
					allWalked++;
				}
				count[ibug+imove[moveNum]][jbug+jmove[moveNum]]++;
				countSteps++;
				ibug+=imove[moveNum];
				jbug+=jmove[moveNum];
			}
			moveNum = new Random().nextInt(8);
			if(allWalked==n*m)
				break;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the original position\n");
		System.out.print("i: ");
		int i = input.nextInt();
		System.out.print("j: ");
		int j = input.nextInt();
		System.out.print("Please enter the properties of the floor\n");
		System.out.print("n:");
		int n = input.nextInt();
		System.out.print("m:");
		int m = input.nextInt();
		RandomWalk randomWalk = new RandomWalk(i, j, n, m);
		randomWalk.move();
		System.out.print("The number of steps:"+randomWalk.countSteps+"\n");
		input.close();
		for(int c=0;c<randomWalk.n;c++){
			for(int d=0;d<randomWalk.m;d++){
				System.out.print(randomWalk.count[c][d]+" ");
			}
			System.out.print("\n");
		}
	}
}
