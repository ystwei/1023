public class E{
	public static void main(String [] args){
		
		int a[]={1,4,2,6,10,11,8};
		int start=0;
		int end =a.length-1;
		quickSort(a,start,end);
		for(int i :a){
			System.out.println(i);
		}
		
	}
	public static void quickSort(int [] a,int start ,int end){
		
		int i=start;
		int j=end;
		if(i>=j){
			return;
		}
		boolean flag=true;//true:R--L false:L---R
		while(i!=j){//第一次大快排
			int m=0;
			if( a[i]-a[j]>0   ){				
				m=a[i];
				a[i]=a[j];
				a[j]=m;				
				flag=flag==true?false:true;
			}
			if(flag){
				j--;
			}else{				
				i++;
			}
		}
		
		i--;
		j++;
		quickSort(a,start,i);
		
		quickSort(a,j,end);
		
	}
}