
public class People {
	int old;//��������Ա����
	int getOld(){//��Ա����
		return old;
	}
	void setOld(int old1){
		old=old1;
		
	}
	People(){//Ĭ�Ϲ��������βεĸ��� ˳�� ���ͣ�����overload
		
	}
	People(int old1){//��Ĭ�Ϲ�����
		old=old1;
	}
	
	public static void main(String[] args) {
		
		People p=new People();//����=������=����
		p.setOld(100);
		System.out.println(p.getOld());
		
		People p1=new People();
		p1.setOld(1000);
		
		System.out.println(p.getOld());
	}
}
