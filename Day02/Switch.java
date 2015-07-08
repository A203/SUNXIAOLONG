package day02;

import java.util.Scanner;

public class Switch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner scanner=new Scanner(System.in);
int day=scanner.nextInt();
scanner.close();
String monthString="";
switch(day)
{
case 1:monthString="monday";break;
case 2:monthString="tuesday";break;
case 3:monthString="wednesday";break;
case 4:monthString="thursday";break;
case 5:monthString="mfriday";break;
case 6:monthString="msaturday";break;
case 7:monthString="sunday";break;
default:monthString="error day";
}
	System.out.println(monthString);
	}

}