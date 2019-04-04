public class UserMatrizRacional{
	public static void main(String []args)
	{
		MatrizRacional M1 = new MatrizRacional("M1"); 
		M1.imprimir(); 

		System.out.println("\n");

		MatrizRacional M2 = new MatrizRacional ("M2", 3, 3, 20); 
		M2.imprimir(); 

		System.out.println("\n"); 

		//MatrizRacional M3 = 

		M1.sumarMatrices(M2); 
		M1.imprimir(); 
	}
}