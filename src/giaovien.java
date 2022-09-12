import java.util.List;

public class giaovien extends person {
    private String thanhTich;

    public giaovien(String name, int age, String address, String thanhTich) {
        super(name, address, age);
        this.thanhTich = thanhTich;
    }

    public giaovien() {};
    // getter
    public String getThanhTich() {return thanhTich;}
    // setter
    public void setThanhTich(String thanhTich) {this.thanhTich = thanhTich;}
    // method
    public String luong() {
        if (thanhTich.toLowerCase().equals("xuat sac")) {return "60 cu";}
        if (thanhTich.toLowerCase().equals("tot")) {return "35 cu";}
        if (thanhTich.toLowerCase().equals("binh thuong")) {return "10 cu";}
        return "Ko luong";
    }

    @Override
    public void display() {
        super.display();
        System.out.format("%-12s %-1s\n", thanhTich, luong());
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

