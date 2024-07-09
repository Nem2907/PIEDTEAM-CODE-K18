
package ui;
//user interface

import java.util.ArrayList;
import utils.Inputter;

/*
menu là một cái khuôn chuyên đúc ra anh quản lý danh sách các option
có : danh sách các optionList
có : title , tên của menu
có : các method để giúp xử lý optionList`
addNewOption : thêm option vào optionList
print : in ra danh sách các option kèm số cho người dùng chọn
getChoice: thua thập lựa chọn của người dùng
*/
public class Menu {
    //danh sách các option
    public ArrayList<String> optionList = new ArrayList<>();
    public String title; // tên menu
    //constructor tạo menu bằng tên menu
    public Menu(String title){
        this.title = title ;
    }
    //addNewOption : hàm thêm option vào optionList
    public void addNewOption(String newOption){
        optionList.add(newOption);
    }
    //print : in ra danh sach
    public void print(){
        int count = 1 ;
        System.out.println("_______________" + title + "_______________");
        for (String op : optionList) {
            System.out.println(count + ". " +op);
            count++;
        }
    }
    
    //getChoice : hàm thu thập lựa chọn
    public int getChoice(){
        int choice = Inputter.getAnInteger("Input your choice ", 
                                            "Your choice must between 1 and "+ optionList.size(),1,
                                            optionList.size() -1);
        return choice;
    }
}
