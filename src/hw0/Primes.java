package hw0;

import java.util.Scanner;

public class Primes {
    private static void IsPrime(int numLimit) {
        // for every number < given number
        for (int i = 2; i <= numLimit; i++) {
            boolean isPrime = true;
            // check if any number > 1 can divide current num
            for (int j = 2; j < i; j++) {
                if(i % j == 0) {
                    isPrime = false;
                }
            }
            if(isPrime) {
                System.out.println(i);
            }
        }
    }

    /**
     * A single nonnegative integer, n, not larger than 10,000.
     * Output: A list of all of the prime numbers less than or equal to n,
     * in increasing order, each on its own line.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLimit = Integer.parseInt(scanner.nextLine());
        IsPrime(numLimit);
    }
}
