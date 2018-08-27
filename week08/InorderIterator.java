package week08;

// Inner class InorderIterator
class InorderIterator<E extends Comparable<E>> implements java.util.Iterator<E>
{
	// Store the elements in a list
	private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
	private int current = 0; // Point to the current element in list

	public InorderIterator(TreeNode<E> root)
	{
		inorder(root); // Traverse binary tree and store elements in list
	}

	/** Inorder traversal from the root */
//	private void inorder()
//	{
//		inorder(root);
//	}

	/** Inorder traversal from a subtree */
	private void inorder(TreeNode<E> root)
	{
		if(root == null)
			return;
		inorder(root.left);
		list.add(root.element);
		inorder(root.right);
	}

	/** Next element for traversing? */
	public boolean hasNext()
	{
		if(current < list.size())
			return true;

		return false;
	}

	/** Get the current element and move cursor to the next */
	public E next()
	{
		return list.get(current++);
	}

	/** Remove the current element and refresh the list */
	public void remove()
	{
//		delete(list.get(current)); // Delete the current element
//		list.clear(); // Clear the list
//		inorder(); // Rebuild the list
	}
	
	protected TreeNode<E> root;
}

