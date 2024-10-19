{
    private ComplexNum[][] matrix;
    private int rows;
    private int cols;

    public ComplexMatrix(ComplexNum[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Матрица не может быть пустой. Некорректный ввод");
        }
        this.matrix = matrix;
        this.rows = matrix.length;
        this.cols = matrix[0].length;
    }

    public ComplexMatrix sum(ComplexMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }

        ComplexNum[][] summarize = new ComplexNum[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                summarize[i][j] = this.matrix[i][j].sum(other.matrix[i][j]);
            }
        }
        return new ComplexMatrix(summarize);
    }

    public ComplexMatrix sub(ComplexMatrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Матрицы должны быть одинакового размера");
        }

        ComplexNum[][] subtract = new ComplexNum[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                subtract[i][j] = this.matrix[i][j].sub(other.matrix[i][j]);
            }
        }
        return new ComplexMatrix(subtract);
    }

    public ComplexMatrix mul(ComplexMatrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Количество столбцов первой различно с количеством строк второй матрицы");
        }

        ComplexNum[][] multiplication = new ComplexNum[rows][other.cols];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                multiplication[i][j] = new ComplexNum(0, 0);
                for (int n = 0; n < this.cols; n++) {
                    multiplication[i][j] = multiplication[i][j].sum(this.matrix[i][n].mul(other.matrix[n][j]));
                }
            }
        }
        return new ComplexMatrix(multiplication);
    }

    public ComplexMatrix trans() {
        ComplexNum[][] transpose = new ComplexNum[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = this.matrix[i][j];
            }
        }
        return new ComplexMatrix(transpose);
    }

    public void printmatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
