/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function ()
{
   $("#ricerca").keyup(function()
    {  
        // Preleva il valore
        var text = $("#ricerca").val();
       
        $.ajax(
        {
            url: "filter.json",
            data:{
              cmd: "search",
              text: text
            },
            dataType: 'json',
            success : function(data, state){
                aggiornaListaProdotti(data);
            },
            error : function(data, state){
            }
        });
        
        // Funzione che viene richiamata in caso di successo
        function aggiornaListaProdotti(listaProdotti)
        {
            $("#risultato").empty();
            if(listaProdotti.length == 0){
                
                var par = document.createElement("p");
                var messaggioNulla = document.createTextNode("Nessun risultato");
                par.appendChild(messaggioNulla);
                $("#risultato").append(par);
                $("#tabellaProdotti").empty();
            } else {
                
                var par = document.createElement("p");
                var messaggioNulla = document.createTextNode("Hai trovato " + listaProdotti.length + " prodotti");
                par.appendChild(messaggioNulla);
                $("#risultato").append(par);
                // Svuoto la tabella
                $("#tabellaProdotti").empty();

                // Per ogni alunno trovato dal database
                var newtrh = document.createElement("tr");
                // Creo l'intestazione della tabella 
                var newth1 = document.createElement("th");
                newth1.setAttribute("class", "prodotto");
                var testo1 = document.createTextNode("Prodotto");
                newth1.appendChild(testo1);

                var newth2 = document.createElement("th");
                var testo2 = document.createTextNode("Foto");
                newth2.appendChild(testo2);

                var newth3 = document.createElement("th");
                newth3.setAttribute("class", "tot");
                var testo3 = document.createTextNode("Tot");
                newth3.appendChild(testo3);

                var newth4 = document.createElement("th");
                var testo4 = document.createTextNode("Prezzo");
                newth4.appendChild(testo4);

                var newth5 = document.createElement("th");
                var testo5 = document.createTextNode("Carrello");
                newth5.appendChild(testo5);

                newtrh.appendChild(newth1);
                newtrh.appendChild(newth2);
                newtrh.appendChild(newth3);
                newtrh.appendChild(newth4);
                newtrh.appendChild(newth5);

                $("#tabellaProdotti").append(newtrh);
                // Creo ogni riga della tabella per ogni prodotto trovato 
                for(var prodotto in listaProdotti)
                {
                    // Crea un nuovo tag tr
                    var newtr = document.createElement("tr");

                    // Colonna nome prodotto
                    var newtd1 = document.createElement("td");
                    newtd1.setAttribute("class", "prodotto");
                    var text1 = document.createTextNode(listaProdotti[prodotto].nomeProdotto + " ");
                    newtd1.appendChild(text1);

                    //Colonana immagine
                    var newtd2 = document.createElement("td");
                    var img = document.createElement("img");
                    img.setAttribute("title", listaProdotti[prodotto].nomeProdotto);
                    img.setAttribute("alt", listaProdotti[prodotto].descrizione);
                    img.setAttribute("src", listaProdotti[prodotto].linkFoto);
                    img.setAttribute("width", "100");
                    img.setAttribute("height", "100");
                    newtd2.appendChild(img);

                    //Colonna totale
                    var newtd3 = document.createElement("td");
                    newtd3.setAttribute("class", "tot");
                    var text3 = document.createTextNode(listaProdotti[prodotto].quantita + " ");
                    newtd3.appendChild(text3);

                    //Colonna prezzo
                    var newtd4 = document.createElement("td");
                    newtd4.setAttribute("class", "prezzo");
                    var text4 = document.createTextNode(listaProdotti[prodotto].prezzo + "€ ");
                    newtd4.appendChild(text4);

                    //Colonna link
                    var newtd5 = document.createElement("td");
                    var link = document.createElement("a");
                    link.setAttribute("href", "CompraProdotto?idProdotto=" + listaProdotti[prodotto].id);
                    var img2 = document.createElement("img");
                    img2.setAttribute("src", "Immagini/carrello.png");
                    link.appendChild(img2);
                    newtd5.appendChild(link);

                    // Aggiunge il tag td al tag tr
                    newtr.appendChild(newtd1);
                    newtr.appendChild(newtd2);
                    newtr.appendChild(newtd3);
                    newtr.appendChild(newtd4);
                    newtr.appendChild(newtd5);

                    // Aggiungo la nuova riga creata
                    $("#tabellaProdotti").append(newtr);
                }
            }
        }
    }); 
});

