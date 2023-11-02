package org.startsteps.week9.class_04;

import org.junit.jupiter.api.Test;
import org.startsteps.week9.class_04.reports.*;

import java.lang.reflect.InvocationTargetException;

import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorTest {

    @Test
    void generateEmployeeReport() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Given
        ReportGenerator reportGenerator = new ReportGenerator();

        // When
        Report report = reportGenerator.generateReport(ReportType.EMPLOYEE);

        // Then
        assertNotNull(report);
        assertTrue(report instanceof EmployeeReport);

    }

    @Test
    void generateDepartmentReport() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReportGenerator reportGenerator = new ReportGenerator();
        Report report = reportGenerator.generateReport(ReportType.DEPARTMENT);
        assertNotNull(report);
        assertTrue(report instanceof DepartmentReport);
    }

    @Test
    void generateHierarchyReport() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReportGenerator reportGenerator = new ReportGenerator();
        Report report = reportGenerator.generateReport(ReportType.HIERARCHY);
        assertNotNull(report);
        assertTrue(report instanceof HierarchyReport);
    }

    @Test
    void generateInvalidReport() {
        ReportGenerator reportGenerator = new ReportGenerator();
        assertThrows(ClassNotFoundException.class, () -> reportGenerator.generateReport(ReportType.INVALID_REPORT_TYPE));
    }

    @Test
    void generateEmployeeReport2() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        // Given
        ReportGenerator reportGenerator = new ReportGenerator();

        // When
        Report report = reportGenerator.generateReport2(ReportType.EMPLOYEE);

        // Then
        assertNotNull(report);
        assertTrue(report instanceof EmployeeReport);

    }

    @Test
    void generateDepartmentReport2() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReportGenerator reportGenerator = new ReportGenerator();
        Report report = reportGenerator.generateReport2(ReportType.DEPARTMENT);
        assertNotNull(report);
        assertTrue(report instanceof DepartmentReport);
    }

    @Test
    void generateHierarchyReport2() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        ReportGenerator reportGenerator = new ReportGenerator();
        Report report = reportGenerator.generateReport2(ReportType.HIERARCHY);
        assertNotNull(report);
        assertTrue(report instanceof HierarchyReport);
    }

    @Test
    void generateInvalidReport2() {
        ReportGenerator reportGenerator = new ReportGenerator();
        assertThrows(ClassNotFoundException.class, () -> reportGenerator.generateReport2(ReportType.INVALID_REPORT_TYPE));
    }

    @Test
    void generateInvalidReportWhenReportTypeIsNonExistant2(){
        ReportGenerator reportGenerator = new ReportGenerator();
        assertThrows(NullPointerException.class, () -> reportGenerator.generateReport2(null));
    }

    @Test
    void generateInvalidReportWhenReportTypeIsNonExistant(){
        ReportGenerator reportGenerator = new ReportGenerator();
        assertThrows(NullPointerException.class, () -> reportGenerator.generateReport(null));
    }

    @Test
    void titleCaseBerlinFromBERLIN(){
        // Given
        String input = "BERLIN";

        // When
        String output = ReportGenerator.toTitleCase(input);

        // Then
        assertEquals(output, "Berlin");
    }

    @Test
    void titleCaseBerlinFrombeRLIN(){
        // Given
        String input = "beRLIN";

        // When
        String output = ReportGenerator.toTitleCase(input);

        // Then
        assertEquals("Berlin", output);
    }

    @Test
    void titleCaseBerlinFromberlin(){
        // Given
        String input = "berlin";

        // When
        String output = ReportGenerator.toTitleCase(input);

        // Then
        assertEquals(output, "Berlin");
    }
}


