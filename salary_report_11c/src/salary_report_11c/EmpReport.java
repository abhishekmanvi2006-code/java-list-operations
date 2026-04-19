package salary_report_11c;


import java.sql.*;

public class EmpReport {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3309/employee";
        String user = "root";
        String password = "Abhishek@123";

        int grandSalary = 0;

        try {
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Salary Report");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Emp");

            while (rs.next()) {

                int empno = rs.getInt("Emp_NO");
                String name = rs.getString("Emp_Name");
                int salary = rs.getInt("Basicsalary");

                System.out.println("Emp_No   : " + empno);
                System.out.println("Emp_Name : " + name);
                System.out.println("Basic    : " + salary);
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

                grandSalary += salary;
            }

            System.out.println("Grand Salary : " + grandSalary);
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error occurred!");
            e.printStackTrace();
        }
    }
}