fun main(args: Array<String>)
{
    var ciclomenu = false
    var cicloAgg = false
    var lista:ArrayList<String> = ArrayList()

    while(ciclomenu==false)
    {
        println("BENVENUTO!")
        println("COSA VUOI FARE")
        println("A: CREARE TASK ")
        println("B: MODFICARE TASK")
        println("C: STAMPARE TASK ")
        println("D: ELIMINARE TASK")

        var scelta:String=""
        scelta= readln().toString()

        if(scelta=="A")
        {
            //nel caso in cui sceglie CREA
            println("Cosa vuoi aggiungere?")
            var inserimento:String=""
            inserimento= readln().toString()
            lista.add(inserimento)

            while (cicloAgg==false)
            {
                println("vuoi inserire altro? [S/N")
                scelta = readln().toString()
                if (scelta == "S")
                {
                    println("Inserisci di nuovo")
                    inserimento= readln().toString()
                    lista.add(inserimento)
                }
                else
                {
                    cicloAgg=true
                }
            }
        }
        else if(scelta=="B")
        {
            println("Le tue task sono:")
            for(i in 0 until  lista.size)
            {
                println(i.toString() + " " + lista.get(i))
            }
            println("Cosa vuoi modificare?")
            var sceltaModifica:Int=0
            sceltaModifica= readln().toString().toInt()

            println("Con cosa vuoi modifcare la tua task?")
            var modificaEffettuata: String=""
            modificaEffettuata= readln().toString()
            //manca la presa della modifica e l'effettica modfica
            lista.set(sceltaModifica, modificaEffettuata)

            //aggiornamento task
            println("Ore le tue task sono:")
            for (i in 0 until lista.size)
            {
                //stampa la lista
                println(i.toString() + " " + lista.get(i))
            }
        }
        else if(scelta=="C")
        {
            //qui stampa
            println(lista)
        }
        else if(scelta=="D")
        {
            println("Quale task vuoi eliminare?")
            for (i in 0 until lista.size)
            {
                //stampa la lista
                println(i.toString() + " " + lista.get(i))
            }
            //effettiva eliminazione
            println("Cosa vuoi eliminare?")
            var sceltaElimina:Int=0
            sceltaElimina= readln().toString().toInt()
            lista.removeAt(sceltaElimina)

            //aggiornamento task
            println("Ore le tue task sono:")
            for (i in 0 until lista.size)
            {
                //stampa la lista
                println(i.toString() + " " + lista.get(i))
            }
        }
        else
        {
            //parte di uscita con conferma
            println("Sei sicuro di voler uscire [S/N]")
            var choice:String=""
            choice= readln().toString()
            if(choice=="S")
            {
                println("ARRIVEDERCI")
                ciclomenu=true
            }
        }
    }






}