package vue
import game.Game

fun printWelcome(){
    println("==========================")
    println("Bienvenu dans ce jeu de calcul mental")
    println("Etes-vous prêt à commencer?")

    printUnOuDeux()
}

fun printTakeTime(){
    println("Prenez votre temps")
    println("Etes-vous prêt maintenant?")

    printUnOuDeux()
}

fun printUnOuDeux(){
    println("==========================")
    println("Tapez 1 pour oui, 2 pour non")

    var startGame = readLine()!!

    try{
        if(startGame.toInt() == 1){

            // Initialisation des variables
            var game = Game()

            if(game.getReponses() < 2){
                // NIVEAU 1
                while (game.getReponses() < 2) {
                    game.niveaux()
                }

                if(game.getReponses() < 4){
                    var thisNiveau = game.getNiveau()
                    thisNiveau += 1
                    game.setNiveau(thisNiveau)
                    // NIVEAU 2
                    while (game.getReponses() < 4) {
                        game.niveaux()
                    }
                }

                if(game.getReponses() >= 4){
                    var thisNiveau = game.getNiveau()
                    thisNiveau += 1
                    game.setNiveau(thisNiveau)
                    // NIVEAU 3
                    while (game.getReponses() >= 4) {
                        game.niveaux()
                    }
                }
            }
        } else if (startGame.toInt() == 2){
            printTakeTime()
        } else {
            printUnOuDeux()
        }
    } catch (e: NumberFormatException){
        print("Les valeurs null ou string ne sont pas acceptées")
    }
}