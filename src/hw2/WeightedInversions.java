package hw2;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeightedInversions {
    private static long merge(int[] arr, int left, int mid, int right) {
        int i = left, j = mid, k = 0;
        long invCount = 0;
        int[] temp = new int[(right - left + 1)];

        while ((i < mid) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                ++k;
                ++i;
            }
            else {
                temp[k] = arr[j];
                for(int n = i; n < mid; n++)
                {
                    invCount += Math.abs(arr[n] - arr[j]);
                }
                ++k;
                ++j;
            }
        }

        while (i < mid) {
            temp[k] = arr[i];
            ++k;
            ++i;
        }

        while (j <= right) {
            temp[k] = arr[j];
            ++k;
            ++j;
        }

        for (i = left, k = 0; i <= right; i++, k++) {
            arr[i] = temp[k];
        }

        return invCount;
    }
    private static long mergeSort(int[] arr, int left, int right) {
        int invCount = 0;

        if (right > left) {
            int mid = (right + left) / 2;

            invCount += mergeSort(arr, left, mid);
            invCount += mergeSort(arr, mid + 1, right);
            invCount += merge(arr, left, mid + 1, right);
        }
        return invCount;
    }

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw2/InputFiles/input-3.4"));
        int length = Integer.parseInt(scanner.nextLine());
        String[] stringArr = scanner.nextLine().split(" ");
        int[] numArr = new int[length];
        for(int i = 0; i < length; i++)
        {
            numArr[i] = Integer.parseInt(stringArr[i]);
        }
        System.out.println(mergeSort(numArr, 0, length-1));
    }
}
