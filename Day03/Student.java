package day03;

public class Student {
	int number;
	String name;
	String adress;
	void introduceMyself(){
		System.out.println("��Һ�");
	}
	
	public static void main(String[] args){
		Student i = new Student();
		i.number = 278;
		i.adress = "�Ϸʹ�ҵ��ѧ";
		i.name = "ǳ��ook";
		
		i.introduceMyself();
		System.out.println("�ҵ����ֽ�"+i.name);
		System.out.println("��ס��"+i.adress);
		System.out.println("�ҵ�ѧ����"+i.number);
		i.introduceMyself();
	}
}
