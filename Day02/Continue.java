package day02;

public class Continue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=0;
		for(int i=1;i<=99;i++){
			if(i%5==0){
			System.out.println(i);
			continue;
			}
			num++;//记录不符合要求的数字
		}
		System.out.print("num:"+num);
	}

}
