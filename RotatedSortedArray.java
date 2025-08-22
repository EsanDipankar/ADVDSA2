public class RotatedSortedArray {
    public static void main(String[] args){
    int[] arr={4,5,6,7,0,1,2,3};
    int key=4;
    System.out.println(finddata(arr, key));
    }
    public static int finddata(int[] arr, int key){
        int start= 0;
        int end= arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid= (start+end)/2;
            if(arr[mid]== key){
                ans= mid;
                return ans; 
            }
            if(arr[start]< arr[mid]){
                if(key>=arr[start] && key< arr[mid]){
                    end=mid-1;
                }else{
                    start= mid+1;
                }
            }else{
                if(key>arr[mid] && key<= arr[end]){
                    start= mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return ans;
    }
}
