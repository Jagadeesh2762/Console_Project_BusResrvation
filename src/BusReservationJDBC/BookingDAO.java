package BusReservationJDBC;

import java.sql.*;
import java.util.Date;
import java.util.Stack;

public class BookingDAO {

        public  int getBookedCount(int busNo, Date date) throws SQLException {
            String query = "select count(passenger_Name) from booking where bus_no=? and travel_date =?";
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            java.sql.Date sqlDate= new java.sql.Date(date.getTime());
            pst.setInt(1,busNo);
            pst.setDate(2,sqlDate);
            ResultSet rs = pst.executeQuery();
            rs.next();

            return  rs.getInt(1);
        }
        public void addBooking(bookingClass booking) throws SQLException {
            String query = "insert into booking(passenger_name,bus_no,travel_date) values(?,?,?)";
            Connection conn = DBConnection.getConnection();
            java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1,booking.passengerName);
            pst.setInt(2,booking.busNo);
            pst.setDate(3,sqlDate);
            pst.executeUpdate();


        }
        public void removeTicket(int id)throws SQLException{
            String query = "delete from booking where booking_id ="+ id;
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            int row= st.executeUpdate(query);
            if(row > 0)
                System.out.println("Cancellation successfull");
            else
                System.out.println("Issue in Cancellation Process,Please enter proper Booking Id");

        }
}
