package runtime;
//luyện = giỏi

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
         // 1 - Regex
        // Regular expression | pattern | Biểu thức chính quy
        String str = "SE1245678";
        String regex ="^[Ss][Ee]\\d{7}$";
        
        
        // học viết
        //1. Phân biệt hoa thường : (?i) : i cho ignore 
        // chỉ có ở java , ko có ở javastrict
        checkString("name", "name");
        
        checkString("nAme","name");
        
        checkString("NaMe", "(?i)name");
        //2.1 ký tự đặc bất kỳ trừ dấu enter :
        checkString("may", "m.y");
        
        checkString("mOy", "m.y");
        
        
        // dấu . đại diện cho tất cả ký tự trừ dấu chấm
          
        //3. lập lại từ 0 đến nhiều lần : * hoặc {0.n} , n cho số lần lặp lại
        // {3} : lâp lại 3 lần
        // {2,4} : lập lại từ 2 -> 4
        // {3,} : từ 3 lần trở lên
        // {0,} :  * từ ko lần trở lên
        // {1,1} : + từ 1 trở lên
        // (0,1):  ?  từ 0 - 1 lần , có hoặc ko
        checkString("", regex);
        checkString("mererery", ",(re)I");
        
        checkString("mey", "m[^ewry]"); //false
        //mey|mwy|mry false
        //còn lại true hết
        //[a-z]  : 1 ký tự trong khoảng a-z
        //[A-Z]  : 1 ký tự trong khoảng A-Z
        //[A-Za-z]: 1 chữ hoa hoặc thường đều đc
        //[0-9]  : 1 chữ số
        
        // shorthand : viết tắt
        // \w :[A-Za-z0-9] ,   \W là phủ định
        // \d : [0-9]      ,   \D là phủ định
        // \s : space      ,   \S là phủ định
        
        // Custom Error
        // error complalation : lỗi phát sinh trong quá trình biên dịch 
        // error runtime : lỗi phát sinh trong quá trình vận hành 
        
        // Scanner : class chứa các method liên quan đến việc nhập giá trị
        
        Scanner sc = new Scanner(System.in);
        // Scanner sc = new Scanner(file); nhận vào giá trị trong file
        int age ;
        try{
            System.out.println("Nhập tuổi đi em :");
            age = sc.nextInt();
            if(age < 10 || age > 30){
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Ngu");
        }
            
      
        
        //
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    } 
    
    public static void checkString(String str, String regex){
       
        
        System.out.println(str.matches(regex));
    }
    
}
/*
Bài tập về nhà 
    regex về tiền tệ : 100.000.000 VND
    regex cho email
*/