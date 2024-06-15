/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import static data.Monkey.RECEPTIVE;
import java.util.Random;

/*
bác thợ săn ko có dây dưa hay huyết thống với bọn khỉ , bọn ngựa 
bác ko phỉa anh em của bọn nó , bác là chủ , còn bọn nó là nô lệ
và thức ăn nên khoogn về chung 1 nhà được , ko nhận cha con được
bác chỉ đơn giản là muốn vô lớp học thôi
 */
public class Hunter implements StudyEnthusiasts{ 
    private String name ;
    private int yob ;
    private double weight;
    private String gear ;
    // vì bác mãi nhìn phò mã nên kém tập trung
    public static final double REPCEPTIVE = 50 ;

    public Hunter(String name, int yob, double weight, String gear) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
        this.gear = gear;
    }
   
    public double study(){
        return new Random().nextDouble() * RECEPTIVE;
    }

    
    public void showLearningOutComes() {
        String str = String.format("%-20s|%-20s|%4s|%6.2f|%6.2f|%s", 
                                    "Hunter",name,yob,weight,study(),gear);
        System.out.println(str);
    }

    @Override
    public double studyHard() {
        return study() * 1.5 ;
    }

    @Override
    public void showProfile() {
        String str = String.format("%-20s|%-20s|%4s|%6.2f|%6.2f|%s", 
                                    "Hunter",name,yob,weight,studyHard(),gear);
        System.out.println(str);
    }
}
