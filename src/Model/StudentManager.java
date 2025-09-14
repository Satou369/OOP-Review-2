package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    // Them
    public void themSinhVien(Student s) {
        students.add(s);
    }

    // Xoa
    public boolean xoaSinhVien(String id) {
        return students.removeIf(s -> s.getId().equals(id));
    }

    // Sua
    public boolean suaSinhVien(String id, String name, LocalDate dob,
                               String major, double gpa, String classroom) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                s.setName(name);
                s.setDob(dob);
                s.setMajor(major);
                s.setGpa(gpa);
                s.setClassroom(classroom);
                return true;
            }
        }
        return false;
    }

    // In toan bo danh sach
    public void inDanhSach() {
        if (students.isEmpty()) {
            System.out.println("Danh sach trong!");
            return;
        }
        students.forEach(System.out::println);
    }

    // In theo lop sinh hoat
    public void inTheoLop(String lop) {
        boolean found = false;
        for (Student s : students) {
            if (s.getClassroom().equalsIgnoreCase(lop)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("Khong co sinh vien nao trong lop " + lop);
    }

    // In theo nganh
    public void inTheoNganh(String nganh) {
        boolean found = false;
        for (Student s : students) {
            if (s.getMajor().equalsIgnoreCase(nganh)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("Khong co sinh vien nao thuoc nganh " + nganh);
    }

    // In sap xep theo diem TB
    public void inSapXepTheoDiem() {
        students.stream()
                .sorted(Comparator.comparingDouble(Student::getGpa).reversed())
                .forEach(System.out::println);
    }

    // In sinh vien theo thang sinh
    public void inTheoThangSinh(int month) {
        boolean found = false;
        for (Student s : students) {
            if (s.getDob().getMonthValue() == month) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("Khong co sinh vien nao sinh vao thang " + month);
    }
}
