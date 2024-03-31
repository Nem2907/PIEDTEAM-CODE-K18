    
package runtime;

import data.Star;


public class Program {
    public static void main(String[] args) {
        Star mpt = new Star("Sơn Tùng MTP ", 1994, 
                            "Nam", "Nơi này có anh");
        // new Star : là gọi cái phễu Star
        mpt.showInfor();
        
        Star chiPu = new Star("Huyền Chi ", 1993, "Nữ", "Chiếc ố");
        chiPu.showInfor();
    }
}























/*
Modifier : bộ nghĩa 
    1 - access  modifier
       + public : phạm vi truy cập rộng nhất, gọi ở đâu cũng được , ai cũng nhìn
                thấy
       + private : phạm vi truy cập thấp nhất, ko ai truy cập được , chỉ có
                mình nó xài được
       + default : trong cùng package ai cũng có thể truy cập được nó
       
       + protected :  giống public nhưng chỉ truy cập bởi đám con

vd : 
    pks runtime 
        class Program
    pks data
        public class Student
        private class Car
        class Bike

Program : thấy Student          | ai thấy nó : ko ai
Student : thấy được Bike        | ai thấy nó : Program , Car , Bike
Car : thấy được Student , Bike  | ai thấy nó : ko ai
Bike : thấy được Student        | ai thấy nó : Car , Student


vd protected :
class có khả năng kế thừa , nhận cha con
--> biến những biến từ protected thành public cho class con của nó

    class Hai{
        protected People Bà_Nội ;
    }

    class Tuan extend Hai{
        protected int money = 1000 ;
    }
    
    class Hung extends Tuan{
        protected People Người_Yêu ;
    }
    Hải là cha của Tuấn
    Tuấn là cha của Hùng


    Hải thừa hưởng  :  ko              có : ko có
    Tuấn thừa hưởng :  Hải             có : Bà Nội
    Hải thừa hưởng  :  Tuấn            có : tiền và Bà Nội


    * : Quy tắc bất hiếu : cha cho con hết những gì cha có , còn con
    thì ko cho cha cái gì cả
     class là gì ?
     Nguyên tắc quản lý : ta phải đứa mọi thứ về cùng một mảng thì mới quản lý được
     Nhung mảng chỉ chơi với những đứa cùng kiểu 

--> ta bốc ra 2 dối tượng (object) bất kỳ và tìm kiếm điểm chung của nó từ điểm
chung này ta suy luận ra được bộ khung(Class)
nên chúng ta là 1 nhà , cùng 1 loại , cùng 1 khung tạo ra , về cùng 1 mảng 

    2 - non-access modifier
    + final : áp dụng cho class , properties , method 
        - class: ko nhận con , nhưng vẫn tạo object
        - properties : hằng số
        - method : cho kế thừa nhưng ko được override 
    + static :tĩnh lặng , đứng yên , ko xê dịch :
        - prop , method mà ko có static thì nghĩa là các object ko được nhân bản
          mà phải xài chung với nhau
          lúc này prop và methoud đó là của Class
    + abstract  : trừu tượng
        -
    +



Ví dụ : 
    * final + class
    class thì có cơ chế :
        1 - nhận 1 class khác làm con của nó
        2 - tạo ra object

    câu hỏi : Vậy 1 class bị final thì bị sao ?
        thì nó vẫn tạo object (vì đây là công việc của nó)
        nhưng nó ko nhận class khác là con của nó được

    class Hai{
        protected People Bà_Nội ;
    }

    class Tuan extend Hai{
        protected int money = 1000 ;
    }
    
    final class Hung extends Tuan{
        protected People Người_Yêu ;
    }
    
    * final + properties  : thuộc tính , bản chất cũng chỉ là cái biến 
                          bình thường
    final int yob 
    yob ko đucợ chỉnh giá trị nữa --> hằng số
    
    * final method 
    // ví dụ về việc việc bán trà sữa   

    class Cha{
        protected methoud : nấu trà sữa{
            bỏ đường , sữa , than tre ;
        }
    }

    class con Extended Cha{
        @override
        protected method : nấu trà sữa{
            bỏ đường , sữa , than tre ;
            đường hóa học , ma tóe 
        }
    }
    
    Cha.nấu trà sữa()
    Con.nấu trà sữa()

    thời của con thì người tiêu dùng thích rẻ 
    thằng con dựa vào hàm nấu trà sữa của cha mà độ lại 
    chế ra hàm nấu trà sữa của riêng  nó
    vậy thì thằng cha có : 1 cách nấu trà sữa và không nấu được giống
    con vì quy tắc bất hiếu
    vậy thì thằng con có : 2 cách nấu trà sữa và nó dùng cách nó độ

    class Cha{
        protected final methoud : nấu trà sữa{
            bỏ đường , sữa , than tre ;
        }
    }

    class con Extended Cha{
        @override
        protected method : nấu trà sữa{
            bỏ đường , sữa , than tre ;
            đường hóa học , ma tóe 
        }
    }
    
    final ở hàm cha : phiên bản cuối cùng , thì con vẫn kế thừa method 
    nhưng mà ko được override ( dộ hoặc tạo ra cách dùng trà sữa mới )
    --> vẫn cho kế thừa nhưng mà ko thể override 
    
vd : abstract : trừu tượng
abstrct class Cha{
        abstract methoud : Thành công()
        abstract methoud : ăn trứng()
        abstract methoud : yêu()
    }
thành công là một định nghĩa rất khó để viết ra , mỗi người mỗi nghĩa khác nhau 
   

1 class có những abstract method nó class đó là abstract class
nhưng 1 abstract class thì ko nhất thiết phải có abstract method
*/