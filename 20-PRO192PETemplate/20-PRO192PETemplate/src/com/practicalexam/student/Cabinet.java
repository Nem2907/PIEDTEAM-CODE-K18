package com.practicalexam.student;

import com.practicalexam.student.data.Student;
import utils.Inputter;

/**
 *
 * @author FPT University - HCMC
 * Java OOP Practical Exam Template
 */




public class Cabinet {

    //StartList - do not remove this comment!!!
	int count = 0;
	Student ds[] = new Student[10];
    

    // Declare ArrayList or Array here
    
    //EndList - do not remove this comment!!!
    
    public void add() {
        // Print the object details after adding
    	//thu thập
    	boolean isDup ;
        String id ;
                do{
                    isDup = false ; 
                    id = Inputter.getString("Nhập mã sinh viên :", 
                                            "Mã sinh viên ko đúng");
                    isDup = checkDuplicatedId(id);//kiểm tra xem có trùng k
                    if(isDup){
                        System.out.println("Mã sinh viên bị trùng rồi");
                    }
                }while(isDup);
            String name = Inputter.getString("Nhập tên sinh viên ","Tên sinh viên cấm để trống !!");
            int point = Inputter.getAnInteger("Nhập điểm số của sinh viên", "Điểm số phải từ 0 đến 10",
                                                0, 10);
            //tạo
            Student nstudent = new Student(id, name, point);
            //nhét
            ds[count] = nstudent;
    	count++;
    	System.out.println("Danh sach sinh vien");
    	   for (int i = 0; i < count - 1; i++) {
               ds[i].Show();
            
        }
    }

    public boolean checkDuplicatedId(String id) {
        // Your code here
        for (int i = 0; i < count - 1; i++) {
            if(ds[i].getId().equals(id)){
                return true ;
            }
        }
        return false;
    }

    public void update() {
        // Print the object details after updating name/model and price
        String keyId = Inputter.getString("Nhap ma sinh vien can cap nhat", 
                                            "Ma sinh vien khong duoc de trong !!");
        //dùng keyid tìm pos
        int pos = -1 ;
        for (int i = 0; i < count -1 ; i++) {
            if(ds[i].getId().equals(keyId)){
                pos = i ;
            }
        }
        if(pos == -1){
            System.out.println("Ko có sinh viên này");
        }else{
            System.out.println("Thông tin sinh viên trước khi cập nhập");
            ds[pos].Show();
            System.out.println("Đang cập nhật");
           
        String nName = Inputter.getString("Nhập tên mới :", "Tên mới ko được để trống");
        int nPoint = Inputter.getAnInteger("Nhập điểm số mới :", "Điểm phải trong 0 và 10",0,10);
        //sets
        ds[pos].setName(nName);
        ds[pos].setPoint(nPoint);
            System.out.println("Cập nhật sinh viên thành công");
            for (int i = 0; i < count - 1; i++) {
               ds[i].Show();
            }
        }
    }

    public void search() {
        String keyId = Inputter.getString("Nhap ma sinh vien can cap nhat", 
                                            "Ma sinh vien khong duoc de trong !!");
        //dùng keyid tìm pos
        int pos = -1 ;
        for (int i = 0; i < count -1 ; i++) {
            if(ds[i].getId().equals(keyId)){
                pos = i ;
            }
        }
        if(pos == -1){
            System.out.println("Ko có sinh viên này");
        }else{            
            System.out.println("Thông tin sinh viên"); 
            ds[pos].Show();
        }
    }
    
    public void remove() {
        // Print the list after removing
        String keyId = Inputter.getString("Nhap ma sinh vien can xoa", 
                                            "Ma sinh vien khong duoc de trong !!");
        //dùng keyid tìm pos
        int pos = -1 ;
        for (int i = 0; i < count -1 ; i++) {
            if(ds[i].getId().equals(keyId)){
                pos = i ;
            }
        }
        if(pos == -1){
            System.out.println("Ko có sinh viên này");
        }else{
            System.out.println("Thông tin sinh viên"); 
            ds[pos].Show();
            for (int i = pos ; i <= count-1; i++) {
                ds[i] = ds[i+1];
            }
            count--;
            System.out.println("Xóa sinh viên thành công !!!");
            //in ra
            for (int i = 0; i < count - 1; i++) {
               ds[i].Show();
            }
        }
        
        
    }

    public void sort() {
        // Print the object details after sorting
    	   for (int i = 0; i < count - 2; i++) {
               for (int j = i+1; j < count - 1; j++) {
                   if(ds[i].getPoint() > ds[j].getPoint()){
                       //swap
                       Student tmp = ds[i];
                       ds[i] = ds[j];
                       ds[j] = tmp ;
                   }
               }
        }
           //in ra danh sách
           System.out.println("Danh sách học sinh");
           for (int i = 0; i < count - 1; i++) {
               ds[i].Show();
        }
    }
    
}
