package com.weikun.d;

public enum ESeason implements IA {//public static final Season SPRING =new Season();
	SPRING(){
		@Override
		public void go() {
			// TODO Auto-generated method stub
		}   
	},SUMMER(){
		@Override
		public void go() {
			// TODO Auto-generated method stub
		}   
	},FALL(){		
		@Override
		public void go() {
			// TODO Auto-generated method stub
		}   
	},WINTER(){
		@Override
		public void go() {
			// TODO Auto-generated method stub
		}   
	};

	
	
	
}
interface IA{
	public void go();
}