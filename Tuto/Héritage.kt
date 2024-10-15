// Classe parent
open class Animal(val nom: String) {
    fun dormir() {
        println("$nom dort.")
    }
}

// Classe enfant
class Chien(nom: String) : Animal(nom) {
    fun aboyer() {
        println("$nom aboie.")
    }
}

fun main() {
    val monChien = Chien("Rex")
    monChien.dormir()  // Hérité de la classe Animal
    monChien.aboyer()  // Méthode propre à Chien
}
