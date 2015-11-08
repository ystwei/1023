public class D{
	
	public static void main(String [] args){
		
		int a[]={4,1,5,2,6,9,3};
		bubble(a);
	}
	public static void bubble(int a[]){
		
		for(int i=0;i<a.length-1;i++){//0..5 6
			
			for(int j=0;j<a.length-1-i;j++){				
				int m=0;				
				if(a[j]-a[j+1]>0){
					m=a[j];
					a[j]=a[j+1];
					a[j+1]=m;
				}
				
			}
		}
		for(int i :a){
			System.out.println(i);
		}
		
	}
	
	
}