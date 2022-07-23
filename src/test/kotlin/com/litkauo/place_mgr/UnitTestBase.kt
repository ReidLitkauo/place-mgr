package com.litkauo.place_mgr
import com.litkauo.place_mgr.*
import kotlin.test.*
import com.google.gson.*

abstract class UnitTestBase<I,O> (val numTestCases: Int, val testParameters: Map<String, String> = mapOf()) {

	val expected = arrayOfNulls<TestCase<I,O>>(numTestCases)
	val actual   = arrayOfNulls<TestCase<I,O>>(numTestCases)
	val gson = GsonBuilder().setPrettyPrinting().create()
	
	init {

	}

	//#########################################################################

	@Test fun runUnitTest() {
		this.buildTestCases()
		this.runTestCases()
		this.assertTestCases()
	}

	//=========================================================================

	fun buildTestCases() {
		for (i in 0 until this.numTestCases) {
			this.expected[i] = this.buildOneExpectedTestCase(i)
		}
	}

	//-------------------------------------------------------------------------

	abstract fun buildOneExpectedTestCase(i: Int): TestCase<I,O>

	//=========================================================================

	fun runTestCases() {
		for (i in 0 until this.numTestCases) {
			this.actual[i] = TestCase(
				input  = this.expected[i]!!.input,
				output = this.runOneTestInput(this.expected[i]!!.input)
			)
		}
	}

	abstract fun runOneTestInput(input: I): O

	//=========================================================================

	fun assertTestCases() {
		var success = true
		for (i in 0 until this.numTestCases) {
			if (!this.outputsAreEqual(this.expected[i]!!.output, this.actual[i]!!.output)) {
				success = false
				this.printTestCaseInfo(i)
			}
		}
		if (!success) {
			throw AssertionError()
		}
	}

	//-------------------------------------------------------------------------

	open fun outputsAreEqual(expected: O, actual: O): Boolean {
		if ((expected is Double && actual is Double) || (expected is Float && actual is Float)) {
			return outputDoublesAreEqual(expected as Double, actual as Double)
		} else {
			return outputObjectsAreEqual(expected, actual)
		}
	}

	fun outputDoublesAreEqual(expected: Double, actual: Double): Boolean {
		val epsilon = 1e-8
		return epsilon > Math.abs(expected - actual)
	}

	fun outputObjectsAreEqual(expected: O, actual: O): Boolean {
		return expected!!.equals(actual)
	}

	//-------------------------------------------------------------------------

	fun printTestCaseInfo(testIndex: Int) {
		println("=".repeat(80))
		println()
		print("Input:    ")
		println(gson.toJson(this.expected[testIndex]!!.input))
		println()
		print("Expected: ")
		println(gson.toJson(this.expected[testIndex]!!.output))
		println()
		print("Actual:   ")
		println(gson.toJson(this.actual[testIndex]!!.output))
		println()
	}

}

