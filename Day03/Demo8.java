package day03;

public class Demo8 {

	int age;
	
	static void hello(){
		System.out.println("hello......");
	}
	static String name = "熊";
	
	void hi(){
		System.out.println("hi....");
	}
	
	public static void main(String[] args){
		Demo8 d = new Demo8();
		Demo8.hello();
		d.hi();
		System.out.println(Demo8.name);
		
		
		
	}
	
	
}
