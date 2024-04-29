package runtime;

import data.Author;
import data.Book;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        ArrayList<Author> auList = new ArrayList<>();
        ArrayList<Book> boList = new ArrayList<>();
        
        initData(auList, boList);// nạp giá trị vào 2 cuốn sách
        
        int choose ; 
        
        Scanner sc = new Scanner(System.in);
        
        do{
            showMenu();
            System.out.println("Vui lòng nhập lựa chọn :");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1 :{
                    System.out.println("Thêm 1 cuốn sách");
                    Book newBook = new Book();
                    newBook.inputInfor();//nhập vào bookName,createAt , nickName
                    //phải kiểm tra xem tác giả của cuốn sách này đã lưu chưa
                    
                    boolean isFind = false ;
                    for (Author author: auList) {
                        if(author.getNickname().equals(newBook.getNickName())){
                            isFind = true ;
                        }
                    }
                    if(!isFind){
                        Author newAuthor = new Author(newBook.getNickName());
                        newAuthor.inputInfor();
                        auList.add(newAuthor);      
                    }
                    break;
                }
                 case 2:{
                     System.out.println("In ra danh sách các cuốn sách");
                     boolean isFind = false ;
                     for (Book book : boList) {
                         book.showInfor();
                     }
                     if(!isFind){
                         System.out.println("Ko có cuốn sách");
                     }
                    break;
                }
                 case 3 :{
                     System.out.println("Thêm mới 1 tác giả");
                     Author newAuthor = new Author();
                     newAuthor.inputInfor(auList);
                     auList.add(newAuthor);
                    break;
                }
                 case 4 :{
                     System.out.println("Tìm sách theo bút danh");
                     System.out.println("Nhập bút danh của tác giả cần tìm kiếm");
                    String keyID = sc.nextLine();
                    // duyệt danh sách các cuốn sách , tìm sách nào có nick name trên
                   
                    boolean isFind = false;
                     for (Book book : boList) {
                         if(book.getNickName().equals(keyID)){
                              book.showInfor();
                              isFind = true; 
                         }
                     }
                     if(!isFind){
                         System.out.println("Không tìm được cuốn sách nào");
                     }
                    
                    break;
                }
                 case 5 :{
                     System.out.println("Hẹn gặp lại");
                    break;
                } 
                 default:{
                     System.out.println("Phải nhập từ 1 - 5");
                 }
            }
        }while(choose != 5);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }   
    //hàm nạp sẳn giá trị cho auList và bolist
    public static void initData(ArrayList<Author> auList ,
                                ArrayList<Book> boList){
        //nạp giá trị cho auList
       
        auList.add(new Author("Ngoo Kiến Huy ", "Huy Quan Hoa", 1999));
        auList.add(new Author("Nguyen Thuy Chi ", "ChiPu", 1994));
        auList.add(new Author("Le Muoi Diep", "UncleTen", 1999));
        //thêm mấy cuốn sách
        
        boList.add(new Book("Mãi mãi là hết tiền", "16-4-2024", "Huy Quan Hoa"));
        boList.add(new Book("Đừng làm mọi thứ phức tạp", "16-4-2024", "ChiPu"));
        boList.add(new Book("Dạy người giàu giả nghèo", "16-4-2024", "UncleTen"));
         
    }
    
    public static void showMenu(){
        System.out.println("1.Nhập thông tin sách in ra màn hình");
        System.out.println("2.Hiển thị thông tin sách ra màn hình");
        System.out.println("3.Nhập thông tin tác giả");
        System.out.println("4.Tìm kiếm sách theo bút danh");
        System.out.println("5.Thoát");
        
        
    }
}
/*
tạo chương trình quản lý thư viện
gồm 2 class sau
Author
    name nickname old birthday;
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