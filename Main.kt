import java.awt.Menu

/*TRE FASI (Login, Creazione Utente o Admin, Gestione azioni Bacheca
*
* Login: creare e poter accedere ad un profilo utente o admin
*
* Utente: pubblicare annunci su bacheca, commentare e comprare e fare logout
*
* Admin: eliminare e modficare annunci sulla bacheca e poter vedere la lista degli utenti totali, con logout torna al login
*
*Il sistema dove aver eseguito un clock (una funzione più end) dovrà riportare alla schermata login
*
* DIFFICILE: admin deve poter bannare utente
*
*Classi da poter usare: tente, admin (forse anche bacheca)
*/



fun main(args: Array<String>)
{
    //dichiarazione variabili
    var utente1 = Utente ("pippo","123") //creo utente iniziale da eliminare


    var admin = Admin ("admin","admin123") //creo admin

    val utenteTemp = Utente ("","")

    var scelta :String =""
    var sceltaMenu:String=""


    var listaUtenti: ArrayList<Utente> = ArrayList()
    val menu =Bacheca()
    var controlloMenu :Boolean = false

    menu.AggiungiAnnuncio("Erba")
    menu.AggiungiAnnuncio("Crack")
    menu.AggiungiAnnuncio("Cocaina")

    listaUtenti.add(utente1) //aggiungo l'utente iniziale all'array di utenti



    //creo un ciclo infinito per tornare sempre al login o registrazione
    while(true)
    {
        controlloMenu=false
        println("Sei un Admin o un Utente?")
        println("A:admin")
        println("U:utente")
        scelta= readLine().toString()

        if(scelta == "U")
        {
            println("Sei già registrato? [S/N]")
            var sceltaSN :String =""
            sceltaSN= readLine().toString()

            //====================SCELTA UTENTE LOGIN===========================//
            if (sceltaSN == "S")
            {
                //richaimo fun login utente
                utenteTemp.LoginUtente(listaUtenti)

                while(controlloMenu == false)
                {
                    //entra in Bacheca e stampa menu utente
                    sceltaMenu = menu.StampaMenu(scelta)

                    when(sceltaMenu)
                    {
                        "A"->
                        {
                            //caso in cui scelga pubblica
                            utenteTemp.AggiungiAnnuncio(menu)
                        }
                        "B"->
                        {
                            //caso in cui scelga commenta
                            utenteTemp.AggiungiCommento(menu)
                        }
                        "C"->
                        {
                            //caso in cui scelga compra
                            utenteTemp.CompraAnnuncio(menu)

                        }
                        "D"->
                        {
                            //caso in cui scelga esce
                            controlloMenu = true //interrompe il loop del menu di scelta
                        }
                        else ->
                        {
                            //nel caso in cui scelta sbagliata
                            println("Scelta non idonea, inserisci una lettera corretta")
                        }

                    }
                }
            }
            //====================SCELTA UTENTE REGISTRAZIONE===========================//
            else if (sceltaSN == "N")
            {
                //richaimo fun login utente
                utenteTemp.Registrazione(listaUtenti)

                while(controlloMenu == false)
                {
                    //entra in Bacheca e stampa menu utente
                    sceltaMenu = menu.StampaMenu(scelta)

                    when(sceltaMenu)
                    {
                        "A"->
                        {
                            //caso in cui scelga pubblica
                            utenteTemp.AggiungiAnnuncio(menu)
                        }
                        "B"->
                        {
                            //caso in cui scelga commenta
                            utenteTemp.AggiungiCommento(menu)
                        }
                        "C"->
                        {
                            //caso in cui scelga compra
                            utenteTemp.CompraAnnuncio(menu)

                        }
                        "D"->
                        {
                            //caso in cui scelga esce
                            controlloMenu = true //interrompe il loop del menu di scelta
                        }
                        else ->
                        {
                            //nel caso in cui scelta sbagliata
                            println("Scelta non idonea, inserisci una lettera corretta")
                        }
                    }
                }
            }
            else
            {
                println("Devi scegliere S o N")
            }

        }
        //====================SCELTA ADMIN LOGIN===========================//
        else if (scelta == "A")
        {
            //richiam fun login admin
            admin.LoginAdmin(admin)

            while(controlloMenu == false)
            {
                //entra in Bacheca tramite e tramite  l'input dato dall utente returna questa scelta
                sceltaMenu = menu.StampaMenu(scelta)

                when (sceltaMenu)
                {
                    "A" ->
                    {
                        //caso in cui scelga elimina annuncio
                        admin.EliminaAnnuncio(menu)

                    }

                    "B" ->
                    {
                        //caso in cui scelga modifcia annuncio
                        admin.ModificaAnnuncio(menu)
                    }

                    "C" ->
                    {
                        //caso in cui scelga stampa lista utenti
                        admin.ListaUtenti(listaUtenti)

                    }

                    "D" ->
                    {
                        //caso in cui scelga esce
                        controlloMenu = true
                    }

                    else ->
                    {
                        //nel caso in cui scelta sbagliata
                    }
                }
            }
        }
        else
        {
            println("Non ammettiamo Robot")
        }
    }
}

