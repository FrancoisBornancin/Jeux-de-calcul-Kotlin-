package game

import kotlin.random.Random
import kotlin.system.exitProcess

// Cette classe ne possède pas de constructeur car le joueur ne doit initier aucune variable.
class Game(){
    // Les variables commençent à zéro sauf le niveau
    private var points: Int = 0
    private var vies: Int = 0
    private var bonnes_reponses: Int = 0
    private var niveau: Int = 1

    fun getNiveau(): Int{
        var thisNiveau = this.niveau
        return thisNiveau
    }

    fun getReponses(): Int{
        var thisReponses = this.bonnes_reponses
        return thisReponses
    }

    fun setNiveau(niveau: Int){
        this.niveau = niveau
    }

    //Structure identique pour les niveaux 1, 2 et 3:
        fun niveaux(){

            var nbre1 = this.nombre1(this.niveau)
            var nbre2 = this.nombre2(this.niveau)

            this.printStatus()

            var TrueFalseAnswer = false

            while (TrueFalseAnswer == false) {

                this.printEquation(this.niveau, nbre1, nbre2)

                var playerAnswer = readLine()!!

                // si réponse = OK : Affiche true + Incrémente les variables
               if (playerAnswer.toInt() == this.resultNiveau(this.niveau, nbre1, nbre2)) {

                    this.increaseStatus(this.niveau)
                    TrueFalseAnswer = true

                } else {

                    this.badAnswer()

                }
            }
        }

    //Nombre 1 attendu pour les niveaux 1, 2 et 3:
        fun nombre1(niveau: Int): Int{
            var number1: Int
            if(niveau == 1){
                number1 = Random.nextInt(1, 99)

            } else if (niveau == 2){
                number1 = Random.nextInt(100, 999)

            } else{
                number1 = Random.nextInt(1, 9)
            }
                return number1
        }

    //Nombre 2 attendu pour les niveaux 1, 2 et 3:
        fun nombre2(niveau: Int): Int{
                var number2: Int = Random.nextInt(1, 99)
                return number2
        }

    // Résultats attendus pour niveaux 1, 2 et 3:
        fun resultNiveau(niveau: Int, nombre1: Int, nombre2: Int): Int{
            var result: Int
            if(niveau == 1){

                result = nombre1 + nombre2

            }
            else if (niveau == 2){

                result = nombre1 - nombre2 + nombre2

            } else{

                result = nombre1 * nombre2
            }
            return result
        }

    // Affichage des équations niveaux 1, 2 et 3:
        fun printEquation(niveau: Int, nombre1: Int, nombre2: Int){
            if(niveau == 1){

                println("$nombre1 + $nombre2 = ?")

            }
            else if(niveau == 2){

                println("$nombre1 - $nombre2 - $nombre2 = ?")

            } else {

                println("$nombre1 x $nombre2 = ?")

            }
        }

    // Incrémentation des variables si bonnes réponses niveau 1, 2 et 3
        fun increaseStatus(niveau: Int){
            this.bonnes_reponses++
            this.vies++

            if(niveau == 1){

                this.points++

            } else if(niveau == 2){

                this.points += 2

            } else {

                this.points += 3

            }
        }

    // Etat du joueur
        fun printStatus(){
            println("Niveau : " + this.niveau)
            println("Points : " + this.points)
            println("Bonnes réponses : " + this.bonnes_reponses)
            println("Nombre de vies : " + this.vies)
        }

    // Affiche mauvaise réponse + fin de partie
        fun printGameOver(){
            println("GameOver! Votre score est de " + this.points + " points")
            exitProcess(0)
        }

        fun printBadAnswer(){
            println("Mauvaises réponses")
            println("Nombre de vies : " + this.vies)
        }

        fun badAnswer(){
            this.vies--
            if(this.vies == 0){
                this.printGameOver()
            }
            this.printBadAnswer()
        }
}