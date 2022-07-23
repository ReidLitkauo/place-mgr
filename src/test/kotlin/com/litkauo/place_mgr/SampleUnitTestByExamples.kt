package com.litkauo.place_mgr
import com.litkauo.place_mgr.*

class SampleUnitTestByExamples : UnitTestByExamples<Pair<Double, Double>, Double>(

	arrayOf(
		TestCase(
			input  = Pair(1.0, 2.0),
			output = 3.0,
		),
		TestCase(
			input  = Pair(5.0, 8.0),
			output = 13.0,
		)
	),

	mapOf()

) {

	override fun runOneTestInput(input: Pair<Double,Double>): Double {
		return SampleModule.add(input.first, input.second)
	}

}

