import java.util.Random; 

public class MatrizRacional{
	private String nombre; 
	private int filas; 
	private int columnas; 
	private Racional[][] datos;

/*---- Crea una matriz de (3 x 3) de racionales (1/1)
	Parámetros:
		1. String: nombre de la matriz.
 */
public MatrizRacional (String nom)
{
	nombre = nom; 
	filas = 3; 
	columnas = 3; 

	datos = new Racional[filas][columnas]; 

	for(int i = 0; i < filas; i++)
		for(int j = 0; j < columnas; j++)
			datos[i][j] = new Racional(1,1);  
}


/*---- Crea una matriz (n x n) de racionales (1/1) ----
	Parámetros:
		1. String: nombre de la matriz.
		2. int: tamaño de la matriz cuadrada.
 */
public MatrizRacional (String nom, int n)
{
	nombre = nom;
	filas = n;
	columnas = n;

	datos = new Racional[filas][columnas];

	for(int i = 0; i < filas; i++)
		for(int j = 0; j < columnas; j++)
			datos[i][j] = new Racional(1, 1);
}


/*---- Crea una matriz (n x m) de racionales(1/1) ----
	Parámetros:
		1. String: nombre de la matriz.
		2. int: numeros de filas (n).
		3. int: numeros de columnas (m).
 */
public MatrizRacional (String nom, int filas, int columnas)
{
	nombre = nom;
	this.filas = filas;
	this.columnas = columnas;
	datos = new Racional[this.filas][this.columnas];

	for(int i = 0; i < this.filas; i++)
		for(int j = 0; j < this.columnas; j++)
			datos[i][j] = new Racional(1, 1);
}


/*

 */

public void imprimir()
{
	System.out.println("\tMatriz : "+nombre+"\t");
	for(int i = 0; i < filas; i++){
		System.out.println(); 
		for(int j = 0; j < columnas; j++)
			System.out.print("\t"+datos[i][j]);
	}  
}

public MatrizRacional(String n, int fil, int col, int rango)
{
	nombre = n; 
	if(fil <= 0 || col <= 0)
	{
		datos = null; 
		System.out.println(nombre+"No puede ser construído con índices negativos."); 
		return; 
	}

	filas = fil; 
	columnas = col; 

	datos = new Racional[fil][col];  

	for(int i = 0; i < fil; i++)
		for(int j = 0; j < col; j++)
			datos[i][j] = Racional.generarAleatorio(rango); 
}

public static boolean sonDelMismoTam(MatrizRacional m1, MatrizRacional m2)
{
	return ((m1.filas == m2.filas)&& (m1.columnas == m2.columnas));
}



public void sumarMatrices(MatrizRacional m)
{
	if(!sonDelMismoTam(this, m))
	{
		System.out.println("No se pueden sumar.");
		return;  
	}

	for(int i = 0;  i < m.filas; i++)
		for(int j = 0; j < m.columnas; j++){
			this.datos[i][j] = this.datos[i][j].sumar(m.datos[i][j]);
			this.datos[i][j].simplificar(); 
		}
}

}