//questa funzione mi permette di capire se un utente ha selezionato un numero
fun controllonum(scelta: String?): Boolean {
    //controllo che la stringa passata sia non nulla
    if (scelta == null)
    {
        return false
    }
    //controllo che la stringa passata sia effettivamente un numero
    for (i in scelta)
    {
        if (i < '0'||i > '9')
        {
            return false
        }
    }
    return true
}


fun main(args: Array<String>)
{
    //dichiaro ed inizialiazzo una var utente con dei valori per provare il login
    var utente1 = Utente("pippo", "pippo7@gmail.com", "1234", "Bobby")
    var  utenteTemp = Utente("", "", "", "")
    var scelta :String=""
    var controlloLogin:Boolean=false
    //arayylist per la lista utenti
    var listaUtenti: ArrayList<Utente> = ArrayList()

    //aggiungo l utente alla lista
    listaUtenti.add(utente1)

    //inizializzo variabili per la ToDoList
    //inizializzazione e valorizazione delle varibili
    var ciclomenu = false //variabile che permette di fermare il ciclo del menu
    var cicloAgg = false //variabile che permette di fermare il ciclo dell'aggiungi
    var task:ArrayList<String> = ArrayList() //arraylist delle task
    var cicloMod=false //variabile che permette di fermare il ciclo della modifica
    var cicloEl=false //variabile che permette di fermare il ciclo dell'elimina
    var cicloEsci=false //variabile che permette di fermare il ciclo dell'esci
    var cicloTaskCompl=false //variabile che permette di fermare il ciclo delle task completate

    //inizailizzo variabili per il back
    var back=Backup()


    while (controlloLogin==false)
    {
        println("A: Registrati \n" +  "B: Accedi\n" + "C: Recupera password\n" + "D:Esci")
        var inserimento= readLine().toString()

        when(inserimento)
        {
            "A", "a" ->
            {
                //nel caso in cui scelga di registrarsi
                utenteTemp.Registrazione(listaUtenti)
            }
            "B", "b" ->
            {
                //nel caso in cui scelga di accedere
                if(utenteTemp.Login(listaUtenti)==true)
                {
                    //qui accede correttamente e prosegue con il codice della nostra ToDoList
                    while(ciclomenu==false)
                    {

                        println("BENVENUTO! \nCOSA VUOI FARE? \nA: CREARE TASK \nB: MODIFICARE TASK \nC: STAMPARE TASK \nD: ELIMINARE TASK \nE: COMPLETA TASK \nF: ESCI")

                        var scelta:String="" //variabile che permette di salvare la scelta dell'utente
                        scelta= readLine().toString()

                        if(scelta.equals("A")||scelta.equals("a")) // creare una task
                        {
                            //nel caso in cui sceglie CREA
                            println("Cosa vuoi aggiungere?")
                            var inserimento:String=""
                            inserimento= readLine().toString()

                            task.add(inserimento) //aggiunge una task

                            while (cicloAgg==false)
                            {
                                println("vuoi inserire altro? [S/N]")
                                scelta = readLine().toString()
                                //se l'utente vuole inserire una nuova task
                                if (scelta.equals("S")||scelta.equals("s"))
                                {
                                    println("Inserisci di nuovo")
                                    inserimento= readLine().toString()
                                    task.add(inserimento) //aggiungo una nuova task
                                }
                                else if(scelta.equals("N")||scelta.equals("n")) { //altrimenti vuole fruire di un altro comando
                                    cicloAgg=true
                                }
                                else
                                {
                                    //il carattere digitato non è previsto
                                    println("Comando non valido!")
                                }
                            }
                            cicloAgg=false
                        }//chiusura if scelta CREA
                        else if(scelta.equals("B")||scelta.equals("b")) //modificare una task
                        {
                            //il seguente permette di controllare se non ci sono task
                            if (task.isNullOrEmpty()) {
                                println("Non ci sono Task!")
                            }//chiusura if
                            else {
                                println("Le tue task sono:")
                                for(i in 0 until  task.size)
                                {
                                    println(i.toString() + " " + task.get(i))
                                }
                                while(cicloMod==false)
                                {
                                    println("Cosa vuoi modificare?")
                                    var sceltaModifica:String=""
                                    sceltaModifica= readLine().toString()

                                    var num:Int=0 //variabile di appoggio

                                    //richiamo la funzione che mi permette di capire se è stato inserito un numero
                                    if (controllonum(sceltaModifica))
                                    {
                                        num=sceltaModifica.toString().toInt()

                                        println("Con cosa vuoi modifcare la tua task?")
                                        var modificaEffettuata: String=""
                                        modificaEffettuata= readLine().toString()
                                        task.set(num, modificaEffettuata)

                                        //aggiornamento task
                                        println("Ora le tue task sono:")
                                        for (i in 0 until task.size)
                                        {
                                            //stampa delle task
                                            println(i.toString() + " " + task.get(i))
                                        }//chiusura for
                                        cicloMod=true
                                    }//chiusura if
                                    else
                                    {
                                        println("Non hai selezionato un numero!")
                                    }
                                }
                            }
                            cicloMod=false
                        }//chiusura if scelta MODIFICA
                        else if(scelta.equals("C")||scelta.equals("c")) //stampare una task
                        {
                            //stampa la lista delle task
                            println("La Lista delle tue task è: ")
                            for (i in 0 until task.size)
                            {
                                //stampa la lista
                                println(i.toString() + " " + task.get(i))
                            }
                        }//chiusura if scelta STAMPA
                        else if(scelta.equals("D")||scelta.equals("d")) //eliminare una task
                        {
                            if (task.isNullOrEmpty()) {
                                println("Non puoi eliminare da una Task vuota!")
                            }
                            else {
                                println("Quale task vuoi eliminare?")
                                for (i in 0 until task.size)
                                {
                                    //stampa le task
                                    println(i.toString() + " " + task.get(i))
                                }

                                while(cicloEl==false)
                                {
                                    //effettiva eliminazione
                                    println("Cosa vuoi eliminare?")
                                    var sceltaElimina:String=""
                                    sceltaElimina = readLine().toString()
                                    var num:Int=0
                                    if (controllonum(sceltaElimina))
                                    {
                                        num=sceltaElimina.toString().toInt()
                                        task.removeAt(num)
                                        //aggiornamento task
                                        println("Ora le tue task sono:")
                                        for (i in 0 until task.size) {
                                            //stampa la lista
                                            println(i.toString() + " " + task.get(i))
                                        }
                                        cicloEl=true
                                    }//chiusura if
                                    else
                                    {
                                        println("Non hai selezionato un numero!")
                                    }
                                }//chiusura while controllo

                            }
                            cicloEl=false
                        }//chiusura if scelta ELIMINA
                        else if(scelta.equals("E")||scelta.equals("e")) //completa una task
                        {
                            if (task.isNullOrEmpty())
                            {
                                println("Non ci sono Task!")
                            }
                            else
                            {
                                println("Le tue task sono:")
                                for (i in 0 until task.size) {
                                    println(i.toString() + " " + task.get(i))
                                }
                                while(cicloTaskCompl==false)
                                {
                                    println("Quale task hai completato?")
                                    var sceltaCompletata: String = ""
                                    sceltaCompletata = readLine().toString()

                                    var num: Int = 0 //variabile di appoggio

                                    //richiamo la funzione che mi permette di capire se è stato inserito un numero
                                    if (controllonum(sceltaCompletata))
                                    {
                                        num = sceltaCompletata.toString().toInt()
                                        println("Ora le tue task non completate sono:")
                                        for (i in 0 until task.size)
                                        {
                                            if(i==num)
                                            {
                                                task.set(num,task.get(i)+  " ✔ " )
                                                println(i.toString() + " " + task.get(i) )
                                            }
                                            else
                                            {
                                                println(i.toString() + " " + task.get(i))
                                            }
                                        }//chiusura for
                                        cicloTaskCompl=true
                                    }//chiusura if
                                    else
                                    {
                                        println("Non hai selezionato un numero!")
                                    }
                                }//chiusura while controllo taskcompl
                            }
                            cicloTaskCompl=false
                        }//chiusura if scelta COMPLETA
                        else if(scelta.equals("F")||scelta.equals("f")) //esci
                        {
                            //parte di uscita con conferma
                            while(cicloEsci==false)
                            {
                                println("Sei sicuro di voler uscire [S/N]")
                                var choice:String=""
                                choice= readLine().toString()
                                if(choice.equals("S")||choice.equals("s"))
                                {
                                    println("ARRIVEDERCI")
                                    ciclomenu=true
                                    cicloEsci=true
                                }
                                else if(choice.equals("N")||choice.equals("n")) {
                                    cicloEsci=true
                                    ciclomenu=false
                                }
                                else
                                {
                                    println("Scelta non valida")
                                    cicloEsci=false
                                }
                            }//chiusura while controllo esci
                            cicloEsci=false
                        }//chiusura if scelta ESCI
                        else
                        {
                            println("Comando non valido!")
                        }

                    }

                }
                else
                {
                    println("Login non effettuato")
                }
            }
            "C","c"->
            {
                //nel caso in cui vuole recuperare la password
                back.cambia_pass(listaUtenti)
            }
            "D", "d"->
            {
                //caso in cui scelga esce
                controlloLogin = true //interrompe il loop del menu di scelta
            }
            else ->
            {
                //nel caso in cui faccia una scelta sbagliata
                println("Scelta non valida")
            }
        }
    }
}

