package day03;

public class ABTest {
	public static void main(String[] args){
		A a = new A();
		System.out.println(a.str);
		a.hello();
		
		B b = new B();
		System.out.println(b.str);
		b.hello();
		
		A c =new B();
		System.out.println(c.str);
		c.hello();
	}

}
