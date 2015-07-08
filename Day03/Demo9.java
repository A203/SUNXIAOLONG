package day03;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Demo9 {
	public static void main(String[] args){
		Calulator c1 = new Calulator();
		Calulator c2 = new Calulator();
		c1.a();
		System.out.println(c1.num1);
		System.out.println(c1.num2);
		System.out.println("-------");
		System.out.println(c2.num1);
		System.out.println(c2.num2);
				
	}

}

class Calulator{
	static int num1 = 1;
	int num2 = 2;
	
	void a(){
		num1 = 9;
		num2 = 10;
		
		
	}
	
}