//====================CLASSE UTENTE===========================//
class Utente(var nome:String, var email:String, var password:String, var risposta:String)
{
    fun Registrazione(listaUtenti: ArrayList<Utente>)
    {
        //dichiaro e inizializzo var per il mio ciclo
        var controlloDatiUtente : Boolean = false

        var  controlloNome :Boolean= false
        var controlloEmail :Boolean =false
        var controlloPsw:Boolean=false
        var controlloRisp:Boolean=false


        var nomeUtente:String= ""
        var emailUtente:String= ""
        var pswUtente:String= ""
        var rispostaSicurezza:String=""


        //====================CONTROLLO NOME===========================//
        while (controlloNome==false)
        {
            println("Inserisci il nome")
            nomeUtente = readLine().toString()

            if(nomeUtente == "")
            {
                println("Dati non validi, reinserisci")
            }
            else
            {
                for(i in 0 until listaUtenti.size)
                {
                    if(!nomeUtente.equals(listaUtenti.get(i).nome))
                    {
                        println("Nome disponibile")
                        controlloNome=true
                    }
                }
                if(controlloNome==false)
                {
                    println("Nome già esistente, scegliene un altro")
                }
            }
        }

        //====================CONTROLLO EMAIL===========================//
        while (controlloEmail==false)
        {
            println("Inserisci la tua email")
            emailUtente = readLine().toString()

            if(emailUtente == "")
            {
                println("Dati non validi, reinserisci")
            }
            else
            {
                for (i in 0 until listaUtenti.size)
                {
                    if(!emailUtente.equals(listaUtenti.get(i).email))
                    {
                        println("Email disponibile")
                        controlloEmail=true
                    }
                }
                if(controlloEmail==false)
                {
                    println("Email già esistente, scegliene un'altra")
                }
            }

        }
        //====================CONTROLLO PSW===========================//
        while (controlloPsw==false)
        {
            println("Inserisci password")
            pswUtente = readLine().toString()

            if(pswUtente=="")
            {
                println("Dati non validi, reinserisci")
            }
            else
            {
                controlloPsw=true
            }
        }
        //====================CONTROLLO RISPOSTA DI SICUREZZA===========================//
        println("Inserisci una risposta per la domanda di sicurezza")
        rispostaSicurezza= readln().toString()

        while (controlloRisp==false)
        {
            if(rispostaSicurezza=="")
            {
                println("Dati non validi, reinserisci")
            }
            else
            {
                controlloRisp=true
            }
        }

        //memorizzo i dati nell arraylist
        var utenteRegistrato = Utente (nomeUtente, emailUtente ,pswUtente, rispostaSicurezza)
        listaUtenti.add(utenteRegistrato)
    }

