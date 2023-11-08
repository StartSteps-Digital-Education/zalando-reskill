package org.startsteps.week9.class_05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Recruiter {
    private String name;
    private List<JobPosition> jobPositionsManaged;
    private Set<String> specializedIndustries = new HashSet<>(); // Initialize the sets here
    private Set<String> specializedRoles = new HashSet<>();

    public Recruiter() {}

    public Recruiter(String name) {
        this.name = name;
        this.jobPositionsManaged = new ArrayList<>();
    }

    public void assignJobPosition(JobPosition jobPosition) {
        jobPositionsManaged.add(jobPosition);
    }

    public void reviewApplicant(Applicant applicant) {
        applicant.setStatus(ApplicantStatus.REVIEWED);
    }

    public boolean isSpecializedFor(JobPosition jobPosition) {
        if (specializedIndustries != null && specializedRoles != null) {
            boolean industryMatch = specializedIndustries.contains(jobPosition.getIndustry());
            boolean roleMatch = specializedRoles.contains(jobPosition.getRole());
            return industryMatch || roleMatch;
        } else {
            // Handle the case where specializedIndustries or specializedRoles is null
            return false;
        }
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobPosition> getJobPositionsManaged() {
        return jobPositionsManaged;
    }

    public void setJobPositionsManaged(List<JobPosition> jobPositionsManaged) {
        this.jobPositionsManaged = jobPositionsManaged;
    }

    public Set<String> getSpecializedIndustries() {
        return specializedIndustries;
    }

    public void setSpecializedIndustries(Set<String> specializedIndustries) {
        this.specializedIndustries = specializedIndustries;
    }

    public Set<String> getSpecializedRoles() {
        return specializedRoles;
    }

    public void setSpecializedRoles(Set<String> specializedRoles) {
        this.specializedRoles = specializedRoles;
    }
}
