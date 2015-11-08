import java.util.*;
public class B{
	public static void main(String [] args){
		int a[]={4,1,2,6,7,10,1,5,23,6,7,8,9,123,123,65,7,23,546,0};//1 2   4 6 7 10
		Arrays.sort(a);
		
		System.out.println(binarySearch(a,9));		
	}
	public static int binarySearch(int [] a,int key){
		//1
		int lo=0;
		int hi=a.length-1;//5
		int index=-1;
		while(lo<=hi){			
			int mid=(lo+hi)/2;//2
			
			if(key<a[mid]){//向左查找
				hi=mid-1;				
			}else if(key>a[mid]){//向右查找				
				lo=mid+1;				
			}else{
				index=mid;	
				break;			
			}
		}
		return index;
	}
}