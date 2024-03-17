package ca.timnorman;

import java.time.LocalDate;

public class Submission {
    private String submissionsName;
    private int dueWeek;
    private LocalDate dueDate;
    private int weight;

    public String getSubmissionsName() {
        return submissionsName;
    }

    public void setSubmissionsName(String submissionsName) {
        this.submissionsName = submissionsName;
    }

    public int getDueWeek() {
        return dueWeek;
    }

    public void setDueWeek(int dueWeek) {
        this.dueWeek = dueWeek;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
