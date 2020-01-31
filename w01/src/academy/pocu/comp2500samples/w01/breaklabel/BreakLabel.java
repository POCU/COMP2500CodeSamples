package academy.pocu.comp2500samples.w01.breaklabel;

public class BreakLabel {

    public static void main(String[] args) {
        int[][] squareMatrix = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8}
        };

        System.out.println("1. Find 0");
        findNumber(squareMatrix, 0);

        System.out.println("2. Find -1");
        findNumber(squareMatrix, -1);
    }

    public static void findNumber(int arr[][], final int n) {
        int[][] defaultMatrix = {
                {4, 1, 3, 1},
                {9, 2, -1, 6},
                {6, 0, 10, 5},
                {1, 2, 3, 3},
        };

        int i = 0;
        int j = 0;

        found:
        {
            for (i = 0; i < arr.length; ++i) {
                for (j = 0; j < arr[0].length; ++j) {
                    if (arr[i][j] == n) {
                        System.out.println(String.format("%d found in arr.", n));
                        break found;
                    }
                }
            }

            System.out.println("Nothing found in arr. Searching defaultMatrix");

            for (i = 0; i < 4; ++i) {
                for (j = 0; j < 4; ++j) {
                    if (defaultMatrix[i][j] == n) {
                        System.out.println(String.format("%d found in defaultMatrix.", n));
                        break found;
                    }
                }
            }
        }

        System.out.println(String.format("Number: %d", n));
        System.out.println(String.format("Index positions: (%d, %d)", i, j));
    }
}
