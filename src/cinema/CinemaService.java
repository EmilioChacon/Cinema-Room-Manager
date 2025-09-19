package cinema;

public class CinemaService {

    public static int calculateTicketPrice(Cinema cinema, int rowIndex) {
        int rows = cinema.getRows();
        int seats = cinema.getSeatsPerRow();
        if (rows * seats <= 60) {
            return 10;
        } else if (rowIndex < rows / 2) {
            return 10;
        } else {
            return 8;
        }
    }

    public static int calculatePurchasedTickets(Cinema cinema) {
        int purchased = 0;
        char[][] seats = cinema.getSeatMap();
        for (char[] row : seats) {
            for (char seat : row) {
                if (seat == 'B') purchased++;
            }
        }
        return purchased;
    }

    public static double calculateOccupancy(Cinema cinema) {
        int totalSeats = cinema.getRows() * cinema.getSeatsPerRow();
        int purchased = calculatePurchasedTickets(cinema);
        return (double) purchased / totalSeats * 100;
    }

    public static int calculateCurrentIncome(Cinema cinema) {
        int income = 0;
        char[][] seats = cinema.getSeatMap();
        for (int i = 0; i < cinema.getRows(); i++) {
            for (int j = 0; j < cinema.getSeatsPerRow(); j++) {
                if (seats[i][j] == 'B') {
                    income += calculateTicketPrice(cinema, i);
                }
            }
        }
        return income;
    }

    public static int calculateTotalIncome(Cinema cinema) {
        int totalIncome = 0;
        for (int i = 0; i < cinema.getRows(); i++) {
            for (int j = 0; j < cinema.getSeatsPerRow(); j++) {
                totalIncome += calculateTicketPrice(cinema, i);
            }
        }
        return totalIncome;
    }
}
