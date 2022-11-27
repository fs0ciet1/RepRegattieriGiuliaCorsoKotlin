

/*Creare un sistema di login per due tipologie
- Utente: Verrà riportato al menu per eseguire il quiz o uscire
- Admin: Verrà riportato a un menu per: AGGIUNGERE, RIMUOVERE E VISUALIZZARE le domande e uscire
All'utente quando finisce il quiz dovrà uscire il suo risultato e non potrà ripetere il test
Alla fine del test gli utenti torneranno al login*/



import kotlin.collections.ArrayList

fun main(args: Array<String>) {

    var nomeUtente = "utente"
    var passUtente = "password"
    var nomeAdmin = "admin"
    var passAdmin = "admin"
    var u = 0
    var i = 0
    var risultatoQuiz = 0


    var controlloDati = false
    var controlloMenu = true
    var controlloLogin=false


    var ArrayListDomande: ArrayList<String> = ArrayList()
    ArrayListDomande.add("Cosa è un oggetto?")
    ArrayListDomande.add("Cosa è una classe?")
    ArrayListDomande.add("Da cosa è composto un oggetto?")

    var ArrayListRisposte: ArrayList<String> = ArrayList()
    ArrayListRisposte.add("A:Una padella")
    ArrayListRisposte.add("B:Un insieme di classi")
    ArrayListRisposte.add("C:l'istanza di una classe")

    ArrayListRisposte.add("A:Un contenitore astratto")
    ArrayListRisposte.add("B:Un elemento del codice")
    ArrayListRisposte.add("C:un insieme di alunni")

    ArrayListRisposte.add("A:Da un insieme di classi")
    ArrayListRisposte.add("B:Da un insieme di variabili")
    ArrayListRisposte.add("C:Da metodi e attributi")

    var ArrayListRisposteEsatte: ArrayList<String> = ArrayList()
    ArrayListRisposteEsatte.add("C")
    ArrayListRisposteEsatte.add("A")
    ArrayListRisposteEsatte.add("C")


    var risposteUtente: ArrayList<String> = ArrayList()

    //arraydomande
    //array rispose
    //arrayriso esatte


//while controllo login
    while (controlloLogin == false)
    {
        controlloDati = false
        controlloMenu = true //da controllare
        println("Vuoi accedere come:")
        println("1:utente")
        println("2:admin")

        val scelta = readLine()!!.toString()

        if(scelta.equals("1"))
        {
            //utente
            //====================LOGIN===========================//
            while (controlloDati == false) //cicla finchè è sbagliato
            {
                println("Inserisci nome ")
                val utente = readLine()!!.toString()

                println("Inserisci password ")
                val password = readLine()!!.toString()

                if (utente == "" || password == "")
                {
                    println("Dati non validi")
                }
                else if(utente.equals(nomeUtente) && password.equals(passUtente))
                {
                    controlloDati = true //qui finisce controllo login
                    println("Accesso eseguito con successo!")
                }
                else
                {
                    println("Scelta non valida")
                }
            }
            //====================ENTRA NEL MENU===========================//
            while (controlloMenu == true)
            {
                println("Cosa vuoi fare?");
                println("A:Fai il quiz");
                println("B:Esc");
                println("--------------------------------------")

                val scelta = readLine()!!.toString()
                if (scelta == "A")
                {

                    println("Cominciamo!")
                    println("Rispondi alle seguenti domande:")
                    println("--------------------------------------")

                    //====================COMINCIO IL TEST===========================//
                    u=0
                    for (i in 0 until ArrayListDomande.size)  //cicla sulle domande e le fa stamapre insieme alle proprie risposte
                    {
                        println("--------------------------------------")
                        //qui stampa domanda
                        println(ArrayListDomande.get(i))

                        //qui stampa riposte
                        println(ArrayListRisposte.get(u))
                        println(ArrayListRisposte.get(u + 1))
                        println(ArrayListRisposte.get(u + 2))

                        //inserimento risposta utente
                        val risposta = readLine()!!.toString()

                        risposteUtente.add(risposta)

                        u += 3
                    }
                    //qui controlla risposte esatte e stampa risultato del quiz
                    for (i in 0 until ArrayListRisposteEsatte.size) {
                        if (risposteUtente.get(i).equals(ArrayListRisposteEsatte.get(i))) {
                            //alloca in memoria la quantità di risposte esatte
                            risultatoQuiz++
                        }
                    }

                    //stampo risultato quiz
                    println("Il tuo risultato è:" + risultatoQuiz + " su " + ArrayListDomande.size)
                    controlloMenu = false //QUI INTERROMPO IL LOOP

                }
                else if (scelta == "B")
                {

                    controlloMenu = false //QUI INTERROMPO IL LOOP
                    println("Il tuo risultato è:")
                }
                else
                {
                    println("Devi inserire per forza A o B")
                }

            }
        }
        else if (scelta.equals("2"))
        {
            //admin
            //====================LOGIN===========================//
            while (controlloDati == false) //cicla finchè è sbagliato
            {
                println("Inserisci nome ")
                val admin = readLine()!!.toString()

                println("Inserisci password ")
                val password = readLine()!!.toString()

                if (admin == "" || password == "")
                {
                    println("Dati non validi")
                }
                else if(admin.equals(nomeAdmin) && password.equals(passAdmin))
                {
                    controlloDati = true //qui finisce controllo login
                    println("Accesso eseguito con successo!")
                }
                else
                {
                    println("Scelta non valida")
                }
            }
            //====================ENTRA NEL MENU===========================//
            while (controlloMenu == true)
            {
                println("Cosa vuoi fare?")
                println("A:Aggiungi domanda")
                println("B:Rimuovi domanda")
                println("C:Stampa")
                println("D:Esc")
                println("--------------------------------------")

                val scelta = readLine()!!.toString()

                if(scelta.equals("A"))
                {
                    //aggiungi domanda
                    println("Inserisci una nuova domanda")

                    val inserimentoDomande = readLine()!!.toString()
                    ArrayListDomande.add(inserimentoDomande) //qui aggiungo le domande

                    println("Inserisci risposta A")
                    val inserimentoRispostaA = readLine()!!.toString()
                    ArrayListRisposte.add(inserimentoRispostaA) //qui aggiungo all arraylist delle risp la risp A

                    println("Inserisci risposta B")
                    val inserimentoRispostaB = readLine()!!.toString()
                    ArrayListRisposte.add(inserimentoRispostaB) //qui aggiungo all arraylist delle risp la risp B

                    println("Inserisci risposta C")
                    val inserimentoRispostaC = readLine()!!.toString()
                    ArrayListRisposte.add(inserimentoRispostaC) //qui aggiungo all arraylist delle risp la risp C

                    println("Inserisci la risposta esatta solo la lettera")
                    val inserimentoRispostaGiusta = readLine()!!.toString()
                    ArrayListRisposteEsatte.add(inserimentoRispostaGiusta ) //qui aggiungo all arraylist delle risp giuste quella giusta

                }
                else if (scelta.equals("B"))
                {
                    //rimuovi domanda
                    //stampa prima per farle vedere all admin
                    for (i in 0 until ArrayListDomande.size)
                    {
                        println("--------------------------------------")
                        //qui stampa domanda
                        print(i)
                        print(". ")
                        println(ArrayListDomande.get(i))
                    }

                    println("--------------------------------------")
                    println("Quale domanda vuoi eliminare ?")
                    val rimuovi = readLine()!!.toInt()

                    ArrayListDomande.removeAt(rimuovi)  //qui rimuove la domanda nella posizione remove


                    //rimuovo sempre nella stassa posizione perché gli elementi  scalano quindi sarranno sempre nella posizione rimuovix3
                    ArrayListRisposte.removeAt(rimuovi*3)    //qui rimuove la risposta a nella posizione remove
                    ArrayListRisposte.removeAt(rimuovi*3)   //qui rimuove la risposta b nella posizione remove
                    ArrayListRisposte.removeAt(rimuovi*3)   //qui rimuove la risposta c nella posizione remove

                    ArrayListRisposteEsatte.removeAt(rimuovi)         //rimuove anche quella esatta


                }
                else if (scelta.equals("C"))
                {
                    //stampa dell admin
                    u=0 //azzero per poterla riusare per la stampa
                    for (i in 0 until ArrayListDomande.size)
                    {
                        println("--------------------------------------")
                        //qui stampa domanda
                        println(ArrayListDomande.get(i))

                        //qui stampa riposte
                        println(ArrayListRisposte.get(u))
                        println(ArrayListRisposte.get(u + 1))
                        println(ArrayListRisposte.get(u + 2))

                        u += 3
                    }

                }
                else if (scelta.equals("D"))
                {
                    //esc
                    controlloMenu = false //QUI INTERROMPO IL LOOP
                }
                else
                {
                    println("Devi inserire per forza A, B,C o D")
                }


            }

        }
        else
        {
            println("Scelta non valida")
            //invalid answer
        }
    }
}

