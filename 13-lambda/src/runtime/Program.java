/*
1 file Java có thể chứa nhiều class
    tuy nhiên chỉ có một class được public và phải cùng tên với file

và đây là lý do interface nên có 1 method

đơn giản là nếu sài annoymous sài dài quá thì sài lambda để gọn hơn
*/
package runtime;
public class Program {
    public static void main(String[] args) {
        Human diep = () -> {//đây là lambda
            System.out.println("Ahihihi đồ chó ");
        };
        diep.show();
        
        Math ct = (int a , int b) ->(a+b);
    }
    //class B là inter
    class B{
            
    }    
}
// class A và Human được gọi là outter
class A{
    
}

@FunctionalInterface // annontation
interface Human{
    public void show();
    //public void showAhihi();
}// nếu có 2 method thì sẽ báo đỏ

interface Math{
    public int add(int a , int b);
}

