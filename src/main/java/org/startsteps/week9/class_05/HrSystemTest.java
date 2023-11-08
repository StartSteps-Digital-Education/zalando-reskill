package org.startsteps.week9.class_05;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HrSystemTest {

    private HrSystem hrSystem;

    @Before
    public void setUp() {
        hrSystem = new HrSystem();
    }

    @Test
    public void testAddJobPosition() {
        // Test adding a valid job position
        JobPosition validJobPosition = new JobPosition("Software Engineer", "Job description", 60000, 90000);
        hrSystem.addJobPosition(validJobPosition);
        assertTrue(hrSystem.getJobPositions().contains(validJobPosition));

        // Test adding a job position with null values (should not be added)
        JobPosition jobPositionWithNullValues = new JobPosition("Invalid Position", null, 60000, 90000);
        hrSystem.addJobPosition(jobPositionWithNullValues);
        assertFalse(hrSystem.getJobPositions().contains(jobPositionWithNullValues));
    }

    @Test
    public void testAddRecruiter() {
        // Test adding a valid recruiter
        Recruiter validRecruiter = new Recruiter("John Doe");
        hrSystem.addRecruiter(validRecruiter);
        assertTrue(hrSystem.getRecruiters().contains(validRecruiter));

        // Test adding a recruiter with null value (should not be added)
        Recruiter recruiterWithNullName = new Recruiter(null);
        hrSystem.addRecruiter(recruiterWithNullName);
        assertFalse(hrSystem.getRecruiters().contains(recruiterWithNullName));
    }

    @Test
    public void testAddApplicant() {
        // Test adding a valid applicant
        Applicant validApplicant = new Applicant("Alice", "Software Engineer", ApplicantStatus.APPLIED, 70000);
        hrSystem.addApplicant(validApplicant);
        assertTrue(hrSystem.getApplicants().contains(validApplicant));

        // Test adding an applicant with null values (should not be added)
        Applicant applicantWithNullValues = new Applicant(null, null, null, 0);
        hrSystem.addApplicant(applicantWithNullValues);
        assertFalse(hrSystem.getApplicants().contains(applicantWithNullValues));
    }

    @Test
    public void testGenerateReports() {
        // Create job positions
        JobPosition softwareEngineer = new JobPosition("Software Engineer", "Software Engineer description", 60000, 90000);
        JobPosition productManager = new JobPosition("Product Manager", "Product Manager description", 70000, 110000);
        hrSystem.addJobPosition(softwareEngineer);
        hrSystem.addJobPosition(productManager);

        // Create applicants
        Applicant applicant1 = new Applicant("Alice", "Software Engineer", ApplicantStatus.APPLIED, 75000);
        Applicant applicant2 = new Applicant("Bob", "Software Engineer", ApplicantStatus.INTERVIEWED, 85000);
        Applicant applicant3 = new Applicant("Charlie", "Product Manager", ApplicantStatus.HIRED, 100000);
        hrSystem.addApplicant(applicant1);
        hrSystem.addApplicant(applicant2);
        hrSystem.addApplicant(applicant3);

        // Test generating reports
        String reports = hrSystem.generateReports();
        assertTrue(reports.contains("Job Position: Software Engineer"));
        assertTrue(reports.contains("Applicant: Alice, Status: APPLIED"));
        assertTrue(reports.contains("Applicant: Bob, Status: INTERVIEWED"));
        assertTrue(reports.contains("Job Position: Product Manager"));
        assertTrue(reports.contains("Applicant: Charlie, Status: HIRED"));
    }
}
