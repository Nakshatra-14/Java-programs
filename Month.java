import java.util.*;

public class Month
{
	public static void main(String Args[])
	{
		Scanner inp = new Scanner(System.in);
		String month[] = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
		System.out.print("Enter month no.: ");
		int n = inp.nextInt();
		System.out.println(month[n - 1]);
	}
}
