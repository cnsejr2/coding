import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p1991 {
	static class Node {
		char value;
		Node left;
		Node right;
		
		Node(char value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}
	
	static int n;
	static Node head = new Node('A', null, null);
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String [] str = br.readLine().split(" ");
			
			char root = str[0].charAt(0);
			char left = str[1].charAt(0);
			char right = str[2].charAt(0);
			insertNode(head, root, left, right);
		}
		
		preOrder(head);
		System.out.println();
		inOrder(head);
		System.out.println();
		postOrder(head);
		
	}

	private static void insertNode(Node tmp, char root, char left, char right) {
		// TODO Auto-generated method stub
		// 루트 노드(A)인가
		if(tmp.value == root) {
			// 자식노드가 .이면 null이고 아니면 새로운 노드를 만들어준다. 
			tmp.left = (left == '.' ? null : new Node(left, null, null));
			tmp.right = (right == '.' ? null : new Node(right, null, null));
		} else {
			if (tmp.left != null) { insertNode(tmp.left, root, left, right); }
			if (tmp.right != null) { insertNode(tmp.right, root, left, right); }
		}
	}
	private static void preOrder(Node n) {
		if (n == null) return;
		System.out.print(n.value);
		preOrder(n.left);
		preOrder(n.right);
	}
	private static void inOrder(Node n) {
		if (n == null) return;
		inOrder(n.left);
		System.out.print(n.value);
		inOrder(n.right);
	}
	private static void postOrder(Node n) {
		if (n == null) return;
		postOrder(n.left);
		postOrder(n.right);
		System.out.print(n.value);
	}
}
