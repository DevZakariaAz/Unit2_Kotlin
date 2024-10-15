// Classe parent
open class Forme {
    open fun dessiner() {
        println("Dessiner une forme")
    }
}

// Classe enfant
class Cercle : Forme() {
    override fun dessiner() {
        println("Dessiner un cercle")
    }
}

// Classe enfant
class Rectangle : Forme() {
    override fun dessiner() {
        println("Dessiner un rectangle")
    }
}

fun main() {
    val formes: List<Forme> = listOf(Cercle(), Rectangle())

    for (forme in formes) {
        forme.dessiner()  // Appel polymorphique
    }
}
