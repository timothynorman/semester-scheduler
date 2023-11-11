package ca.timnorman.semesterscheduler;

public class Course {
    private String name;
    private String number;

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
}
