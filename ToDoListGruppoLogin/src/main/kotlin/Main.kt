fun main(args: Array<String>)
{
    //dichiaro ed inizialiazzo una var utente con dei valori per provare il login
    var utente1 = Utente("pippo", "pippo7@gmail.com", "1234")
    var  utenteTemp = Utente("", "", "")
    var scelta :String=""
    var controlloLogin:Boolean=false
    //arayylist per la lista utenti
    var listaUtenti: ArrayList<Utente> = ArrayList()

    //aggiungo l utente alla lista
    listaUtenti.add(utente1)

    while (controlloLogin==false)
    {
        println("A: Registrati \n" +  "B: Accedi\n" + "C: Esci")
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

               }
               else
               {
                   println("Login non effettuato")
               }
           }
           "C","c"->
           {
               //caso in cui scelga esce
               controlloLogin = true //interrompe il loop del menu di scelta
           }
           else ->
           {
               //nel caso in cui faccia una scelta sbagliata
           }
       }
    }
    //utenteTemp.Registrazione(listaUtenti)
    //utenteTemp.Login(listaUtenti)
}

//====================CLASSE UTENTE===========================//
class Utente(var nome:String, var email:String, var password:String)
{
    fun Registrazione(listaUtenti: ArrayList<Utente>)
    {
        //dichiaro e inizializzo var per il mio ciclo
        var controlloDatiUtente : Boolean = false

        var  controlloNome :Boolean= false
        var controlloEmail :Boolean =false
        var controlloPsw:Boolean=false


        var nomeUtente:String= ""
        var emailUtente:String= ""
        var pswUtente:String= ""

        /*while(controlloDatiUtente==false)
        {}*/
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

        //memorizzo i dati nell arraylist
        var utenteRegistrato = Utente (nomeUtente, emailUtente ,pswUtente)
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
                else
                {
                    //creo condizione di arresto per uscire dal while
                    index=3
                }

            }
            index++
        }
        return false
    }

}