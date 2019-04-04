public class Matemáticas {
    public static int máximoComúnDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        if(a < b)
            return Matemáticas.máximoComúnDivisor(b, a);

        if(b == 0)
            return a;
        int residuo = a % b;
        return Matemáticas.máximoComúnDivisor(b, residuo);
    }
}
