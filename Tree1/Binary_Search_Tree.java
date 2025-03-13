package Tree1;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Search_Tree 
{
  // 1. creating a normal tree
  // 2. creating a binary tree
  //************************************************************************************* */
  //creating a normal tree
    public static TreeNode Create_tree(int[] arr)
    {
        if (arr.length == 0) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length)
        {
            TreeNode current = queue.poll();

            // Assign left child
            if (i < arr.length)
            {
                current.left = new TreeNode(arr[i++]);
                queue.add(current.left);
            }

            // Assign right child
            if (i < arr.length)
            {
                current.right = new TreeNode(arr[i++]);
                queue.add(current.right);
            }
        }
        return root;
    }
   //************************************************************************************* */
  //creating a binary tree
    public static TreeNode Create_Binary_tree(int[] arr)
    {
        TreeNode root = null;
        for (int i : arr)
        {
            root = insert(root, i);
        }
        return root;
    }

    public static TreeNode insert(TreeNode root, int node_value)
    {
        if (root == null)
        {
            return new TreeNode(node_value);
        }
        if (node_value < root.data)
        {
            root.left = insert(root.left, node_value);
        }
        else
        {
            root.right = insert(root.right, node_value);
        }
        return root;
    }
  //************************************************************************************* */
  //Searching a node in a binary tree
  public static boolean Search_Node(TreeNode root,int target)
  {
    if(root==null)
    {
      return false;
    }
    if(root.data==target)
    {
      return true;
    }
    if(root.data>target)
    {
      return Search_Node(root.left, target);
    }
    else
    {    
    return Search_Node(root.right, target);
    }
  }
}
