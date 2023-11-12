package ca.timnorman.semesterscheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Course {
    private String name;
    private String number;
    List<CourseItem> courseItems = new ArrayList<>();
    Scanner keyboard = new Scanner(System.in);

    Course(String name, String number) {
        this.name = name;
        this.number = number;
    }

    Course(){}

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return name + " " + number;
    }

    /**
     * Add a new item (assignment, test, lab, etc.) to the course.
     */
    public void addItem() {
        CourseItem item = new CourseItem();
        String userInput;

        System.out.print("Enter description: ");
        item.setDescription(keyboard.nextLine());

        System.out.print("Enter due date in DD-MM format (leave blank if unknown): ");
        userInput = keyboard.nextLine();
        if (!userInput.isEmpty()) {
            item.setDueDate(parseDate(userInput));
        } else {
            System.out.print("Enter semester week due: ");
            item.setWeekDueDate(keyboard.nextInt());
            keyboard.nextLine();
        }

        System.out.print("Enter grade weight (leave blank if unknown): ");
        userInput = keyboard.nextLine();
        if (!userInput.isEmpty()) {
            item.setGradeWeight(Integer.parseInt(userInput));
        }

        courseItems.add(item);
    }

    /**
     * Method for converting a String to a Calendar object
     * @param userInput String of a date in dd-MM format
     * @return Calendar object of the entered String.
     */
    private Calendar parseDate(String userInput) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM");    // TODO Check if this needs a yyyy - confirmed, 1970 if blank.
        Calendar dueDate;
        try {
            Date parsedDate = dateFormat.parse(userInput);
            dueDate = Calendar.getInstance();
            dueDate.setTime(parsedDate);
        } catch (ParseException e) {
            throw new RuntimeException();
        }
        return dueDate;
    }
}
