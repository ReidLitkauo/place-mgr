package com.litkauo.place_mgr
import com.litkauo.place_mgr.*

data class Coordinate(val x: Int, val y: Int) {

	fun getIndex(): Int {
		return ((Board.WIDTH * y) + x)
	}

}

