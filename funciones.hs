--Verifica si una palabra es anagrama de otra
anagrama :: [Char] -> [Char] -> Bool
anagrama xs ys = findTrue ([x==y | x<- [xs], y<- permutacion ys])

--Busca un elementon "True" en una lista
findTrue :: [Bool]->Bool
findTrue [] = False
findTrue (x:xs) | x==True = True
				|otherwise = findTrue xs   

--realiza una lista de todas las permutaciones de del string
permutacion :: Ord a => [a] -> [[a]]
permutacion [] = [[]]
permutacion (x:xs) = concat [intercala x ys | ys <- permutacion xs]

--
intercala :: Ord a => a -> [a] -> [[a]]
intercala x [] = [[x]]
intercala x (y:ys) = (x:y:ys) : [y:zs | zs <- intercala x ys]

--SlowSort
slowSort::Ord a => [a] -> [a]
slowSort [] = []
slowSort (x:xs) = head([x|x<-permutacion (x:xs),isSorted x])

-- Verifica si una lista esta ordenada de forma creciente
isSorted::Ord a => [a]->Bool
isSorted [] = True
isSorted [x]=True
isSorted (x:y:ys) = (x<=y) && isSorted (y:ys)

--Sublistas
sublists::[a] -> [[a]]
sublists [] = [[]]
sublists (x:xs) = listAux (x:xs) ++ sublists(xs)

--Calculo auxiliar
listAux::[a] -> [[a]]
listAux [x] = [[x]]
listAux (x:xs) = [(x:xs)]++listAux(init(x:xs))