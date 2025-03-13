package Tree1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class Binary_tree_traversal 
{
    //**************************************************************************************************** */
    // 1. Preorder Traversal (Root -> Left -> Right)
    public static  void preorder(TreeNode root) 
    {
        if (root == null) return;
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    //**************************************************************************************************** */
    // 2. Inorder Traversal (Left -> Root -> Right)
    public static void inorder(TreeNode root) 
    {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    //**************************************************************************************************** */
    // 3. Postorder Traversal (Left -> Right -> Root)
    public static void postorder(TreeNode root) 
    {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    //**************************************************************************************************** */
    // 4. Level Order Traversal (BFS)
    public static List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            int size = queue.size();
            List<Integer> sublvl = new ArrayList<>();
            for (int i = 0; i < size; i++) 
            {
                TreeNode temp = queue.poll();
                sublvl.add(temp.data);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            res.add(sublvl);
        }
        return res;
    }

    //**************************************************************************************************** */
    // 5. Spiral/Zigzag Level Order Traversal
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) 
    {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> subarray = new LinkedList<>();
            for (int i = 0; i < size; i++) 
            {
                TreeNode curr = queue.poll();
                if (leftToRight) {
                    subarray.addLast(curr.data);
                } else {
                    subarray.addFirst(curr.data);
                }
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            res.add(subarray);
            leftToRight = !leftToRight;
        }
        return res;
    }

    //**************************************************************************************************** */
    // 6. Reverse Level Order Traversal
    public static void reverseLevelOrder(TreeNode root) 
    {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            TreeNode node = queue.poll();
            stack.push(node.data);
            if (node.right != null) queue.add(node.right);
            if (node.left != null) queue.add(node.left);
        }
        while (!stack.isEmpty()) 
        {
            System.out.print(stack.pop() + " ");
        }
    }
    //******************************************************************************************************* */
    //                                         TREE's Properties
    //******************************************************************************************************* */
    /* Topics to be covered
            1   Height/Depth of a Binary Tree
            2   Diameter of a Binary Tree
            3   Count the Number of Nodes in a Binary Tree
            4   Sum of All Nodes in a Binary Tree
            4   Check if Two Trees are Identical
            5   Check if a Binary Tree is Balanced
            6   Check if a Binary Tree is Symmetric
            7   Invert/Flip a Binary Tree (Mirror Tree)
            8   Maximum Depth of a Binary Tree
            Minimum Depth of a Binary Tree
    */
    //********************************************************************** */
    //Height of the tree    :simply find the max of left and right and add 1;
    public static int Height_of_the_tree(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=Height_of_the_tree(root.left);
        int right=Height_of_the_tree(root.right);
        return Math.max(left,right)+1;
    }
    //************************************************************************ */
    /* Diameter of the tree
        there are 2 ways one is O(N^2) and O(N)
    */
    //O(N^2)
    public static int Diameter(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int diam1=Diameter(root.left);
        int diam2=Diameter(root.right);
        int diam3=Height_of_the_tree(root.left)+Height_of_the_tree(root.right)+1;
        return Math.max(diam3,Math.max(diam1,diam2));
    }
    //O(N)
    //As we have calculated height and diameter separatly it took O(M^2) so create a object of height and diameter in a single unit 
    static class height_and_diameter
    {
        int height;
        int diameter;
        public height_and_diameter(int height,int diameter)
        {
            this.height=height;
            this.diameter=diameter;
        }
    }
    public static height_and_diameter Diameter1(TreeNode root)
    {
        if(root==null)
        {
            return new height_and_diameter(0, 0);
        }
        height_and_diameter d1=Diameter1(root.left);
        height_and_diameter d2=Diameter1(root.right);

        int myheight=Math.max(d1.height,d2.height)+1;

        int diam1=d1.diameter;
        int diam2=d2.diameter;
        int diam3=d1.height+d2.height+1;
        
        int diam=Math.max(diam3,Math.max(diam1,diam2));

        return new height_and_diameter(myheight, diam);
    }
    //************************************************************************* */
    //count the nodes
    public static int Count_the_nodes(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=Count_the_nodes(root.left);
        int right=Count_the_nodes(root.right);
        return left+right+1;
    }
    //************************************************************************* */
    //Sum of all nodes in a tree
    public static int Sum_of_all_nodes(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=Sum_of_all_nodes(root.left);
        int right=Sum_of_all_nodes(root.right);
        return left+right+root.data;
    }
    //************************************************************************* */
    //Check if a Binary Tree is Balanced
    public static int Balance_check(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=Balance_check(root.left);
        if(left==-1)
        {
            return -1;
        }
        int right=Balance_check(root.right);
        if(right==-1)
        {
            return -1;
        }
        if(Math.abs(left-right)>1)
        {
            return -1;
        }
        return Math.max(left,right)+1;
    }
    //******************************************************** */
    //Check if a Binary Tree is Symmetric
    public static boolean Symmetric_check(TreeNode root)
    {
        if(root==null)
        {
            return true;
        }
        return ismirror(root.left,root.right);
    }
        
    private static boolean ismirror(TreeNode left, TreeNode right) 
    {
        if(left==null && right==null)
        {
            return true;
        }
        if(left==null || right==null)
        {
            return false;
        }
        return (left.data == right.data) && ismirror(left.right,right.left) && ismirror(right.right,left.left);   
    }
    ///********************************************************************* */
    // Invert/Flip a Binary Tree (Mirror Tree)
    public static TreeNode Flip_tree(TreeNode root)
    {
        if(root==null)
        {
            return null;
        }
         TreeNode new_left=Flip_tree(root.left);
         TreeNode new_right=Flip_tree(root.right);

         root.left=new_right;
         root.right=new_left;
        return root;
    }
    //************************************************************ */
    // Maximum_depth_of_the_tree
    public static int Maximum_depth_of_the_tree(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int left=Maximum_depth_of_the_tree(root.left);
        int right=Maximum_depth_of_the_tree(root.right);
        return Math.max(left,right)+1;
    }
    //************************************************************ */
    //Minimum depth of the tree
    public static int Minimum_depth_of_the_tree(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        int depth=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                TreeNode temp=queue.poll();
                if(temp.left==null && temp.right==null)
                {
                    return depth;
                }
                if(temp.left!=null)
                {
                   queue.add(temp.left);
                }
                if(temp.right!=null)
                {
                    queue.add(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }
    //************************************************************************ */
    //*                              Path Problem                              */
    //************************************************************************ */
    /*  Topics to be covered
     *  1. Root-to-Leaf Path Sum
     *  2. Total sum of the path
     *  3. Print All Root-to-Leaf Paths
     *  4. Maximum Path Sum in a Binary Tree
     *  5. Lowest Common Ancestor (LCA) of Two Nodes
     *  6. Find Distance Between Two Nodes in a Binary Tree
     *  7. Pring alll the leaf Nodes
     */
    //*********************************************************************** 
    //Root to leaf Path sum
    public static ArrayList<Integer> Root_to_leaf_sum(TreeNode root,int sum,ArrayList<Integer> arr)
    {
        if(root==null)
        {
           return new ArrayList<>();
        }
        sum +=root.data;
        if(root.left==null && root.right==null)
        {
          arr.add(sum);
        }
        Root_to_leaf_sum(root.left,sum,arr);
        Root_to_leaf_sum(root.right,sum,arr);
        return arr;
    }
    //*********************************************************************** 
    //find min and max path of the tree
    public static void Min_and_Max_Path(TreeNode root,int sum,AtomicInteger min,AtomicInteger max)
    {
        if(root==null)
        {
            return;
        }
        sum=sum+root.data;
        if(root.left==null && root.right==null)
        {
            min.set(Math.min(min.get(),sum));
            max.set(Math.max(max.get(),sum));
        }
        Min_and_Max_Path(root.left, sum, min, max);
        Min_and_Max_Path(root.right, sum, min, max);
    }
    //*********************************************************************** 
    //Print All Root-to-Leaf Paths
    public static ArrayList<ArrayList<Integer>> Path_print(TreeNode root,ArrayList<ArrayList<Integer>> main_arr,ArrayList<Integer> arr)
    {
        if(root==null)
        {
            //arr.removeLast()
            return main_arr;

        }
        
        arr.add(root.data);
        if(root.left==null && root.right==null)
        {
            main_arr.add(new ArrayList<Integer>(arr));
        }
        Path_print(root.left, main_arr, arr);
        Path_print(root.right, main_arr, arr);
        
        
        arr.remove(arr.size()-1);
        return main_arr;
    }
    //********************************************************************* 
    //Maximum Path Sum in a Binary Tree
    public static AtomicInteger Max_path(TreeNode root,int sum,AtomicInteger max)
    {
        if(root==null)
        {
            return max;
        }
        sum=sum+root.data;
        if(root.left==null && root.right==null)
        {
         max.set(Math.max(sum,max.get()));
        }
        
        Max_path(root.left, sum, max);
        Max_path(root.right, sum, max);
        return max;
    }

    //*********************************************************************** */
    // Lowest Common Ancestor (LCA) of  Nodes
    public static void Ancestor_node(TreeNode root,int target)
    {
        if(root==null)
        {
            return ;
        }
        if(root.left!=null && root.left.data==target || root.right!=null && root.right.data==target)
        {
            System.out.println(root.data +"  is the ancestor");
            return ;
        }
        Ancestor_node(root.left, target);
        Ancestor_node(root.right, target);
    }
    //************************************************************************************* 
    //Find Distance Between Two Nodes in a Binary Tree
        
}
