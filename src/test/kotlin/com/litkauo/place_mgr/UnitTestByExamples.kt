package com.litkauo.place_mgr
import com.litkauo.place_mgr.*

abstract class UnitTestByExamples<I,O>(val examples: Array<TestCase<I,O>>, testParameters: Map<String, String>) : UnitTestBase<I,O>(examples.size, testParameters) {

	override fun buildOneExpectedTestCase(i: Int): TestCase<I,O> {
		return this.examples[i]
	}

}