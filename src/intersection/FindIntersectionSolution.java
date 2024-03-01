package intersection;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class FindIntersectionSolution {

    public static void main(String[] args) {
        var solution = new FindIntersectionSolution();
        int[] nums1 = new int[] {1, 2, 3, 3, 4, 5};
        int[] nums2 = new int[] {3, 4, 4, 5, 6, 7};
        System.out.println(Arrays.toString(solution.findIntersectionNoOrder(nums1, nums2)));
        System.out.println(Arrays.toString(solution.findIntersectionOrder(nums1, nums2)));
    }

    // Solution 1: if the result is acceptable in any order
    // HashSet doesn't preserve insertion order
    private int[] findIntersectionNoOrder(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        HashSet<Integer> intersectionSet = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] result = new int[intersectionSet.size()];

        int index = 0;

        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }

    // Solution 2: if the order of elements in result matters
    // LinkedHashSet preserves insertion order
    private int[] findIntersectionOrder(int[] nums1, int[] nums2) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for (int num : nums1) {
            set.add(num);
        }

        LinkedHashSet<Integer> intersectionSet = new LinkedHashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersectionSet.add(num);
            }
        }

        int[] result = new int[intersectionSet.size()];
        int index = 0;

        for (int num : intersectionSet) {
            result[index++] = num;
        }

        return result;
    }

}
