package sg.edu.rp.c346.p03;

public class Grade {
    private int week;
    private String grade;
    private String module;
    public Grade(int week, String grade, String module) {
        this.week = week;
        this.grade = grade;
        this.module = module;
    }
    public int getWeek() {
        return week;
    }
    public String getGrade() {
        return grade;
    }
    public String getModule(){
        return module;
    }

}
