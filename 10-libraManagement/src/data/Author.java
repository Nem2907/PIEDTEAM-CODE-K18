/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Author {
    private String nickname; 
    private String name ;
    private int yob ;
    //construtor
    // cái phễu rỗng
    public Author() {
    }

    public Author(String nickname, String name, int yob) {
        this.nickname = nickname;
        this.name = name;
        this.yob = yob;
    }

    public Author(String name) {
        this.name = name;
    }


    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    // hàm inputInfor() ko nhận hì cả chỉ nhận name và yob
    
    public void inputInfor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên của tác giả");
        this.name = sc.nextLine(); 
        
        System.out.println("Nhập tuổi của tác giả");
        this.yob = Integer.parseInt(sc.nextLine());
        
        
    }
//overload : inputInfor(auList) hàm nhập nhưng nhân thêm danh sách tác giả
//để cho việc kiểm tra nickname có ai dung chưa , hàm nhập nickname , name ,yob
    
    public void inputInfor(ArrayList<Author> auList){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập bút danh tác giả :");
        while(true){
            String inputNickname = sc.nextLine();
            boolean isDup = false ;
            for (Author author : auList) {
                if(author.getNickname().equals(inputNickname)){
                    isDup = true;
                }
            }
            if(!isDup){
                this.nickname = inputNickname;
                break;
            }
        }
        this.inputInfor(); // nhập name và yob bình thường
    } 
    
    public void showInfor(){
        System.out.printf("%-30s|%-30s|%5d\n",name,nickname,yob);
    }
}
/*
tạo chương trình quản lý thư viện
gồm 2 class sau
Author
    name nickname yob;
    tạo phểu hàm không đối số
    tạo phểu có đối số 
    tạo phểu có đối số là nickname
    tạo getter không tạo setter
    tạo hàm nhập thông tin tác giả
    nhưng nếu tác giả đã tồn tại trong danh sách thì k cho
    ép nhập lại
    tạo hàm showInfor
Book
    bookName createAt nickName
    tạo có đối số và k có đồi số
    tạo getter anh setter
    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
program:
    menu
    1.Nhập thông tin sách in ra màn hình
    2.Hiển thị thông tin sách ra màn hình
    3.Nhập thông tin tác giả
    4.Tìm kiếm sách theo bút danh
    5.Thoát
*/