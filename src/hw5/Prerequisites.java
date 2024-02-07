package hw5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Prerequisites {

    public static ArrayList<Integer>[] adj;


    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw5/InputFilesP3/input-1.1"));
        int numCourses = Integer.parseInt(scanner.nextLine());
        adj = new ArrayList[numCourses];
        String[] curLine;

        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
            curLine = scanner.nextLine().split(" ");
            for(int j = 0; j < curLine.length-1; j++) {
                adj[i].add(Integer.parseInt(curLine[j]));
            }
        }
        for(ArrayList array : adj) {
            System.out.println(Arrays.toString(array.toArray()));
        }


        boolean[] completed = new boolean[numCourses];

    }
}

