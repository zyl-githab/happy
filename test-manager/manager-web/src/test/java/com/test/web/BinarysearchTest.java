package com.test.web;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinarysearchTest {

	@Test
	public void testBsearchWithoutRecursion() {

		int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 17 };
		int target = 15;
		int result = Binarysearch.bsearchWithoutRecursion(arr, 0, arr.length - 1, target);
		assertEquals(result, 7);
	}

}
