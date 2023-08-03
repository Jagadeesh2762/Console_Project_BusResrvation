package BusReservationJDBC;

import java.sql.SQLException;
import java.util.Scanner;

public class BusReserMain {
    public static void main(String[] args) {
        BusDAO busdao = new BusDAO();
        try {
            busdao.displayBusInfo();

            int userOpt = 1;
            Scanner sc = new Scanner(System.in);

            while (userOpt == 1) {
                System.out.println("Enter 1 to Book Ticket ");
                System.out.println("Enter 2 to View available ticket ");
                System.out.println("Enter 3 to Cancelation process");
                System.out.println("Enter 4 to exit...");
                userOpt = sc.nextInt();
                switch (userOpt){
                    case 1:
                        bookingClass booking = new bookingClass();
                        booking.bookingClassInput();
                        if (booking.isAvailable()) {
                            BookingDAO bookingDAO = new BookingDAO();
                            bookingDAO.addBooking(booking);
                            System.out.println("Your Booking is Confirmed ");
                        } else
                            System.out.println("Sorry. Bus is full. Try another bus or date.");
                        break;
                    case 2:
                            bookingClass booking1= new bookingClass();
                            booking1.availableSeats();
                            break;

                    case 3:
                        bookingClass booking2= new bookingClass();
                        booking2.cancellation();
                        break;
                }

            }
            sc.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
