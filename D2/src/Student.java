
public class Student {
	
	//重载overload:方法里，名称相同，形参不同的方法就叫重载
	Student(){//默认构造器，特殊方法，就是没有返回类型
		
		
	}
	Student(int age1,String name1,String no1){//非默认构造器
		name=name1;
		no=no1;
		age=age1;
	}
	String no;//int char String
	String name;//MIKE
	char sex='m';
	int age=100;
	//getXXX
	//setXXX
	int old=100;
	String getName(){//getXXX->出

		return name;
	}
	void setName(String name1){
		name=name1;

	}
	int getAge(){
		return age;

	}
	void setAge(int age1){
		age=age1;
		

	}
	public static void main(String[] args) {
		Student s=new Student();
		s.setAge(90);
		System.out.println(s.getAge());
		
		
	}

}
