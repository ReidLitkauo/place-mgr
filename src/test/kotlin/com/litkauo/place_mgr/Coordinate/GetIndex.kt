package com.litkauo.place_mgr
import com.litkauo.place_mgr.*
import kotlin.test.*

class GetIndex : UnitTestBase<Coordinate, Int>(1, mapOf()) {

	override fun buildOneExpectedTestCase(i: Int): TestCase<Coordinate, Int> {
		return TestCase(
			input  = Coordinate(20, 5),
			output = 10020,
		)
	}

	override fun runOneTestInput(input: Coordinate): Int {
		return input.getIndex()
	}

}

