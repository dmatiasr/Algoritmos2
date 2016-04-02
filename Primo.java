
import java.util.LinkedList;

/*Ej.   11.
Implemente  un  algoritmo  que,  dado  un  numero  entero n,  retorne  todos  los  numeros  primos
menores  o  iguales  que n. Implemente  este  algoritmo  usando  la  definicion  de  numero  primo,  es  decir,
evaluando uno a uno los elementos de [2::n], y comprobando que todos los valores menores (excepto el uno)
no los dividen.  Realice el analisis de tiempo de ejecucion, en peor caso, de este algoritmo.
*/
public class Primo {
    private int prim;
    
    public Primo( int n) {
        prim=n;
    }
    public Primo () {
        
    }
    


	/* Ingresando un numero, retorna todos los numeros primos entre 1 y n
	   La complejidad es O(n^2), ya que son dos ciclos anidados.

	*/

    /**
     *
     * @param n
     
        public void result (int n){
		System.out.println("ALGORITMO DE PRIMOS :");
                System.out.println("");
                
                this.primo(i);
                System.out.println("CRIBA DE ERATOSTENES :");
                System.out.println("");
                this.cribaEratostenes(i);
                
	}*/
        public LinkedList primo(int n){
       		int nc=1;
                LinkedList primos= new LinkedList();
 		while (nc < n){
 			if (esPrimo(nc)){ 
 				primos.add(nc);
 			}
 			nc++;
 		}
 		return(primos);
        }
	/* esPrimo retorna el valor de verdad si un numero es primo o no.
	   La complejidad del algoritmo en su peor caso es O(n).
	*/
	public boolean esPrimo(int n){
            int i=2;
            boolean primo= true;
            while  (primo && i<n){
		if  (n%i ==0){
                    primo=false;
                }               
		i++;                     
            }
            return primo;
	}
	/*
		CRIBA DE ERATOSTENES
	
		for p ← 2 to n do A[p] ← p
		
		for p ← 2 to raizcuadrada(n) do //see note before pseudocode
			if A[p] = 0
			//p hasn’t been eliminated on previous passes
			j ← p ∗ p
			while j ≤ n do
				A[j ] ← 0 //mark element as eliminated
				j ← j + p
				//copy the remaining elements of A to array L of the primes
				i ← 0
				for p ← 2 to n do
					if A[p]  = 0
					L[i] ← A[p]
					i ← i + 1
					return L
*/
        /*
            Consiste en llenar un arreglo de true, luego llenar con false todos los multiplos de 2,luego de 3, 4, etc
            mientras i*j < numeroEnCuestion.
           (Complejidad O(n log log n))
         o O (n log n)
        
        */
	public LinkedList cribaEratostenes (){
		//declarar un arreglo del tamaño n
		boolean[] criba = new boolean[prim];
		LinkedList primos = new LinkedList();
                for (int i=0; i<criba.length; i++){
                    criba[i]=true;
                }
                for(int i=2; i< prim ; i++ ){
                    for (int j=2; i*j < prim; j++){
                        criba[i*j]= false;
                    }
                }
                //Muestra los primos antes que n.
                for (int i=1 ; i<prim; i++){
                    if (criba[i]== true) {
                        primos.add(i);
                    }
                        
                }
               return primos;
	}
        /*
        
            toString de la clase
        */
        public String toString(LinkedList n){
            String s="";
            for(int i=0; i<n.size();i++){
                s= s +""+ n.get(i);
                i++;
            }
            return s;
        }

}