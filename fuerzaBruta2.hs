--Escriba programas Haskell que realicen las siguientes tareas:
--• dada una lista, genere todas las permutaciones de la misma,
--• dado un conjunto representado como una lista, genere todos los subconjuntos del mismo,
--• dada una lista, genere todas las sublistas de la misma.

--Permutacion de una lista de elementos.
perms::Ord a =>[a]->[[a]]
perms [] = [[]]
perms (x:xs) = concat [move  x ys |ys <- perms xs ] 

--mueve un elemento en una lista formando listas de listas.
move :: a->[a]->[[a]]
move x [] = [[x]]
move x (y:ys)= (x:y:ys) : [y:zs | zs <- move x ys]


--subconjuntos de un conjunto
subconjuntos :: [a] -> [[a]]
subconjuntos []     = [[]]
subconjuntos (x:xs) = [x:ys | ys <- subconjuntos xs] ++ subconjuntos xs


--Generar todas las sublistas de una lista
sublista:: [a] -> [[a]]
sublista [] = [[]] 
sublista (x:xs)=  sublista xs ++ tail (inits (x:xs) )


inits::[a]->[[a]]
inits [] = [ [] ]
inits (x:xs) = [] : map (x:) (inits xs)
--sublista (x:xs) =  (x:xs) : init (x:xs) : sublista xs 





-- subconjuntos de un conjuntos otra version
--subset::[a]->[[a]]
--subset [] = [[]]
--subset




--Escriba un programa Haskell que implemente el algoritmo de ordenamiento SlowSort, que ordena
--una lista de elementos (por ejemplo, de enteros) mediante la generaci ́on de la lista de todas las permuta-
--ciones de la lista original, y filtrando aquella que est ́a ordenada.Utilice su cuenta en codeboard para acceder
--al template de este algoritmo donde podr ́
--a encontrar tambi ́en una serie de test para probar su programa.



slowSort::Ord a =>[a]-> [a]
slowSort [] = []
slowSort (x:xs) =  head ([x | x <- perms (x:xs), orden x]) 


orden:: Ord a => [a]->Bool
orden [] = True
orden [x] = True
orden (x:y:xs) = (x<=y)  && (orden (y:xs))
