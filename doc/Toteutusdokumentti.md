### Toteutus

Ohjelma käyttää sopivasti koodattua Helsingin keskustan karttaa, joka sisältää 41 baaria, sekä noin 65 kadunkulmaa. Karttapohjana olen käyttänyt Limes ry:n vuoden 2017 approkarttaa (https://appro.limes.fi/restaurants.html).

Ohjelma laskee lyhimmät polut Floyd-Warshallin algoritmilla ja tallentaa polun rekonstruktontia varten polun edelliset solmut omaan taulukkoonsa. Floyd-Warshallin algoritmin toteutus on hyvin pitkälti sovellus Wikipediassa esitettystä pseudokoodista (https://en.wikipedia.org/wiki/Floyd–Warshall_algorithm#Path_reconstruction).

Lyhimpien polkujen laskemisen jälkeen TSP ratkaistaan halutulla joukolla pisteitä. Pisteet ovat tässä tapauksessa kadunkulmia tai baareja. TSP:n hyödynnetään dynaamista ohjelmointia käyttävää Held-Karpin algoritmia jotakuinkin siten kuin LUT-yliopiston materiaaleissa on kuvailtu (http://www.mafy.lut.fi/study/DiscreteOpt/DOSLID5.pdf).

TSP ratkeaa sekunneissa noin 10 solmuun asti, Floyd-Warshall-algoritmin suorittaminen vie millisekunteja 107 X 107 -matriisilla. Held-Karpin algoritmin suoritusajassa saman kokoisella pistejoukolla on huomattavaa vaihtelua, sillä osa pisteistä on täsmälleen samassa kohtaa. Luonnollisesti TSP ratkeaa nopeammin sellaisella pistejoukolla, jossa on enemmän samassa kohti olevia pisteitä.
