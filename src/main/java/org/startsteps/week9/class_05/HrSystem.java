package org.startsteps.week9.class_05;

import java.util.ArrayList;
import java.util.List;

public class HrSystem {
    private List<JobPosition> jobPositions;
    private List<Recruiter> recruiters;
    private List<Applicant> applicants;

    public HrSystem() {
        jobPositions = new ArrayList<>();
        recruiters = new ArrayList<>();
        applicants = new ArrayList<>();
    }

    public void addJobPosition(JobPosition jobPosition) {
        if (jobPosition != null && jobPosition.getOfferedSalaryRangeStart() <= jobPosition.getOfferedSalaryRangeEnd()) {
            jobPositions.add(jobPosition);
        }
    }

    public void addRecruiter(Recruiter recruiter) {
        if (recruiter != null) {
            recruiters.add(recruiter);
        }
    }

    public void addApplicant(Applicant applicant) {
        if (applicant != null) {
            applicants.add(applicant);
        }
    }

    public String generateReports() {
        // Generate report on the number of applicants per status and per job position
        for (JobPosition jobPosition : jobPositions) {
            System.out.println("Job Position: " + jobPosition.getTitle());
            for (Applicant applicant : applicants) {
                if (jobPosition.getTitle().equals(applicant.getPreferredJobTitle())) {
                    return "Applicant: " + applicant.getName() + ", Status: " + applicant.getStatus();
                }
            }
        }

        return null;
    }

    // getters and setters
    public List<JobPosition> getJobPositions() {
        return jobPositions;
    }

    public void setJobPositions(List<JobPosition> jobPositions) {
        this.jobPositions = jobPositions;
    }

    public List<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(List<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }
}
