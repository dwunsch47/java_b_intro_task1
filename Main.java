import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static final int VALUE_UPPER_BOUND = 256;
    public static final char SEPARATOR = ' ';
    public static final String EMPTY_FILLER = "";
    public static final String SINGLE_FILLER = " ";
    public static final String DOUBLE_FILLER = "  ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int[][] originalMatrix = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                originalMatrix[i][j] = random.nextInt(VALUE_UPPER_BOUND);
            }
        }

        printMatrix(originalMatrix);
        System.out.print("Enter clockwise rotation angle (90, 180, 270): ");
        int rotationAngle = sc.nextInt();
        int[][] newMatrix = rotateMatrix(originalMatrix, rotationAngle);
        System.out.println("Rotated matrix");
        printMatrix(newMatrix);
    }

    public static int[][] rotateMatrix(int[][] oldMatrix, int angle) {
        int[][] resultMatrix = new int[SIZE][SIZE];
//        if (angle == 90) {
//            for (int i = 0; i < SIZE; i++) {
//                for (int j = 0; j < SIZE; j++) {
//                    resultMatrix[j][SIZE - 1 - i] = oldMatrix[i][j];
//                }
//            }
//        } else if (angle == 180) {
//            for (int i = 0; i < SIZE; i++) {
//                for (int j = 0; j < SIZE; j++) {
//                    resultMatrix[SIZE - 1 - i][SIZE - 1 - j] = oldMatrix[i][j];
//                }
//            }
//        } else if (angle == 270) {
//            for (int i = 0; i < SIZE; i++) {
//                for (int j = 0; j < SIZE; j++) {
//                    resultMatrix[SIZE - 1 - j][i] = oldMatrix[i][j];
//                }
//            }
//        }

        int newI, newJ;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                newI = (angle == 90 ? j : (angle == 180 ? (SIZE - 1 - i) : (SIZE - 1 - j))); // assume only three valid inputs: 90, 180, 270
                newJ = (angle == 90 ? (SIZE - 1 - i) : (angle == 180 ? (SIZE - 1 - j) : i));
                resultMatrix[newI][newJ] = oldMatrix[i][j];
            }
        }

        return resultMatrix;
    }

    public static String printFiller(int cell) {
        return (cell >= 100 ? EMPTY_FILLER : (cell >= 10 ? SINGLE_FILLER : DOUBLE_FILLER));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(printFiller(cell) + cell + SEPARATOR);
            }
            System.out.println();
        }
    }
}