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
		int position;//��ǰ�ڵ��������
		SonNode next;//��һ�ڵ�λ��
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
			this.first=null;//�ոճ����ýڵ㣬�ýڵ㲢û�ж��ӣ�
		}

	}

	private int treeSize = 100;
	//ʹ��һ��Node[]��������¼����������нڵ�
	private Node[] nodes;
	//��¼�ڵ���Ŀ
	private int nodeNums;
	//��ָ�����ڵ㴴����
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
				if(parent.first==null){//�ѵ�ǰ�ڵ�ŵ��ĸ��ڵ�ĺ���䵱�ӽڵ��ģ�
					SonNode son=new SonNode(i,null);
					parent.first=son;//��ǰ�ڵ����ɸ��ӽڵ㣬���ѵ�ַ����ǰ���ڵ��first��

				}else{//��ǰ���ڵ��Ѿ��е�һ�������ˣ�
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
	//�ҵ���ǰ�ڵ����ȣ�ÿ�����������Ϊ������������������ + 1
	public int deep(Node node){
		
		if(node.first==null){//û���ӽڵ�
			return 1;
		}else{//���ӽڵ�
			
			int max=0;
			
			SonNode next=node.first;//�ҵ����һ������
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
