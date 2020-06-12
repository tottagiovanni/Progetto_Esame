# Progetto_Esame
## Scopo
L'applicazione si occupa dell'analisi dei dati e metadati provenienti da una ricerca su Twitter. 
Su una lista di 50 tweets, ricercati in base ad una keyword o da file locale, si ha la possibilità di:
- visualizzare la lista completa;
- visualizzare dettagli di un tweet specifico;
- filtrare la lista su uno o più campi;
- visualizzare le statistiche su un campo;
- visualizzare le statistiche filtrate su un campo;
- visualizzare i metadati.

Il Data-set è un JSON contenente le informazioni principali per ogni tweet, ad esempio:
![JSON](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/json.PNG)

## Casi d'uso
![casouso1](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/usecase1-1.png)
![casouso2](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/usecase2-1.png)

## Tipologia richieste
|METODI|ROTTA   |DESCRIZIONE| 
| :--- |--------|-----------|
|GET   |`/tweets` |restituisce tutti i record|
|GET/POST   |`/tweets?filter={"campo":{"operatore":valore}}` | restituisce i record filtrati|
|GET/POST   |`/tweets?filter={"$and": [{"campo1": valore1},{"campo2": valore2}]}`|restituisce la concatenazione di record filtrati per AND|
|GET/POST   |`/tweets?filter={"$or": [{"campo1": valore1},{"campo2": valore2}]}`|restituisce la concatenazione di record filtrati per OR|
|GET   |`/stats?field=campo`|restituisce le statistiche di tutti i post per quel campo|
|GET/POST   |`/stats?field=campo&filter={"campo":{"operatore":valore}}`|restituisce le statistiche dei post filtrati per un certo campo (vale anche per AND e OR)|
|GET   |`/metadata`|restituisce i metadati|

*per le richieste in post, il parametro filter è richiesto nel body.*

I filtri disponibili ("operatore") sono:
- `"$eq"` --> _valore campo_ uguale a _valore_;
- `"$!eq"` --> _valore campo_ diverso da _valore_;
- `"$in"` --> _valore_ presente in _valore campo_;
- `"$!in"` --> _valore_ non presente in _valore campo_;
- `"$gte"` --> _valore campo_ maggiore (o uguale) di _valore_;
- `"$gt"` --> _valore campo_ maggiore di _valore_;
- `"$lt"` --> _valore campo_ minore di _valore_;
- `"$lte"` --> _valore campo_ minore (o uguale) di _valore_;
- `"$and"` --> concatenazione di più filtri ("$in" per le stringhe, "$eq" per i numeri) ;
- `"$or"` --> concatenazione di più filtri ("$in" per le stringhe, "$eq" per i numeri).

## Diagramma dei package
![package](https://github.com/tottagiovanni/Progetto_Esame/blob/master/Progetto_Esame/images/package_diagramm.jpeg)










 

