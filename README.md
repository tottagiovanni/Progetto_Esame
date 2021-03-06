# Progetto_Esame
## SCOPO
L'applicazione si occupa dell'analisi dei dati e metadati, riguardanti le metriche pubbliche, provenienti da una ricerca su Twitter. 
Su una lista di 50 tweets, [ricercati in base ad una keyword o da file locale](#finestra-per-caricare-i-tweet), si ha la possibilità di:
- [visualizzare la lista completa con statistiche generali](#finestra-con-tweet-e-statistiche);
- [visualizzare dettagli di un tweet specifico](#finestra-per-dettagli-su-un-tweet);
- filtrare la lista su uno o più campi;
- visualizzare le statistiche su un campo;
- visualizzare le statistiche filtrate su un campo;
- visualizzare i metadati.

L'applicazione crea un server locale, in ascolto sulla porta 8080, dove si possono inviare [*query-string*](#tipologia-richieste). 

L'API di Twitter utilizzata è la seguente: 
"https://wd4hfxnxxa.execute-api.us-east-2.amazonaws.com/dev/api/1.1/search/tweets.json?q=univpm&count=50&result_type=mixed" (*q*: keyword, *count*: numero tweet, *result type*: tipo di risultati)

Il Data-set è un JSON contenente le informazioni principali per ogni tweet, ad esempio:
![JSON](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/json.PNG)

### Interfaccia utente
#### Finestra per caricare i tweet
![intro](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/IntroWindow.png)
![msg](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/MessageDialog.png)
#### Finestra con tweet e statistiche
![list](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/TweetsWindow.png)
#### Finestra per dettagli su un tweet
![info](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/InfoWindow.png)

N.B.: per filtrare i dati e per le statistiche specifiche è necessario utilizzare un API client, come [Postman](#programmi-utilizzati).

## TIPOLOGIA RICHIESTE
|METODI|ROTTA   |DESCRIZIONE| 
|------|--------|-----------|
|GET   |`/tweets` |restituisce tutti i record|
|GET/POST   |`/tweets?filter={"campo":{"operatore":valore}}` | restituisce i record filtrati|
|GET/POST   |`/tweets?filter={"$and": [{"campo1": valore1},{"campo2": valore2}]}`|restituisce la concatenazione di record filtrati per AND|
|GET/POST   |`/tweets?filter={"$or": [{"campo1": valore1},{"campo2": valore2}]}`|restituisce la concatenazione di record filtrati per OR|
|GET   |`/stats?field=campo`|restituisce le statistiche di tutti i post per quel campo (tipo numerico)|
|GET/POST   |`/stats?field=campo&filter={"campo":{"operatore":valore}}`|restituisce le statistiche dei post filtrati per un certo campo (vale anche per AND e OR)|
|GET   |`/metadata`|restituisce i metadati|

*per le richieste in post, il parametro filter è richiesto nel body.*

I filtri disponibili ("operatore") sono:
- `"$eq"` &rarr; _**valore campo**_ uguale a _**valore**_;
- `"$!eq"` &rarr; _**valore campo**_ diverso da _**valore**_;
- `"$in"` &rarr; _**valore**_ presente in _**valore campo**_;
- `"$!in"` &rarr; _**valore**_ non presente in _**valore campo**_;
- `"$gte"` &rarr; _**valore campo**_ maggiore (o uguale) di _**valore**_;
- `"$gt"` &rarr; _**valore campo**_ maggiore di _**valore**_;
- `"$lt"` &rarr; _**valore campo**_ minore di _**valore**_;
- `"$lte"` &rarr; _**valore campo**_ minore (o uguale) di _**valore**_;
- `"$and"` &rarr; concatenazione di più filtri (`"$in"` per le stringhe, `"$eq"` per i numeri) ;
- `"$or"` &rarr; concatenazione di più filtri (`"$in"` per le stringhe, `"$eq"` per i numeri).

Le statistiche sono:
- **average**: media dei valori del *campo* scelto;
- **min**: minimo tra i valori del *campo* scelto;
- **max**: massimo tra i valori del *campo* scelto;
- **sum**: somma dei valori del *campo* scelto;
- **count**: numero di tweet analizzati;
- **mode**: moda dei valori del *campo* scelto;
- **standardDeviation**: deviazione standard dei valori del *campo* scelto.

#### Esempi
- `GET localhost:8080/tweets?filter={"Like": {"$lte": 20000}}` &rarr; seleziona i tweet con un numero di like minore o uguale a 20000;
- `GET localhost:8080/tweets?filter={"$and": [{"device": "android"}, {"text": "univpm"}]}` &rarr; seleziona i tweet scritti da un dispositivo *android* **e** con *univpm* nel testo;
- `GET localhost:8080/stats?field=like&filter={"$or": [{"text": "univpm"},{"device": "android"}]}` &rarr; esegue le statistiche sul campo *like* dei tweet scritti da un dispositivo *android* **o** con *univpm* nel testo;

## MODELLAZIONE PROGETTO (UML)
### Casi d'uso
![casouso1](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/usecase1-1.png)
![casouso2](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/usecase2-1.png)

### Diagramma dei package
![package](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/package_diagramm.jpeg)

### Diagrammi delle classi 
*Diagramma della classe **JSONService** e le varie relazioni*.
![jsondiagram](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/class_diagram_JSON.jpg)

*Diagramma della classe **FilterService** e le varie relazioni*.
![filterdiagram](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/class_diagram_filter.jpeg)

*Diagramma della classe **StatsService** e le varie relazioni*.
![filterdiagram](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/class_diagram_stats.jpeg)

*Diagramma della classe **MetadataService** e le varie relazioni*.
![filterdiagram](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/class_diagram_metadata.jpg)

### Diagrammi di sequenza
Diagramma di sequenza per il **caricamento** dei dati tramite **keyword**, attraverso una interfaccia utente *user-friendly*.
![cercaTweets](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_search.png)

Diagramma di sequenza per il **caricamento** dei dati tramite **file locale**, attraverso una interfaccia utente *user-friendly*.
![caricaTweets](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_load.png)

Diagramma di sequenza per la **visualizzazione** della lista dei **tweet** e delle **statistiche generali**.
![visualizzaTweets](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_view.png)

Diagramma di sequenza per la **visualizzazione** dei *dettagli* dei singoli **tweet**.
![infoTweets](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_info.png)

Diagramma di sequenza per la gestione della **richiesta** di tutti i **tweet**, con i relativi dati, attraverso una `GET` da *client* (vedi [tabella](#tipologia-richieste) - riga 1).
![tweets](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_TWEETS.png)

Diagramma di sequenza per la gestione della **richiesta** dei **tweet filtrati**, attraverso una `GET/POST` tramite *client* (vedi [tabella](#tipologia-richieste) - righe 2-3-4).
![filter](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_FILTER.png)

Diagramma di sequenza per la gestione della **richiesta** di **statistiche** su un **campo numerico** di tutti i tweet, attraverso una `GET` tramite *client* (vedi [tabella](#tipologia-richieste) - riga 5).
![stats](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_stats.png)

Diagramma di sequenza per la gestione della **richiesta** di **statistiche** su un **campo numerico** dei **tweet filtrati**, attraverso una `GET/POST` tramite *client* (vedi [tabella](#tipologia-richieste) - riga 6).
![statsFilter](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_statsFilter.png)

Diagramma di sequenza per la gestione della **richiesta** di **metadati**, attraverso una `GET` tramite *client* (vedi [tabella](#tipologia-richieste) - riga 7). 
![metadata](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/sequence_metadata.png)

## Programmi utilizzati
- [Eclipse](https://www.eclipse.org), per scrittura codice, documentazione e diagrammi (classi e sequenze);
- [Postman](https://www.postman.com), per testare le richieste al server locale;
- [Spring Boot](https://spring.io/projects/spring-boot), framework che consente lo sviluppo di web app scritte in codice Java;
- [Maven](https://maven.apache.org), strumento per la gestione dei progetti Java;
- [ArgoUML](https://en.wikipedia.org/wiki/ArgoUML), per creazione diagrammi dei casi d'uso.

## Autori
*Saraceno Alberto Zaccaria* (implementazione controller, filtri, statistiche, GUI).

*Totta Giovanni* (implementazione controller, filtri, JUnit test, eccezioni, JavaDoc).




 

