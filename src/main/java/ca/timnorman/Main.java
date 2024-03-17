package ca.timnorman;

public class Main {
    public static void main(String[] args) {
        YamlController yamlController = new YamlController();
        Semester semester;

        semester = yamlController.readYamlSchedule("Test.yaml");
        System.out.println(semester.getSemesterName());
        System.out.println(semester.getCourses().get(0).getSubmissions().get(2).getSubmissionName())    ;
    }
}