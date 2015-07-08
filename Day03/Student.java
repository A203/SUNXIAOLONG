package day03;

public class Student {
	int number;
	String name;
	String adress;
	void introduceMyself(){
		System.out.println("大家好");
	}
	
	public static void main(String[] args){
		Student i = new Student();
		i.number = 278;
		i.adress = "合肥工业大学";
		i.name = "浅橙ook";
		
		i.introduceMyself();
		System.out.println("我的名字叫"+i.name);
		System.out.println("我住在"+i.adress);
		System.out.println("我的学号是"+i.number);
		i.introduceMyself();
	}
}
