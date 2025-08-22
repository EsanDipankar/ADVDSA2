import java.util.*;
class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class treetest {
    public static HashMap<Integer, Integer> hm;
    public static int ind=0;
    public static void preorder(TreeNode Root){
        if(Root== null) return;
        System.out.println(Root.data);
        preorder(Root.left);
        preorder(Root.right);
        return;
    }
    public static void Inorder(TreeNode Root){
        if(Root== null) return;
        Inorder(Root.left);
        System.out.println(Root.data);
        Inorder(Root.right);
        return;
    }
    public static int getHeight(TreeNode root){
        if(root==null) return 0;
        int lh=getHeight(root.left);
        int rh=getHeight(root.right);
        return 1+ Math.max(lh, rh);

    }   
    public static int isbalance(TreeNode root){
        if(root==null) return 0;
        int lh=1+getHeight(root.left);
        if(lh ==-1) return -1;

        int rh=1+getHeight(root.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh)>1)  return -1;
        return 0;
    }
    //inorder travershal using loops
    public static void travershal(TreeNode root){
        Stack<TreeNode> st= new Stack<>();
        TreeNode curr= root;
        // st.push(curr);
        while(curr!= null || !st.isEmpty()){
            if(curr!= null){
                st.push(curr);
                curr= curr.left;
            }else{
                curr= st.peek();
                st.pop();
                System.out.println(curr.data);
                curr=curr.right;
            }
        }
    }
    public static void LevelOrderTravershal(TreeNode root){
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int siz = q.size();
            for(int i=0; i<siz; i++){
                TreeNode curr= q.poll();
                System.out.print(curr.data);
                if(curr.left!= null) q.offer(curr.left);
                if(curr.right!= null) q.offer(curr.right); 
            }
        }
    }
    // generate tree from inorder and preorder
    public static TreeNode GeneratetreeusingINPRE(int[] inorder, int[] preorder, int first, int last){
        if(first>last) return null;
        TreeNode root= new TreeNode(preorder[ind]);
        ind+=1;
        int inorderindex= hm.get(root.data); 

        root.left=GeneratetreeusingINPRE(inorder, preorder,first, inorderindex-1 );
        root.right= GeneratetreeusingINPRE(inorder, preorder, inorderindex+1, last);

        return root;
    }
    public static void generatetree(int[] inorder, int[] preorder){
         hm= new HashMap<>();
        
        for(int i=0; i<inorder.length; i++){
            hm.put(inorder[i], i);
        }
        ind=0;
        TreeNode root= GeneratetreeusingINPRE(inorder, preorder, 0, inorder.length-1);
        LevelOrderTravershal(root);
    }
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */

        // Creating nodes
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

       /* 
       System.out.println("Preorder Traversal of Tree:");
        preorder(root);  // Output should be: 1 2 4 5 3
        System.out.println("Inorder Traversal of Tree:");
        Inorder(root);  // Output should be: 1 2 4 5 3
        System.out.print("Height of the tree is:-   "+ getHeight(root));
        System.out.print("Checking tree is Balance:-   "+ isbalance(root));
        travershal(root);
        LevelOrderTravershal(root);
    */ 
      
        int[] preorder = {1, 2, 4, 5, 3, 6, 7};
        int[] inorder  = {4, 2, 5, 1, 6, 3, 7};
        generatetree(inorder, preorder);
        
    }
}
