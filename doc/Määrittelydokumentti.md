### Kebab delivery problem

#### Häh?

Kuinka toimittaa annokset asiakkaille mahdollisimman nopeasti? Kuinka välttää ylimääräistä matkantekoa ja säästää näin kallista polttoainetta? Kebab-kuski toimittaa kertareissulla yhteensä 3-10 eri tilausta eri osoitteisiin. Kuskilla on tabletissaan kartta, josta hän pystyy näkemään ne osoitteet joihin ruokaa pitää toimittaa. Missä järjestyksessä ja mitä reittiä kuskin kannattaa ajaa?

#### Syöte

Ohjelma saa syötteenään 30-100 solmusta koostuvan suuntaamattoman verkon G, joka mallintaa pienehköä kartta-aluetta (esim. Helsingin keskusta), sekä 3-10 merkitsevän solmun joukon S ja lähtösolmun v. Kaikki solmut kuvaavat katujen risteyksiä tai osoitteita risteyksyen välillä, joten kaarten määrä verkossa on verrattain vähäinen. Joukon S solmut kuvaavat niitä paikkoja joissa kuskin on käytävä, v kuvaa ravintolan sijaintia.

#### Ongelma

Ongelmana on löytää verkon G lyhin polku annetusta lähtösolmusta v lähtösolmuun siten, että polku kulkee annettuun solmujoukkoon S kuuluvien solmujen kautta. Toinen vaikeampi variaatio samasta ongelmasta on, että pitää löytää lyhin polku kahden annetun solmun välillä niin, että polku kulkee vähintään k:n annettuun solmujoukkoon kuuluvan solmun kautta. Tiedetään, että |S| verrattain on pieni.

Aluksi on tarkoitus totetuttaa hyvin naiivi ratkaisu ensimmäisestä variaatiosta siten, että annetun verkon G ja merkitsevän solmujoukon S perusteella konstruoidaan sellainen uusi verkko G', joka koostuu vain merkitsevistä solmuista siten, että koko verkko on klikki. Uuden verkon konstruoinnin jälkeen jäljellä on TSP.

Naiivin ratkaisun jälkeen on tarkoitus etsiä mielekkäämpiä ratkaisuvaihtoehtoja tai vaihtoehtoisesti yrittää hakea mielekästä ratkaisua ongelman toiseen variaatioon.

#### Toteutussuunnitelma ja aikavaativuus

Verkon G' konstruoinnissa on tarkoitus käyttää Floyd-Warshallin algoritmia ja TSP:n ratkaisussa jotain tyypillistä, vielä valitsematonta, branch-and-bound -tyyppistä algoritmia. Lisäksi lienee parasta tallentaa verkko G' vierusmatriisina, sillä verkossa G' on kaari kaikkien solmujen välillä.

Ensimmäisen ratkaisuversion aikavaativuus O(|S|!), koska TSP:n ratkaisu on kokonaisongelman vaikein askel.
