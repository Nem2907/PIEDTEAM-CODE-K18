
package runtime;

import java.util.StringTokenizer;

public class Program {
    public static void main(String[] args) {
     
         //cho mình 1 cái classs tên là String
         String lastName = new String("Điệp");
         String tmp = lastName; // tmp tham chiếu LastName
         String firstName = "Lê" ;
         // String la 1 object immutable mọi thao tác , mọi hành động tương tác
         // với Sring sẽ ko làm string thay đổi mà nó sẽ tạo là biến mới
         lastName = lastName.concat(firstName);
         System.out.println("lastName  "+lastName);
         System.out.println("tmp " +tmp);
                 
         //StringBuffer , StringBuilder 
         //2 thằng này là chuỗi nhưng lại mutable 
         // mutable : là object có thể chỉnh sửa được
         StringBuilder lastName2 = new StringBuilder("Điệp");
         StringBuilder tmp2 = lastName2;
         StringBuilder firstName2 = new StringBuilder("Lê");
         lastName2.append(firstName2);// nối
         
         System.out.println("lastName  "+ lastName2);
         System.out.println("tmp " +tmp2);
         //điểm khác : StringBuilder : khi có bị thay đổi thì nang cx bị 
         // thay đổi theo
         
         //StringTokenizer : làm split
         String information = "SE123|Điệp Đẹp Trai|2004|9.9";
         StringTokenizer st = new StringTokenizer(information,"|");
         System.out.println(st.countTokens());//đem xem có bao nhiêu khúc
         System.out.println(st.hasMoreTokens());//còn chặt được ko ? T or F
         
         while(st.hasMoreTokens()){
             System.out.println(st.nextToken());
         }
         System.out.println(information);
         
              
        }
    public static void checkStringMethod(){
        // khi fung method với str thì phỉa để ý return
        // vì String là immuable nên methoad của nó thuongfwf return
        // 1 string kết quả
        String str1 = "Điệp";
        String str3 = "Lê";
        str1 = str1.concat(str2);
        System.out.println("str 1 nè "+ str1);
                
    }

}
