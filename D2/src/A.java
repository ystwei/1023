import java.util.*;

public class A{

	public static void main(String [] args){
		
		int [] a={2,4,1,5,9,3};
		
		//int [] b={10,11,12,14};
		//int [] a=new int[10];//0..9
		//Arrays.fill(a,10);
		//System.arraycopy(a,1,b,2,3);
		
		Arrays.sort(a);
	//	int [] b=Arrays.copyOfRange(a,2,5);
		System.out.println(Arrays.binarySearch(a,10));
		
		/*for(int i :b ){
			System.out.println(i);
			
		}*/
		
	}
}