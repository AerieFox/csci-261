package hw1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Planters {

    private static final String yesOutput = "YES";
    private static final String noOutput = "NO";


    /**
     *
     * go through current array
     * if there is a planter that is size+1 of current, remove both,
     * else:
     * get the smallest planter that is able to be used by current
     */
    private static boolean CanMovePlanters(int[] currentPlants, int[] combinedPlanters)
    {
        int limiter = 0;
        for (int currentPlant : currentPlants) {
            boolean minFound = false;
            int minValIndex = -1;
            for (int j = 0; j < combinedPlanters.length - limiter; j++) {
                int curPlanter = combinedPlanters[j];
                if (currentPlant + 1 == curPlanter)   // if the planter is 1 bigger than the plant
                {
                    minValIndex = j;
                    minFound = true;
                    break;
                } else
                {
                    if (minValIndex == -1)
                    {
                        if (curPlanter > currentPlant)
                        {
                            minValIndex = j;
                        }
                    } else if (combinedPlanters[minValIndex] > curPlanter &&  currentPlant < curPlanter) {
                        minValIndex = j;
                    }
                }
            }
            if (minValIndex == -1 || combinedPlanters[minValIndex] < currentPlant + 1 && !minFound) {
                return false;
            }
            Swap(combinedPlanters, minValIndex, (combinedPlanters.length - limiter) - 1);
            limiter += 1;
        }
        return true;

    }

    private static void Swap(int[] array, int i, int j)
    {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

    private static int[] CombineArrays(String[] currentPlants, String[] addedPlants)
    {
        int[] combinedArr = new int[currentPlants.length + addedPlants.length];

        for(int i = 0; i < currentPlants.length; i++)
        {
            combinedArr[i] = Integer.parseInt(currentPlants[i]);
        }

        for(int i = 0; i < addedPlants.length; i++)
        {
            combinedArr[i + currentPlants.length] = Integer.parseInt(addedPlants[i]);
        }
        return combinedArr;
    }


    public static void main(String[] args) throws FileNotFoundException
    {
        //Scanner scanner = new Scanner(System.in);
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw1/InputFiles/input-1.7"));
        scanner.nextLine();

        String[] currentPlanters = scanner.nextLine().split(" ");
        String[] addedPlanters = scanner.nextLine().split(" ");

        int[] currentPlants = new int[currentPlanters.length];
        for(int i = 0; i < currentPlanters.length; i++)
        {
            currentPlants[i] = Integer.parseInt(currentPlanters[i]);
        }

        int[] combinedArr = CombineArrays(currentPlanters, addedPlanters);

        if(CanMovePlanters(currentPlants, combinedArr))
        {
            System.out.println(yesOutput);
        }
        else
        {
            System.out.println(noOutput);
        }
    }
}
