package edu.miu.cs.cs489appsd.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate;
    private double yearlySalary;
    private PensionPlan pensionPlan;

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;

    }

    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = null;
    }


    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }
    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }
    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    @Override
    public String toString() {
        return "EmployeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", employmentDate=" + employmentDate + ", yearlySalary=" + yearlySalary ;
    }

    public static void printAllEmployee(List<Employee> employees) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Employee> sortedEmployee = employees.stream().sorted(Comparator.comparingDouble(Employee::getYearlySalary).reversed().thenComparing(Employee::getLastName)).toList();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(sortedEmployee);
        System.out.println(json);
    }
}