    fun Login(listaUtenti: ArrayList<Utente>):Boolean
    {
        var nomeUtente:String= ""
        var emailUtente:String= ""
        var pswUtente:String= ""
        var index:Int=0
        var trovato: Boolean = false

        while(index<3)
        {
            println("Inserisci il nome")
            nomeUtente = readLine().toString()
            println("Inserisci la tua email")
            emailUtente = readLine().toString()
            println("Inserisci password")
            pswUtente = readLine().toString()

            if(nomeUtente == "" || emailUtente=="" || pswUtente=="")
            {
                println("Dati non validi, reinserisci")
            }
            else
            {
                for(i in 0 until listaUtenti.size)
                {
                    if(nomeUtente.equals(listaUtenti.get(i).nome) && emailUtente.equals(listaUtenti.get(i).email) && pswUtente.equals(listaUtenti.get(i).password))
                    {
                        println("Login effettuato con successo")
                        return true
                    }
                }

                if(trovato==false)
                {
                    println("Dati errati")
                }
            }
            index++
        }
        return false //returna falso perché non ha trovato valori idonei per loggare
    }
}
//====================CLASSE BACKUP===========================//
class Backup()
{
    private var backup:String="" //password che mi passa Giulia

    //var nome:String="Bobby" //nome che deve inserire l'utente quando risponde alla domanda nel Login (RISPOSTA ALLA DOMANDA DI SICUREZZA)
    var esci:Boolean=true

    fun cambia_pass(listaUtenti: ArrayList<Utente>)
    {
        var i:Int=0
        var j:Int=3
        var nomesicurezza:String=""

        listaUtenti.get(i).risposta
        while(esci==true)
        {
            if(i==3)
            {
                println("IMPOSSIBILE CAMBIARE PASSWORD!!!")
                esci=false
            }
            else
            {
                println("Di quale utente vorresti modificare la password?")
               var modifica= readLine().toString()
                for(z in 0 until listaUtenti.size)
                {
                    if(modifica.equals(listaUtenti.get(z).nome))
                    {
                        println("Per recuperare la password devi rispondere alla seguente domanda: ")
                        println("Qual è il nome del tuo cane? ")
                        nomesicurezza= readLine().toString()

                        if(nomesicurezza==listaUtenti.get(z).risposta)
                        {
                            println("Puoi cambiare password!")
                            println("Qual è la nuova password?")
                            backup= readLine().toString()

                            println("Nuova Password salvata!")
                            var utenteTemp = Utente(listaUtenti.get(z).nome, listaUtenti.get(z).email, backup, listaUtenti.get(z).risposta )

                            listaUtenti.set(z,utenteTemp )

                            esci=false
                        }
                        else
                        {
                            j--
                            println("Hai sbagliato! Hai ancora ${j} tentativi")
                        }
                    }
                }
            }
            i++
        }
    }
}