package hw2;

import java.io.*;
import java.util.Scanner;

class Coords
{
    int x;
    int y;

    public Coords(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

public class MaxRectangle
{
    public static int findLargestRectangleArea(Coords[] points) {
        int maxArea = 0;
        Stack stack = new Stack();
        Coords current;
        Coords last;
        for(int i = 0; i < points.length; i += 2)
        {
            if((i == 0) || points[i].y > points[i-2].y)
            {
                stack.push(points[i]);
            }
            else
            {
                current = points[i];
                last = points[i-2];

                while(stack.peekSecond() != null && stack.peek().y > current.y)
                {
                    Coords top1 = stack.peek();
                    Coords top2 = stack.peekSecond();

                    int area = (last.x - top2.x) * top1.y;

                    if(area > maxArea)
                    {
                        maxArea = area;
                    }

                    stack.pop();
                }

                stack.push(points[i]);
            }

        }

        last = points[points.length - 1];
        while(stack.peekSecond() != null)
        {
            Coords top1 = stack.peek();
            Coords top2 = stack.peekSecond();

            int area = (last.x - top2.x) * top1.y;

            if(area > maxArea)
            {
                maxArea = area;
            }

            stack.pop();
        }

        return maxArea;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("/Users/astowwe/source/Algorithms/src/hw2/InputFiles/input-2.2"));
        int verts = Integer.parseInt(scanner.nextLine());
        Coords[] points = new Coords[verts];
        for(int i = 0; i < verts; i++)
        {
            String[] curLine = scanner.nextLine().split(" ");
            points[i] = new Coords(Integer.parseInt(curLine[0]), Integer.parseInt(curLine[1]));
        }

        System.out.println(findLargestRectangleArea(points));
    }
}

