import java.util.Queue;
import java.util.LinkedList;

public class NewBST<E extends Comparable>

{

	public Node root; 
	private int height; 


	public NewBST(E rootData)
	{
		root = new Node(rootData);
		height++;
	}


	public void add(E dataToAdd)
	{
		root = add(dataToAdd,root);
	}


	private Node add(E data, Node node)
	{
		if(node == null)
		{
			return new Node<E>(data);
		}

		else if(node.compareTo(data) == 0)
		{
			return node;
		}

		else if(node.compareTo(data) < 0)
		{
			node.right = add(data,node.right);
		}

		else if(node.compareTo(data) > 0)
		{
			node.left = add(data,node.left);
		}

		return node;

	}

	public void preOrderTraversal(Node node)
	{
		if(node != null)
		{
			System.out.print(node.data);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	public void inOrderTraversal(Node node)
	{
		if(node != null)
		{
			inOrderTraversal(node.left);
			System.out.print(node.data);
			inOrderTraversal(node.right);
		}
	}

	public void postOrderTraversal(Node node)
	{
		if(node != null)
		{
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.print(node.data);
		}
	}

	public void levelOrder(Node<E> node)
	{
		Queue<Node<E>> queue = new LinkedList<Node<E>>();
		
		if(node != null)
		{
			queue.add(node);
		}
		
		while(!queue.isEmpty())
		{
			Node<E> next = queue.remove();

			System.out.print(next.data);
			
			if(next.left != null)
			{
				queue.add(next.left);
			}
			
			if(next.right != null)
			{
				queue.add(next.right);
			}
		}
	}

	//finds the height of every subtree, keeps the bigger height when going back through the recursive stack (adds 1)d


	public int findHeight(Node node)
	{
	    if(node == null)
	        return -1;

	    int leftHeight = findHeight(node.left);

	    int rightHeight = findHeight(node.right);

	    if(leftHeight > rightHeight)
	    {
	    	return leftHeight + 1;
	    }
	   
	    else
	    {
	        return rightHeight + 1;
	    }

	}


	public boolean search(E data)
	{
		return search(data,root).compareTo(data) == 0; 
	}



	private Node search(E data, Node node)
	{
		if(node == null || node.compareTo(data) == 0)
		{
			return node;
		}

		else if(node.compareTo(data) < 0)
		{
			return search(data,node.right);
		}

		else 
		{
			return search(data,node.left);
		}
	}


	/*

	Three cases for remove function 

	1. Removing a leaf node (no children) ----> Find its parent, set the reference to the node = to null

	2. Removing a node with one child ----> Copy its child node and attach to grandparent in place of deleted node

	3. Removing a node with two children ----> Restructure tree: 

	3. a) Find minimum value in the right subtree, make it the root; 

	3. b) If no right subtree, take the max in the left subtree and make it the root

	*/
	
	
	public Node getMin(Node root)
	{
		Node temp = root; 

		while(temp.left != null)
		{
			temp = temp.left;
		}
		return temp; 
	}


	public Node getMax(Node root)
	{
		Node temp = root; 

		while(temp.right != null)
		{
			temp = temp.right; 
		}
		return temp; 
	}


	public void remove(E data)
	{
		root = remove(data,root);
	}


	private void remove(E data, Node node)
	{	
		if(node == null)
		{
			return node;
		}

		if(node.compareTo(data) < 0)
		{
			node.right = remove(data,node.right);
		}

		else if(node.compareTo(data) > 0)
		{
			node.left = remove(data,node.left);
		}

		else 													//found the node we want to delete 
		{
			if(node.right == null)								//if there is only one child on left OR no children at all 
			{
				node = node.left;
			}

			else if(node.left == null)							//checks to see if there is a single RIGHT child
			{
				node = node.right;
			}

			else												//two children, find successor node
			{
				E successor = getMin(node.right).data;			//find min of right subtree and store it
				node.right = remove(successor,node.right);		//delete it from the tree so that there aren't duplicates
				node.data = sucessor;							//set the node you wanted to delete = to the successor node
			}

		}

	}
}