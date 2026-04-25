package com.model;
 
import java.math.BigDecimal;
import java.sql.Date;
 
/**
 * Employee Model - Maps to the Employee database table.
 * Fields: Empno, EmpName, DoJ, Gender, Bsalary
 */
public class Employee {
	 private int empno;
	    private String empName;
	    private Date doj;
	    private String gender;
	    private BigDecimal bsalary;
	 
    // Default constructor
    public Employee() {}
 
    // Parameterized constructor
    public Employee(int empno, String empName, Date doj, String gender, BigDecimal bsalary) {
        this.empno   = empno;
        this.empName = empName;
        this.doj     = doj;
        this.gender  = gender;
        this.bsalary = bsalary;
    }
 
    // Getters
    public int       getEmpno()   { return empno;   }
    public String    getEmpName() { return empName; }
    public Date      getDoj()     { return doj;     }
    public String    getGender()  { return gender;  }
    public BigDecimal getBsalary(){ return bsalary; }
 
    // Setters
    public void setEmpno(int empno)           { this.empno   = empno;   }
    public void setEmpName(String empName)    { this.empName = empName; }
    public void setDoj(Date doj)              { this.doj     = doj;     }
    public void setGender(String gender)      { this.gender  = gender;  }
    public void setBsalary(BigDecimal bsalary){ this.bsalary = bsalary; }
 
    @Override
    public String toString() {
        return "Employee [empno=" + empno + ", empName=" + empName +
               ", doj=" + doj + ", gender=" + gender + ", bsalary=" + bsalary + "]";
    }
}
 