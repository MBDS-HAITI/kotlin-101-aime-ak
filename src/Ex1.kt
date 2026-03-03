fun ex1CreateImmutableList(): List<Int> {
    return listOf(1, 2, 3, 4, 5)
}

fun main() {
    val list = ex1CreateImmutableList()
    println(list)
}