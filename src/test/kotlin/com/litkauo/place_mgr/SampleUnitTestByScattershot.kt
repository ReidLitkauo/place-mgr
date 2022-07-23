package com.litkauo.place_mgr
import com.litkauo.place_mgr.*
import kotlin.random.Random

class SampleUnitTestByScattershot : UnitTestByScattershot<Pair<Double,Double>, Double>(1000, mapOf(
	"maxSum" to "1000.0"
)) {

	override fun buildOneRandomExpectedOutput(): Double {
		return Random.nextDouble() * this.testParameters.get("maxSum")!!.toDouble()
	}

	override fun buildTestInputFromExpectedOutput(expected: Double): Pair<Double,Double> {
		val addend1 = Random.nextDouble() * this.testParameters.get("maxSum")!!.toDouble()
		val addend2 = expected - addend1
		return Pair(addend1, addend2)
	}

	override fun runOneTestInput(input: Pair<Double,Double>): Double {
		return SampleModule.add(input.first, input.second)
	}

}