package org.startsteps.week9.class_04.reports;

// Enum to define different report types
public enum ReportType {
    EMPLOYEE("Employee Report"),
    DEPARTMENT("Department Report"),
    HIERARCHY("Hierarchy Report"),
    INVALID_REPORT_TYPE("Invalid Report"),
    FINANCIAL("Financial Report");

    private final String displayName;

    // Constructor to initialize enum constants with display names
    ReportType(String displayName) {
        this.displayName = displayName;
    }

    // Getter to retrieve the display name of the report type
    public String getDisplayName() {
        return displayName;
    }
}
