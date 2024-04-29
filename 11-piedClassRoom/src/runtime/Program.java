package runtime;

import data.Herbivore;
import data.Horse;
import data.Hunter;
import data.Monkey;
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
       // h2 ko có getSaddle vì nó đc tạo bởi Herbivore
       //((Horse)h2).getColorSaddle();// ép kiểu
       
       //tạo mảng lưu hết tất cả các học viên
       ArrayList<Herbivore> stuList = new ArrayList<>();
       stuList.add(m1);
       stuList.add(m2);
       stuList.add(h1);
       stuList.add(h2);
       
        for (Herbivore student : stuList) {
            student.showLearningOutComes();
        }
        /*
        Thêm bối cacnhr : hôm đó đang học , trời lạnh cóng 
        mọi người trong lớp co ro , thì có một con vật chậm chậm
        bước vào lớp , vì trời lạnh nên con vật này mặc đồ chùm 
        kín mình , không đoán được là con gì , nó ăn cỏ nên mình
        tin rằng nó là đv ăn cỏ
        nhưng k đoán được là con gì , tui muốn lưu con này vào 
        danh sach học viên của tui thì phải làm sao ?
        */
        // solution ==> annoymous
        
        Herbivore xxx = new Herbivore("Con chậm chạp", 2024 , 4) {
            @Override
            public double study() {
                return 80;
            }
            
            @Override
            public void showLearningOutComes() {
                String str = String.format("%-20s|%-20s|%4s|%6.2f|%6.2f", 
                                    "xxx",name,yob,weight,study());
                System.out.println(str);
            }
        };
        stuList.add(xxx);
        /*
        thêm bối cảnh : lớp học đang tập trung thì lại có 1 bạn mới vào
        làm cả lớp sôi động , đó là 1 bác sợ săn
        bác nói rằng bác đến vì bác ham học , muốn gia nhập vào lớp học
        vậy tui cần lưu trữ được bác thợ săn
        */
        
        Hunter hun1 = new Hunter("Tay săn vượn", 1999 , 0, "Nỏ");//Lép Tôn Xtoi
        Hunter hun2 = new Hunter("Mắt diều hâu ", 1999 , 0, "Cung");//
        hun1.showLearningOutComes();
        hun2.showLearningOutComes();
        //tuy in ra mượt nhưng ngựa , khỉ và bác thơ săn thì ko nằm cùng mảng
        // chúng khác nhau quả nhiều về mặt sinh học , càng ko phải là anh em   
        //đôi khi ta phải nhét những đối tượng  k có điểm chung về mặt sinh học
        // vào chung 1 mảng như thế này ,nhưng trong java luôn có cách để đưa
        // chúng về với nhu , chỉ cần có 1 điểm điểm chung là đủ .
        // thì điểm chung ở đây ko nằm ở thuộc tính mà là sự đam mê học tập
    }
}
