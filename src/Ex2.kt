fun ex2CreateMutableList(): MutableList<String> {
    // Créer une liste mutable avec 3 éléments
    val list = mutableListOf("Alice", "Bob", "Charlie")
    
    // Ajouter un élément
    list.add("AIME")
    
    // Retourner la liste finale
    return list
}

fun main() {
    val result = ex2CreateMutableList()
    println("Résultat: $result")
}