import java.util.Scanner;

public class Game {
    final String ex = "X";
    final String oh = "O";
    final String f = "F";
    public String winner = null; //or can just declare without setting to null
    public String turn;
    public String p1;
    public String p2;
    public String[][] state = {{"F", "F", "F"}, {"F", "F", "F"}, {"F", "F", "F"}};
    public Board board = new Board();

    // different ways to declare an array
//    public String[][] state = {{"X", "X", "X"}, {"X", "X", "X"}, {"X", "X", "X"}};
//    public String[] dimension = {"X", "X", "X"};
//    public String[][] state = {dimension, dimension, dimension};
//    public int[] lst1;
//    public int []lst2;
//    public int lst3[];
//    Piece [][]ourBoard = new Piece[row][col]; //for object arrays


    // constructor
    public Game() {
        this.turn = "X";
        this.board.displayBoard(this.state);

        // instantiate the array after declaration
//        this.lst2 = new int[5];

        this.play();
    }

    public String getTurn() {
        return this.turn;
    }

    public void displayWinner(String player) {
        this.winner = player;
        System.out.println("Congratulations " + this.winner + "!\nYou are the winner!");
    }

    public boolean checkWinner() {
//        boolean winner = false;
//        int cnt_vert = 0;
//        int cnt_hor = 0;
//        String turn_vert;
//        String turn_hor;

//        for(int x = 0; x < 3; x++) {
//            for(int y = 0; y < 3; y++) {
//                if(y == 0 && (this.state[x][y].equals(ex) || this.state[x][y].equals(oh))) {
//                    turn_vert = this.state[x][y];
//                    cnt_vert++;
//                }else if(this.state[x][y].equals(turn_vert)) {
//                    cnt_vert++;
//                }else {
//                    // no wins
//                }
//            }
//        }

        //horizontal wins
        if(this.state[0][0].equals(this.state[0][1]) && this.state[0][0].equals(this.state[0][2]) && !(this.state[0][0].equals(this.f))) {
            return true;
        }else if(this.state[1][0].equals(this.state[1][1]) && this.state[1][0].equals(this.state[1][2]) && !(this.state[1][0].equals(this.f))) {
            return true;
        }else if(this.state[2][0].equals(this.state[2][1]) && this.state[2][0].equals(this.state[2][2]) && !(this.state[2][0].equals(this.f))) {
            return true;
        }
        //vertical wins
        else if(this.state[0][0].equals(this.state[1][0]) && this.state[0][0].equals(this.state[2][0]) && !(this.state[0][0].equals(this.f))) {
            return true;
        }else if(this.state[0][1].equals(this.state[1][1]) && this.state[0][1].equals(this.state[2][1]) && !(this.state[0][1].equals(this.f))) {
            return true;
        }else if(this.state[0][2].equals(this.state[1][2]) && this.state[0][2].equals(this.state[2][2]) && !(this.state[0][2].equals(this.f))) {
            return true;
        }
        //diagonal wins
        else if(this.state[0][0].equals(this.state[1][1]) && this.state[0][0].equals(this.state[2][2]) && !(this.state[0][0].equals(this.f))) {
            return true;
        }else if(this.state[2][0].equals(this.state[1][1]) && this.state[2][0].equals(this.state[0][2]) && !(this.state[2][0].equals(this.f))) {
            return true;
        }

        return false;
    }

    public boolean checkLegalMove(int row, int col) {
        if(state[row][col].equals("F")) {
            return true;
        }

        return false;
    }

    public void play() {
        boolean done = false;
        int row, col;

        Scanner player1 = new Scanner(System.in);
        System.out.print("Player 1 name: ");
        p1 = player1.nextLine();

        Scanner player2 = new Scanner(System.in);
        System.out.print("Player 2 name: ");
        p2 = player2.nextLine();

        while(!done) {
            //try to scan for both at once with comma separated
//            Scanner move = new Scanner(System.in);
//            System.out.println("Enter move: (row, col)");
//            row = move.nextInt();
//            col = move.nextInt();

            Scanner rowInput = new Scanner(System.in);
            System.out.println("Enter row");
            row = rowInput.nextInt();

            Scanner colInput = new Scanner(System.in);
            System.out.println("Enter col");
            col = colInput.nextInt();

            int index_row = row-1;
            int index_col = col-1; //use for actually people playing as they will input row 1 as first row instead of row 0

            if(checkLegalMove(row, col)) { //change to index_row and index_col
                state[row][col] = this.turn;
                this.board.displayBoard(this.state);

                if(checkWinner()) {
                    if(this.turn.equals(this.ex)) {
                        displayWinner(p1);
                        done = true;
                    }else if(this.turn.equals(this.oh)) {
                        displayWinner(p2);
                        done = true;
                    }
                }

                if(this.turn.equals(this.ex)) this.turn = this.oh;
                else this.turn = this.ex;

            }else{
                System.out.println("Please choose an empty \"F\" row and column between 1 and 3");
            }
        }
    }
}
