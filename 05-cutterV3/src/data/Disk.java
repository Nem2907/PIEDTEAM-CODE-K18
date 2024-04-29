
package data;


public class Disk extends Shape{
    private double radius ;
    public static final double PI = 3.14 ;

    public Disk( String owner, String color , double radius) {
        super(owner, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getPerimeter() {
        return 2*radius*PI ;
    }

    @Override
    public double getArea() {
        return PI*Math.pow(radius, 2);
    }

    @Override
    public void paint() {
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f|", 
                                    "Disk",owner,color,radius,getPerimeter(),getArea());
        System.out.println(str);
    }
    
    
}
