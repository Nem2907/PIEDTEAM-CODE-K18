
package data;


public class Square extends Rectangle{
    private double edge ; 

    public Square(double edge , String color) {
        super(edge, edge, color);
    }
    
    @Override
    public void paint(){
        String str = String.format("Square   |%5.2f|%5.2f|%5.2f|%5.2f| %-10s", 
                                    width,height,getArea(),getPerimeter(),color);
        System.out.println(str);
    }
}
