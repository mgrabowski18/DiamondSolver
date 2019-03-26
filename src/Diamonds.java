public class Diamonds {

    public static void main(String[] args) {
        int size = 100;
        Board board = new Board(size);
        board.randomField(size);

        boolean[][] diamondBoard = board.getBoard();

        /*for(int i=0; i<diamondBoard.length; i++) {
            for (int j = 0; j < diamondBoard[i].length; j++) {
                if(diamondBoard[i][j]==true)
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }*/

        BoardSolver bs = new BoardSolver(diamondBoard);
        System.out.println(bs.solver(0,0));


    }

}
