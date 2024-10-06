public class ComplexMatrix{ // класс комплексных чисел
    private ComplexNum[][] matrix; // эти 3 строчки - скелет матрицы
    private int rows;
    private int cols;

    public ComplexMatrix(ComplexNum[][] matrix){ // конструктор
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public ComplexMatrix sum(ComplexMatrix other){ //сложение матриц
        if (this.rows == other.rows && this.cols == other.cols){
            ComplexNum[][] summarize = new ComplexNum[rows][cols];

            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    summarize[i][j] = this.matrix[i][j].sum(other.matrix[i][j]);
                }
            }

            return new ComplexMatrix(summarize);
        }
        else{
            return null;
        }

    }

    public ComplexMatrix sub(ComplexMatrix other){ // вычитание матриц
        if (this.rows == other.rows && this.cols == other.cols){
            ComplexNum[][] subtract = new ComplexNum[rows][cols];

            for (int i = 0; i < rows; i++){
                for (int j = 0; j < cols; j++) {
                    subtract[i][j] = this.matrix[i][j].sub(other.matrix[i][j]);
                }
            }

            return new ComplexMatrix(subtract);
        }
        else{
            return null;
        }
    }

    public ComplexMatrix mul(ComplexMatrix other){ // умножение
        if (this.cols == other.rows){
            ComplexNum[][] multiplication = new ComplexNum[rows][cols];

            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < other.cols; j++) {
                    multiplication[i][j] = new ComplexNum(0,0);
                }
            }


            for (int i = 0; i < this.rows; i++){
                for (int j = 0; j < other.cols; j++) {
                    for (int n = 0; n < this.cols; n++){
                        multiplication[i][j] = multiplication[i][j].sum(this.matrix[i][n].mul(other.matrix[n][j]));
                    }
                }
            }

            return new ComplexMatrix(multiplication);
        }
        else{
            return null;
        }
    }

    public ComplexMatrix trans(){ // транспонирование

        ComplexNum[][] transpose = new ComplexNum[cols][rows];

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                transpose[j][i] = this.matrix[i][j];
            }
        }

        return new ComplexMatrix(transpose);
    }

    public void printmatrix() { //вывод матрицы
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}