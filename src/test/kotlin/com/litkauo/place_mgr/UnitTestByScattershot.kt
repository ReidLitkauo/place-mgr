package com.litkauo.place_mgr
import com.litkauo.place_mgr.*

abstract class UnitTestByScattershot<I,O>(numTestCases: Int, testParameters: Map<String, String>): UnitTestBase<I,O>(numTestCases, testParameters) {

	override fun buildOneExpectedTestCase(i: Int): TestCase<I,O> {
		val output = this.buildOneRandomExpectedOutput()
		val input  = this.buildTestInputFromExpectedOutput(output)
		return TestCase(
			input = input,
			output = output,
		)
	}

	abstract fun buildOneRandomExpectedOutput(): O
	abstract fun buildTestInputFromExpectedOutput(expected: O): I

}

