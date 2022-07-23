package com.litkauo.place_mgr
import com.litkauo.place_mgr.*

enum class UserRole (val roleCode: Byte) {
	Anon    (0b00000000),
	Banned  (0b00010000),
	Default (0b00100000),
	Admin   (0b00110000),
}

