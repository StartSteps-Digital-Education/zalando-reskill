package org.startsteps.week5.class_05;

class Task implements Taskable {
    private String title;
    private String description;
    private String priority;

    public Task(String title, String description, String priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Description: " + description + ", Priority: " + priority;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String getPriority() {
        return priority;
    }
}
