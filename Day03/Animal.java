package day03;

public abstract class Animal {
	
	public abstract void  sleep();

}

class Tiger extends Animal{

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("趴着睡");
	}
}

class Monkey extends Animal{
	public  void sleep(){
		System.out.println("躺着睡.");
	}
}
//ĳ�����ǳ����࣬���������ǿ���û�г��󷽷�
