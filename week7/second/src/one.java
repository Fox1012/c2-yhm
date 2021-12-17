public class one {
    public static void main(String[] args) {
        int nums1[] = {4, 1, 2};
        int nums2[] = {1, 3, 4, 2};
        int result[] = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            for (int i = 0; i < nums2.length; i++) {
                if (nums1[j] == nums2[i]) {
                    int max = nums1[j];
                    for (int s = i; s < nums2.length; s++) {
                        if (nums2[s] > max) {
                            max = nums2[s];
                            break;
                        }
                    }
                    if (max == nums1[j])
                        result[j] = -1;
                    else
                        result[j] = max;
                    break;
                }
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(result[i]);
        }
    }
}