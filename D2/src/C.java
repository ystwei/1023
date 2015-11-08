public class C{
	public static void main(String [] args){
		int [][][] a={
									{{1,2,3,4,5},{6,7,8,9,10}},
									{{11,12,14,16},{17,18},{19,21},{22}},
									{{24,25},{28,40}}
								 };//x y z
	
		System.out.println(a[1][3][0]);
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[i].length;j++){
				for(int k=0;k<a[i][j].length;k++){
					
					System.out.println(a[i][j][k]);
				}
			}
			
		}
		
		for(int i[][] : a){
			for(int j[] :i ){
				for(int k :j){
					System.out.println(k);
				}
			}
			
		}
		
		
		/*for(int i=0;i<a.length;i++){//ÐÐ
			for(int j=0;j<a[i].length;j++){
				System.out.println(a[i][j]);
			}			
		}
		for(int i[] :a){
			
			for(int j :i){
				System.out.println(j);
				
			}
		}*/
		
	}

}