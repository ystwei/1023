import java.util.ArrayList;
import java.util.List;






public class TestTreeSon {
	public static void main(String[] args) {
		Tree root=new Tree("ROOT");
		
		Tree.Node a=root.addChild("A", root.root());
		
		root.addChild("B", root.root());
		
		root.addChild("C", a);
		
		List<Tree.Node> list=root.getChildren(a);
		
		for(Tree.Node  s:list){
			
			System.out.println(s.data);
		}
		
		System.out.println(root.deep(a));
	}
}

class Tree{

	static class SonNode{
		int position;//当前节点的索引号
		SonNode next;//下一节点位置
		public SonNode(int position,SonNode next){
			this.position=position;
			this.next=next;
		}

	}
	static class Node{
		String data;
		SonNode first;

		public Node(String data){
			this.data=data;
			this.first=null;//刚刚成立该节点，该节点并没有儿子，
		}

	}

	private int treeSize = 100;
	//使用一个Node[]数组来记录该树里的所有节点
	private Node[] nodes;
	//记录节点数目
	private int nodeNums;
	//以指定根节点创建树
	public Node root(){
		return nodes[0];
	}
	public Tree(String data){
		nodes=new Node[this.treeSize];
		nodes[0]=new Node(data);
		nodeNums++;

	}
	public Node addChild(String data,Node parent){
		for(int i=0;i<this.treeSize;i++){
			if(nodes[i]==null){
				nodes[i]=new Node(data);
				if(parent.first==null){//把当前节点放到哪个节点的后面充当子节点哪？
					SonNode son=new SonNode(i,null);
					parent.first=son;//当前节点生成个子节点，并把地址给当前父节点的first域

				}else{//当前父节点已经有第一个儿子了，
					SonNode next=parent.first;

					while(next.next!=null){
						next=next.next;
					}
					next.next=new SonNode(i,null);


				}
				nodeNums++;
				return nodes[i];
			}

		}
		return null;
	}
	public List<Node> getChildren(Node parent){
		
		
		List<Node> list=new ArrayList<Node>();
		
		
		SonNode next=parent.first;
		while(next!=null){
			
			list.add(nodes[next.position]);
			
			next=next.next;
		}
		
		return list;
	}
	//找到当前节点的深度：每棵子树的深度为其所有子树的最大深度 + 1
	public int deep(Node node){
		
		if(node.first==null){//没有子节点
			return 1;
		}else{//有子节点
			
			int max=0;
			
			SonNode next=node.first;//找到其第一个儿子
			while(next!=null){
				int temp=deep(nodes[next.position]);
				if(temp>max){
					max=temp;
				}
				next=next.next;
			}
			
			return max+1;
			
		}
		
	}
	

}
