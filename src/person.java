import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class person {
    private String name, address;
    private int age;

    public person(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public person() {}
    // getter
    public String getName() {return name;}
    public String getAddress() {return address;}
    public int getAge() {return age;}
    // setter
    public void setName(String name) {this.name = name;}
    public void setAddress(String address) {this.address = address;}
    public void setAge(int age) {this.age = age;}
    // display
    public void display() {System.out.format("%-16s %-4s %-11s", name, age, address);}
    // method
    public void showDanhSach(List<String>data, person obj, String format, String doiTuong, String doiTuong2, String function) {
        Scanner cin = new Scanner(System.in);
        while (true) {
            System.out.format("%-15s %-5s %-10s " + format + " %-1s\n",
            "HO TEN", "TUOI", "DIA CHI", doiTuong2.toUpperCase(), function.toUpperCase());
            for (int i = 0; i < data.size(); i++) {
                String each_person[] = data.get(i).split(";");
                if(doiTuong.equals("sinh vien")) {
                    obj = new sinhvien(each_person[0], Integer.valueOf(each_person[1]), each_person[2], Double.valueOf(each_person[3]));
                }
                if(doiTuong.equals("giao vien")) {
                    obj = new giaovien(each_person[0], Integer.valueOf(each_person[1]), each_person[2], each_person[3]);
                }
                obj.display();
            }
            system.showGach();
            system.quayLai();
            break;
        }
        //de xoa cai thong bao chet tiet
        int meow=1;
        if(meow==2) {cin.close();}
    }
    public void addPerson(List<String>data, String path_data, person obj, String doiTuong, String doiTuong2) {
        Scanner cin = new Scanner(System.in);
        String newPerson_add="", my_name="", my_age="", my_address="", my_doiTuong2="";

        System.out.println("THEM " + doiTuong.toUpperCase());
        System.out.println();
        //ten
        System.out.print("Nhap ten: ");
        my_name = cin.nextLine();
        //tuoi
        while(true) {
            Boolean check = true;
            System.out.print("Nhap tuoi: ");
            my_age = cin.next();
            for(int i=0; i<my_age.length(); i++) {
                if(my_age.charAt(i)<'0' || my_age.charAt(i)>'9') {system.showNhapSai(); check=false; break;}
            }
            if (check) {break;}
        }
        //dia chi
        System.out.print("Nhap dia chi: ");
        cin.nextLine();
        my_address = cin.nextLine();
        //doituong2
        if(doiTuong.equals("sinh vien")) {
            while(true) {
                System.out.print("Nhap " + doiTuong2 + ": ");
                my_doiTuong2 = cin.next();
                if(my_doiTuong2.length()<3) {system.showNhapSai(); continue;}
                if(my_doiTuong2.charAt(0)<'0' || my_doiTuong2.charAt(0)>'9') {system.showNhapSai(); continue;}
                if(my_doiTuong2.charAt(1)!='.') {system.showNhapSai(); continue;}
                boolean check2 = true;
                for(int i=2; i<my_doiTuong2.length(); i++) {
                    if(my_doiTuong2.charAt(i)<'0' || my_doiTuong2.charAt(i)>'9') {system.showNhapSai(); check2=false; break;}
                }
                if(check2) {break;}
            }
        } 
        if(doiTuong.equals("giao vien")) {
            System.out.print("Nhap " + doiTuong2 + ": ");
            my_doiTuong2 = cin.nextLine();
        }
        //gom lai
        newPerson_add = my_name + ";" + my_age + ";" + my_address + ";" + my_doiTuong2;
        //add vao data
        data.add(newPerson_add);
        //hien thi doi tuong vua them
        system.showGach();
        System.out.println();
        System.out.println(my_name + ", " + my_age + ", " + my_address + ", " + my_doiTuong2);
        //cap nhat (ghi file)
        system.writeFile(data, path_data);
        system.showGach();
        system.quayLai();
        //de xoa cai thong bao chet tiet
        int meow=1;
        if(meow==2) {cin.close();}
    }
    public void editPerson(List<String>data, String path_data, person obj, String doiTuong, String doiTuong2) {
        Scanner cin = new Scanner(System.in);
        boolean findSuccess=false;
        int index=0;
        System.out.println("SUA THONG TIN");
        System.out.println();
        System.out.println("Nhap ten day du " + doiTuong + " can sua: ");
        String name = cin.nextLine();
    
        for(int i=0; i<data.size(); i++) {
            String[] arr = data.get(i).split(";");
            if(name.toLowerCase().equals(arr[0].toLowerCase())) {
                findSuccess=true;
                system.showGach();
                System.out.println("Ten: " + arr[0]);
                System.out.println("Tuoi: " + arr[1]);
                System.out.println("Dia chi: " + arr[2]);
                System.out.println(doiTuong2+ ": " + arr[3]);
                System.out.println();
                index = i;
                break;
            }
        }
        if(findSuccess) {
            //show lua chon
            while(true) {
                system.showLuaChonSua(doiTuong2);
                String check = cin.next();
                if(check.equals("5")) {break;}
                else if(check.equals("1")) {
                    System.out.print("Nhap ten moi: ");
                    cin.nextLine();
                    String newName = cin.nextLine();
                    system.capNhatSauEdit(data, index, 0, path_data, newName);
                }
                else if(check.equals("2")) {
                    String newAge;
                    while(true) {
                        Boolean check2 = true;
                        System.out.print("Nhap tuoi moi: ");
                        newAge = cin.next();
                        for(int i=0; i<newAge.length(); i++) {
                            if(newAge.charAt(i)<'0' || newAge.charAt(i)>'9') {system.showNhapSai(); check2=false; break;}
                        }
                        if (check2) {break;}
                    }
                    system.capNhatSauEdit(data, index, 1, path_data, newAge);
                }
                else if(check.equals("3")) {
                    System.out.print("Nhap dia chi moi: ");
                    cin.nextLine();
                    String  newAddress = cin.nextLine();
                    system.capNhatSauEdit(data, index, 2, path_data, newAddress);
                }
                else if(check.equals("4")) {
                    System.out.print("Nhap " + doiTuong2 + " moi: ");
                    String newDoituong2="";
                    if(doiTuong.equals("sinh vien")) {
                        while(true) {
                            newDoituong2 = cin.next();
                            if(newDoituong2.length()<3) {system.showNhapSai(); continue;}
                            if(newDoituong2.charAt(0)<'0' || newDoituong2.charAt(0)>'9') {system.showNhapSai(); continue;}
                            if(newDoituong2.charAt(1)!='.') {system.showNhapSai(); continue;}
                            boolean check2 = true;
                            for(int i=2; i<newDoituong2.length(); i++) {
                                if(newDoituong2.charAt(i)<'0' || newDoituong2.charAt(i)>'9') {system.showNhapSai(); check2=false; break;}
                            }
                            if(check2) {break;}
                        }
                    } 
                    if(doiTuong.equals("giao vien")) {
                        cin.nextLine();
                        newDoituong2 = cin.nextLine();
                    }
                    system.capNhatSauEdit(data, index, 3, path_data, newDoituong2);
                }
                else {system.showNhapSai(); continue;}
            }
        }
        else {
            System.out.println("Khum tim thay!");
            system.quayLai();
        }
        int meow=1;
        if(meow==2) {cin.close();}
    }
    public void deletePerson(List<String>data, String path_data, String doiTuong, String doiTuong2) {
        Scanner cin = new Scanner(System.in);
        //nhap ten 
        boolean findSuccess=false; int index=0;
        System.out.println("Nhap ten day du " + doiTuong + " can xoa: ");
        String name = cin.nextLine();
        //hien thi
        for(int i=0; i<data.size(); i++) {
            String[] arr = data.get(i).split(";");
            if(name.toLowerCase().equals(arr[0].toLowerCase())) {
                findSuccess=true;
                system.showGach();
                System.out.println("Ten: " + arr[0]);
                System.out.println("Tuoi: " + arr[1]);
                System.out.println("Dia chi: " + arr[2]);
                System.out.println(doiTuong2+ ": " + arr[3]);
                System.out.println();
                index = i;
                break;
            }
        }
        //xac nhan
        if(findSuccess) {
            while(true) {
                System.out.println("Xac nhan xoa? (Y/N)");
                char xacNhan = cin.next().charAt(0);
                if(xacNhan=='Y' || xacNhan=='y') {
                    //delete data[i];
                    data.remove(index);
                    //cap nhat;
                    system.writeFile(data, path_data);
                    system.showGach();
                    system.quayLai();
                    break;
                }
                if(xacNhan=='N' || xacNhan=='n') {
                    System.out.println("Xoa that bai!");
                    system.quayLai();
                    break;
                }
                else {system.showNhapSai();}
            }
        }
        else {
            System.out.println("Khum tim thay!");
            system.quayLai();
        }
        int meow=1;
        if(meow==2) {cin.close();}
    }
    public void sortByName(List<String>data, String path_data, String doiTuong, String doiTuong2) {
        Collections.sort(data);
        System.out.println("Sap xep thanh cong");
        system.writeFile(data, path_data);
        system.showGach();
        system.quayLai();
    }
    public void sortByDoiTuong2(List<String>data, String path_data, String doiTuong, String doiTuong2) {
        if(doiTuong.equals("sinh vien")) {
            //chuyen cai gpa len dau
            system.daoViTri(data);
            //sort len
            Collections.sort(data);
            //chuyen lai nhu cu
            system.daoViTri(data);
        }
        if(doiTuong.equals("giao vien")) {
            List<String>data_binhThuong = new ArrayList<>();
            List<String>data_tot = new ArrayList<>();
            List<String>data_xuatSac = new ArrayList<>();
            List<String>data_khac = new ArrayList<>();
            for(int i=0; i<data.size(); i++) {
                String[] arr = data.get(i).split(";");
                if(arr[3].toLowerCase().equals("binh thuong")) {
                    String arr_string = String.join(";", arr);
                    data_binhThuong.add(arr_string);
                }
                else if(arr[3].toLowerCase().equals("tot")) {
                    String arr_string = String.join(";", arr);
                    data_tot.add(arr_string);
                }
                else if(arr[3].toLowerCase().equals("xuat sac")) {
                    String arr_string = String.join(";", arr);
                    data_xuatSac.add(arr_string);
                }
                else {
                    String arr_string = String.join(";", arr);
                    data_khac.add(arr_string);
                }
            }
            //xoa het list cu
            data.clear();
            //noi 4 cai lai
            data.addAll(data_binhThuong);
            data.addAll(data_tot);
            data.addAll(data_xuatSac);
            data.addAll(data_khac);
        }
        //cap nhat
        System.out.println("Sap xep thanh cong");
        system.writeFile(data, path_data);
        system.showGach();
        system.quayLai();
    }
}

