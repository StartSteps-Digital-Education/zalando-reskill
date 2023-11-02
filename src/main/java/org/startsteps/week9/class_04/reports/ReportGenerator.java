package org.startsteps.week9.class_04.reports;

import org.startsteps.week9.class_04.model.Employee;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportGenerator {
    public Report generateReport(ReportType reportType) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException { // reportType == FINANCIAL
                                                          // reportType.name() == Financial + " Report"

//        reportType = ReportType.INVALID_REPORT_TYPE;
        try {
            Class<?> reportClass = Class.forName("org.startsteps.week9.class_04.reports."+toTitleCase(reportType.name())+ "Report");
            // Class.forName("org.startsteps.week9.class_04.reports.Financial" + "Report")
            Constructor<?> constructor = reportClass.getDeclaredConstructor();
            return (Report) constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
                 IllegalAccessException | InvocationTargetException e) {
            throw e;
            //return null;
        }
    }

    public Report generateReport2(ReportType reportType) throws ClassNotFoundException {
        switch (reportType) {
            case EMPLOYEE:
                return new EmployeeReport();
            case DEPARTMENT:
                return new DepartmentReport();
            case HIERARCHY:
                return new HierarchyReport();
            default:
                throw new ClassNotFoundException("Invalid report type: " + reportType);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReportGenerator reportGenerator = new ReportGenerator();
        List<Employee> employees = new ArrayList<>();

        // Adding employees to the employee list
        employees.add(new Employee("CEO", 1, "Executive", "CEO", 0, new Date(), 100000.0));
        employees.add(new Employee("Manager A", 2, "IT", "Manager", 1, new Date(), 80000.0));
        employees.add(new Employee("Manager B", 3, "HR", "Manager", 1, new Date(), 75000.0));
        employees.add(new Employee("Employee X", 4, "IT", "Developer", 2, new Date(), 60000.0));
        employees.add(new Employee("Employee Y", 5, "HR", "HR Assistant", 3, new Date(), 50000.0));

        // Generate Employee Report
        Report employeeReport = reportGenerator.generateReport(ReportType.EMPLOYEE);
        Report employeeReport2 = reportGenerator.generateReport2(ReportType.EMPLOYEE);
        if (employeeReport != null) {
            employeeReport.generateReport(employees);
        }

        // Generate Department Report
        Report departmentReport = reportGenerator.generateReport(ReportType.DEPARTMENT);
        if (departmentReport != null) {
            departmentReport.generateReport(employees);
        }

        // Generate Hierarchy Report
        Report hierarchyReport = reportGenerator.generateReport(ReportType.HIERARCHY);
        if (hierarchyReport != null) {
            hierarchyReport.generateReport(employees);
        }
    }

    public static String toTitleCase(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }

        return converted.toString();
    }
}
