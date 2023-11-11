package ca.timnorman.semesterscheduler;

import java.util.Date;

public class CourseItem {
    String description; // Required
    int weekDueDate;    // Required
    Date dueDate;       // Optional
    int gradeWeight;    // Optional

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeekDueDate() {
        return weekDueDate;
    }

    public void setWeekDueDate(int weekDueDate) {
        this.weekDueDate = weekDueDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public int getGradeWeight() {
        return gradeWeight;
    }

    public void setGradeWeight(int gradeWeight) {
        this.gradeWeight = gradeWeight;
    }

    @Override
    public String toString() {
        return "CourseItem{" +
                "description='" + description + '\'' +
                ", weekDueDate=" + weekDueDate +
                ", dueDate=" + dueDate +
                ", gradeWeight=" + gradeWeight +
                '}';
    }
}
