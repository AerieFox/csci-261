package hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class SizeDoubleS
{


    /**
     * Use mergesort
     *
     * get all sums without checking if one is already in there
     * sort the list of sums
     * go through list and add 1 to sum total when the value from 1 index to the next changes
     * @param inputArray
     * @return
     */
    private static int FindSums(double[] inputArray)
    {
        boolean containsZero = false;
        int index = 0;
        double[] sums = new double[100];
        for(int i = 0; i < inputArray.length; i++)
        {
            for(int j = i; j < inputArray.length; j++)
            {
                if(index == sums.length - 1)
                {
                    sums = EnlargeArray(sums);
                }
                if(inputArray[i] + inputArray[j] == 0)
                {
                    containsZero = true;
                }
                sums[index] = inputArray[i] + inputArray[j];
                index++;
            }
        }
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(sums, 0, sums.length-1);

        return CountSums(sums, containsZero);
    }


    private static int CountSums(double[] sums, boolean containsZero)
    {
        double curSum = 0;
        int numSum = 0;
        for(int i = 0; i < sums.length; i++)
        {
            if(sums[i] != curSum && sums[i] != 0.0)
            {
                numSum++;
                curSum = sums[i];
            }
        }
        if(containsZero)
        {
            numSum++;
        }
        return numSum;
    }

    /**
     * take array and enlarge it by a factor of 10
     * @param array
     * @return
     */
    private static double[] EnlargeArray(double[] array)
    {
        double[] newArr = new double[array.length * 10];
        System.arraycopy(array, 0, newArr, 0, array.length);
        return newArr;
    }


    /**
     * if sum is not already in sum array, add it and add 1 to sum var
     *
     */
    public static void main(String[] args) throws FileNotFoundException {

        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw1/InputFiles/input-2.5"));
        scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        double[] inputNums = new double[input.length];

        for(int i = 0; i < input.length; i++)
        {
            inputNums[i] = Double.parseDouble(input[i]);
        }

        System.out.println(FindSums(inputNums));

    }


}
