package hw3;

import java.io.*;
import java.util.Scanner;

public class TestClass {

    public static void main(String[] args) throws IOException {
        String filePath = "/Users/astowwe/source/Algorithms/src/hw3/InputFiles/test";
        int length = 6500;

        PrintWriter printWriter = new PrintWriter(filePath);
        printWriter.print("");
        printWriter.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.append(Integer.toString(length));
        writer.newLine();
        for(int i = 0; i < length; i++) {
            int randInt = (int) (Math.random() * 2000);
            writer.append(Integer.toString(randInt));
            writer.append(' ');
        }
        writer.close();
    }
}

