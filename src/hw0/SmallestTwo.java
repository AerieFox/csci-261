package hw0;

import java.util.Scanner;

public class SmallestTwo
{

    private static int[] FindSmallest(Scanner scanner)
    {
        int smallest = scanner.nextInt();
        int secondSmallest = scanner.nextInt();
        if(secondSmallest < smallest)
        {
            int tmp = smallest;
            smallest = secondSmallest;
            secondSmallest = tmp;
        }
        int current;
        while(scanner.hasNext())
        {
            current = scanner.nextInt();

            if(current < smallest)
            {
                secondSmallest = smallest;
                smallest = current;
            }
            else if(current < secondSmallest && current != smallest)
            {
                secondSmallest = current;
            }
        }
        return new int[] {smallest, secondSmallest};
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int[] minNums = FindSmallest(scanner);
        System.out.println(minNums[0]);
        System.out.println(minNums[1]);
    }
}
