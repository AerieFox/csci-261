package hw3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Majority
{

    static void findMax(int[] arr, int n)
    {
        int count1 = 0, count2 = 0;
        int first =  Integer.MIN_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (first == arr[i])
            {
                count1++;
            }

            else if (second == arr[i])
            {
                count2++;
            }
            else if (count1 == 0)
            {
                count1++;
                first = arr[i];
            }

            else if (count2 == 0)
            {
                count2++;
                second = arr[i];
            }

            else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < n; i++)
        {
            if (arr[i] == first)
            {
                count1++;
            }

            else if (arr[i] == second)
            {
                count2++;
            }
        }
                            // check for N/2
        if (count1 > n / 2)
        {
            System.out.println("YES");
        }
        else if (count2 > n / 2)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }
                            // check for N/3
        if (count1 > n / 3)
        {
            System.out.println("YES");
        }
        else if (count2 > n / 3)
        {
            System.out.println("YES");
        }
        else
        {
            System.out.println("NO");
        }

    }

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw3/InputFiles/input-4.6"));
        int length = Integer.parseInt(scanner.nextLine());
        int[] vals = new int[length];
        String[] line = scanner.nextLine().split(" ");
        for(int i = 0; i < length; i++)
        {
            vals[i] = Integer.parseInt(line[i]);
        }

        findMax(vals, length);
    }
}
