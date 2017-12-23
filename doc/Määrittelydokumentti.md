#### Kebab delivery problem

#### Syöte

Ohjelma saa syötteenään suuntaamattomana verkkona mallinnetun kartan (esim. Helsingin keskusta), joka koostuu 30-100 solmusta. Solmut kuvaavat katujen risteyksiä, joten kaarten määrä verkossa on verrattain vähäinen.

#### Ongelma

Ongelmana on löytää verkon G lyhin polku annetusta lähtösolmusta v lähtösolmuun niin, että polku kulkee annettuun solmujoukkoon S kuuluvien solmujen kautta. Toinen vaikeampi variaatio samasta ongelmasta on, että pitää löytää lyhin polku kahden annetun solmun välillä niin, että polku kulkee vähintään k:n annettuun solmujoukkoon kuuluvan solmun kautta. Reaalimaailmassa ensimmäinen variaatio ongelmasta voisi olla esimerkiksi ruokalähetin kuljetusreitti. Voidaan olettaa, että |S| on pieni.

Aluksi on tarkoitus totetuttaa hyvin naiivi ratkaisu ensimmäisestä variaatiosta siten, että annetun verkon G ja halutun solmujoukon S perusteella konstruoidaan sellainen uusi verkko G', joka koostuu vain halutuista haluista solmuista siten, että koko verkko on klikki. Uuden verkon konstruoinnin jälkeen jäljellä on TSP.

Naiivin ratkaisun jälkeen on tarkoitus etsiä mielekkäämpiä ratkaisuvaihtoehtoja tai vaihtoehtoisesti yrittää hakea mielekästä ratkaisua ongelman toiseen variaatioon.

#### Toteutussuunnitelma ja aikavaativuus

Verkon G' konstruoinnissa on tarkoitus käyttää Floyd-Warshallin algoritmia. Lisäksi lienee parasta tallentaa verkko G' vierusmatriisina, sillä verkossa G' on kaari kaikkien solmujen välillä.

Ensimmäisen ratkaisuversion aikavaativuus O(|S|!), koska TSP:n ratkaisu on kokonaisongelman vaikein askel.
