package com.ecwid.testtask.ipv4addresses

import com.ecwid.testtask.ipv4address.Ipv4Address
import org.junit.jupiter.api.Test
import java.io.File

class Ipv4AddressTest {

    @Test
    fun `should return correct UInt values`() {
        val file = File("resources/ip_addresses.txt")
        var ipv4Addresses: Ipv4Address
        val int = UInt.MAX_VALUE
        println(int)

    }

}