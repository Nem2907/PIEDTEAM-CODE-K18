//quản lý các hình chừ nhật và hình vuông
package runtinme;

import data.Rectangle;
import data.Square;

public class Program {
    public static void main(String[] args) {
        Square sq1 = new Square(5, "Béo");
        Rectangle re1 = new Rectangle(2, 3, "Trắng");
        Rectangle re2 = new Square(7, "Đỏ");
        // Square sq2 = new Rectangle(3, 7, "Chàm");
        // khai cha new cha thì bithg
        // khai cha new con thì vẫn bình thường
        // Không được khai con new cha
        Square ds[] = new Square[3];     
        Rectangle ds1[] = new Rectangle[3];
        ds1[0] = sq1 ;
        ds1[1] = re1 ;
        ds1[2] = re2 ;
        
        /*
            duyệt danh sách và kêu từng đứa một
            for(int i = 0 ; i <= ds1.length - 1 ;i++){
                ds[i].paint();
            }
        */
        for (Rectangle rectangle : ds1) {
            rectangle.paint();
        }
    }
    
}
