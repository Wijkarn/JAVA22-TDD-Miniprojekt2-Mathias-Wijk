package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Prime;

class PrimeTest {

	Prime prime;

	@BeforeEach
	void beforeEach() {
		prime = new Prime(0, 1000);
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 1")
	void constructorThrows() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(0, 1001));
		assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 2")
	void constructorThrows2() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(0, -1));
		assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 3")
	void constructorThrows3() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 1000));
		assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 4")
	void constructorThrows4() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> new Prime(1, 1000));
		assertEquals("Hoppsan, fel intervall angivet!", exception.getMessage());
	}

	@Test
	@DisplayName("Doesn't throw if ints are 0 and 1000")
	void constructorDoesNetThrows4() {
		assertDoesNotThrow(() -> prime);
	}

	@Test
	@DisplayName("Test if getPrime size is correct value")
	void getPrimesSize() {
		assertEquals(168, prime.getPrimes().size());
	}

	@Test
	@DisplayName("Test if getCount size is correct value")
	void getCount() {
		assertEquals(168, prime.getCount());
	}

	@Test
	@DisplayName("Get sumOfPrimes")
	void getSumOfPrimes() {
		assertEquals(76127, prime.getSumOfPrimes());
	}

	@Test
	@DisplayName("Test printSum")
	void printSum() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		prime.printSum();
		assertEquals("Sum of all primes between 0 and 1000: 76127", outputStreamCaptor.toString().trim());

		System.setOut(System.out);
	}

	@Test
	@DisplayName("Test printCount")
	void printCount() {
		ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStreamCaptor));

		prime.printCount();
		assertEquals("Amount of primes between 0 and 1000: 168", outputStreamCaptor.toString().trim());

		System.setOut(System.out);
	}

}
