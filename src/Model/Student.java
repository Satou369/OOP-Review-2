package Model;

import java.time.LocalDate;

public class Student {
    private String id;
    private String name;
    private LocalDate dob;
    private String major;
    private double gpa;
    private String classroom;

    public Student(String id, String name, LocalDate dob, String major, double gpa, String classroom) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.major = major;
        this.gpa = gpa;
        this.classroom = classroom;
    }

    // Getter & Setter
    public String getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDob() { return dob; }
    public String getMajor() { return major; }
    public double getGpa() { return gpa; }
    public String getClassroom() { return classroom; }

    public void setName(String name) { this.name = name; }
    public void setDob(LocalDate dob) { this.dob = dob; }
    public void setMajor(String major) { this.major = major; }
    public void setGpa(double gpa) { this.gpa = gpa; }
    public void setClassroom(String classroom) { this.classroom = classroom; }

    @Override
    public String toString() {
        return String.format("%s | %s | %s | %s | %.2f | %s",
                id, name, dob, major, gpa, classroom);
    }
}
