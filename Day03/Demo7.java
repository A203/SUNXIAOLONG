package day03;


public class Demo7 {
	public static void main(String[] args){
	Person01 person = new Person01("王明",87,"山东");
	person.introduce();
	
		
	}
}

class Person01{
	String name;
	int age;
	String address;
	
	public Person01(){}
	public Person01(String name,int age){
		this.name = name;
		this.age = age;
	}
	
	public Person01(String name,int age,String address){
		this(name,age);
		this.address = address;
	}
	void hello(){
		System.out.println("hello....");
	}
	
	void introduce(){
      System.out.println("name:"+this.name+"\tage:"+this.age+"\taddress"+this.address);
	  this.hello();
	}
	
}
