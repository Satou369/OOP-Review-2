package Model;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUAN LY SINH VIEN =====");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Sua sinh vien");
            System.out.println("4. In danh sach");
            System.out.println("5. In danh sach sinh vien theo lop");
            System.out.println("6. In danh sach sinh vien theo nganh");
            System.out.println("7. In danh sach sinh vien sap xep theo diem TB");
            System.out.println("8. In danh sach sinh vien theo thang sinh");
            System.out.println("0. Thoat");
            System.out.print("Chon: ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1 -> themSinhVienUI();
                case 2 -> xoaSinhVienUI();
                case 3 -> suaSinhVienUI();
                case 4 -> manager.inDanhSach();
                case 0 -> { System.out.println("Ket thuc."); return; }
                case 5 -> {
                    System.out.print("Nhap lop: ");
                    String lop = sc.nextLine();
                    manager.inTheoLop(lop);
                }
                case 6 -> {
                    System.out.print("Nhap nganh (CNTT/KTPM): ");
                    String nganh = sc.nextLine();
                    manager.inTheoNganh(nganh);
                }
                case 7 -> {
                    System.out.println("Danh sach sap xep theo diem TB:");
                    manager.inSapXepTheoDiem();
                }
                case 8 -> {
                    System.out.print("Nhap thang sinh (1-12): ");
                    int month = Integer.parseInt(sc.nextLine());
                    manager.inTheoThangSinh(month);
                }
                default -> System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private static void themSinhVienUI() {
        System.out.print("Ma SV: ");
        String id = sc.nextLine();
        System.out.print("Ho ten: ");
        String name = sc.nextLine();
        System.out.print("Ngay sinh (yyyy-MM-dd): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());
        System.out.print("Nganh: ");
        String major = sc.nextLine();
        System.out.print("Diem TB: ");
        double gpa = Double.parseDouble(sc.nextLine());
        System.out.print("Lop sinh hoat: ");
        String classroom = sc.nextLine();

        Student s = new Student(id, name, dob, major, gpa, classroom);
        manager.themSinhVien(s);
        System.out.println("Da them!");
    }

    private static void xoaSinhVienUI() {
        System.out.print("Nhap ma SV can xoa: ");
        String id = sc.nextLine();
        if (manager.xoaSinhVien(id))
            System.out.println("Da xoa!");
        else
            System.out.println("Khong tim thay!");
    }

    private static void suaSinhVienUI() {
        System.out.print("Nhap ma SV can sua: ");
        String id = sc.nextLine();
        System.out.print("Ho ten moi: ");
        String name = sc.nextLine();
        System.out.print("Ngay sinh moi (yyyy-MM-dd): ");
        LocalDate dob = LocalDate.parse(sc.nextLine());
        System.out.print("Nganh moi: ");
        String major = sc.nextLine();
        System.out.print("Diem TB moi: ");
        double gpa = Double.parseDouble(sc.nextLine());
        System.out.print("Lop sinh hoat moi: ");
        String classroom = sc.nextLine();

        if (manager.suaSinhVien(id, name, dob, major, gpa, classroom))
            System.out.println("Da cap nhat!");
        else
            System.out.println("Khong tim thay!");
    }
}
