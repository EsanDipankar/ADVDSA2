import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;
public class mcm {
    public static ArrayList<Integer> miniHeap= new ArrayList<>();
    public static void main(String[] args){
        miniHeapadd(5);
        miniHeapadd(4);
        miniHeapadd(3);
        miniHeapadd(2);
        System.out.print(miniHeap);
    }
    public static void miniHeapadd(int a){
       miniHeap.add(a);
        int n = miniHeap.size();
        int childIndex=n-1;
        int parent= (n-2)/2;
        if(miniHeap.get(childIndex) < miniHeap.get(parent)){
            while (childIndex>0 && miniHeap.get(childIndex) < miniHeap.get(parent)){
                int temp = miniHeap.get(childIndex);
                miniHeap.set(childIndex, miniHeap.get(parent));
                miniHeap.set(parent, temp);
                childIndex=parent;                
                parent = (childIndex-1)/2;
            }
        }
    }
    public static void removelement(){
        if (miniHeap.isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }

        int lastindex=miniHeap.size()-1;
        if(miniHeap.size() == 1){
            miniHeap.remove(0);
        }
        else{
            int temp= miniHeap.get(0);
            miniHeap.set(0, miniHeap.get(lastindex));
            miniHeap.set(lastindex, temp);
            miniHeap.remove(lastindex);
            Balancingheap();
        }
        
    }
    public static void Balancingheap(){ // Balancing After Remove data 
        int nodeIndex=0;
        
        int smallest = nodeIndex;
        while(2*nodeIndex+1<miniHeap.size()){
            smallest= 2*nodeIndex+1;
            
            if(2*nodeIndex+2 < miniHeap.size() && miniHeap.get(2*nodeIndex+2) < miniHeap.get(2*nodeIndex+1)){
                smallest=2*nodeIndex+2;
            }
            if(smallest== nodeIndex){
                break;
            }

            int temp= miniHeap.get(nodeIndex);
            miniHeap.set(nodeIndex, miniHeap.get(smallest));
            miniHeap.set(smallest, temp);
            
            nodeIndex=smallest;
        }
    }
    public static ArrayList<Integer> convert(ArrayList<Integer> miniHeap){
        ArrayList<Integer> maxiHeap= new ArrayList<>();
        for(int i=miniHeap.size()-1; i>=0; i--){
            int node=miniHeap.get(i);
            maxiHeap.add(node);
            int childIndex= maxiHeap.size()-1;
            int parent= (childIndex-1)/2;
    
            while(childIndex > 0 && maxiHeap.get(childIndex) > maxiHeap.get(parent)){
                int temp= maxiHeap.get(parent);
                maxiHeap.set(parent, maxiHeap.get(childIndex));
                maxiHeap.set(childIndex, temp);
                childIndex=  parent;
                parent= (childIndex-1)/2;
            }
        }
        return maxiHeap;
    }
    public static void preorder(treenode Root){
        if(root== null) return;
        System.out.println(root.data);
        preorder(Root.left);
        preorder(Root.right);
    }
    public static void Inorder(treenode Root){
        if(root== null) return;
        
        Inorder(Root.left);
        System.out.println(root.data);
        Inorder(Root.right);

    }
    public static void InorderTravershal(treenode Root){
        Stack<treenode> st= new Stack<>();
        treenode cur= Root;
        st.push(cur);
        while (!st.isEmpty()){

            
        }

    }
}