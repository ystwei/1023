
public class Cat extends  ColorCat{//extends:��չ
	Cat(int i) {
		// TODO Auto-generated constructor stub
	}
	public void miaomiao(){
		
	}
	public static void main(String[] args) {
		Cat c=new Cat();
		
		
		Cat c1=new Cat();
		System.out.println(c.toString());//c.getClass()+@+c.hashCod()
		System.out.println(c==c1?"��":"��");//c.getClass()+@+c.hashCod()
	}
	Cat() {
		// TODO Auto-generated constructor stub
	}
}
class ColorCat {
	public void go(){
		System.out.println("go");
	}
	ColorCat(int old){
		
	}
	ColorCat(){
		
	}
}