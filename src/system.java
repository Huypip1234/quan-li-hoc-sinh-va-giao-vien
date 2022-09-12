import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class system {
    // doc file
    public static List<String> readFile(String fileName) {
        List<String> data_list = new ArrayList<>();
        try {
            // luu duong dan file data vao doi tuong path
            Path path = Path.of(fileName); // path = data.txt;
            // doc file data (moi dong la 1 thanh phan cua list)
            data_list = Files.readAllLines(path); // tham so la 1 object
        } catch (IOException e) {
            System.out.println("Loi cmnr: " + e);
        }
        return data_list;
    }

    // ghi file
    public static void writeFile(List<String> data_list, String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName);
            for (int i = 0; i < data_list.size(); i++) {
                fw.write(data_list.get(i) + "\r\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Loi cmnr: " + e);
        }
        System.out.println("Da cap nhat!");
    }

    // hien thi
    public static void showbatDau() {
        System.out.println("1) Quan li sinh vien");
        System.out.println("2) Quan li giao vien");
        System.out.println("3) Tuy bien them");
        System.out.println("4) Thoat");
        System.out.print("Moi ban chon: ");
    }

    public static void showNhapSai() {
        System.out.println();
        System.out.println("NHAP KO DUNG!");
    }

    public static void showGach() {
        System.out.println("______________________");
    }

    public static void showQuaylai() {
        System.out.println();
        System.out.print("Nhan Q de quay lai:");
    }

    public static void showChonTinhNang(String doiTuong, String doiTuong2) {
        System.out.println("1) Hien thi danh sach " + doiTuong);
        System.out.println("2) Them " + doiTuong + " khac");
        System.out.println("3) Sua ten/tuoi/dia chi/" + doiTuong2);
        System.out.println("4) Xoa " + doiTuong);
        System.out.println("5) Sap xep "+ doiTuong +" theo ten");
        System.out.println("6) Sap xep " + doiTuong + " theo " + doiTuong2);
        System.out.println("7) Tro lai");
        System.out.print("Moi ban chon: ");
    }

    public static void showLuaChonSua(String doiTuong2) {
        System.out.println("1) Sua ten") ;
        System.out.println("2) Sua tuoi") ;
        System.out.println("3) Sua dia chi") ;
        System.out.println("4) Sua " + doiTuong2) ;
        System.out.println("5) Tro lai");
        System.out.print("Moi ban chon: ");
        System.out.println();
    }

    public static void quayLai() {
        Scanner cin = new Scanner(System.in);
        while(true) {
            system.showQuaylai();
            char check2 = cin.next().charAt(0);
            system.showGach();
            if(check2=='q' || check2=='Q') {break;}
            else {system.showNhapSai();}
        }
        //de xoa cai thong bao chet tiet
        int meow=1;
        if(meow==2) {cin.close();}
    }

    public static void capNhatSauEdit(List<String>data, int index_data, int index2, String path_data, String newProperty) {
        //luu vao mang
        String[] arr_person = data.get(index_data).split(";");
        arr_person[index2] = newProperty;
        //cho mang vao list
        String string_person = String.join(";", arr_person);
        data.set(index_data, string_person);
        //cap nhat data
        system.writeFile(data, path_data);
        system.showGach();
        system.quayLai();
    }

    public static void daoViTri(List<String>data) {
        for(int i=0; i<data.size(); i++) {
            String[] arr = data.get(i).split(";");
            String tmp=arr[0];
            arr[0]=arr[3];
            arr[3]=tmp;
            //cho vao list
            String string_arr = String.join(";", arr);
            data.set(i, string_arr);
        }
    }

    public static void mainProcess(List<String> data, String path_data, person obj, String format, String doiTuong, String doiTuong2, String function) {
        Scanner cin = new Scanner(System.in);
        while (true) {
            system.showChonTinhNang(doiTuong, doiTuong2);
            String check2 = cin.next();
            system.showGach();
            //xu li
            if(check2.equals("7")) {break;}
            else if(check2.equals("1")) {obj.showDanhSach(data, obj, format, doiTuong, doiTuong2, function);} 
            else if(check2.equals("2")) {obj.addPerson(data, path_data, obj, doiTuong, doiTuong2);}
            else if(check2.equals("3")) {obj.editPerson(data, path_data, obj, doiTuong, doiTuong2);}
            else if(check2.equals("4")) {obj.deletePerson(data, path_data, doiTuong, doiTuong2);}
            else if(check2.equals("5")) {obj.sortByName(data, path_data, doiTuong, doiTuong2);}
            else if(check2.equals("6")) {obj.sortByDoiTuong2(data, path_data, doiTuong, doiTuong2);}
            else {system.showNhapSai();}
            //end here
        }
        //de xoa cai thong bao chet tiet
        int meow=1;
        if(meow==2) {cin.close();}
    }
}

