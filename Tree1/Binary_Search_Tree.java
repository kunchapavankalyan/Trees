package Tree1;

import java.util.LinkedList;
import java.util.Queue;

public class Binary_Search_Tree 
{
  // 1. creating a normal tree
  // 2. creating a binary tree
  // 3. deletion of node in a binary tree
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
  //************************************************************************************* */
  //Deletion of a node in a binary treee
  //there is 3 types of conditons we need to take care 
  //1. delete a leaf node
  //2. delete a single parent node
  //3. delete a parent node with 2 childs
  public static TreeNode delete(TreeNode root, int target)
  {
    if(root==null)
    {
      return null;
    }
    if(root.data<target)
    {
      root.left=delete(root.left, target);
    }
    else if(root.data>target)
    {
      root.right=delete(root.right, target);
    }
    else
    {
      //case 1 :leaf node
      if(root.left==null && root.right==null)
      {
        return null;
      }
      //case 2:target node with one child
      if(root.left==null)
      {
        return root.right;
      }
      if(root.right==null)
      {
        return root.left;
      }
      //case 3:target node with two childs
      //find the min element in the right sub tree
      TreeNode min=min_helper(root.right);
      root.data=min.data;
      root.right=delete(root.right, min.data);
    }
    return root;
  }
  private static TreeNode min_helper(TreeNode root)
    {
      while(root.left!=null)
      {
        root=root.left;
      }
      return root;
    }
}
