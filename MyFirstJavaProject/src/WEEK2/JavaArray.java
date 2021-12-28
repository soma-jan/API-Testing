package WEEK2;

public class JavaArray {
	public static void main (String args[])
	{
		int  number[] = {9, 900, 87, 675, 45, 88, 338, 101,500};
		int j=0;
		for(int i=0;i<number.length;i++) {
			if(number[i]>100)
			{
				j++;
			}
			
		}
		System.out.print(j + "j"+ "values are greater than 100");
		
	}

}
