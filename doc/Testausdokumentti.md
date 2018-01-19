### Testausdokumentti

[Rivikattavuus](https://htmlpreview.github.io/?https://github.com/mkmoisio/Kebab-Delivery-Problem/blob/master/doc/jacoco/html/index.html)

Testausta varten on pari yksinkertaista verkkoa, joiden lyhimmät polut ja TSP:n oikea ratkaisu on tunnettu, jolloin algoritmien palauttamaan arvoa tai tulostetta voidaan verrata näihin tunneuttuihin ratkaisuihin. Lisäksi settiä ja suuruusvertailun metodeja testattu yksinkertaisilla esimerkkitapauksilla raja-arvot huomioiden.

Tämän lisäksi olen kokeillut algoritmia useilla eri syötteillä varsinaisella käytettävällä verkolla. Hyvin yksikertaista monimutkaisemmissa tapauksissa oikeellisuudesta on hankala varmistua, mutta olen vertaillut tulosta silmämääräisesti karttaan, eikä ainakaan ilmeisiä virheitä ole ilmennyt.

#### Ajankäyttö

TSP:n approksimaatio jäi nyt valitettavasti toteuttamatta, joten algoritmien välistä vertailua ei ole mahdollista suorittaa. Ohjelmaa eri syötteillä ajamalla on kuitenkin helppo havainnollistaa, mitä NP-kovuudesta seuraa. Jo n = 15 vaikuttaisi olevan liikaa.

Tässä viiden suorituskerran keskimääräiset suoritusajat:

1 points running time: 55 ms

2 points running time: 14 ms

3 points running time: 8 ms

4 points running time: 9 ms

5 points running time: 9 ms

6 points running time: 7 ms

7 points running time: 33 ms

8 points running time: 24 ms

9 points running time: 59 ms

10 points running time: 55 ms

11 points running time: 174 ms

12 points running time: 603 ms

13 points running time: 3216 ms

14 points running time: 14987 ms

