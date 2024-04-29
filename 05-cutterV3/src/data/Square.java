
package data;


public class Square extends Rectangle{

    public Square(String owner, String color, double edge) {
        super(owner, color, edge , edge);
    }
     public void paint() {
        String str = String.format("%15s|%10s|%10s|%5.2f|%5.2f|%5.2f|%5.2f|",
                                    "Square",owner,color,width,height,getPerimeter(),getArea());
        System.out.println(str);
    }
    public void drawTilte(){
        System.out.println("Ahihihi");
    }
     
}
