//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Project by Yana Zakharchenko\n");

        ComplexNum[][] m1 = { //данные для 1 матрицы
            { new ComplexNum(2,3), new ComplexNum(4,5), new ComplexNum(6,7) },
            { new ComplexNum(7,0), new ComplexNum(0, 0), new ComplexNum(9,9) },
            { new ComplexNum(0,0), new ComplexNum(7,9), new ComplexNum(3, 0) }
        };

        ComplexNum[][] m2 = { //данные для 2 матрицы
            { new ComplexNum(1,2), new ComplexNum(0,0), new ComplexNum(7,8) },
            { new ComplexNum(4,44), new ComplexNum(6, 11), new ComplexNum(8,8) },
            { new ComplexNum(11,0), new ComplexNum(15,3), new ComplexNum(19, 41) }
        };

        ComplexMatrix matrix1 = new ComplexMatrix(m1); // создание матриц
        ComplexMatrix matrix2 = new ComplexMatrix(m2);

        System.out.println("Матрица 1:");
        matrix1.printmatrix();

        System.out.println("Матрица 2:");
        matrix2.printmatrix();

        System.out.println("Сумма");
        ComplexMatrix sumatrix = matrix1.sum(matrix2);
        sumatrix.printmatrix();

        System.out.println("Разность");
        ComplexMatrix submatrix = matrix1.sub(matrix2);
        submatrix.printmatrix();

        System.out.println("Умножение");
        ComplexMatrix mulmatrix = matrix1.mul(matrix2);
        mulmatrix.printmatrix();


        System.out.println("Транспонирование матрицы 1");
        ComplexMatrix transmatrix = matrix1.trans();
        transmatrix.printmatrix();

    }
}


