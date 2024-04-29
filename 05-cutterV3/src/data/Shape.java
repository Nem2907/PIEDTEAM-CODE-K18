
package data;
/*
    Shape là cha của mọi loại hình học
    bản chất các hình : tròn , vuông , hình chữ nhật  ,...
    có thể tồn tạo độc lập mà k cần nhận cha con
    nhưng như vậy thì chúng sẽ ko về 1 nhà được(mảng)
    --> ko quản lý được
vậy nên chúng mới tìm và tạo ra một ra một tk cha để chứng minh
mình có cùng 1 chủng loại và về chung 1 mảng
nhớ rằng cha sẽ cho con tất cả những gì cha có
nên cha chỉ lưu những điể chung của các con
nếu cha lưu 1 đặc tính riêng của con nào đó(radius)
thì các thằng con còn lại đều sử hữu radius -> vô lý 

*/

public abstract class Shape {
    //lưu dặc tính chung của các con
    protected String owner ;
    protected String color ;
    // theo chuẩn thì phải để private để ko chỉnh sửa
    // còn nếu cần thì phải setter

    public Shape(String owner, String color) {
        this.owner = owner;
        this.color = color;
    }
    
    // getter

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }
    // get chi vi
     public abstract double getPerimeter();
     
     public abstract double getArea();
     
     public abstract void paint();
}
/*
Câu hỏi phỏng vấn :
1 : tại sao ko viết công thức cho chu vi ?
--> vì ko có công thức chung nào , nếu bỏ vào 1 công thức 
    thì các hình khác phải sài chung , ko phải hình cũng đúng

2: tại sao Shape là class vậy ?
--> vì nó có class Method
  
3: abs methoud là gì
--> là một method ko được định nghĩa(k có body), giống như 1 lỗ thủng

mà class là một cái khuôn , 1 class mà chứa abs method thì nó là 
một cái khuôn bị thủng

abstract class bản thân là 1 cái khuôn bị thủng  -> ko đúc đc object

vậy abstract cần làm gì ?
 sẽ tìm 1 class con của nó và nhó thnagwr tk con vá cho mình những lỗ 
thủng đó , nếu vá đc thì con sẽ ko đúc ra ngoài object

còn nếu vá k được hoặc là vá ko đủ thì thằng con sẽ trở thành abs class
và chờ một thằng class cháu vá

    public abstract double getPerimeter();
     
     public abstract double getArea();
     
     public abstract void paint();

abs class Shap
    abs double getPerimeter();
    abs double getArea();
    abs void paint();
abs class Rectanle extends Shape{
    double getPerimeter() (r+d)*2
}
*/