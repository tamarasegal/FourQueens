import java.util.HashSet;
import java.util.Set;

public class FourQ {

    //for Big O representations, n refers to the number of queens
    static int[] board = {0, 0, 0, 0};

    //finds all solutions to the four queens problem
    public static void findSolutions() {

        //is this O(n^n?), if so that's lowk really bad, but of course it's that way because this is a brute force approach
        do {
            if (isSafe()) {
                printBoard();
                System.out.println();
            }
        }
        while (advance());
    }

    //returns true if it's a valid advance and false otherwise - O(n)
    public static boolean advance() {
        if (board[3] == 3)
            return false;
        else
            board[0]++;
        int i = 0;
        while (board[i] == 4) {
            board[i] = 0;
            board[i+1]++;
            i++;
        }
        return true;
    }

    //prints the current status of the board - O(n^2)
    public static void printBoard() {
       for (int j = 0; j < board.length; j++) {
           String rn = "";
           for (int i = 0; i < board.length; i++) {
               if (i == board[j])
                   rn += "Q ";
               else
                   rn += "_ ";
           }
           System.out.println(rn);;
       }
    }

    //returns true if the queens are all safe and false otherwise - memory O(n), time O(n^2) (technically n! but i think that's improper notation)
    public static boolean isSafe() {
        //system inherently disregards possibilities of queens in same column

        //checking if in same row
        Set<Integer> already = new HashSet<>();
        for (int n : board) {
            if (already.contains(n))
                return false;
            already.add(n);
        }

        //checking for diagonal attacking
        for (int i = 0; i < 4; i++) {
            for (int j = i+1; j < 4; j++) {
                if (Math.abs((i-j)/(board[i]-board[j])) == 1)
                    return false;
            }
        }

        //all tests passed at this point
        return true;
    }
}
