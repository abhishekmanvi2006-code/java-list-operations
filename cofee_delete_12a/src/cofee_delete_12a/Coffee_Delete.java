package cofee_delete_12a;


import java.sql.*;
import java.util.Scanner;

public class Coffee_Delete {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3309/test";
        String user = "root";
        String password = "Abhishek@123";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();

            // 1. Display existing records
            System.out.println("Existing Coffee Records:");
            System.out.println("--------------------------------");

            ResultSet rs = st.executeQuery("SELECT * FROM coffee");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("coffee_name") + " " +
                        rs.getInt("price")
                );
            }

            rs.close();

            // 2. Delete record by id
            Scanner sc = new Scanner(System.in);
            System.out.print("\nEnter Coffee ID to delete: ");
            int id = sc.nextInt();

            String deleteQuery = "DELETE FROM coffee WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(deleteQuery);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("No record found with given ID.");
            }

            ps.close();

            // 3. Display updated records
            System.out.println("\nUpdated Coffee Records:");
            System.out.println("--------------------------------");

            ResultSet rs2 = st.executeQuery("SELECT * FROM coffee");

            while (rs2.next()) {
                System.out.println(
                        rs2.getInt("id") + " " +
                        rs2.getString("coffee_name") + " " +
                        rs2.getInt("price")
                );
            }

            rs2.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
    }
}