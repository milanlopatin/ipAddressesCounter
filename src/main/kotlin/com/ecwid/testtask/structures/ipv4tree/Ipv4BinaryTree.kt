package com.ecwid.testtask.structures.ipv4tree
import com.ecwid.testtask.ipv4address.Ipv4Address

@ExperimentalUnsignedTypes
class Ipv4BinaryTree() {

    private var ipv4NodeCount: UInt = 0u
    private var ipv4Node: Ipv4Node? = null

    private class Ipv4Node(var ipv4: Ipv4Address?, var left: Ipv4Node?, var right: Ipv4Node?)

    fun isEmpty(): Boolean {
        return size() == 0u
    }

    fun size(): UInt {
        return ipv4NodeCount;
    }

    fun isContainsElement(): Boolean {

    }

}