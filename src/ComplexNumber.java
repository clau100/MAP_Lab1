import org.jetbrains.annotations.NotNull;

public class ComplexNumber{
    public int re, im;

    public ComplexNumber(int re, int im){
        this.re = re;
        this.im = im;
    }

    public static boolean checkIfNumberIsOk(String Number){
        String[] parts = Number.split("\\+", 2);
        try{
            Integer.parseInt(parts[0]);
            String[] im = parts[1].split("\\*",2);
            Integer.parseInt(im[0]);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    public ComplexNumber(String Number){
        String[] parts = Number.split("\\+", 2);
        int real = Integer.parseInt(parts[0]);

        String[] im = parts[1].split("\\*",2);
        int imaginary = Integer.parseInt(im[0]);

        this.re = real;
        this.im = imaginary;
    }

    public ComplexNumber add(@org.jetbrains.annotations.NotNull ComplexNumber other){
        return new ComplexNumber(this.re + other.re , this.im + other.im);
    }

    public ComplexNumber subtract(@NotNull ComplexNumber other){
        return new ComplexNumber(this.re - other.re, this.im - other.im);
    }

    public ComplexNumber multiply(@NotNull ComplexNumber other){
        return new ComplexNumber(this.re * other.re - this.im * other.im, this.re * other.im + this.im * other.re);
    }

    public ComplexNumber divide(@NotNull ComplexNumber other){
        return new ComplexNumber((this.re * other.re + this.im * other.im) / (other.re * other.re + other.im * other.im),
                (this.im * other.re - this.re * other.im) / (other.re * other.re + other.im * other.im));
    }

    public ComplexNumber conjugate(){
        return new ComplexNumber(this.re, -this.im);
    }

    @Override
    public String toString() {
        return this.re + "+" + this.im + "*i";
    }
}
