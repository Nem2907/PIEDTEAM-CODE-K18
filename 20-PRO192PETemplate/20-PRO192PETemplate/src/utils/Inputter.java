package utils;

import java.util.Scanner;

/*

Inputter là class, cái khuôn 
nhưng anh ko thích dùng inputter để đúc ra object 
mà anh dùng Inputter để lưu những hàm tiện ích hỗ trợ cho việc
nhập

nhưng trong java thì lại ko có hàm
*/
public class Inputter {
    //props
    public static Scanner sc = new Scanner(System.in);
    //những method ép người dùng nhập số nguyên
    
    //1. method ép người dùng nhập số nguyên
    public static int getAnInteger(String inpMsg , String errMsg){
        System.out.println(inpMsg);// hiển thị lời mời
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                return number ;
            } catch (Exception e) {
                System.out.println(errMsg);// hiển thị câu chửi
            }
        }
    }
    //2. method ép người dùng nhập số nguyên chuẩn nhưng phải trong khoảng
      public static int getAnInteger(String inpMsg , String errMsg ,
                                     int upperBound, int lowerBound){
        // dành cho người vô tri nhập ngu
            if (lowerBound > upperBound) {
                int tmp = lowerBound ;
                lowerBound = upperBound ;
                upperBound = tmp ;
            }
            
        System.out.println(inpMsg);// hiển thị lời mời
        while(true){
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number ;
            } catch (Exception e) {
                System.out.println(errMsg);// hiển thị câu chửi
            }
        }
    }
      
    //3. method ép người dùng nhập số thực
    public static double getADouble(String inpMsg , String errMsg){
        System.out.println(inpMsg);// hiển thị lời mời
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                return number ;
            } catch (Exception e) {
                System.out.println(errMsg);// hiển thị câu chửi
            }
        }
    }
    //4. method ép người dùng nhập số thực chuẩn nhưng phải trong khoảng
      public static double getADouble(String inpMsg , String errMsg ,
                                     double upperBound, double lowerBound){
        // dành cho người vô tri nhập ngu
            if (lowerBound > upperBound) {
                double tmp = lowerBound ;
                lowerBound = upperBound ;
                upperBound = tmp ;
            }
            
        System.out.println(inpMsg);// hiển thị lời mời
        while(true){
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number < lowerBound || number > upperBound) {
                    throw new Exception();
                }
                return number ;
            } catch (Exception e) {
                System.out.println(errMsg);// hiển thị câu chửi
            }
        }
    }
    //5. Hàm nhập chuỗi cấm để trống
    
    public static String getString(String inpMsg , String errMsg){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if (str.isEmpty()) {
                    throw new Exception();
                }
                return str ;
            } catch (Exception e) {
                System.out.println(errMsg);// câu chửi
            }
        }
    }
    
    //6. Hàm nhập chuỗi cấm để trống và phải giống format(regex)  
    public static String getString(String inpMsg , String errMsg,String regex){
        System.out.println(inpMsg);
        while(true){
            try {
                String str = sc.nextLine();
                if (str.isEmpty() || !str.matches(regex)) {
                    throw new Exception();
                }
                return str ;
            } catch (Exception e) {
                System.out.println(errMsg);// câu chửi
            }
        }
    }
     
}
//Làm thử : Hàm nhập ngày tháng năm theo format
//f( "Nhập ngày tháng năm nha: " ,"ngu" ,"DD-MM-YYYY" , "YYYY-MM-DD");
//compareDate