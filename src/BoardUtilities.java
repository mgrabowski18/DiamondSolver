public class BoardUtilities {

    public static int checkRow(boolean[][] board, int x, int y)
    {
        int number=0;
        if(!isPositionValid(board, x, y+1))
            return 0;

        for (int i=y+1; i<board.length; i++)
        {
            if(board[x][i]==true)
                number++;
        }
        return number;
    }

    public static int checkColumn(boolean[][] board, int x, int y)
    {
        int number=0;
        if(!isPositionValid(board, x+1, y))
            return 0;

        for (int i=x+1; i<board[x].length; i++)
        {
            if(board[i][y]==true)
                number++;
        }
        return number;
    }

    public static boolean isPositionValid(boolean[][] board, int x, int y)
    {
        if(x>=board.length || y>=board[x].length)
            return false;
        else
            return true;
    }
}
