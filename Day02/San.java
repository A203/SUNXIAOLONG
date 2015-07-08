import java.util.Scanner;


public class San {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Scanner input =new Scanner(System.in);
    System.out.println("«Î ‰»Î––∫≈£∫");
    int num=input.nextInt();
    input.close();
    for(int i=1;i<=num;i++){
	     for(int j=1;j<=num-i;j++){
             System.out.println(" ");
           }
	     for(int j=1;j<=i*2-1;j++){
             System.out.println("*");
             }
	     System.out.println(); 
	     }    
    }
}