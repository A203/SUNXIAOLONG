package day03;

public class ArraryPractice01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int[] arr = {21,13,91,23,72,78,88};
    int sum = 0;
    int max = arr[0];
    int min = arr[0];
    
    for(int i = 0;i<arr.length;i++){
    	sum = sum + arr[i];
    	if(arr[i]>max){
    		max = arr[i];
         continue;	
    	}
    	if(arr[i]<min){
    		min = arr[i];
    	}
    	
    }
    System.out.println("sum:"+sum);
    System.out.println("min:"+min);
    System.out.println("max:"+max);
  
	}

}
