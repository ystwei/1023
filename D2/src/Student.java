
public class Student {
	
	//����overload:�����������ͬ���ββ�ͬ�ķ����ͽ�����
	Student(){//Ĭ�Ϲ����������ⷽ��������û�з�������
		
		
	}
	Student(int age1,String name1,String no1){//��Ĭ�Ϲ�����
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
	String getName(){//getXXX->��

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
