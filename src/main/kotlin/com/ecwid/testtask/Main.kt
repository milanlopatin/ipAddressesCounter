import com.ecwid.testtask.ipv4address.Ipv4Address

@ExperimentalUnsignedTypes
fun main() {
    val add1 = Ipv4Address("0.255.255.255")
    val add2 = Ipv4Address("255.255.255.255")
    val add3 = Ipv4Address("0.255.255.255")
    println(add1.hashCode())
    println(add2.hashCode())
    println(add3.hashCode())
    println(add1 == add2)
    println(add1 == add3)
    println(add1.getStringValue())
    println(add1.getUIntValue())
    println(add1.toString())


}