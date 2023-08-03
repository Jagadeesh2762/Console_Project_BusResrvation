package BusReservationJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO  {

    public void displayBusInfo() throws SQLException {
        String query = "select * from bus";
        Connection conn = DBConnection.getConnection();
        Statement st =conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.print("Bus No : "+ rs.getInt(1));
            if(rs.getInt(2) == 0)
                System.out.print("  AC : NO");
            else
                System.out.print("  AC : YES ");
            System.out.print("  Capacity : "+ rs.getInt(3));
            System.out.print("Driver Name : "+ rs.getString(4));
            System.out.print("Boarding Place : "+ rs.getString(5));
            System.out.print("Destination  : "+ rs.getString(6));
            System.out.println("Total duration : "+ rs.getString(7));
        }
        System.out.println("--------------------------------");

    }

    public int getCapacity(int busNo) throws  SQLException{
            String query = "select capacity from bus where id ="+busNo;
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            return rs.getInt(1);
    }
}
