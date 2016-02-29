public class main

{
	
	public static void main(String[] args) {
		
	//int [] arr = {9, 4, 5, 7, 11, 12};
		
	BST t = new BST();	

	//Add Elements
	t.insert(10);t.insert(20);t.insert(15);t.insert(5);t.insert(25);
	t.insert(30);t.insert(50);t.insert(0);

	//Display elements inorder
	//t.display(t.root);System.out.println();

	//Get Height of Tree
	//System.out.println("Height: " + t.getHeight(t.root));

	//TEST Breadth First Search (Level Order)
	//t.BFS(t.root);

	//Access tree nodes
	//System.out.println(t.root.left.data);

	//Test Search
	//System.out.println(t.search(51));
	}
	
}