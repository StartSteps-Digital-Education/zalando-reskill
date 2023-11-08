package org.startsteps.week9.class_05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobPositionTest {
    @Test
    public void testIsWithinBudget_True() {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setOfferedSalaryRangeStart(60000);
        jobPosition.setOfferedSalaryRangeEnd(80000);

        Applicant applicant = new Applicant();
        applicant.setExpectedSalary(70000);

        assertTrue(jobPosition.isWithinBudget(applicant));
    }

    @Test
    public void testIsWithinBudget_False() {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setOfferedSalaryRangeStart(60000);
        jobPosition.setOfferedSalaryRangeEnd(80000);

        Applicant applicant = new Applicant();
        applicant.setExpectedSalary(90000);

        assertFalse(jobPosition.isWithinBudget(applicant));
    }
}


