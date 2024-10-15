// Classe abstraite
abstract class Vehicule {
    abstract fun demarrer()  // Méthode abstraite sans implémentation
}

// Classe concrète
class Voiture : Vehicule() {
    override fun demarrer() {
        println("La voiture démarre.")
    }
}

fun main() {
    val maVoiture = Voiture()
    maVoiture.demarrer()  // Implémentation de la méthode abstraite
}


// Sortie : La voiture démarre.

