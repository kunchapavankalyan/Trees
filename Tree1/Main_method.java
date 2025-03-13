package Tree1;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Main_method 
{
    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("Preorder Traversal:");
        Binary_tree_traversal.preorder(root);
        System.out.println("\nInorder Traversal:");
        Binary_tree_traversal.inorder(root);
        System.out.println("\nPostorder Traversal:");
        Binary_tree_traversal.postorder(root);
        System.out.println("\nLevel Order Traversal:");
        System.out.println(Binary_tree_traversal.levelOrder(root));
        System.out.println("\nZigzag Level Order Traversal:");
        System.out.println(Binary_tree_traversal.zigzagLevelOrder(root));
        System.out.println("\nReverse Level Order Traversal:");
        Binary_tree_traversal.reverseLevelOrder(root);
        System.out.println("\nHeight of the tree is  "+Binary_tree_traversal.Height_of_the_tree(root));
        System.out.println("Diameter of the tree with O(N^2) is :"+Binary_tree_traversal.Diameter(root));
        System.out.println("Diameter of the tree with O(N)   is :"+Binary_tree_traversal.Diameter1(root).diameter);
        System.out.println("total count of all the nodes in tree :"+Binary_tree_traversal.Count_the_nodes(root));
        System.out.println("sum of all the nodes in a tree : "+Binary_tree_traversal.Sum_of_all_nodes(root));
        System.out.println("checking is the Tree balanced "+(Binary_tree_traversal.Balance_check(root)==Binary_tree_traversal.Height_of_the_tree(root)));
        System.out.println("symmetry check for the tree  : "+Binary_tree_traversal.Symmetric_check(root));
        System.out.println("Flip :");
        Binary_tree_traversal.inorder(Binary_tree_traversal.Flip_tree(root));
        System.out.println("\nMaximum depth of the tree is :"+Binary_tree_traversal.Maximum_depth_of_the_tree(root));
        System.out.println("The minimum depth of the tree is : "+Binary_tree_traversal.Minimum_depth_of_the_tree(root));
        System.out.println("the Path sum from root to leaf : "+Binary_tree_traversal.Root_to_leaf_sum(root,0,new ArrayList<>()));
        AtomicInteger min=new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger max=new AtomicInteger(Integer.MIN_VALUE);
        Binary_tree_traversal.Min_and_Max_Path(root, 0, min, max);
        System.out.println("the minimum path is : "+min.get());
        System.out.println("the maximum path is : "+max.get());
        System.out.println("Root to Path values "+Binary_tree_traversal.Path_print(root, new ArrayList<ArrayList<Integer>>(), new ArrayList<>()));
        System.out.println("the max path of the tree is "+Binary_tree_traversal.Max_path(root, 0, new AtomicInteger(Integer.MIN_VALUE)));
        Binary_tree_traversal.Ancestor_node(root, 7);

        /*********************************************************Binary Tree *****************************************************/
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};

        System.out.println("This is a tree:");
        TreeNode normalTree = Binary_Search_Tree.Create_tree(arr);
        Binary_tree_traversal.inorder(normalTree);

        System.out.println("\nThis is a binary search tree:");
        TreeNode binaryTree = Binary_Search_Tree.Create_Binary_tree(arr);
        Binary_tree_traversal.inorder(binaryTree);

        System.out.println("\n Searching an element "+Binary_Search_Tree.Search_Node(binaryTree,8));
    }
    
}
