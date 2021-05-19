# Page Handling Algorithm Simulation
Facultative homework for Operating Systems' lecture's. 3/3 points.
# Hungarian specification
Készítsen egy programot Java vagy Python nyelven, amely egy lapcsere-rendszer működését szimulálja!

A program bemeneteként memóriaműveletek során hivatkozott lapok azonosítóit kapja a hivatkozásuk sorrendjében. Kimeneteként a végrehajtott lapcserék eredményeképpen lefoglalt fizikai memóriakeretek azonosítóit és a laphibák számát adja vissza.

A rendszerben 3 memóriakeret található, amelyek kezdetben mind üresek. Az induláskor a lapok a cserehelyen találhatók.

A lapokat számok (1-99), a kereteket betűk (A,B és C) jelölik.

Bemenet (standard input, stdin)<br>
Egyetlen sorban a lapokra történő hivatkozások egymástól vesszővel elválasztva. Például:

1,2,3,-1,5,-1
A negatív számok írási műveleteket jeleznek a megadott lapon; ekkor a keretek "dirty" jelzést kapnak (ez nem minden algoritmus esetén releváns információ, de a bemeneten előfordulhat).

A bemenet végét EOF jelzi (előtte soremelés, üres sor lehet). Ekkor kell a kimenetre kiírni az eredményt.

Kimenet (standard output, stdout)<br>
A kimeneten az első sorban a bemeneti memóriahivatkozások kiszolgálásához lefoglalt memóriakeretek betűjelei szerepelnek a megfelelő sorrendben, szóközök nélkül, egybeírva, majd a következő sorban a laphibák száma. A kiírt eredmények előtt, után üres karakterek, további sorok ne legyenek!
Amennyiben egy memóriahivatkozáshoz nem kellett új keretet foglalni (már a memóriában volt a lap), a kimeneten az adott pozícióban "-" jel jelenik meg.
Ha egy memóriafoglalás nem teljesíthető (nincs szabad keret és egyetlen keret sem szabadítható fel), akkor a kimeneten "*" karakter jelenik meg (a műveletet nem ismétli meg az algoritmus). Ez utóbbi eset értelemszerűen nem minden algoritmusnál fordulhat elő.

Megvalósítandó algoritmus<br>
Legrégebben nem használt (LRU) lapcsere maximum 3 lépésig tartó tárba fagyasztással
Az algoritmus használati idő szerint rendezi sorba a kereteket.

A program írja ki az algoritmus szerinti memóriafoglalásokat és a laphibák számát!
Pl. a fenti bemenetre adott válasz:

ABC-AB<br>
5<br>

Tesztadatok<br>
Az első beküldés előtt érdemes az alábbi tesztekkel megpróbálkozni.

1,2,3,5,4,2<br>
ABC*A-<br>
5<br>

1,2,3,2,4,3,2,1<br>
ABC-A--C<br>
5<br>

1,2,3,3,4,5,2,1<br>
ABC-ABC*<br>
7<br>

1,2,3,4,5,4,3,2,1<br>
ABC*AB-CA<br>
8<br>

-5,2,5,3,2,1,-3<br>
AB-C-A-<br>
4<br>
