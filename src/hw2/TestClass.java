package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestClass
{
    static long merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0;
        long count = 0;
        while (i < left.length || j < right.length) {
            if (i == left.length) {
                arr[i+j] = right[j];
                j++;
            } else if (j == right.length) {
                arr[i+j] = left[i];
                i++;
            } else if (left[i] <= right[j]) {
                arr[i+j] = left[i];
                i++;
            } else {
                arr[i+j] = right[j];
//                 count += left.length-i;
                for(int n = i; n < left.length; n++)
                {
                    count += Math.abs(left[n] - right[j]);
                }
                j++;
            }
        }
        return count;
    }

    static long invCount(int[] arr) {
        if (arr.length < 2)
            return 0;

        int m = (arr.length + 1) / 2;
        int[] left = new int[m];
        int[] right = new int[arr.length/2];
        System.arraycopy(arr, 0, left, 0, m);
        System.arraycopy(arr, m, right, 0, arr.length - m);
//        int left[] = Arrays.copyOfRange(arr, 0, m);
//        int right[] = Arrays.copyOfRange(arr, m, arr.length);

        return invCount(left) + invCount(right) + merge(arr, left, right);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw2/InputFiles/input-3.3"));
        int length = Integer.parseInt(scanner.nextLine());
        String[] stringArr = scanner.nextLine().split(" ");
        int[] numArr = new int[length];
        for(int i = 0; i < length; i++)
        {
            numArr[i] = Integer.parseInt(stringArr[i]);
        }

        System.out.print(invCount(numArr));
    }
}