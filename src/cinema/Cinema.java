package cinema;

public class Cinema {
    private final char[][] seatMap;

    public Cinema(int rows, int seats) {
        seatMap = new char[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                seatMap[i][j] = 'S';
            }
        }
    }

    public char[][] getSeatMap() {
        return seatMap;
    }

    public int getRows() {
        return seatMap.length;
    }

    public int getSeatsPerRow() {
        return seatMap[0].length;
    }

    public char getSeat(int rowIndex, int seatIndex) {
        return seatMap[rowIndex][seatIndex];
    }

    public void setSeat(int rowIndex, int seatIndex, char value) {
        seatMap[rowIndex][seatIndex] = value;
    }
}
