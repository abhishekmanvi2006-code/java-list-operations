package com.mysql;



import java.sql.*;

public class Coffee_Filter_D {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3309/test";
        String user = "root";
        String password = "Abhishek@123";

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            Statement st = con.createStatement();

            // 1. Display all records
            System.out.println("All Coffee Records:");
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

            // 2. Query coffee names starting with 'D'
            System.out.println("\nCoffee Names Starting with 'D':");
            System.out.println("--------------------------------");

            String query = "SELECT * FROM coffee WHERE coffee_name LIKE 'D%'";
            ResultSet rs2 = st.executeQuery(query);

            boolean found = false;

            while (rs2.next()) {
                found = true;
                System.out.println(
                        rs2.getInt("id") + " " +
                        rs2.getString("coffee_name") + " " +
                        rs2.getInt("price")
                );
            }

            if (!found) {
                System.out.println("No coffee found starting with 'D'");
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