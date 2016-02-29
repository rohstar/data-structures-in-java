import java.util.LinkedList;
import java.util.Queue;


public class BST {
	
	public static Node root;
	
	public BST(){
		this.root = null;
	}
	
	public boolean search(int num){
		//Set the Root Node
		Node current = root;
		// While the node we're going to isn't null
		while(current!=null){
			//If the current node is num, true!
			if(current.data==num){
				return true;
			//If the current node is smaller than num, move leftwards  
			}else if(num <= current.data ){
				current = current.left;
			//else move right
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	public void insert(int num){
		
		//Create a node with the data as "num"
		Node newNode = new Node(num);
		
		//If the tree is empty, just add to the tree
		if(root == null){
			root = newNode;
			return;
		}
		
		Node currentNode = root;
		Node parentNode = null;
		
		while(true){
			//save the previous location before moving to parent
			parentNode = currentNode;
			if(num > currentNode.data ){
				// move right
				currentNode = currentNode.right;
				//After moving to the right, if the node is empty, add there
				if(currentNode==null){
					parentNode.right = newNode;
					return;
				}
			} else {
				//move left
				currentNode = currentNode.left;
				if(currentNode==null){
					//if node is empty, add to it's left
					parentNode.left = newNode;
					return;
				}
			}
		}	
	}
	
	public void display(Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.data);
			display(root.right);
		}
	}

	public void remove(int num){
			Node current = root;
			Node toBeRemoved = null;
			Node parent = null;
			//mark what side of the parent the node is on
			boolean isLeftChild = false;
				
			while(current.data != num){
				System.out.println(current.data);
				parent = current;
				if(current.data==num){
					toBeRemoved = current;
				}else if(num <= current.data){
					current = current.left;
					isLeftChild = true;
				}else{
					current = current.right;
					}
				}
				
			//Not found
				if(toBeRemoved == null){System.out.println("Node with " +num + " not found!");}
			
			//If the node has no children	
				if(toBeRemoved.right == null && toBeRemoved.left == null){
					if(toBeRemoved==root){
						root = null;
					} 
					if(isLeftChild){
						 parent.left = null;
					 } else {
						 parent.right = null;
					 }
					 System.out.println("Node " + num + "was removed sucessfully (no kids)");
				} else if(toBeRemoved.left != null){
			//if the node has one child	
					if(toBeRemoved == root){
						root = current.left;
					}
					if(isLeftChild){
						parent.left = toBeRemoved.left;
					} else {
						parent.right = toBeRemoved.right;
					}
				} else if(toBeRemoved.right != null){
			//if the node has one child	
					if(toBeRemoved == root){
						root = current.left;
					}
					if(isLeftChild){
						parent.left = toBeRemoved.left;
					} else {
						parent.right = toBeRemoved.right;
					}
				} else if(toBeRemoved.left!=null && toBeRemoved.right!=null){
					
					//now we have found the minimum element in the right sub tree
					Node successor	 = getSuccessor(toBeRemoved);
					if(current==root){
						root = successor;
					}else if(isLeftChild){
						parent.left = successor;
					}else{
						parent.right = successor;
					}			
					successor.left = current.left;
				}		
				System.out.println("Removed...");	
			}
			
	public Node getSuccessor(Node deleleNode){
				Node successsor =null;
				Node successsorParent =null;
				Node current = deleleNode.right;
				while(current!=null){
					successsorParent = successsor;
					successsor = current;
					current = current.left;
				}
				//check if successor has the right child, it cannot have left child for sure
				// if it does have the right child, add it to the left of successorParent.
//				successsorParent
				if(successsor!=deleleNode.right){
					successsorParent.left = successsor.right;
					successsor.right = deleleNode.right;
				}
				return successsor;
			}
				
	public int getHeight(Node node){
		
		if(node == null){
			return -1;
		}
		return Math.max(getHeight(node.right),getHeight(node.left)) + 1;
	}	

	public void BFS(Node root){
		
		Queue<Node> q = new LinkedList<Node>();
		if(root == null) {return;}
		q.add(root);
		while(!q.isEmpty()){
			
			Node n = (Node) q.remove();
			
			System.out.println(" " + n.data);
						
			if(n.left != null){
				q.add(n.left);
			}
			if(n.right != null){
				q.add(n.right);
			}
		}
	}

	public void preorder(Node root){
		if(root == null) {return;}
		System.out.print(" " + root.data);
		preorder(root.left);
		preorder(root.right);
	}
	
	public void postorder(Node root){
		if(root == null) {return;}
		preorder(root.left);
		preorder(root.right);
		System.out.print(" " + root.data);
	}
	
	public void inorder(Node root){
		if(root == null) {return;}
		preorder(root.left);
		System.out.print(" " + root.data);
		preorder(root.right);
	}
	
	
}
	
