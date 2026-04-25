package com.dao;

import com.model.Employee;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    private static final String JDBC_URL  = "jdbc:mysql://localhost:3309/employeedb?useSSL=false&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Abhishek@123"; // ← change to your password

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL Driver not found: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
    }

    // ── ADD ──────────────────────────────────────────────
    public boolean addEmployee(Employee emp) {
        String sql = "INSERT INTO Employee (Empno, EmpName, DoJ, Gender, Bsalary) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt       (1, emp.getEmpno());
            ps.setString    (2, emp.getEmpName());
            ps.setDate      (3, emp.getDoj());
            ps.setString    (4, emp.getGender());
            ps.setBigDecimal(5, emp.getBsalary());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ── UPDATE ───────────────────────────────────────────
    public boolean updateEmployee(Employee emp) {
        String sql = "UPDATE Employee SET EmpName=?, DoJ=?, Gender=?, Bsalary=? WHERE Empno=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString    (1, emp.getEmpName());
            ps.setDate      (2, emp.getDoj());
            ps.setString    (3, emp.getGender());
            ps.setBigDecimal(4, emp.getBsalary());
            ps.setInt       (5, emp.getEmpno());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ── DELETE ───────────────────────────────────────────
    public boolean deleteEmployee(int empno) {
        String sql = "DELETE FROM Employee WHERE Empno=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, empno);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ── GET BY EMPNO ─────────────────────────────────────
    public Employee getEmployeeByEmpno(int empno) {
        String sql = "SELECT * FROM Employee WHERE Empno=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, empno);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return mapRow(rs);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // ── GET ALL ──────────────────────────────────────────
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee ORDER BY Empno";
        try (Connection conn = getConnection();
             Statement  stmt = conn.createStatement();
             ResultSet  rs   = stmt.executeQuery(sql)) {

            while (rs.next()) list.add(mapRow(rs));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ── REPORT 1 — Names starting with letter ────────────
    public List<Employee> getEmployeesByNameLetter(String letter) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee WHERE EmpName LIKE ? ORDER BY EmpName";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, letter.toUpperCase() + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ── REPORT 2 — N or more years of service ────────────
    public List<Employee> getEmployeesByYearsOfService(int years) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee WHERE TIMESTAMPDIFF(YEAR, DoJ, CURDATE()) >= ? ORDER BY DoJ";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, years);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ── REPORT 3 — Salary above threshold ────────────────
    public List<Employee> getEmployeesAboveSalary(BigDecimal salary) {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee WHERE Bsalary > ? ORDER BY Bsalary DESC";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setBigDecimal(1, salary);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) list.add(mapRow(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // ── MAP ROW ──────────────────────────────────────────
    private Employee mapRow(ResultSet rs) throws SQLException {
        return new Employee(
            rs.getInt       ("Empno"),
            rs.getString    ("EmpName"),
            rs.getDate      ("DoJ"),
            rs.getString    ("Gender"),
            rs.getBigDecimal("Bsalary")
        );
    }
}