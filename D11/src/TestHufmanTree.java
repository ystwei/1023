import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;






public class TestHufmanTree {
	
	public Node createTree(List<Node> list){
		while(list.size()>1){
			Collections.sort(list);//ÿ�ζ�����
			Node left=list.get(0);//��С����
			Node right=list.get(1);//�ڶ�С����
			//�γ��µĽڵ㣬
			Node parent=new Node(null,left.getWeight()+right.getWeight());
			
			parent.setLeft(left);
			parent.setRight(right);
			
			list.remove(left);
			list.remove(right);
			list.add(parent);
			
		}
		return list.get(0);//Ϊ���ȱ�������� 
		/*
		 * 
		 * 	for(Node node :list){
				System.out.println(node.getValue());
			}
		
		 */
	}
	public void broadIterator(Node root){
		if(root==null){
			System.out.println("����");
			return;
		}
		//���ǿ���
		System.out.print("������ȣ�");
		ArrayDeque<Node> deque=new ArrayDeque<Node>();
		deque.add(root);
		while(deque.isEmpty()==false){//��û���ɾ�
			Node current=deque.remove();//��ǰ�ڵ�
			System.out.print(current.getWeight()+" ");
			if(current.getLeft()!=null){
				deque.add(current.getLeft());
			}
			if(current.getRight()!=null){
				deque.add(current.getRight());
			}
		}

	}
	public static void main(String[] args) {
		TestHufmanTree h=new TestHufmanTree();
		List<Node> list=new ArrayList<Node>();
		
		list.add(new Node("a",1));  
		list.add(new Node("b",4));  
		list.add(new Node("c",4));  
		list.add(new Node("d",5));
		list.add(new Node("e",6));
		
		
		h.broadIterator(h.createTree(list));
	}
	
}
class Node implements Comparable{
	
	private String value;
	private int weight;
	private Node left;
	private Node right;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	Node(String value,int weight){
		this.value=value;
		this.weight=weight;
	}
	
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Node other=(Node)o;
		
		
		return  this.getWeight()-other.getWeight();//����
	}
	
	
	
}