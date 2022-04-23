package org.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestAddTwoNumber {
	
	@Test
	void test() {
		AddTwoNum object = new AddTwoNum();
		int returnValue = object.addTwoNumber(1, 1);
		int expectedValue = 2;
		assertEquals(returnValue, expectedValue);
	}

}
