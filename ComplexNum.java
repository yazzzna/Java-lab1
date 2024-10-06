public class ComplexNum{ //класс комплексных чисел (a+bi)
    private double re;  // это a
    private double im; // это bi

    public ComplexNum(double re, double im){ // конструктор
        this.re = re;
        this.im = im;
    }

    public ComplexNum sum(ComplexNum other){ // сложение комплексных чисел
        return new ComplexNum(this.re + other.re, this.im + other.im);
    }

    public ComplexNum sub(ComplexNum other){ // вычитание комплексных чисел
        return new ComplexNum(this.re - other.re, this.im - other.im);
    }

    public ComplexNum mul(ComplexNum other){ // умножение комплексных чисел
        return new ComplexNum(this.re * other.re - this.im * other.im, -(this.re * other.im) - (other.re * this.im));
    }
    public ComplexNum div(ComplexNum other){ // деление комплексных чисел
        return new ComplexNum((this.re * other.re + this.im * other.im)/(other.re * other.re + other.im * other.im) , (this.im * other.re - this.re * other.im)/(other.re * other.re + other.im * other.im));
    }
}