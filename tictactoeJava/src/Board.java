public class Board {
    private static int row = 3;
    private static int col = 3;

    public Board() {
        System.out.println("Let the games begin!");
    }

    public void displayBoard(String[][] state) {
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < col; ++j) {
                System.out.print(state[i][j]);
            }
            System.out.print("\n");
        }
    }
}
