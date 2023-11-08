package org.startsteps.week9.class_05;

import java.util.List;

public class Applicant {
    private List<String> previousCompanies;
    private String currentCity;
    private String preferredLocation;
    private double expectedSalary;
    private ApplicantStatus status;
    private String name;
    private String preferredJobTitle;

    public Applicant() {}

    public Applicant(String name, String preferredJobTitle, ApplicantStatus status, double expectedSalary) {
        this.expectedSalary = expectedSalary;
        this.status = status;
        this.name = name;
        this.preferredJobTitle = preferredJobTitle;
    }

    public boolean isRelocationPreferred() {
        return !currentCity.equals(preferredLocation);
    }

    public List<String> getPreviousCompanies() {
        return previousCompanies;
    }

    public void setPreviousCompanies(List<String> previousCompanies) {
        this.previousCompanies = previousCompanies;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public ApplicantStatus getStatus() {
        return status;
    }

    public void setStatus(ApplicantStatus status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreferredJobTitle() {
        return preferredJobTitle;
    }

    public void setPreferredJobTitle(String preferredJobTitle) {
        this.preferredJobTitle = preferredJobTitle;
    }
}
