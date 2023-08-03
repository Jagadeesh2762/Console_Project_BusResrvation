package BusReservationJDBC;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class bookingClass {
     String passengerName;
     int busNo;
     Date date;

     int booking_id;
     bookingClass(){

     }

    public void bookingClassInput(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter name of passenger : ");
        passengerName = sc.next();
        System.out.println("Enter bus no : ");
        busNo = sc.nextInt();
        System.out.println("Enter date dd-MM-yyyy : ");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public void availableSeats() throws Exception{
        BusDAO busDAO = new BusDAO();
        BookingDAO bookingDAO = new BookingDAO();
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the BusNo to view tickets :");
        int busNo = sc.nextInt();
        System.out.println("Enter  the date : ");
        String dateS = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(dateS);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        int capacity = busDAO.getCapacity(busNo);
        int booked = bookingDAO.getBookedCount(busNo,date);
        int availableSeatsAre = capacity -booked;
        if(availableSeatsAre == 0){
            System.out.println("Sorry. No tickets available.");
        }else
             System.out.println("Available seats :"+availableSeatsAre);

    }

    public boolean isAvailable() throws SQLException {

        BusDAO busDAO = new BusDAO();
        BookingDAO bookingDAO = new BookingDAO();
        int capacity = busDAO.getCapacity(busNo);

        int booked = bookingDAO.getBookedCount(busNo,date);

        return booked<capacity;

    }

    public void cancellation()throws SQLException{
         Scanner sc =new Scanner(System.in);
         BookingDAO cancel = new BookingDAO();
        System.out.println("Enter the Booking ID : ");
        int id= sc.nextInt();
        cancel.removeTicket(id);
        
    }


}
