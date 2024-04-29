
package data;
/*
    Rectangle kế thừa cha để lấy lại những gì nó đã 
    gửi lệnh cho ổng , giúp nó khôi phục lại trạng
    thái bạn đầu như chưa có kế thừa
0. tạo class con
1. khai báo đặc tính của riêng con
2. cho con nhận cha "extends Shape"
3. tạo phễu 
4. làm phần việc mà cha giao cho nếu có
    bổ sung code các abs method của cha ( vá lỗ)
    độ lại hàm của cha nếu ko phù hợp
    thêm những hàm riêng của con nếu có

*/

public class Rectangle extends Shape{
    protected double width ;
    protected double height ;
    // constructor
    public Rectangle(String owner, String color , double width , double height) {
        super(owner, color); // phải đặt super ở đầu 
        this.width = width;
        this.height = height;
    }
    // super : new Cha => new Shape
    // super phải là câu lệnh đầu tiên của cái phễ con

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    
    @Override
    public double getPerimeter() {
        return (width+height)*2;
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public void paint() {
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f|%5.2f|",
                                    "Rectangle",owner, color,width,height,getPerimeter(),getArea());
        System.out.println(str);
    }
}
