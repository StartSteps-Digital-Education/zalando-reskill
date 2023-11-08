package org.startsteps.week9.class_05;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecruiterTest {
    @Test
    public void testIsSpecializedFor_IndustryMatch() {
        Recruiter recruiter = new Recruiter();
        recruiter.setName("John Doe");

        // Create a job position with an industry that the recruiter specializes in
        JobPosition jobPosition = new JobPosition();
        jobPosition.setIndustry("Software Development");

        // Add the job position to the list of job positions managed by the recruiter
        List<JobPosition> jobPositionsManaged = new ArrayList<>();
        jobPositionsManaged.add(jobPosition);
        recruiter.setJobPositionsManaged(jobPositionsManaged);

        // Add the industry to the list of specialized industries
        Set<String> specializedIndustries = new HashSet<>();
        specializedIndustries.add("Software Development");
        recruiter.setSpecializedIndustries(specializedIndustries);

        assertTrue(recruiter.isSpecializedFor(jobPosition));
    }

    @Test
    public void testIsSpecializedFor_RoleMatch() {
        Recruiter recruiter = new Recruiter();
        recruiter.setName("Jane Smith");

        // Create a job position with a role that the recruiter specializes in
        JobPosition jobPosition = new JobPosition();
        jobPosition.setRole("HR Manager");

        // Add the job position to the list of job positions managed by the recruiter
        List<JobPosition> jobPositionsManaged = new ArrayList<>();
        jobPositionsManaged.add(jobPosition);
        recruiter.setJobPositionsManaged(jobPositionsManaged);

        // Add the role to the list of specialized roles
        Set<String> specializedRoles = new HashSet<>();
        specializedRoles.add("HR Manager");
        recruiter.setSpecializedRoles(specializedRoles);

        assertTrue(recruiter.isSpecializedFor(jobPosition));
    }

    @Test
    public void testIsSpecializedFor_NoMatch() {
        Recruiter recruiter = new Recruiter();
        recruiter.setName("Alice Johnson");

        // Create a job position with an industry and role that the recruiter does not specialize in
        JobPosition jobPosition = new JobPosition();
        jobPosition.setIndustry("Data Science");
        jobPosition.setRole("Data Analyst");

        // Add the job position to the list of job positions managed by the recruiter
        List<JobPosition> jobPositionsManaged = new ArrayList<>();
        jobPositionsManaged.add(jobPosition);
        recruiter.setJobPositionsManaged(jobPositionsManaged);

        // The recruiter does not specialize in the industry or role of the job position
        Set<String> specializedIndustries = new HashSet<>();
        specializedIndustries.add("Software Development");
        recruiter.setSpecializedIndustries(specializedIndustries);

        Set<String> specializedRoles = new HashSet<>();
        specializedRoles.add("HR Manager");
        recruiter.setSpecializedRoles(specializedRoles);

        assertFalse(recruiter.isSpecializedFor(jobPosition));
    }
}

