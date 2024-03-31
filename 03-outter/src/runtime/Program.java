
package runtime;

import data.RightTriangle;
import data.Triangle;


public class Program {
    public static void main(String[] args) {
        Triangle t1 = new  Triangle(3, 4, 6);
        t1.showInfo();
        
        RightTriangle r1 = new RightTriangle(3, 9);
        r1.showInfo();
    }
    
}
