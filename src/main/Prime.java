package main;

import java.util.ArrayList;
import java.util.List;

/*-
* This program counts the sum and the number of prime (int) numbers in the interval 0-1000
*/
public class Prime {

	private List<Integer> primes;
	private int count = 0;
	private int sumOfPrimes = 0;

	// Constructor to initialize the object and calculate prime numbers
	public Prime(int firstNumber, int lastNumber) {

		if (firstNumber != 0 || lastNumber != 1000) {
			throw new IllegalArgumentException("Hoppsan, fel intervall angivet!");
		}
		primes = new ArrayList<>();
		calculatePrimes(firstNumber, lastNumber);
		printSum();
		printCount();
	}

	public boolean numIsPrime(int current) {
		// Numbers less than or equal to 3 are prime (2 and 3).
		if (current <= 3) {
			return true;
		}
		if (current % 2 == 0 || current % 3 == 0) {
			return false;
		}
		// Check for divisibility by numbers of the form 6k ± 1, optimizing the
		// primality test.
		for (int i = 5; i * i <= current; i += 6) {
			if (current % i == 0 || current % (i + 2) == 0) {
				return false;
			}
		}
		// If none of the above conditions are met, the number is prime.
		return true;
	}

	// Calculate prime numbers within a given range
	public void calculatePrimes(int current, int stop) {
		if (current <= stop) {
			if (current >= 2 && numIsPrime(current)) {
				primes.add(current);
				++count;
				sumOfPrimes += current;
			}
			calculatePrimes(++current, stop);
		}
	}

	// Getter method for the count of prime numbers
	public int getCount() {
		return count;
	}

	// Getter method for the sum of prime numbers
	public int getSumOfPrimes() {
		return sumOfPrimes;
	}

	// Getter method for the list of prime numbers
	public List<Integer> getPrimes() {
		return primes;
	}

	public void printSum() {
		System.out.println("Sum of all primes between 0 and 1000: " + sumOfPrimes);
	}

	public void printCount() {
		System.out.println("Amount of primes between 0 and 1000: " + count);
	}
}
