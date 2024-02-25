public class FireModel
{
    public static int SIZE = 47;
    private FireCell[][] myGrid;
    private FireView myView;

    public FireModel(FireView view)
    {
        myGrid = new FireCell[SIZE][SIZE];
        int setNum = 0;
        for (int r=0; r<SIZE; r++)
        {
            for (int c=0; c<SIZE; c++)
            {
                myGrid[r][c] = new FireCell();
            }
        }
        myView = view;
        myView.updateView(myGrid);
    }

    public void fire(int r, int c) {
    	if (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
    		if (myGrid[r][c].getStatus() == FireCell.GREEN) {
    			myGrid[r][c].setStatus(FireCell.BURNING);
    	        myView.updateView(myGrid);
    			fire(r + 1, c);
    			fire(r - 1, c);
    			fire(r, c + 1);
    			fire(r, c - 1);
    		}
    	}
    }

    public void solve() {
        for (int i = 0; i < SIZE; i++) {
        	fire(SIZE - 1, i);
        }

        for (int x = 0; x < SIZE; x++) {
            if (myGrid[0][x].getStatus() == FireCell.BURNING) {
                System.out.print("Onett is in trouble!");
                break;
            }
            
            if (x == SIZE - 1 && myGrid[0][x].getStatus() != FireCell.BURNING) {
            	System.out.print("Onett is safe.");
            }
        }
    }
}
