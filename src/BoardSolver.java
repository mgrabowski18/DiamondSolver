public class BoardSolver {
    private boolean[][] boardToSolve;

    public BoardSolver(boolean[][] board) {
        boardToSolve = board;
    }


    public int solver(int x_start, int y_start) {
        int number = 0;
        String road;
        int x_end = x_start;
        int y_end = y_start;
        if (boardToSolve[x_end][y_end] == true)
            number++;
        while ((x_end != boardToSolve.length - 1) || (y_end != boardToSolve[x_end].length - 1)) {
            road = chooseDirection(x_end, y_end);
            for (int i = 0; i < road.length(); i++) {
                if (road.charAt(i) == 'r')
                    y_end++;
                else if (road.charAt(i) == 'd')
                    x_end++;

                if (boardToSolve[x_end][y_end] == true)
                    number++;
            }
        }
        return number;
    }
    private String chooseDirection(int x_start, int y_start) {
        String toReturn = "";
        if ((BoardUtilities.isPositionValid(boardToSolve, x_start, y_start+1)) && (BoardUtilities.checkRow(boardToSolve, x_start, y_start) > BoardUtilities.checkColumn(boardToSolve, x_start, y_start))) {
            y_start++;
            toReturn = toReturn + "r";
        } else if ((BoardUtilities.isPositionValid(boardToSolve, x_start+1, y_start)) && (BoardUtilities.checkRow(boardToSolve, x_start, y_start) < BoardUtilities.checkColumn(boardToSolve, x_start, y_start))) {
            x_start++;
            toReturn = toReturn + "d";
        }else if ((BoardUtilities.checkRow(boardToSolve, x_start, y_start) == 0) && (BoardUtilities.checkColumn(boardToSolve, x_start, y_start))==0){
            if(BoardUtilities.isPositionValid(boardToSolve,x_start,y_start+1))
                toReturn = toReturn + "r";
            else
                toReturn=toReturn+"d";
        }
        else if ((BoardUtilities.isPositionValid(boardToSolve, x_start, y_start)) && (BoardUtilities.checkRow(boardToSolve, x_start, y_start) == BoardUtilities.checkColumn(boardToSolve, x_start, y_start))) {
            toReturn += compare(x_start, y_start, x_start, y_start);
        }


        return toReturn;
    }

    private String compare(int x0, int y0, int x1, int y1) {
        String toReturn = "";
        if(!BoardUtilities.isPositionValid(boardToSolve, x0 + 1, y1 + 1))
        {
            if(BoardUtilities.isPositionValid(boardToSolve,x0+1,y0))
                toReturn+="r";
            else
                toReturn+="d";
            return toReturn;
        }

        if (BoardUtilities.checkRow(boardToSolve, x0, y0) > BoardUtilities.checkColumn(boardToSolve, x1, y1))
            toReturn += "r";
        else if (BoardUtilities.checkRow(boardToSolve, x0, y0) < BoardUtilities.checkColumn(boardToSolve, x1, y1))
            toReturn += "d";
        else
            toReturn += compare(x0+1, y0, x1, y1+1);


        return toReturn;
    }
}
