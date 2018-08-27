package week08;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Search Tree implementation
 *
 * The generic type supported must implement Comparable<E>
 *
 * @author Scott LaChance & Efosa Uwa-Omede
 */
public class BST<E extends Comparable<E>> extends AbstractTree<E>
		implements Cloneable
{
	protected TreeNode<E> root;
	protected int size = 0;

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            BST()
	 * @param override
	 *            None
	 * @param comment
	 *            Create a default binary tree
	 * @param visiblity
	 *            public
	 */
	public BST()
	{
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            BST(E[] objects)
	 * @param objects
	 *            Array of objects
	 * @param override
	 *            None
	 * @param comment
	 *            Create a binary tree from an array of objects
	 * @param visiblity
	 *            public
	 */
	public BST(E[] objects)
	{
		for(int i = 0; i < objects.length; i++)
		{
			insert(objects[i]);
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            clear()
	 * @param override
	 *            None
	 * @param comment
	 *            Remove all elements from the tree
	 * @param visiblity
	 *            public
	 */
	public void clear()
	{
		root = null;
		size = 0;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            clone()
	 * @param override
	 *            None
	 * @param comment
	 *            Clones the tree and returns it
	 * @param visiblity
	 *            public
	 * 
	 * @return the cloned tree object
	 */
	public Object clone()
	{
		BST<E> tree1 = new BST<E>();

		copy(root, tree1);

		return tree1;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            copy(TreeNode<E> root, BST<E> tree)
	 * @param root
	 *            The TreeNode to copy
	 * @param tree
	 *            The tree to receive the copy
	 * @param override
	 *            None
	 * @param comment
	 *            Copies a tree node and its children into the tree
	 * @param visiblity
	 *            private
	 * 
	 * @return the return type minus the qualified name
	 */
	private void copy(TreeNode<E> root, BST<E> tree)
	{
		if(root != null)
		{
			tree.insert(root.element);
			copy(root.left, tree);
			copy(root.right, tree);
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            createNewNode(E e)
	 * @param e
	 *            Element to create the node for
	 * @param override
	 *            None
	 * @param comment
	 *            Creates a new tree node
	 * @param visiblity
	 *            protected
	 * 
	 * @return New TreeNode instance
	 */
	protected TreeNode<E> createNewNode(E e)
	{
		return new TreeNode<E>(e);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            delete(E e)
	 * @param e
	 *            Element to delete
	 * @param override
	 *            None
	 * @param comment
	 *            Delete an element from the binary tree. Return true if the
	 *            element is deleted successfully Return false if the element is
	 *            not in the tree
	 * @param visiblity
	 *            public
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean delete(E e)
	{
		// Locate the node to be deleted and also locate its parent node
		TreeNode<E> parent = null;
		TreeNode<E> current = root;
		while(current != null)
		{
			if(e.compareTo(current.element) < 0)
			{
				parent = current;
				current = current.left;
			}
			else if(e.compareTo(current.element) > 0)
			{
				parent = current;
				current = current.right;
			}
			else
				break; // Element is in the tree pointed by current
		}

		if(current == null)
			return false; // Element is not in the tree

		// Case 1: current has no left children
		if(current.left == null)
		{
			// Connect the parent with the right child of the current node
			if(parent == null)
			{
				root = current.right;
			}
			else
			{
				if(e.compareTo(parent.element) < 0)
					parent.left = current.right;
				else
					parent.right = current.right;
			}
		}
		else
		{
			// Case 2: The current node has a left child
			// Locate the rightmost node in the left subtree of
			// the current node and also its parent
			TreeNode<E> parentOfRightMost = current;
			TreeNode<E> rightMost = current.left;

			while(rightMost.right != null)
			{
				parentOfRightMost = rightMost;
				rightMost = rightMost.right; // Keep going to the right
			}

			// Replace the element in current by the element in rightMost
			current.element = rightMost.element;

			// Eliminate rightmost node
			if(parentOfRightMost.right == rightMost)
				parentOfRightMost.right = rightMost.left;
			else
				// Special case: parentOfRightMost == current
				parentOfRightMost.left = rightMost.left;
		}

		size--;
		return true; // Element inserted
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getDepth()
	 * @param override
	 *            None
	 * @param comment
	 *            N/A
	 * @param visiblity
	 *            public
	 * 
	 * @return
	 */
	public int getDepth()
	{
		return walkDepth(root, 1);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getLeafData()
	 * @param override
	 *            None
	 * @param comment
	 *            Searches the whole tree and identify the leaf nodes, put the
	 *            data from the nodes into a list and return it.
	 * @param visiblity
	 *            public
	 * 
	 * @return the return type minus the qualified name
	 */
	public List<E> getLeafData()
	{

		if(root == null)
		{
			return null;
		}
		List<E> result = new ArrayList<>();
		getLeaves(root, result);
		return result;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getLeaves(TreeNode<E> root, List<E> list)
	 * @param root
	 *            Parameter
	 * @param list
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            N/A
	 * @param visiblity
	 *            private
	 * 
	 * @return the return type minus the qualified name
	 */
	private void getLeaves(TreeNode<E> root, List<E> list)
	{
		if(root == null)
		{
			return;
		}
		getLeaves(root.left, list);
		getLeaves(root.right, list);

		if(root.left == null && root.right == null)
		{
			list.add(root.getElement());
		}
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getRoot()
	 * @param override
	 *            None
	 * @param comment
	 *            Returns the root of the tree
	 * @param visiblity
	 *            public
	 * 
	 * @return TreeNode reference for the root
	 */
	public TreeNode<E> getRoot()
	{
		return root;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            getSize()
	 * @param override
	 *            None
	 * @param comment
	 *            Get the number of nodes in the tree
	 * @param visiblity
	 *            public
	 * 
	 * @return number of nodes in the tree
	 */
	public int getSize()
	{
		return size;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            inorder()
	 * @param override
	 *            None
	 * @param comment
	 *            Inorder traversal from the root
	 * @param visiblity
	 *            public
	 */
	public void inorder()
	{
		inorder(root);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            inorder(TreeNode<E> root)
	 * @param root
	 *            TreeNode to start from
	 * @param override
	 *            None
	 * @param comment
	 *            Inorder traversal from a subtree
	 * @param visiblity
	 *            protected
	 */
	protected void inorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		inorder(root.left);
		System.out.print(root.element + " ");
		inorder(root.right);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            inorderIterator()
	 * @param override
	 *            None
	 * @param comment
	 *            Obtain an inorder iterator
	 * @param visiblity
	 *            public
	 * 
	 * @return The in-order Iterator for the tree
	 */
	public java.util.Iterator<E> inorderIterator()
	{
		return new InorderIterator<E>(root);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            insert(E e)
	 * @param e
	 *            to insert for
	 * @param override
	 *            None
	 * @param comment
	 *            Insert element o into the binary tree Return true if the
	 *            element is inserted successfully
	 * @param visiblity
	 *            public
	 * 
	 * @return true if successful, otherwise false
	 */
	public boolean insert(E e)
	{
		if(root == null)
		{
			root = createNewNode(e); // Create a new root
		}
		else
		{
			// Locate the parent node
			TreeNode<E> parent = null;
			TreeNode<E> current = root;
			while(current != null)
				if(e.compareTo(current.element) < 0)
				{
					parent = current;
					current = current.left;
				}
				else if(e.compareTo(current.element) > 0)
				{
					parent = current;
					current = current.right;
				}
				else
					return false; // Duplicate node not inserted

			// Create the new node and attach it to the parent node
			if(e.compareTo(parent.element) < 0)
				parent.left = createNewNode(e);
			else
				parent.right = createNewNode(e);
		}

		size++;
		return true; // Element inserted
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            iterator()
	 * @param override
	 *            None
	 * @param comment
	 *            Obtain an iterator. Use inorder.
	 * @param visiblity
	 *            public
	 * 
	 * @return The in-order Iterator for the tree
	 */
	public java.util.Iterator<E> iterator()
	{
		return inorderIterator();
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            path(E e)
	 * @param e
	 *            Element to find in the tree
	 * @param override
	 *            None
	 * @param comment
	 *            Returns a path from the root leading to the specified element
	 * @param visiblity
	 *            public
	 * 
	 * @return List of TreeNode elements in the path
	 */
	public java.util.ArrayList<TreeNode<E>> path(E e)
	{
		java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<TreeNode<E>>();
		TreeNode<E> current = root; // Start from the root

		while(current != null)
		{
			list.add(current); // Add the node to the list
			if(e.compareTo(current.element) < 0)
			{
				current = current.left;
			}
			else if(e.compareTo(current.element) > 0)
			{
				current = current.right;
			}
			else
				break;
		}

		return list; // Return an array of nodes
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            postorder()
	 * @param override
	 *            None
	 * @param comment
	 *            Postorder traversal from the root
	 * @param visiblity
	 *            public
	 */
	public void postorder()
	{
		postorder(root);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            postorder(TreeNode<E> root)
	 * @param root
	 *            TreeNode to start from
	 * @param override
	 *            None
	 * @param comment
	 *            Postorder traversal from a subtree
	 * @param visiblity
	 *            protected
	 * 
	 * @return the return type minus the qualified name
	 */
	protected void postorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.element + " ");
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            preorder()
	 * @param override
	 *            None
	 * @param comment
	 *            Preorder traversal from the root
	 * @param visiblity
	 *            public
	 */
	public void preorder()
	{
		preorder(root);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            preorder(TreeNode<E> root)
	 * @param root
	 *            TreeNode to start from
	 * @param override
	 *            None
	 * @param comment
	 *            Preorder traversal from a subtree
	 * @param visiblity
	 *            protected
	 * 
	 * @return the return type minus the qualified name
	 */
	protected void preorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		System.out.print(root.element + " ");
		preorder(root.left);
		preorder(root.right);
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            search(E e)
	 * @param e
	 *            to search for
	 * @param override
	 *            None
	 * @param comment
	 *            Returns true if the element is in the tree
	 * @param visiblity
	 *            public
	 * 
	 * @return true if found, otherwise false
	 */
	public boolean search(E e)
	{
		TreeNode<E> current = root; // Start from the root

		while(current != null)
		{
			if(e.compareTo(current.element) < 0)
			{
				current = current.left;
			}
			else if(e.compareTo(current.element) > 0)
			{
				current = current.right;
			}
			else // element matches current.element
			{
				return true; // Element is found
			}
		}

		return false;
	}

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            walkDepth(TreeNode<E> node, int curDepth)
	 * @param curDepth
	 *            Parameter
	 * @param node
	 *            Parameter
	 * @param override
	 *            None
	 * @param visiblity
	 *            private
	 * 
	 * @return the return type minus the qualified name
	 */
	private int walkDepth(TreeNode<E> node, int curDepth)
	{
		if(node == null)
		{
			return curDepth;
		}

		curDepth++;

		int leftDepth = walkDepth(node.left, curDepth);
		int rightDepth = walkDepth(node.right, curDepth);

		return leftDepth > rightDepth ? leftDepth : rightDepth;
	}

}
