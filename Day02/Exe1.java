
public class Exe1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] Score=new int[20][7];
		String[] biaoTi={"coreC++","coreJava","Servlet","JSP","EJB","总分","平均分"};
		for(int i=0;i<biaoTi.length;i++)
		{
			System.out.print(biaoTi[i]+"  ");
		}
		System.out.println();
		for(int h=0;h<Score.length;h++)
		{
			int m=0;
			for(int l=0;l<5;l++)
			{
				Score[h][l]=(int)(Math.random()*90+10);
				m=m+Score[h][l];
				System.out.print("  "+Score[h][l]+"        ");
			}
			System.out.print(m);
			System.out.print("        "+m/(Score[h].length-2));
			System.out.println();
		}
	}
}
