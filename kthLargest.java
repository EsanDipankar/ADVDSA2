import java.util.*;
public class kthLargest{
    public static int[] findKthLargest(int[] arr, int k){
        PriorityQueue<Integer> minHeap= new PriorityQueue<>(); 
        int[] ans = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            
            if(minHeap.size()== k &&  minHeap.peek() < arr[i] ){
                minHeap.remove();
            }
            minHeap.add(arr[i]);
            if(minHeap.size()<k){
                ans[i]=-1;
            }else{
                ans[i]= minHeap.peek();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[]= {5,4,1,6,7};
        int k=2;
        int[] arns= new int[arr.length]; 
        arns= findKthLargest(arr,k);
        for(int i=0;i<arns.length; i++){
            System.out.print(arns[i]+"->");
        }

    }

} 