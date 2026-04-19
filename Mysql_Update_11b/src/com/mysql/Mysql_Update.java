package com.mysql;



import java.sql.*;

public class Mysql_Update {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3309/test";
        String user = "root";
        String password = "Abhishek@123";

        Connection dbConnection = null;

        try {
            dbConnection = DriverManager.getConnection(url, user, password);
            System.out.println("Successfully connected to MySQL database test");

            // 1. Display existing records
            String query = "SELECT * FROM coffee";
            Statement st = dbConnection.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println("\nExisting Records:");
            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " " +
                        rs.getString("coffee_name") + " " +
                        rs.getInt("price"));
            }

            rs.close();
            st.close();

            // 2. Update record
            String updateQuery = "UPDATE coffee SET price = ? WHERE id = ?";
            PreparedStatement ps = dbConnection.prepareStatement(updateQuery);

            ps.setInt(1, 950);  // new price
            ps.setInt(2, 102);  // id

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("\nRecord updated successfully!");
            } else {
                System.out.println("\nNo record found to update.");
            }

            ps.close();

            // 3. Display updated records
            Statement st2 = dbConnection.createStatement();
            ResultSet rs2 = st2.executeQuery("SELECT * FROM coffee");

            System.out.println("\nUpdated Records:");
            while (rs2.next()) {
                System.out.println(
                        rs2.getInt("id") + " " +
                        rs2.getString("coffee_name") + " " +
                        rs2.getInt("price"));
            }

            rs2.close();
            st2.close();

        } catch (SQLException e) {
            System.out.println("Database error occurred!");
            e.printStackTrace();

        } finally {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}