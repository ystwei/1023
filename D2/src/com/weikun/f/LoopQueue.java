package com.weikun.f;

public class LoopQueue<T> {
	//��������ĳ��ȡ�
	private int capacity;
	//����һ���������ڱ���ѭ�����е�Ԫ��
	private Object[] elementData;
	//����ѭ��������Ԫ�صĵ�ǰ����
	private int front = 0;
	//��β
	private int rear = 0;
	public LoopQueue(T data,int initsize){
		this.capacity=initsize;
		elementData=new Object[initsize];
		elementData[0]=data;
		rear++;
		
	}
	public int length(){//ѭ�����е�Ԫ�صĳ���
		
		return this.rear>this.front?this.rear-this.front:this.capacity-(this.front-this.rear);
		
	}
	public void add(T element){
//		if((rear==front)&&(elementData[front]!=null)){//һ����������
//			System.out.println("��������");
//			return;
//		}
		elementData[rear++]=element;
		rear= rear==this.capacity? 0:rear ;//����++֮��Ҳ������
		
	}
	public T remove(){
		
		if(empty()){			
			System.out.println("���пյ�");
			return null;
		}
		
		T old=(T)elementData[front];//��Ԫ��
		
		elementData[front++]=null;//�����Ԫ�أ�����ʹfrontָ����һ��
		
		front=front==this.capacity?0:front;//�ж��Ƿ���ȫɾ����
		
		return old;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		if(this.rear-this.front>0){
			
			for(int i=front;i<rear;i++){
				sb.append(elementData[i]);
			}
			
		}else{
			//�п���rear�ڲ�ͣ��++��Ծ���˽���
			for(int i=front;i<capacity;i++){
				sb.append(elementData[i]);
			}
			for(int i=0;i<rear;i++){
				sb.append(elementData[i]);
			}
			
		}
		System.out.println(elementData.toString());
		return sb.toString();
	}
	public T element(){//���ضӶ�Ԫ��		
		
		return (T)elementData[front];
	}
	public boolean empty(){
		return rear==front&&elementData[rear]==null;
	}
	public static void main(String[] args) {
		LoopQueue l=new LoopQueue(100,3);
		l.add(200);
		l.add(300);
		l.add(400);
		l.remove();
		l.add(500);	
		System.out.println(l);
		
	}
}
