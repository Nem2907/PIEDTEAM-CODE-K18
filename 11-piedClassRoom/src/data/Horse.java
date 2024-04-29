package data;
//Horse : khi mà Horse kế thừa Herbivore 
// điều đó có nghĩa là gì ?

import java.util.Random;

//  + khôi phục lại trạng thái như trước khi có ch
//  + thừa hưởng những gì mà cha đã có
//     ( cha cho con hết những gì đã có )
//  + không cần làm lại những gì người đi trước đã 
//    làm tốt rồi , chỉ cần thừa hưởng thôi
public class Horse extends Herbivore{
    //Prop riêng
    private String colorSaddle;
    // ngựa thì vừa học vừa hú hí nên khả năng tiếp 
    // thu kém xem như là 30%
    public static final double RECEPTIVE = 30 ; // khả năng tiếp thu = 30
    //constructor
    public Horse(String name, int yob, double weight, String colorSaddle) {
        super(name, yob, weight);
        this.colorSaddle = colorSaddle;
    }// super = new Cha ==> new Herbivore(name,yob,weight)
    //getter

    public String getColorSaddle() {
        return colorSaddle;
    }
    
    //khả năng tiếp thu của loài ngựa là 30 
    // nhưng ko phải con ngựa nào cũng đạt đến 30 cả
    @Override
    public double study() {
        Random anhNgau = new Random();
        return anhNgau.nextDouble() * 30;
        //trong nextGaussian pseudorandom : sự ngẫu nhiên nhân tạo
        //
    }

    @Override
    public void showLearningOutComes() {
       String str = String.format("%-20s|%-20s|%4s|%6.2f|%6.2f|%s", 
                                    "Horse",name,yob,weight,study(),colorSaddle);
        System.out.println(str);
    }
    
}
