package ca.timnorman.semesterscheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Schedule {
    List<Course> schedule = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);

    /**
     * Method to create a new schedule.
     */
    public void createNew() {
        boolean addAnotherCourse = true;
        System.out.println("Making a new schedule.");

        // TODO 1. prompt for start date
        System.out.print("Enter the first day of the semester in DD-MM-YYYY format: ");
        String userInput = keyboard.nextLine();

        // TODO 2. loop to enter course information
        while (addAnotherCourse == true) {
            addCourse();
            System.out.print("Would you like to add another course (Y/N)? ");
            if (!keyboard.nextLine().equalsIgnoreCase("y")) {
                addAnotherCourse = false;
            }
        }

        System.out.println("The current schedule has the following courses: ");
        for (Course course : schedule) {
            System.out.printf("Index: %d %s %n", schedule.indexOf(course), course.toString());
        }

        for (Course course : schedule) {
            boolean addAnotherItem = true;
            System.out.printf("Enter course items for %s: %n", course.toString());

            while (addAnotherItem == true) {
                course.addItem();
                System.out.print("Would you like to add another item (Y/N)? ");
                if (!keyboard.nextLine().equalsIgnoreCase("y")) {
                    addAnotherItem = false;
                }
            }

            System.out.println(course.courseItems);
        }

    }

    /**
     * Method to prompt for a course name and number, create that course as an object and add it to 'schedule'
     */
    private void addCourse() {
        System.out.print("Enter course name: ");
        String courseName = keyboard.nextLine();
        System.out.print("Enter course number: ");
        String courseNumber = keyboard.nextLine();

        schedule.add(new Course(courseName, courseNumber));
    }

    /**
     * Prompt the user for the first day of the semester and returns a Calendar object of that date.
     * @return startDate Calendar object of the first day of the semester.
     */
    private Calendar startDate(String userInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date parsedDate = dateFormat.parse(userInput);
            Calendar startDate = Calendar.getInstance();
            startDate.setTime(parsedDate);

            return startDate;
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
