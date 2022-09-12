//29-08-2022
//SAU NAY:
//+ them thuoc tinh Id (random id khi them sinh vien, sua thong tin bang tim kiem id).
//+ tra cuu thong tin bang ten.

//util
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Entry {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<String>data = new ArrayList<>(); //khai bao data sinh vien
        String path_data="", doiTuong="", doiTuong2="", function="", format="";

        person obj;

        //xu li
        while(true) {
            system.showbatDau();
            String check=cin.next();
            system.showGach();
            if(check.equals("4")) {break;} 
            //sinh vien
            else if(check.equals("1")) {
                //doc file
                path_data = "data/data_sv.txt";
                data = system.readFile(path_data);
                doiTuong="sinh vien"; 
                doiTuong2="GPA"; function="HOC LUC";
                format="%-5s";
                obj = new sinhvien();
            }
            //giao vien
            else if(check.equals("2")) {
                //doc file
                path_data = "data/data_gv.txt";
                data = system.readFile(path_data);
                doiTuong="giao vien"; 
                doiTuong2="thanh tich"; function="luong";
                format="%-12s";
                obj = new giaovien();
            }
            //tuy bien them
            else if(check.equals("3")) {
                System.out.println();
                System.out.println("Tinh dang dang phat trien!");
                system.quayLai();
                continue;
            }
            else {system.showNhapSai(); continue;}
            
            system.mainProcess(data, path_data, obj, format, doiTuong, doiTuong2, function);

        }
        //end loop here
        cin.close();
    }
}

