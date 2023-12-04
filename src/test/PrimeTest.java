package test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import main.Prime;

class PrimeTest {

	Prime prime;

	@BeforeEach
	void before() {
		prime = new Prime(0, 1000);
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 1")
	void constructorThrows() {
		assertThrows(IllegalArgumentException.class, () -> new Prime(0, 1001));
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 2")
	void constructorThrows2() {
		assertThrows(IllegalArgumentException.class, () -> new Prime(0, -1));
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 3")
	void constructorThrows3() {
		assertThrows(IllegalArgumentException.class, () -> new Prime(-1, 1000));
	}

	@Test
	@DisplayName("Throws if ints aren't 0 and 1000. 4")
	void constructorThrows4() {
		assertThrows(IllegalArgumentException.class, () -> new Prime(1, 1000));
	}

	@Test
	@DisplayName("Get prime size")
	void getPrimesSize() {
		assertEquals(168, prime.getPrimes().size());
	}

	@Test
	@DisplayName("Get prime count")
	void getCount() {
		assertEquals(168, prime.getCount());
	}

	@Test
	@DisplayName("Get sumOfPrimes")
	void getSumOfPrimes() {
		assertEquals(76127, prime.getSumOfPrimes());
	}

}
