package day03;

public class Person {
	String name;
	int age;
	String address;
	
	
	Person(){
		System.out.println("Person的默认构造方法被调用.....");
	}
	Person(String n,int a,String add){
		name = n;
		age = a;
		address = add;
		
	}
	
	void introduce(){
		
		System.out.println("大家好，我叫"+name+",今年"+age+"岁了,我在"+address+"住");
	}
	
	public static void main(String[] args){
		
		Person person = new Person();
		person.name = "张三";
		person.age = 20;
		person.address = "USA";
	    
	    person.introduce();
	    
	   /* Person person01 = new Person("jim",30,"北京");
	    person01.introduce();*/
	    
	    
	    
	    
		
	}

}
