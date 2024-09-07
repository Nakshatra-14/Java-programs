import java.util.*;
public class AreaOfTriangle
{
	public static void main(String args[])
	{
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter Side A: ");
;		int a = inp.nextInt();
		System.out.print("Enter Side B: ");
		int b = inp.nextInt();
		System.out.print("Enter Side C: ");
		int c = inp.nextInt();
		float s = (float)((a + b + c) / 2);
		double n = s*(s-a)*(s-b)*(s-c);
		float area = (float) Math.sqrt(n);
		System.out.println("Area : " + area);
	}
}
