import java.util.Random;

public class Racional {
    private int numerador;
    private int denominador;

    public Racional(int num, int den)
    {
        numerador = num;
        if(den == 0)
            throw new IllegalArgumentException("No puede crearse un Racional con denominador cero.");

        denominador = den;
    }

    public static Racional generarAleatorio()
    {
        Random generador = new Random();
        int numerador = 1 + generador.nextInt(9);
        int denominador = 1 + generador.nextInt(9); //Elimina los ceros posibles.

        Racional r = new Racional(numerador, denominador);
        return r;
    }

    public static Racional generarAleatorio(int rango)
    {
        Random generador = new Random(); 
        int numerador = 1 + generador.nextInt(rango); 
        int denominador = 1 + generador.nextInt(rango); 

        Racional r = new Racional(numerador, denominador); 
        return r; 

    }

    public Racional sumar(Racional r)
    {
        return new Racional(this.numerador*r.denominador + this.denominador*r.numerador,
                            this.denominador*r.denominador);
    }

    public Racional restar(Racional r)
    {
        return new Racional(this.numerador*r.denominador - this.denominador*r.numerador,
                this.denominador*r.denominador);
    }

    public Racional multiplicar(Racional r)
    {
        return new Racional(this.numerador*r.numerador, this.denominador*r.denominador);
    }

    public Racional dividir(Racional r)
    {
        return new Racional(this.numerador*r.denominador, this.denominador*r.numerador);
    }

    public void simplificar()
    {
        int mcd = Matemáticas.máximoComúnDivisor(numerador, denominador);
        numerador = numerador/mcd;
        denominador = denominador/mcd;
    }

    public boolean esIgual(Racional r)
    {
        int mcd = Matemáticas.máximoComúnDivisor(r.numerador, r.denominador);

        boolean b = (this.numerador == r.numerador/mcd) && (this.denominador == r.denominador/mcd);
        return b; 
    }

    public boolean sePuedeSimplificar()
    {
        return Matemáticas.máximoComúnDivisor(numerador, denominador) != 1;
    }

    public String toString()
    {
        return "[" + numerador + "/" + denominador + "]";
    }
}
