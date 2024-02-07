package hw1;

import java.util.Arrays;
public class MergeSort {

    public static void main(String args[]) {
        MergeSort ob = new MergeSort();
        double nums[] = {1.1, 1.2, 1.3, 2.2, 1.4, 2.3, 1.5, 9.8, 7.3, 7.7, 5.2, 5.1, 9.9, 4.1, 4.3, 4.2};
        System.out.println("Original Array:");
        System.out.println(Arrays.toString(nums));
        ob.sort(nums, 0, nums.length - 1);
        System.out.println("Sorted Array:");
        System.out.println(Arrays.toString(nums));
    }

    private void merge(double nums[], int left, int m, int right) {
        int n1 = m - left + 1;
        int n2 = right - m;

        double Left_part_arra[] = new double[n1];
        double Right_part_arra[] = new double[n2];

        for (int i = 0; i < n1; ++i)
            Left_part_arra[i] = nums[left + i];
        for (int j = 0; j < n2; ++j)
            Right_part_arra[j] = nums[m + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (Left_part_arra[i] <= Right_part_arra[j]) {
                nums[k] = Left_part_arra[i];
                i++;
            } else {
                nums[k] = Right_part_arra[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = Left_part_arra[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = Right_part_arra[j];
            j++;
            k++;
        }
    }

    public void sort(double nums[], int left, int right) {
        if (left < right) {
            int m = (left + right) / 2;
            sort(nums, left, m);
            sort(nums, m + 1, right);
            merge(nums, left, m, right);
        }
    }
}