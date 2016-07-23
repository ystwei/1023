package com.weikun.search;


public class MyMap<K,V> {
	
	private int size;// 当前容量
	private static int INIT_CAPACITY = 16;// 默认容量
	private Entry<K, V>[] container;// 实际存储数据的数组对象
	
	/**
	 * 用来实际保存数据的内部类,因为采用挂链法解决冲突，此内部类设计为链表形式
	 * 
	 * @param <K>key
	 * @param <V>
	 *            value
	 */
	class Entry<K, V> {
		Entry<K, V> next;// 下一个结点
		K key;// key
		V value;// value
		int hash;// 这个key对应的hash码，作为一个成员变量，当下次需要用的时候可以不用重新计算

		// 构造方法
		Entry(K k, V v, int hash) {
			this.key = k;
			this.value = v;
			this.hash = hash;
		}
		//相应的getter()方法
	}
	private static float LOAD_FACTOR = 0.75f;// 
	//装载因子:就是hash表中已经存储的关键字个数，
	//与可以散列位置的比值，表征着hash表中的拥挤情况，
	//一般而言，该值越大则越容易发生冲突，相应地ASL(平均查找长度)也增大
	private int max;// 能存的最大的数=capacity*factor
	
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
	/**扩容
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
	 *将指定的结点temp添加到指定的hash表table当中
	 * 添加时判断该结点是否已经存在
	 * 如果已经存在，返回false
	 * 添加成功返回true
	 * @param temp
	 * @param table
	 * @return
	 */
	public boolean setEntry(Entry<K,V> temp ,Entry<K,V> [] table){
		int index=this.index(temp.key.hashCode(), table.length);
		
		Entry<K,V> a=table[index];
		if(a!=null){//代表已经在该索引中存在。
			//虽然temp和a的hash链相同，但还需要判断其equals是否相等
			while(a!=null){
				if( (temp.key==a.key||temp.key.equals(a.key))&&					
						(temp.value==a.value||temp.value.equals(a.value))
						&&
						(temp==a||temp.equals(a))
						){
					return false;//同一个对象
					
					
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
	 * 第一个元素，加载头部
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
	 * 根据hash码，容器数组的长度,计算该哈希码在容器数组中的下标值
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
		Long aBeginTime=System.currentTimeMillis();//记录BeginTime
		
		for(int i=0;i<10000000;i++){
			mm.put("a"+i, ""+i);
		}
		
		Long aEndTime=System.currentTimeMillis();//记录EndTime
		System.out.println("insert time-->"+(aEndTime-aBeginTime));
		
		
		Long lBeginTime=System.currentTimeMillis();//记录BeginTime
		System.out.println(mm.get("a"+100000));
		Long lEndTime=System.currentTimeMillis();//记录EndTime
		System.out.println("seach time--->"+(lEndTime-lBeginTime));
		
	}
}
