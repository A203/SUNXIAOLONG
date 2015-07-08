package day03;

public class Fruit01 {
}

class Apple extends Fruit01{
	public String toString(){
		return "苹果";
	}
}

class Mango extends Fruit01{
	public String toString(){
		return "芒果";
	}
}

class Juicer{
	public void juice(Fruit01 fruit){
		System.out.println("榨"+fruit+"汁");
	}
	public static void main(String[] args){
		Juicer j = new Juicer();
		
		Fruit01 fruit  = new Mango();
		
		j.juice(fruit);
	    
		
	}

}
