
package data;

import java.util.Scanner;


public class Book {
    private String bookName ;
    private String createAt ;
    private String nickName;//tên của tác giả
    // construtor
    //phễu rỗng
    public Book() {
    }

    public Book(String bookName, String createAt, String nickName) {
        this.bookName = bookName;
        this.createAt = createAt;
        this.nickName = nickName;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getNickName() {
        return nickName;
    }

   public void inputInfor(){
       Scanner sc = new Scanner(System.in);
       System.out.println("Tên sách :");
       this.bookName = sc.nextLine();
       
       System.out.println("Ngày tạo ");
       this.createAt = sc.nextLine();
       
       System.out.println("Tác giả của cuốn sách");
       this.nickName = sc.nextLine();
       
   }
   
   public void showInfor(){
       System.out.printf("%-40s|%-15s|%s\n",bookName,createAt,nickName);
   }
  
    
    
}
/*
Book
    bookName createAt nickName
    tạo có đối số và k có đồi số
    tạo getter anh setter
    tạo hàm input//nếu mà sách này có tác giả mà 
    có tên trong danh sách tác giả thì bỏ qua
    nếu tác giả của cuốn sách mà chưa có tồn tại trong ds
    thì thêm mới
*/