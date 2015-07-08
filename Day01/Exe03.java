package Exe;

public class Exe03 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte b = 0;
		short s = 0;
		int i = 0;
		long l = 1;
		float f = 0;
		double d = 0;
	//	float f1 = 0.1;		//可能损失精度
		float f1 = 0.1F;	//正确
	//	i = l;				//可能损失精度
	//	int j = 0.5 * 10;	//可能损失精度
		double j = 0.5 * 10;
	//	byte k = b + 0;		//可能损失精度
	
	/*	①整数字面量为整数(int)；
		②小数字面量为双精度(double)；
		③byte和short型可以直接用字面量赋值；
	*/

		byte k = (byte)(b + 12);		//强制类型转换
	//	byte k = (byte)(b + 200);		//越界，运行结果为 -56
		System.out.println(k);
	}
}