//====================CLASSE UTENTE===========================//
class Utente(var nome:String, var password:String) //ho inserito le variabili come args della classe (l'args è il costruttore della classe)
{
    //i parametri della classe utente sono var nome e var password


    //qui inserisco funzioni utente
    fun LoginUtente (listaUtenti:ArrayList<Utente>) //passo alla funzione l'arrayList di tipo Utente per controllo login
    {
        var controlloDatiUtente : Boolean = false
        //
        while(controlloDatiUtente == false)
        {
            println("Inserisci nome e password")
            val nomeUtente = readLine()
            val pswUtente = readLine()

            if(nomeUtente == "" || pswUtente == "")
            {
                println("Dati non validi")
            }
            else
            {
                //ciclo il mio arraylist per controllare la presenza dell utente
                for (i in 0 until listaUtenti.size)
                {
                   if(nomeUtente.equals(listaUtenti.get(i).nome) && pswUtente.equals(listaUtenti.get(i).password))
                   {
                       controlloDatiUtente = true
                        println("Login effettuato con successo!")

                   }
                }
            }
        }
    }

    fun Registrazione (listaUtenti: ArrayList<Utente>) //:ArrayList<Utente> mi serve per poter riturnare l'arraylist aggiornato
    {
        println("Inserisci il nome")
        val nomeUtenteRegistrazione = readLine()

        println("Inserisci la password")
        var pswUtenteRegistrazione = readLine()

        //inizializzo un oggetto di tipo Utente nel quale inserisco le stringhe aggiunte in input dall utente per poi inserirle nell'arrayList di tipo Utente
        var utenteRegistrato = Utente (nomeUtenteRegistrazione.toString(), pswUtenteRegistrazione.toString()) //creo utente iniziale da eliminare

        //aggiungo l'oggetto al quale ho aggiunto le stringhe di tipo Utente all'arrayList utenti
        listaUtenti.add(utenteRegistrato)
    }

    fun AggiungiAnnuncio(oggettoBacheca:Bacheca)
    {
        var controllo :Boolean = false
        var reinserimento : String =""
        while(controllo == false)
        {
            //variabile d appoggio per l'input
            var annuncioInserito :String?=""

            println("Inserisci il tuo annuncio")

            //faccio inserire in input l'annuncio da aggiungere
            annuncioInserito= readLine()

            //passo la funzione per aggiungere annunci
            oggettoBacheca.AggiungiAnnuncio(annuncioInserito.toString())

            oggettoBacheca.StampaAnnunci()

            println("Vuoi inserire altri annunci? [S/N]")
            reinserimento= readLine().toString()

            if(reinserimento.equals("N"))
            {
                controllo=true
            }

        }

    }
    fun AggiungiCommento(oggettoBacheca: Bacheca)
    {
        //variabile d appoggio per l'input
        var commentoInserito :String?=""
        var index : Int? = 0
        var controllo :Boolean = false
        var reinserimento : String =""

        while(controllo == false)
        {
            println("Quale annuncio vuoi commentare?")

            //stampo lista annunci
            oggettoBacheca.StampaAnnunci()

            //inserimento da input dell indice di quale annuncio vuole commentare
            index= readLine().toString().toInt()



            println("Inserisci il tuo commento")

            //faccio inserire in input il commento da aggiungere
            commentoInserito= readLine()

            //passo la funzione per aggiungere commenti
            oggettoBacheca.AggiungiCommento(commentoInserito.toString(), index)

            println("Vuoi inserire altri commenti? [S/N]")
            reinserimento= readLine().toString()

            if(reinserimento.equals("N"))
            {
                controllo=true
            }

        }
    }
    fun CompraAnnuncio(oggettoBacheca: Bacheca)
    {
        var index : Int? = 0
        var controllo :Boolean = false
        var reinserimento : String =""

        while(controllo == false)
        {
            println("Quale annuncio vuoi comprare?")

            //stampo lista annunci
            oggettoBacheca.StampaAnnunci()

            //inserimento da input dell indice di quale annuncio vuole comprare
            index= readLine().toString().toInt()

            //passo la funzione per comprare un annuncio (quando compri l' annuncio lo elimini anche insieme ai relativi commenti)
            oggettoBacheca.EliminaAnnuncio(index)

            println("Vuoi comprare altri annunci? [S/N]")
            reinserimento= readLine().toString()

            if(reinserimento.equals("N"))
            {
                controllo=true
            }
        }
    }
} //fine classe utente



