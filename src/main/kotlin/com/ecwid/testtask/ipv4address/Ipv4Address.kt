package com.ecwid.testtask.ipv4address

import kotlin.math.pow

//Ipv4 representation
@ExperimentalUnsignedTypes
class Ipv4Address(private val ipv4: String) {
    companion object CONSTANTS {
        private const val SIZE = 4
        private const val MULTIPLICATION_COEFFICIENT = 256.0
        private const val POWER_INDEX = 3
        private  val BOTTOM_RANGE: UInt = 0u
        private  val TOP_RANGE: UInt = 255u
        private val IPV4_OCTET_RANGE: UIntRange = BOTTOM_RANGE..TOP_RANGE
    }

    private val octetsValues = UByteArray(SIZE)

    val asUIntValue: UInt
        get() = ipv4ToUInt()


    private fun ipv4ToUInt(): UInt {
        var ipv4UInt = 0u

        for ((index, valueFromOctet) in octetsValues.withIndex()) {
            val power = (POWER_INDEX - index).toDouble()
            val octetAsUInt = valueFromOctet * MULTIPLICATION_COEFFICIENT.pow(power).toUInt()
            ipv4UInt +=  octetAsUInt
        }

        return ipv4UInt
    }


    fun ipv4AsArrayOfUBytes(): UByteArray {
        val ipv4AsStringList: List<String> = ipv4.split(".")

        for ((index, value) in ipv4AsStringList.withIndex())
            if (value.toUInt() in IPV4_OCTET_RANGE)
                octetsValues[index] = value.toUByte()
            else
                throw IllegalArgumentException("value = $value must be between 0..255")

        return octetsValues
    }
}

