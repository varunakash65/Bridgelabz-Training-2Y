package Arrays;
import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        int[] arr={1,2,3,1,3,1,6,4,6,4,5};
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0; i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map);
    }
}
