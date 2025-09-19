package cinema;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the cinema rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the cinema seats per row: ");
        int seatsPerRow = scanner.nextInt();

        Cinema cinema = new Cinema(rows, seatsPerRow); // or prompt user for rows/seats
        CinemaUI ui = new CinemaUI(cinema, scanner);

        int option;
        do {
            ui.printMenu();
            option = ui.readOption();
            switch (option) {
                case 1 -> ui.printSeats();
                case 2 -> ui.buyTicket();
                case 3 -> ui.showStatistics();
            }
        } while (option != 0);
        scanner.close();

    }
}
