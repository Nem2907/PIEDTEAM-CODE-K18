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
public class Rectangle {
    protected double height ;
    protected double width;
    protected String color ;

    public Rectangle(double height, double width, String color) {
        this.height = height;
        this.width = width;
        this.color = color;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }
    
    public double getPerimeter(){
        return (height + width)*2 ;
    }
    public double getArea(){
        return  height * width ;
    }
    public void paint(){
        String str = String.format("Rectangle|%5.2f|%5.2f|%5.2f|%5.2f| %-10s", 
                                    width,height,getArea(),getPerimeter(),color);
        System.out.println(str);
    }
   
    
}
