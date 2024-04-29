package data;

import java.util.Random;

public class Monkey extends Herbivore{

    public Monkey(String name, int yob, double weight) {
        super(name, yob, weight);
    }
    public static final double RECEPTIVE = 70 ;
    
    @Override
    public double study(){
        return new Random().nextDouble() * RECEPTIVE;
    }

    @Override
    public void showLearningOutComes() {
        String str = String.format("%-20s|%-20s|%4s|%6.2f|%6.2f", 
                                    "Monkey",name,yob,weight,study());
        System.out.println(str);
    }
    
}
