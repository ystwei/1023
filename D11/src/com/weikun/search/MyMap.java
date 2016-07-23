package com.weikun.search;


public class MyMap<K,V> {
	
	private int size;// ��ǰ����
	private static int INIT_CAPACITY = 16;// Ĭ������
	private Entry<K, V>[] container;// ʵ�ʴ洢���ݵ��������
	
	/**
	 * ����ʵ�ʱ������ݵ��ڲ���,��Ϊ���ù����������ͻ�����ڲ������Ϊ������ʽ
	 * 
	 * @param <K>key
	 * @param <V>
	 *            value
	 */
	class Entry<K, V> {
		Entry<K, V> next;// ��һ�����
		K key;// key
		V value;// value
		int hash;// ���key��Ӧ��hash�룬��Ϊһ����Ա���������´���Ҫ�õ�ʱ����Բ������¼���

		// ���췽��
		Entry(K k, V v, int hash) {
			this.key = k;
			this.value = v;
			this.hash = hash;
		}
		//��Ӧ��getter()����
	}
	private static float LOAD_FACTOR = 0.75f;// 
	//װ������:����hash�����Ѿ��洢�Ĺؼ��ָ�����
	//�����ɢ��λ�õı�ֵ��������hash���е�ӵ�������
	//һ����ԣ���ֵԽ����Խ���׷�����ͻ����Ӧ��ASL(ƽ�����ҳ���)Ҳ����
	private int max;// �ܴ��������=capacity*factor
	
	public MyMap(int INIT_CAPACITY,float load_factory){
		
		this.LOAD_FACTOR=load_factory;
		this.max=(int)(INIT_CAPACITY*load_factory);
		container=new Entry[INIT_CAPACITY];
	}
	public void put(K k ,V v){
		
		
		int hashcode=k.hashCode();
		
		Entry<K,V> entry=new Entry<K,V>(k,v,hashcode);
		if(setEntry(entry,container)){
			this.size++;
			
		}
	}
	/**����
	 * 
	 * 
	 * @param newSize
	 */
	private void reSize(int newSize) {
		Entry<K,V> newentry[]=new Entry[newSize];
		this.max=(int)(this.LOAD_FACTOR*newSize);
		for(int i=0;i<this.container.length;i++){
			
			Entry<K,V> temp=this.container[i];
			
			while(temp!=null){
				
				this.setEntry(temp, newentry);
				
				temp=temp.next;
			}
		}
		this.container=newentry;
	}
	/**
	 *��ָ���Ľ��temp��ӵ�ָ����hash��table����
	 * ���ʱ�жϸý���Ƿ��Ѿ�����
	 * ����Ѿ����ڣ�����false
	 * ��ӳɹ�����true
	 * @param temp
	 * @param table
	 * @return
	 */
	public boolean setEntry(Entry<K,V> temp ,Entry<K,V> [] table){
		int index=this.index(temp.key.hashCode(), table.length);
		
		Entry<K,V> a=table[index];
		if(a!=null){//�����Ѿ��ڸ������д��ڡ�
			//��Ȼtemp��a��hash����ͬ��������Ҫ�ж���equals�Ƿ����
			while(a!=null){
				if( (temp.key==a.key||temp.key.equals(a.key))&&					
						(temp.value==a.value||temp.value.equals(a.value))
						&&
						(temp==a||temp.equals(a))
						){
					return false;//ͬһ������
					
					
				}else if(temp.key!=a.key && temp.value!=a.value){
					
					if(a.next==null){
						break;
					}
					
				}
				a=a.next;
			}
			
			
			this.addEntry2Last(a, temp);
		}
		
		setFirstEntry(temp,index,table);
		return true;
	}
	/*
	 * ��һ��Ԫ�أ�����ͷ��
	 */
	private void setFirstEntry(Entry<K, V> temp, int index, Entry<K,V>[] table) {
		if(this.size>this.max){
			this.reSize(this.container.length*4);
		}
		table[index]=temp;
		temp.next=null;
	}
	private void addEntry2Last(Entry<K, V> entry, Entry<K, V> temp) {
		if(size>this.max){
			this.reSize(container.length * 4);
		}
		
		entry.next=temp;
	}
	public MyMap(){
		this(INIT_CAPACITY,LOAD_FACTOR);
	}
	/**
	 * ����hash�룬��������ĳ���,����ù�ϣ�������������е��±�ֵ
	 * 
	 * @param hashcode
	 * @param containerLength
	 * @return
	 */
	public int index(int hashcode,int length){
		int i=hashcode&(length-1);
		return i;
	}
	public V get(K k){
		int index=this.index(k.hashCode(), this.container.length);
		Entry<K,V> entry=this.container[index];
		
		
		while(entry!=null){
			
			if(entry.key==k || entry.key.equals(k)){
				
				return entry.value;
				
			}
			
			entry=entry.next;
		}
		return null; 
		
	}
	public static void main(String[] args) {
		MyMap<String,String> mm=new MyMap<String,String>();
		Long aBeginTime=System.currentTimeMillis();//��¼BeginTime
		
		for(int i=0;i<10000000;i++){
			mm.put("a"+i, ""+i);
		}
		
		Long aEndTime=System.currentTimeMillis();//��¼EndTime
		System.out.println("insert time-->"+(aEndTime-aBeginTime));
		
		
		Long lBeginTime=System.currentTimeMillis();//��¼BeginTime
		System.out.println(mm.get("a"+100000));
		Long lEndTime=System.currentTimeMillis();//��¼EndTime
		System.out.println("seach time--->"+(lEndTime-lBeginTime));
		
	}
}
