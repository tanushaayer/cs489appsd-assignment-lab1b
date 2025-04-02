package edu.miu.cs.cs489appsd;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.cs.cs489appsd.model.Employee;
import edu.miu.cs.cs489appsd.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static edu.miu.cs.cs489appsd.model.Employee.printAllEmployee;

public class Main {
    public static void printUpcomingEnrollees(List<Employee> employees) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        LocalDate nextQuater;

        if (currentMonth <= 3) {
            nextQuater = LocalDate.of(now.getYear(), 4, 1);
        } else if (currentMonth <= 6) {
            nextQuater = LocalDate.of(now.getYear(), 7, 1);
        } else if (currentMonth <= 9) {
            nextQuater = LocalDate.of(now.getYear(), 10, 1);
        } else {
            nextQuater = LocalDate.of(now.getYear() + 1, 1, 1);
        }
        LocalDate nextQuarterEnd = nextQuater.plusMonths(3).minusDays(1);

        List<Employee> enrollees = employees.stream()
                .filter(employee -> employee.getPensionPlan() == null && employee.getEmploymentDate().plusYears(3).isAfter(nextQuater) && employee.getEmploymentDate().plusYears(3).isBefore(nextQuarterEnd)
                ).sorted(Comparator.comparing(Employee::getEmploymentDate).reversed()).toList();
        String result = om.writerWithDefaultPrettyPrinter().writeValueAsString(enrollees);
        System.out.println(result);
    }
    public static void main(String[] args) throws JsonProcessingException {
        List<Employee> employees = new ArrayList<>();
        Employee emp1 = new Employee(121, "Daniel", "Agar", LocalDate.of(2018, 1, 17), 105945.50, new PensionPlan("EX1089", LocalDate.of(2023, 1, 17), 100.00));
        Employee emp2 = new Employee(111, "Benard", "Shaw", LocalDate.of(2022, 9, 3), 197750.00);
        Employee emp3 = new Employee(113, "Carly", "Agar", LocalDate.of(2014, 5, 16), 1555.50, new PensionPlan("SM2307", LocalDate.of(2019, 11, 4), 1555.50));
        Employee emp4 = new Employee(114, "Wesley", "Schneider", LocalDate.of(2022,7,21),74500.00);
        Employee emp5 = new Employee(5, "Anna", "Wiltord", LocalDate.of(2022, 6, 15), 85750.00);

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        printAllEmployee(employees);
       printUpcomingEnrollees(employees);

    }
}