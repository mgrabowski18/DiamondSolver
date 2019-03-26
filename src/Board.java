public class Board {
    private int size;
    private boolean[][] board;

    public Board(int size)
    {
        this.size=size;
        board= new boolean[size][size];
    }

    public boolean[][] getBoard() {
        return board;
    }


    public void randomField(int diamonds)
    {
        int counter=0;
        while(counter!=diamonds)
        {
            int x = (int) (Math.random()*size);
            int y = (int) (Math.random()*size);
            if(board[x][y]!=true){
                counter++;
                board[x][y]=true;
            }
        }
    }

}
