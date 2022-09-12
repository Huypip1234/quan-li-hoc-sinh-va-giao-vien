import java.util.List;

public class sinhvien extends person {
    private double gpa;

    public sinhvien(String name, int age, String address, double gpa) {
        super(name, address, age);
        this.gpa = gpa;
    }
    public sinhvien() {};

    // getter
    public double getGpa() {return gpa;}
    // setter
    public void setGpa(double gpa) {this.gpa = gpa;}
    // method
    public String hocLuc() {
        if (gpa < 5) {return "Trung binh";}
        if (gpa > 5 && gpa < 8) {return "Kha";}
        if (gpa > 8) {return "Gioi";}
        return "";
    }

    @Override
    public void display() {
        super.display();
        System.out.format("%-5s %-1s\n", gpa, hocLuc());
    }
    public void showDanhSach(List<String>data, person obj, String format, String doiTuong, String doiTuong2, String function) {
        super.showDanhSach(data, obj, format, doiTuong, doiTuong2, function);
    }
    public void addPerson(List<String>data, String path_data, person obj, String doiTuong, String doiTuong2) {
        super.addPerson(data, path_data, obj, doiTuong, doiTuong2);
    }
    public void editPerson(List<String>data, String path_data, person obj, String doiTuong, String doiTuong2) {
        super.editPerson(data, path_data, obj, doiTuong, doiTuong2);
    }
}

