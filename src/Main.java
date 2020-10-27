import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] spiralArray = new int[n][n];

        int value = 1; // value begint bij 1, na iedere for-loop moet deze worden verhoogd ++
        int minCol = 0; // start voor kolom = 0
        int maxCol = n - 1; // is de laatste kolom
        int minRow = 0; // start row = 0
        int maxRow = n - 1; // is de laatste row

        while (value <= n*n) {
            // vul de top, van links naar rechts
            for (int i = minCol; i <= maxCol; i++) {
                spiralArray[minRow][i] = value;
                value++;
            }
            // vervolgens de laatste kolom vullen van iedere rij, van boven naar beneden
            for (int i = minRow + 1; i <= maxRow; i++) {
                spiralArray[i][maxCol] = value;
                value++;
            }
            // ten derde moet de laatste rij worden gevuld, deze loopt van rechts naar links!!!
            // let op dat de laatste kolom al gevuld is door de 2e for loop, start dus bij maxCol - 1
            for (int i = maxCol - 1; i >= minCol; i--) {
                spiralArray[maxRow][i] = value;
                value++;
            }
            // als laatste wordt de eerste kolom gevuld, van beneden naar boven
            // let op dat de laatste en eerste kolom al gevuld is door de eerste en de derde for loops
            for (int i = maxRow - 1; i >= minRow + 1; i--) {
                spiralArray[i][minCol] = value;
                value++;
            }
            // er is vanzelfsprekend een diepte in een spiraal, je wilt niet de uitlijning van 1 vierkant telkens vullen
            // de minimale waarden van rij en kolom wordt verhoogd
            // en de maximale waarden van rij en kolom verlaagd
            // zo vul je de gehele vierkant!
            minCol++;
            minRow++;
            maxCol--;
            maxRow--;
        }

        // uitprinten met een tab ertussen, zodat de matrix goed leesbaar is
        for (int i = 0; i < spiralArray.length; i++) {
            for (int j = 0; j < spiralArray.length; j++) {
                System.out.print(spiralArray[i][j] + "\t");
            }
            System.out.println();
        }
    }
}