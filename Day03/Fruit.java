package day03;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Fruit {
	
	
	String name;
	int price;
	String addr;
	
	Fruit(){}
	Fruit(String n,int p,String a){
		name = n;
		price = p;
		addr = a;
	}
	public static void main(String[] args){
		Fruit f = new Fruit("苹果",34,"山东");
		System.out.println("ˮ水果名："+f.name+"价格："+f.price+"销售地址："+f.addr);
	}

}
