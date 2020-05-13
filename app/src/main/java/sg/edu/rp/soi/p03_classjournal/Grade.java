package sg.edu.rp.soi.p03_classjournal;

public class Grade {
    private String Grade;
    private String moduleCode;
    private int week;

    public String getGrade() {
        return Grade;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getWeek() {
        return week;
    }

    public Grade(String Grade, String moduleCode, int week) {
        this.Grade = Grade;
        this.moduleCode = moduleCode;
        this.week = week;
    }
}

