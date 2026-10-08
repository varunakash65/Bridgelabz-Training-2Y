package Arrays.Leetcode;
import java.util.*;
public class LC88 {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int m = sc.nextInt();
            int n = sc.nextInt();

            int[] nums1 = new int[m + n];
            int[] nums2 = new int[n];

            for (int i = 0; i < m; i++) {
                nums1[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                nums2[i] = sc.nextInt();
            }

            for (int j = 0; j < n; j++) {
                nums1[m + j] = nums2[j];
            }

            Arrays.sort(nums1);

            System.out.println(Arrays.toString(nums1));
        }
}
