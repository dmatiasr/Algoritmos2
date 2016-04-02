/*
	Tres formas de obtener el maximo comun divisor de un numero

*/
import java.util.LinkedList;


public class MaximoComunDivisor{
	
	private Primo p;

	public static void main(String[] args){
		int m= Integer.parseInt(args[0]);
		int n= Integer.parseInt(args[1]);
      
		System.out.println( "Euclide algorithm = "+euclide(m,n) );
		System.out.println( "Consecutive integer = "+gcd(m,n) );
		System.out.println( "Middle-school procedure for computing = "+middleSchool(m,n));
	}
	/*
	//Computes gcd(m, n) by Euclid’s algorithm
	//Input: Two nonnegative, not-both-zero integers m and n
	//Output: Greatest common divisor of m and n
	while n != 0 do
		r ← m mod n
		m ← n
		n ← r
	return m

	*/
	public static int euclide(int m, int n){
		while (n!=0){
			int r= m%n;
			m=n;
			n=r;
		}	
		return m;
	}
	/*
	Consecutive integer checking algorithm for computing gcd(m, n)
Step 1 Assign the value of min{m, n} to t.
Step 2 Divide m by t. If the remainder of this division is 0, go to Step 3;
otherwise, go to Step 4.
Step 3 Divide n by t. If the remainder of this division is 0, return the value of
t as the answer and stop; otherwise, proceed to Step 4.
Step 4 Decrease the value of t by 1. Go to Step 2.
	*/
	/*Retorna el minimo de dos elementos.
	*/
	public static int min (int m, int n){
		int t;
		if (m < n){
			t=m;
		}
		else {
			t=n;
		}
		return t;
	}
	/*
	Consecutive integer checking algorithm for computing gcd(m, n).
	*/
	public static int gcd(int m, int n){
		int t =  min(m,n);
		while (m%t!=0 || n%t !=0) { 
				t--;	
		}	
		return t;	
	}


/*
	Middle-school procedure for computing gcd(m, n)
Step 1 Find the prime factors of m.
Step 2 Find the prime factors of n.
Step 3 Identify all the common factors in the two prime expansions found in
Step 1 and Step 2. (If p is a common factor occurring p m and p n times
in m and n, respectively, it should be repeated min{p m , p n } times.)
Step 4 Compute the product of all the common factors and return it as the
greatest common divisor of the numbers given
*/

/*
    fm := sorted list of prime factors of m
    fn := sorted list of prime factors of n
    c := common-factors(fm, fn)
    return product of c
*/

    /**
     *
     * @param prime
     * @param m
     * @param n
     * @return
     */
    public static LinkedList primeFactor(LinkedList prime,int m){
        LinkedList factorprime= new LinkedList(); //Lista de los primos factores de x.
        for (int i=0; i<prime.size();i++ ){
            if ( (m % Integer.parseInt((String) prime.get(i)))== 0  ) {
                factorprime.add(i);
            }
        }
        return factorprime;
    }
        
        
    public static int middleSchool (int m, int n){
        Primo b= new Primo(m);
        LinkedList listprime= b.cribaEratostenes();
        LinkedList listPrimP = new LinkedList();
        listPrimP = primeFactor(listprime,m);
        
        Primo q= new Primo(n);
        listprime = q.cribaEratostenes();
        LinkedList listPrimQ= primeFactor(listprime,n);
        
        //listPrimP = lista de primos q dividen a m.
        //listPrimQ = lista de primos q dividen a n.
        //CONTINUAR VIENDO QUE ELEMENTOS TIENEN EN COMUN AMBAS LISTAS !!!
        //ver cual longitud de elementos es mas larga.
        int nums=1;
        String pr="";
        if (!listPrimP.isEmpty() && !listPrimQ.isEmpty()){
            if (listPrimP.size() < listPrimQ.size()){
                for (int i=0; i<listPrimP.size();i++){
                    if (listPrimQ.contains(listPrimP.get(i) )){
                        nums=nums* Integer.parseInt((String) listPrimP.get(i));
                        pr=pr+""+listPrimP.get(i);
                        listPrimQ.removeFirstOccurrence(listPrimP.get(i));
                        
                    //removeFirstOccurrence(Object o)
                    }
                    listPrimP.remove(i);
                }
                
            }
            else{
                //lista B es menor.
                for (int i=0; i< listPrimQ.size();i++){
                    if (listPrimP.contains(listPrimQ.get(i) )){
                        nums=nums* Integer.parseInt((String) listPrimQ.get(i));
                        pr=pr+""+listPrimQ.get(i);
                        listPrimP.removeFirstOccurrence(listPrimQ.get(i));
                        
                    //removeFirstOccurrence(Object o)
                    }
                    listPrimQ.remove(i);
                }
                  }
        }
        else{
            nums=0;
               //ALGUNA DE LAS LISTAS ES VACIA.
            //POR LO TANTO NO COMPARTEN ELEMENTOS.
        }
 
        return nums;
    }
}