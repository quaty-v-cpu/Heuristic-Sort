# Heuristic-Sort

Heuristisches Sortierverfahren

A fast sorting algorithm that is 30 to 60 times faster than InsertSort for large lists


Ich bin auf die Idee gekommen, eine lineare Funktion (y = k * x + b) fürs Sortieren von dynamischen Arrays zu nutzen. Wobei y ist der gesuchter ungefähre Index vom Element x.

Damit das Ganze funktioniert, muss man zuerst k und b herausfinden. Da wir zwei Elemente und deren Indexe immer wissen, ist es nicht schwer. Es ist immer bekannt der mindeste Index (normalerweise 0) und der höchste Index (die Länge vom Array – 1). Für diese zwei Indexes muss man den kleinsten Wert im Array ermitteln und den höchsten Wert im Array finden.

Das System, dass wir lösen müssen, sieht dann folgenderweise aus : 
wenn der minimale Wert im Array = Min
wenn der maximaler Wert im Array = Max
wenn der minimaler Index = MinIndex 
und maximaler Index = MaxIndex
dann 

MinIndex = k * Min + b
MaxIndex = k * Max + b

Um k und b zu ermitteln, nutzen wir die elementaren mathematischen Kenntnisse und kriegen heraus, dass 

k = ( MaxIndex – MinIndex ) / (Max – Min)

b = MinIndex – k * Min

Und schon können wir einen ungefähren Index für ein bestimmten Wert ermitteln.


Verfahren

1. Zuerst erzeugt man ein leeres Array mit denselben Indexen wie der ursprüngliche Array, den man sortieren will. Normalerweise ist es auch 0..Array.count() - 1. Der neuer Array muss mit einem Wert (Dump) initialisiert werden, der im ursprünglichen Array nicht vorkommen kann, damit man weiß, ob der Platz im neuen Array schon besetzt ist oder nicht.
2. Jetzt versuchen wir, die Elemente aus dem ursprünglichen Array in den neuen Array einzusortieren, indem man einfach der Reihe nach, bei Elementen aus dem ursprünglichen Array den Index nach der Formel (Index = k * Array[i] + b) berechnet und setzt den Element in den neuen Array ein, wenn der Platz noch nicht besetzt ist. Wenn der Platz besetzt ist, dann kopiert man den Element in ein temporales Array. 
3. Jetzt müssen wir die Dump-Elemente aus dem neuen Array löschen. Wir kriegen also, ein sortiertes Array, der Erfahrung nach 50 – 60 % der Elemente aus dem ursprünglichen Array enthält und wir haben noch ein temporales Array mit Elementen, die nicht reingepasst sind, weil der Index mit einem anderem Element gleich war. Das alles nur in O(n) Schritten.
4. Was bleibt, ist die temporale Elemente in den neuen sortierten Array einzusortieren. Dazu kann man einfach linear vorgehen oder man nutzt eine modifizierte binäre Suche, um den Platz im neuen Array zu finden und den Element einzusetzen.
5. Am Ende haben wir also, den unsortierten Ursprung-Array und ein neuen sortierten Array. Damit kann man dann weiterarbeiten.


Erfahrungswerte

Ich habe das Verfahren in Kotlin implementiert, weil es da sehr leicht gemacht wurde, mit dynamischen Array zu arbeiten. Ich habe Zufallsdatenarrays generiert und Folgendes raus gefunden.

1. Das Verfahren ist nicht effizient für kleine Arrays. Es verliert dabei einer Insertsort bei weitem. Also Array mit unter 200 Elementen ist besser mit herkömmlichen Sortierverfahren zu sortierten.
2. Bei großen Arrays mit 200 + Elementen zeigt sich die faszinierende Schnelligkeit. Das Verfahren bei 300 Elementen ist 2-3 Mal schneller als Insertsort und z.B. bei 30000 Elementen 50 – 60 Mal schneller als Insertsort, wenn man die binäre Suche verwendet.  

