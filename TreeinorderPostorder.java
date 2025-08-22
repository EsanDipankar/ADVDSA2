import java.util.HashMap;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode(int data){
        this.data=data;
        left=null;
        right=null;
    }    
}
public class TreeinorderPostorder {
    public static int ind;
    public static HashMap<Integer, Integer> hm ;
    public static TreeNode generateTree(int[] inorder, int[] postorder, int first, int last){
        if(first>last) return null;
        TreeNode root= new TreeNode(postorder[ind]);
        ind--;
        int inorderIndex= hm.get(root.data);
        root.right=generateTree(inorder, postorder, inorderIndex+1, last);
        root.left= generateTree(inorder, postorder, first, inorderIndex-1);
        
        return root;
    }
    public static void buidtree(int[] inorder, int[] postorder){
        int n= inorder.length;
         hm = new HashMap<>();
        for(int i=0; i<n; i++){
            hm.put(inorder[i], i);
        }
        ind= n-1;
        TreeNode root= generateTree(inorder, postorder, 0, n-1);

    }
    public static void main(String[] args){
        int[] inorder  = {40,20,50,10,60,30};
        int[] postorder={40,50,20,60,30,10};
    }
}
