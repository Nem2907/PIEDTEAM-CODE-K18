/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author hoang
 */
public class RightTriangle extends Triangle{
    
    public RightTriangle(double edgesA, double edgesB) {
        super(edgesA, edgesB, Math.sqrt(edgesA*edgesA + edgesB*edgesB));
    }
    // super : new Cha();
    
    public void showInfor(){
        String str = String.format("RightTriangle|%5.2f|%5.2f|%5.2f|%5.2f|%5.2f",
                                                  edgesA,edgesB,edgesC,getPermiter(),getArea());
        System.out.println(str);
    }
    /*
    
    public void showInfor(){
        String str = String.format("RightTriangle|%5.2f|%5.2f|%5.2f|%5.2f|%5.2f",
                                                  getEdgesA(),getEdgesB(),getEdgesC(),getPermiter(),getArea());
    }
    nếu các để ở private
    */
}
//chúng ta có 2 class cha và class con
//hỏi?  object của cha to hơn hay object của con to hơn . Trả lời : con
//vì con kế thừa tất cả của cha và nó còn mở rộng bằng mấy cái hàm độ
//hàm riêng
//nguyên tắc bất hiếu: cha cho con hết những gì cha có.
//con thì không, và con còn có những hàm riêng
// Override : vượt mặt
// chỉ xuất hiện trong mối quan hệ "cha con - kế thừa - is a"
// khi mà thằng con độ lại hàm của thằng cha
// tạo ra 1 hàm mới cùng tên với hàm của cha khác para hoặc body

// overload : ko quan tâm mối quan hệ
// khi má method này trùng tên với method khác
// nhưng khác nhau về para và body