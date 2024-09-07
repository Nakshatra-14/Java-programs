import java.util.*;
public class VolumeOfSphere
{
	public static void main(String args[])
	{
		Scanner inp = new Scanner(System.in);
		System.out.print("Enter the Radius: ");
		int r = inp.nextInt();
		float vol = (float)(4.0/3 * Math.PI * (r * r * r));
		System.out.println("Volume: " + vol);
	}
}
