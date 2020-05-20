import com.ecwid.testtask.ipv4address.Ipv4Address

@ExperimentalUnsignedTypes
fun main() {
    val ipv4 = Ipv4Address("255.255.255.255")
    println(ipv4.ipv4AsArrayOfUBytes())
    for (value in ipv4.ipv4AsArrayOfUBytes()) { println(value.javaClass.kotlin)}
    println(ipv4.asUIntValue)


}