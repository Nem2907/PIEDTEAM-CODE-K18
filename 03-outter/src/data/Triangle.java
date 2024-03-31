/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

public class Triangle {
    protected double edgesA ;
    protected double edgesB ;
    protected double edgesC ;
    //private double perimeter = edgeA + edgeB + edgeC;
    //không nên tạo thuộc tính là diện tích và chu vi
    //1. nếu mà mình tạo ra nó thì cần gắn getter và setter
    //nếu có setter thì ngta có thể chỉnh giá trị lại
    //2.diện tích hay chu vi có thể tự tính bằng 3 cạnh rồi
    // nên mình nên tự làm, còn để người dùng nhập vào thì nó nhập sai
    //=> mình chỉ cần viết hàm get để lấy giá trị thay vì lưu
    //cái phêu: constructor

    public Triangle(double edgesA, double edgesB, double edgesC) {
        this.edgesA = edgesA;
        this.edgesB = edgesB;
        this.edgesC = edgesC;
    }

    public double getEdgesA() {
        return edgesA;
    }

    public double getEdgesB() {
        return edgesB;
    }

    public double getEdgesC() {
        return edgesC;
    }
    // hàm lấy chu vi
    public double getPermiter(){
        return edgesA + edgesB + edgesC ; 
    }
    // hàm lấy diện tích
    public double getArea(){
        double p = getPermiter()/2 ;
        return Math.sqrt(p * (p-edgesA) * (p-edgesB) * (p-edgesC));
    }
    
    public void showInfo(){
        String str = String.format("Triangle     |%5.2f|%5.2f|%5.2f|%5.2f|%5.2f",
                                                  edgesA , edgesB , edgesC , getPermiter() , getArea());
            System.out.println(str);
    }
}
