package exercises;

public class Spiralizor {
    public static void main(String[] args) {
        int[][] spiralize = spiralize(10);
        for (int i = 0; i < spiralize.length; i++) {
            for (int j = 0; j < spiralize[i].length; j++) {
                System.out.print(spiralize[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static int[][] spiralize(int size) {
        int[][] spiral = new int[size][size];
        //first row
        for (int i = 0; i < size; i++) {
            spiral[0][i] = 1;
        }

        //vertical down
        int x1 = 1;
        int y1 = size - 1;
        for (int i = size - 1; i >= 1 ; i-=4) {
            for (int j = 0; j < i; j++) {
                spiral[x1 + j][y1] = 1;
            }
            x1+=2;
            y1-=2;
        }

        //horizontal left
        int x2 = size - 1;
        int y2 = size - 2;
        for (int i = size - 1; i >= 2 ; i-=4) {
            for (int j = 0; j < i; j++) {
                spiral[x2][y2 - j] = 1;
            }
            x2-=2;
            y2-=2;
        }

        //vertical up
        int x3 = size - 2;
        int y3 = 0;
        for (int i = size - 3; i >= 1 ; i-=4) {
            for (int j = 0; j < i; j++) {
                spiral[x3 - j][y3] = 1;
            }
            x3-=2;
            y3+=2;
        }

        //horizontal right
        int x4 = 2;
        int y4 = 1;
        for (int i = size - 3; i >= 2 ; i-=4) {
            for (int j = 0; j < i; j++) {
                spiral[x4][y4 + j] = 1;
            }
            x4+=2;
            y4+=2;
        }
        return spiral;
    }
}

//[0][0] -> 8

//[1][7] -> 7 pionowo w dół
//[7][6] -> 7 poziomo w lewo
//[6][0] -> 5 pionowo w górę
//[2][1] -> 5 poziomo w prawo
//[3][5] -> 3 pionowo w dół
//[5][4] -> 3 poziomo w lewo
//[4][2] -> 1 pionowo w górę

//[0][0] -> 10
//[1][9] -> 9 pionowo w dół
//[9][8] -> 9 poziomo w lewo
//[8][0] -> 7 pionowo w górę
//[2][1] -> 7 poziomo w prawo
//[3][7] -> 5 pionowo w dół
//[7][6] -> 5 poziomo w lewo
//[6][2] -> 3 pionowo w górę
//[4][3] -> 3 poziomo w prawo
//[5][5] -> 1 pionowo w dół


