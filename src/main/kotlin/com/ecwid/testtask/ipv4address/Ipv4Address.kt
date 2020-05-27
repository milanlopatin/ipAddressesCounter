package com.ecwid.testtask.ipv4address

import kotlin.math.pow

//Ipv4 representation
@ExperimentalUnsignedTypes
data class Ipv4Address(private val ipv4AsString: String) {
    companion object CONSTANTS {
        //Size of octets array
        private const val SIZE = 4
        private val octetsValues = UByteArray(SIZE)

        //Values to convert ipv4 to UInt value
        private const val MULTIPLICATION_COEFFICIENT = 256.0
        private const val INITIAL_POWER_INDEX = 3

        //To check if we have correct ipv4 in constructor
        private val IPV4_REGEX_PATTERN =
            "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\$".toRegex()
    }

    //UInt representation of Ipv4 address
    private val asUIntValue: UInt

    init {
        //Check if ipv4 has a correct value
        if (checkIpv4Regex()) {
            ipv4AsArrayOfUBytes()
            asUIntValue = ipv4ToUInt()
        } else
            throw IllegalArgumentException("Wrong ipv4 address: $ipv4AsString\n Pattern for ipv4 is 0-255.0-255.0-255.0-255 ")

    }

    private fun checkIpv4Regex(): Boolean {
        return IPV4_REGEX_PATTERN.matches(ipv4AsString)
    }

    private fun ipv4AsArrayOfUBytes() {
        val ipv4AsStringList: List<String> = ipv4AsString.split(".")

        for ((index, value) in ipv4AsStringList.withIndex())
            octetsValues[index] = value.toUByte()
    }

    private fun ipv4ToUInt(): UInt {
        var value: UInt = 0u

        for ((index, valueFromOctet) in octetsValues.withIndex()) {
            val power = (INITIAL_POWER_INDEX - index).toDouble()
            val octetAsUInt: UInt = valueFromOctet * MULTIPLICATION_COEFFICIENT.pow(power).toUInt()
            value += octetAsUInt
        }
        return value
    }

    fun getUIntValue(): UInt {
        return asUIntValue
    }

    fun getStringValue(): String {
        return ipv4AsString
    }

    override fun toString(): String {
        return "Ipv4 address - $ipv4AsString, UInt value - $asUIntValue"
    }

}

