package cinema;

import java.util.Scanner;

public class CinemaUI {

    private final Cinema cinema;
    private final Scanner scanner;

    public CinemaUI(Cinema cinema, Scanner scanner) {
        this.cinema = cinema;
        this.scanner = scanner;
    }

    public void printMenu() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
    }

    public void printSeats() {
        System.out.print("Cinema:\n  ");
        for (int i = 0; i < cinema.getSeatsPerRow(); i++) System.out.print((i + 1) + " ");
        System.out.println();
        for (int i = 0; i < cinema.getRows(); i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < cinema.getSeatsPerRow(); j++) {
                System.out.print(cinema.getSeat(i, j) + " ");
            }
            System.out.println();
        }
    }

    public void buyTicket() {
        int rowNumber, seatNumber;
        boolean seatAvailable = false;
        while (!seatAvailable) {
            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();
            int r = rowNumber - 1;
            int s = seatNumber - 1;

            if (r < 0 || r >= cinema.getRows() || s < 0 || s >= cinema.getSeatsPerRow()) {
                System.out.println("This seat does not exist. Please try again.");
            } else if (cinema.getSeat(r, s) == 'S') {
                seatAvailable = true;
                cinema.setSeat(r, s, 'B');
                int price = CinemaService.calculateTicketPrice(cinema, r);
                System.out.println("Ticket price: $" + price + "\n");
                System.out.println("Your ticket is booked\n");
                printSeats();
            } else {
                System.out.println("That ticket has already been purchased!");
            }
        }
    }

    public void showStatistics() {
        System.out.println("Number of purchased tickets: " + CinemaService.calculatePurchasedTickets(cinema));
        System.out.printf("Percentage: %.2f%%%n", CinemaService.calculateOccupancy(cinema));
        System.out.println("Current income: $" + CinemaService.calculateCurrentIncome(cinema));
        System.out.println("Total income: $" + CinemaService.calculateTotalIncome(cinema));
    }

    public int readOption() {
        System.out.println("Enter option:");
        return scanner.nextInt();
    }

}


