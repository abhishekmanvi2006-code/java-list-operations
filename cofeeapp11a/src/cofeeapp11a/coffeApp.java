package cofeeapp11a;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class coffeApp {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3309/test";
        String user = "root";       // change if needed
        String password = "Abhishek@123";   // change if needed

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to DB
            con = DriverManager.getConnection(url, user, password);

            stmt = con.createStatement();

            // 3. Read existing records
            System.out.println("Existing Coffee Records:");
            rs = stmt.executeQuery("SELECT * FROM coffee");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("coffee_name") + " | " +
                    rs.getInt("price")
                );
            }

            // 4. Insert new coffee product
            String insertQuery = "INSERT INTO coffee (coffee_name, price) VALUES (?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);

            ps.setString(1, "Cappuccino");
            ps.setInt(2, 180);

            int rows = ps.executeUpdate();
            System.out.println("\nInserted " + rows + " record(s)");

            // 5. Display updated records
            System.out.println("\nUpdated Coffee Records:");
            rs = stmt.executeQuery("SELECT * FROM coffee");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("coffee_name") + " | " +
                    rs.getInt("price")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}