
package runtime;

import data.Disk;
import data.Rectangle;
import data.Shape;
import data.Square;

/*
    Bé Na muốn quản lý hình vuông , hình tròn , hình chữ nhật , hình tam giác
    mà muốn quản lý đống đó  thì phải bỏ chúng vào cùng 1 mảng
    nhưng muốn vào cùng 1 mảng thì phải chứng minh nó cùng 1 loại 
    vậy nên ta cùng nhau chứng minh
*/
public class Program {

  
    public static void main(String[] args) {
        // tảo mảng để lưu tất cả các hình học
        Shape ds[]= new Shape[5];
        ds[0] = new Disk("Tía", "Tím", 2.0);
        ds[1] = new Rectangle("Hường", "Hồng", 2, 3);
        ds[2] = new Square("Anh Sáu", "Green ", 5);
        
        Disk d1 = new Disk("Lam", "Blue", 7);
        ds[3] = d1 ;
        
        /*
muốn tạo ra một object thì ta cần chuẩn bị cái gì ?
        1 - cái khuôn - class
        2 - cái phễu - constructor
        3 - biến con trỏ : Disk d1 = new Disk("Lam", "Blue", 7);
        Dog chiquaqua = new Dog(?,?,?);
        gọi cái phễu Dog bỏ nguyên liệu vào , để rót vào các ngăn của 
        khuôn tạo thành đối tượng Dog , sau đó đưa cho chiquaqua điều khiển
    nếu anh có class con thì object đucợ tạo ra có giống như trên ko ? 
        --> vẫn như v
        vd : Square sq1 = new Square(?,?,?);
    Tuy nhiên , nếu mình nhìn nhậ vào sâu bên trong vùng nhớ của class con
    ta sẽ thấy rằng 
        vùng new Con sẽ chứa vùng new Cha (thông qua Super)
    ý nghĩa :
        +giúp thằng con có tất cả những gì cha có
        +bản thân thằng con vốn có thể sống độc lập , nhưng vì nhận vha nên
        đưa cho cha những phần chung , kế thừa là cách nó khôi phục lại trạng
        thái như lúc chưa thừa kế
        +thừa hưởng những gì người khác đã làm tốt rồi
        
        Square = new Square();
                    new Rectangle() + hàm của riêng con
        con = new cha   +    code của riêng con
              inherit           
              super           extends(vùng biến dị)
              kế thừa
              di truyền
        
        object được tạo từ abstract class thì sao ?
        con = new cha + code riêng con + code vá lỗ 
        
        
        
        
        
        mình hiểu rằng
        abstract class là một cái khuôn bị thủng  
        muốn tạo object thì phải thông qua 1 class trung gian 
        cụ thể là rectangle , Square , Disk
        
        nếu muốn tạo object từ abstract class mà ko thông qua 
        1 class trung gian vì lười , ko biết biết đặt tên gì
        ko dám nói tên , thì có thể sử dụng kỹ thuật anonymous  
                                                      :mượn gió bé măng
        anonymous : là ko thông qua class , dùng abstract class 
        vừa đổ giá trị , vừa vá lỗ
        
        
        ưu điểm : ko cần class trung gian , ko cần đặt tên , làm thủ công
                  + nhanh gọn
        
        nhược điểm : ko nhân bản được , phải copy
        
        Dùng khi nào ?
        
        --> khi nào có một object ko có tên cụ thể nhma lại có cùng đặc điểm
        khung mình tạo để có dễ dàng gọi tên
        
        */
        
        Shape xxx = new Shape("Bé Na", "7Color") {
            @Override
            public double getPerimeter() {
                return 50;
            }
            
            @Override
            public double getArea() {
                return 15 ;
            }
            
            @Override
            public void paint() {
                 String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|", 
                                    "xxx",owner,color,getPerimeter(),getArea());
                System.out.println(str);
            }
        }; // vì từ chỗ khai báo xxx đến đây là câu lệnh
        
        ds[4] = xxx;
        
        for (Shape iteam : ds) {
            iteam.paint();
        }
        
        
        
 
       //Parse type : ép kiểu
       
        Rectangle r1 = new Rectangle("r1","Vàng", 10, 23);
        //r1 ko phải là rectangle , r1 là con trỏ để chỉ vào vùng nhớ để sài
        // và điểu kiểm r1 ở trong Rectangle
        r1.paint(); // Rectangle|...|...
        
        Square s1 = new Square("s1", "Tím", 15);
        s1.paint();// Square|...|...|...
        //r1.drawTiltle : r1 ko được sài hàm của riêng Square
        s1.drawTilte();// sài bình thường
        // hình vuông cũng chính là hình chữ nhật
        // Vậy nếu anh có 1 hình vuông , xong anh nói nó là hình chữ nhật
        // em có đồng ý ko ? ==> có
        
        Rectangle r2 = new Square("r2", "Đỏ", 4);
        //Rectangle r2 = new Square("r2", "Đỏ", 4); 
        // r2 sẽ ko sài đc những hàm riêng của square vì chỉ có thể
        // sử dụng trong vùng nhớ Rectangle
        // nên là không thể sử dụng được method drawTiltle
        r2.paint();//Square|...|...|
        Square tmp = (Square)r2 ;
        //Cách để parse type
        tmp.drawTilte();
        //Hoặc có thể viết :
        ((Square)r2).drawTilte();
        
        
        
        
    }
    
}
