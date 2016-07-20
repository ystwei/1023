package com.weikun.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;





public class Dijsstra {//迪杰斯特拉最短路径
	public static void main(String[] args) {
		Dijsstra dj=new Dijsstra();
		
		
		
		dj.dj(dj.init());
		System.out.println(dj.path.get("V7"));
	}
	private Set<Node> open=new HashSet<Node>();//open用于存储未遍历的点
	private Set<Node> close=new HashSet<Node>();//close用来存储已遍历的节点
	public Map<String,Integer> path=new HashMap<String,Integer>();//封装路径距离
	public Node init(){//我们从V0开始，需要对其对所有节点和v0的关系进行初始化
		path.put("V1", 1);			
		path.put("V2", 5);	
		//初始路径,因没有V3->V0这条路径,所以path(E)设置为Integer.MAX_VALUE
		path.put("V3",Integer.MAX_VALUE);	
		path.put("V4", Integer.MAX_VALUE);			
		path.put("V5", Integer.MAX_VALUE);	
		path.put("V6", Integer.MAX_VALUE);
		path.put("V7", Integer.MAX_VALUE);
		path.put("V8", Integer.MAX_VALUE);
		
		
		return new MapBuilder().build1(open, close);
	}
	
	
	/*
	 * MapBuilder用于初始化数据源，返回图的起始节点
	 */
	public class MapBuilder {
		
		
		public Node build1(Set<Node> open, Set<Node> close){
			Node node0=new Node("V0");
			Node node1=new Node("V1");
			Node node2=new Node("V2");
			Node node3=new Node("V3");
			Node node4=new Node("V4");
			Node node5=new Node("V5");
			Node node6=new Node("V6");
			Node node7=new Node("V7");
			Node node8=new Node("V8");
			
			node0.getChild().put(node1, 1);//V0--V1
			node0.getChild().put(node2, 5);//V0--V2
			
			node1.getChild().put(node0, 1);
			node1.getChild().put(node2, 3);
			node1.getChild().put(node3, 7);
			node1.getChild().put(node4, 5);
			
			node2.getChild().put(node0, 5);
			node2.getChild().put(node1, 3);
			node2.getChild().put(node4, 1);
			node2.getChild().put(node5, 7);
			
			node3.getChild().put(node1, 7);
			node3.getChild().put(node4, 2);
			node3.getChild().put(node6, 3);
			
			node4.getChild().put(node1, 5);
			node4.getChild().put(node2, 1);
			node4.getChild().put(node3, 2);
			node4.getChild().put(node5, 3);
			node4.getChild().put(node6, 6);
			node4.getChild().put(node7, 9);
			
			node5.getChild().put(node2, 7);
			node5.getChild().put(node4, 3);
			node5.getChild().put(node7, 5);
			
			
			node6.getChild().put(node3, 3);
			node6.getChild().put(node4, 6);
			node6.getChild().put(node7, 2);
			node6.getChild().put(node8, 7);
			
			
			node7.getChild().put(node4, 9);
			node7.getChild().put(node6, 2);
			node7.getChild().put(node8, 4);
			
			node8.getChild().put(node6, 7);
			node8.getChild().put(node7, 4);
			////初始节点放入close 其他节点放入open
			open.add(node1);
			open.add(node2);
			open.add(node3);
			open.add(node4);
			open.add(node5);
			open.add(node6);
			open.add(node7);
			open.add(node8);
			close.add(node0);//初始节点放入close
			return node0;
			
		}
	}
	/**
	 * 
	 * @param node:要查找的节点
	 * @return 离该节点最近的那个点
	 */
	public Node getShortestPath(Node node){
		Map<Node,Integer> childs=node.getChild();//找到该节点的所有子节点的集合
		int min=Integer.MAX_VALUE;
		Node n=null;
		for(Node child  :childs.keySet()){//遍历
			if(open.contains(child)){//如果为真，证明他没有被遍历
				
				int weight=childs.get(child);//根据键找到其权值
				if(min>weight){
					min=weight;
					n=child;
				}
			}
			
		}
		return n;
	}
	//计算其最小权值和
	public void dj(Node start){
		Node nearest=this.getShortestPath(start);//V0
		if(nearest==null){//不存在 退出
			return;
		}
		open.remove(nearest);
		close.add(nearest);
		//取出V1的所有儿子
		
		Map<Node,Integer> childs=nearest.getChild();
		for( Node  child : childs.keySet()){
			if(open.contains(child)){//V1的所有当前儿子并没有访问过				
				int newpath=path.get(nearest.getName())+childs.get(child);//新权值
				if(newpath<path.get(child.getName())){
					path.put(child.getName(), newpath);
				}
				
			}
			
		}		
		dj(nearest);
		
	}
	
	/*
	 * Node对象用于封装节点信息，包括名字和子节点
	 */
	public class Node {
		private String name;
		private Map<Node,Integer> child=new HashMap<Node,Integer>();
		public Node(String name){
			this.name=name;
		}
		public String getName() {
			return name;
		}
		
		public Map<Node, Integer> getChild() {
			return child;
		}
		
	}

}
