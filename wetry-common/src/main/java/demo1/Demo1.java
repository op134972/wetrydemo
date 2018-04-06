package demo1;

public class Demo1 {

    public static void main(String[] args) {
        int[] arr = {1,2,2,3,3,4,4};
        System.out.println(fun(arr));

       // System.out.println(transFromString("+72352E3"));
    }


    public static int fun(int []arr){

        return binaryFind2(arr,0,arr.length-1);

    }


    private static int binaryFind(int[] arr, int s, int e) {
        if (s <= e) {
            int mid = s + (e - s) / 2;
            if (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
                return binaryFind(arr, s, mid - 2) + binaryFind(arr, mid + 1, e);
            } else if (mid + 1 < arr.length && arr[mid + 1] == arr[mid]) {
                return binaryFind(arr, s, mid - 1) + binaryFind(arr, mid + 2, e);
            }
            return arr[mid];
        }
        return 0;
    }


    private static int binaryFind2(int[] arr, int s, int e) {
        if(s<=e){
            int mid = s+(e-s)/2;
            if(mid-1>=0&&arr[mid]==arr[mid-1]){
                int newS = mid+1;
                if((e-newS+1)%2 != 0){//右为奇
                    return binaryFind2(arr,mid+1,e);
                }else{
                    return binaryFind2(arr,s,mid-2);
                }
            }else if(mid+1<arr.length&&arr[mid]==arr[mid+1]){
                int newS = mid+2;
                if((e-newS+1)%2!=0){//右为奇
                    return binaryFind2(arr,mid+2,e);
                }else{
                    return binaryFind2(arr, s, mid - 1);
                }
            }
            return arr[mid];
        }
        return -1;
    }
    private static int transFromString(String str){
        return Integer.parseInt(str);
    }
}