//====================CLASSE ADMIN===========================//
class Admin (var nome: String, var password: String)
{
    //qui inserisco controlli ed azioni admin
    fun LoginAdmin(admin: Admin)
    {
        var controlloDatiAdmin:Boolean= false

        while(controlloDatiAdmin == false)
        {
                println("Inserisci nome e password")
                val nomeAdmin = readLine()
                val pswAdmin = readLine()

                if(nomeAdmin == "" || pswAdmin == "")
                {
                    println("Dati non validi")
                }
                else if(nomeAdmin.equals(nome) && pswAdmin.equals(password))
                {
                    controlloDatiAdmin = true //qui finisce controllo login
                    println("Accesso eseguito con successo!")

                }
                else
                {
                    println("Dati non idonei")
                }
        }
    }
    fun ListaUtenti(listaUtenti:ArrayList<Utente>)
    {
        //sampa l'arraylist degli utenti registrati
        for (i in 0 until listaUtenti.size)
        {
            println(listaUtenti.get(i).nome + " " + listaUtenti.get(i).password )
        }
    }
    fun EliminaAnnuncio(oggettoBacheca: Bacheca)
    {
        var index : Int? = 0
        var controllo :Boolean = false
        var reinserimento : String =""

        while(controllo == false)
        {
            println("Quale annuncio vuoi eliminare?")

            //stampo lista annunci
            oggettoBacheca.StampaAnnunci()


            //inserimento da input dell indice di quale annuncio vuole eliminare
            index= readLine().toString().toInt()

            //passo la funzione per eliminare un annuncio (quando elimini l' annuncio lo elimini anche insieme ai relativi commenti)
            oggettoBacheca.EliminaAnnuncio(index)

            println("Vuoi eliminare altri annunci? [S/N]")
            reinserimento= readLine().toString()

            if(reinserimento.equals("N"))
            {
                controllo=true
            }
        }
        println("---LISTA AGGIORNATA---")
        oggettoBacheca.StampaAnnunci()
    }
    fun ModificaAnnuncio(oggettoBacheca: Bacheca)
    {
        //inserisco la funzione della bacheca per eliminare
        var index : Int? = 0
        var controllo :Boolean = false
        var reinserimento : String =""
        var modifica : String = ""

        while(controllo == false)
        {
            println("Quale annuncio vuoi modificare?")

            //stampo lista annunci
            oggettoBacheca.StampaAnnunci()

            //inserimento da input dell indice di quale annuncio vuole modificare
            index= readLine().toString().toInt()

            //inserimento dell annuncio modificato
            println("Inserisce la modifica")

            //inserimento in input della modofica
            modifica= readLine().toString()

            //richiamo la funzione di modifica
            oggettoBacheca.ModificaAnnuncio(modifica, index)

            println("Vuoi modificare altri annunci? [S/N]")
            reinserimento= readLine().toString()

            if(reinserimento.equals("N"))
            {
                controllo=true
            }
        }
        println("---LISTA AGGIORNATA---")
        oggettoBacheca.StampaAnnunci()
    }

} //fine classe admin



//====================CLASSE BACHECA===========================//
class Bacheca()
{
    var annunci: ArrayList<String> = ArrayList()
    var commento: ArrayList<String> = ArrayList()

    fun StampaMenu(scelta:String):String
    {
        //variabile di appoggio per return
        var valoreInput:String?=""
        //====================MENU===========================//
        if(scelta.equals("A"))
        {
            println("---MENU ADMIN---")
            println("Cosa vuoi fare?")
            println("A: Elimina annuncio")
            println("B: Modifica annuncio")
            println("C: Stampa lista utenti")
            println("D: Esci")

        }
        else
        {
            println("---MENU UTENTE---")
            println("Cosa vuoi fare?")
            println("A: Pubblica")
            println("B: Commenta")
            println("C: Compra")
            println("D: Esci")


        }

        //inserimento valore input
        valoreInput= readLine().toString()

        //returno il valore della scelta del meno preso in input dall utente
        return valoreInput
    }
    fun AggiungiAnnuncio(nomeAnnuncio:String)
    {
        annunci.add(nomeAnnuncio)
        commento.add("") //inizzializzo commeno vuoto per l'annuncio per avere i commenti nelle posizioni esatte degli annunci
    }
    fun StampaAnnunci() // vediamo se serve
    {
        for (i in 0 until annunci.size)
        {
            //stampa il numero iesimo dell annuncio iesimo e anche l'annuncio in quella stessa posizione
            println(i.toString() + " " + annunci.get(i))
        }

    }
    fun AggiungiCommento(fraseCommento:String, i:Int)
    {
        //inizializzo una variabile d'appoggio dove inserisco il mio commento vuoto nella posizione iesima per non sovrascivere quando inserisco i commenti successivi
        var variabileAppoggio :String= commento.get(i)

        //aggiungo una virgola per separare i commenti
        variabileAppoggio = variabileAppoggio + "," + commento

        //con set modifico la posizione iesima del commento per aggiungerne un altro e spostarsi nella posizione relativa all annucio
        commento.set(i,variabileAppoggio)
    }
    fun EliminaAnnuncio(index:Int)
    {
        annunci.removeAt(index)
        commento.removeAt(index)
    }

    fun ModificaAnnuncio(nuovoAnnuncio:String, i:Int)
    {
        annunci.set(i, nuovoAnnuncio)
    }

}
