import java.util.Arrays;

public class paixu {
    public static void main(String[] args)
    {
        int num[]=new int[]{4,5,8,1,3,9};
//        maopao(num);                      //冒泡排序
//        ins(num);                         //插入排序
//        quick(num,0,num.length-1);        //快排
        mergeSort(num);                     //归并排序
//        HeapSort(num);                  //堆排序
        for(int i=0;i<num.length;i++)
            System.out.println(num[i]);
    }
    public static void maopao(int num[])
    {
        for(int i=0;i<num.length;i++)
        {
            for(int j =i;j<num.length;j++)
            {
                if(num[j]<num[i])
                {
                    int temp=num[j];
                    num[j]=num[i];
                    num[i]=temp;
                }
            }
        }
        System.out.println("冒泡排序");
        for(int i=0;i<num.length;i++)
        System.out.println(num[i]);
    }
    public static void ins(int num[])
    {
        for(int i=1;i<num.length;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(num[j]<num[j-1])
                {
                    int temp=num[j];
                    num[j]=num[j-1];
                    num[j-1]=temp;
                }
                else
                {
                    break;
                }
            }
        }
        System.out.println("插入排序");
        for(int i=0;i<num.length;i++)
            System.out.println(num[i]);
    }
    //快排
    public static void quick(int arr[],int low,int high)
    {
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
            j=high;
            temp = arr[low];
        while (i<j) {
            while (temp<=arr[j]&&i<j) {
                j--;
            }

            while (temp>=arr[i]&&i<j) {
                i++;
            }
            if (i<j) {
                int z = arr[i];
                int y = arr[j];
                arr[i] = y;
                arr[j] = z;

            }

        }
        arr[low] = arr[i];
        arr[i] = temp;
        quick(arr, low, j-1);
        quick(arr, j+1, high);
    }
    //归并排序
    public static int[] mergeSort(int[] arr) {
        if (arr.length<=1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = Arrays.copyOfRange(arr,0,mid);
        int[] right = Arrays.copyOfRange(arr,mid,arr.length);
        return merge(arr, mergeSort(left), mergeSort(right));
    }
    private static int[] merge(int[] arr, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        for (int index = 0; index < arr.length; index++) {
            if (i>=left.length){
                arr[index]=right[j++];
            }else if(j>=right.length){
                arr[index]=left[i++];
            }else if (left[i]<right[j]){
                arr[index]=left[i++];
            }else {
                arr[index]=right[j++];
            }
        }
        return arr;
    }
    //堆排序
    public static void HeapSort(int[] arr) {
        int i;
        int len = arr.length;
        // 构建一个最小堆
        for (i = len / 2 - 1; i >= 0; i--) {
            adjustment(arr, i, len);
        }
        for (i = len - 1; i >= 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            adjustment(arr, 0, i);
        }
    }

    public static void adjustment(int[] arr, int pos, int len) {
        int child = 2 * pos + 1;
        if (child + 1 < len && arr[child] > arr[child + 1]) {
            child++;
        }
        if (child < len && arr[pos] > arr[child]) {
            int tmp = arr[pos];
            arr[pos] = arr[child];
            arr[child] = tmp;
            adjustment(arr, child, len);
        }
    }
}