package ca.timnorman.semesterscheduler;

import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Calendar;
import java.util.Date;

public class CourseItem {
    String description; // Required
    int weekDue;    // Required
    Calendar dueDate;   // Optional
    int gradeWeight;    // Optional

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeekDue() {
        return weekDue;
    }

    public void setWeekDue(int weekDue) {
        this.weekDue = weekDue;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
        setWeekDue(calculateWeekDue(dueDate));
    }

    public int getGradeWeight() {
        return gradeWeight;
    }

    public void setGradeWeight(int gradeWeight) {
        this.gradeWeight = gradeWeight;
    }

    @Override
    public String toString() {
        Date shortDate;
        if (dueDate != null) {
            shortDate = dueDate.getTime();
        } else {
            shortDate = null;
        }
        return "CourseItem{" +
                "description='" + description + '\'' +
                ", weekDue=" + weekDue +
                ", dueDate=" + shortDate +
                ", gradeWeight=" + gradeWeight +
                '}';
    }

    /**
     * Calculate the semester week number an item is due based on the due date
     * @param dueDate The due date
     * @return The week number the item is due relative to the semester start date.
     */
    private int calculateWeekDue(Calendar dueDate) {
        int startingWeek = weekNumberOfCalendarDate(Schedule.startDate) - 1;
        int weekItsDue = weekNumberOfCalendarDate(dueDate);
        return weekItsDue - startingWeek;

    }

    /**
     * Returns the week number of the year given a date.
     * @param date Date object as a Calendar object.
     * @return Week number as in int.
     */
    private int weekNumberOfCalendarDate(Calendar date) {
        return date
                .getTime()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .get(ChronoField.ALIGNED_WEEK_OF_YEAR);
    }

}
