package day03;

public class Person {
	String name;
	int age;
	String address;
	
	
	Person(){
		System.out.println("Person��Ĭ�Ϲ��췽��������.....");
	}
	Person(String n,int a,String add){
		name = n;
		age = a;
		address = add;
		
	}
	
	void introduce(){
		
		System.out.println("��Һã��ҽ�"+name+",����"+age+"����,����"+address+"ס");
	}
	
	public static void main(String[] args){
		
		Person person = new Person();
		person.name = "����";
		person.age = 20;
		person.address = "USA";
	    
	    person.introduce();
	    
	   /* Person person01 = new Person("jim",30,"����");
	    person01.introduce();*/
	    
	    
	    
	    
		
	}

}
