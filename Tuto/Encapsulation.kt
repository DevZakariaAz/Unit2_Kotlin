 // exemple de classe abstraite
 class CompteBancaire(private var solde: Double) {

     fun deposer(montant: Double) {
         if (montant > 0) {
             solde += montant
             println("Dépôt de $montant, nouveau solde : $solde")
         } else {
             println("Montant invalide")
         }
     }

     fun retirer(montant: Double) {
         if (montant > 0 && montant <= solde) {
             solde -= montant
             println("Retrait de $montant, nouveau solde : $solde")
         } else {
             println("Fonds insuffisants")
         }
     }
 }

 fun main() {
     val monCompte = CompteBancaire(100.0)
     monCompte.deposer(50.0)
     monCompte.retirer(30.0)
 }
