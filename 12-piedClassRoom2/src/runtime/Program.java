package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
import data.StudyEnthusiasts;
import java.util.ArrayList;

/*
Ôn bài 
bối cảnh: mình có nhiệm vụ phổ cập kiến thức
cho muôn loài mà đánh trọng tâm vào vùng hoang
dã
buổi học đầu tiên mình gặp toàn những con dễ thương : ngựa , khỉ


*/
public class Program {
    public static void main(String[] args) {
       Monkey m1 = new Monkey("Rafiki",1998, 210);// The lion king
       Monkey m2 = new Monkey("Abu", 1999 , 30);//Aladin
       Horse h1 = new Horse("Rarity", 2015, 9, "none");
       Herbivore h2 = new Horse("Roach", 2019 , 170 , "Grey");
       
        
        Hunter hun1 = new Hunter("Tay săn vượn", 1999 , 0, "Nỏ");//Lép Tôn Xtoi
        // tạo mảng chứa những người ham học
        ArrayList<StudyEnthusiasts> stuList = new ArrayList<>();
        
        stuList.add(h1);
        stuList.add((Horse)h2); // vì h2 đc tạo bởi Herbibore nhưng new = horse nên là phải ép kiểu
        stuList.add(hun1);
        //hôm nay mọi người học hành rất chăm chỉ , thì có một lười(Sloth)
        //bước vào lớp, tưởng là bạn mới , nhưng hóa ra là con chùm kín mít
        // giờ anh muốn lưu trữ nó thì sao ?
        
        //có 3 cách
        //1. Dùng annoymous với Herbivore để tạo ra nó như bài trước(sai)
        // vì nếu mà để vào Herbivore thì ko có bỏ vào stuList 
         
        //2. tạo class Sloth và cho Sloth implentment vào studyEnthusiasts
        // và dùng khuôn đó đúc ra bạn học viên này (sai)
        // vì tất cả con lười trên thế giới đều sẽ ham học ==> vô lý
        //con lười của em nó quá đặc biệt so với giống loài với nó
        // nó đặc biệt tới nỗi biến thành 1 loài mới ko biết tên
        // ==>3. sử dụng annoymours nhưng với StudyEnthusiasts vì nó vượt ra giống loài mới
        
        StudyEnthusiasts xxx = new StudyEnthusiasts() {
           @Override
           public double studyHard() {
               return 80 * 1.5 ;
           }

           @Override
           public void showProfile() {
               String str = String.format("%-20s|%-20s|%4s|%6.2f|%6.2f", 
                                    "Sloth","Flash",1999,120F,studyHard());
               System.out.println(str);
           }
       };
        stuList.add(xxx);
        
    }
}
