
package data;
// đây là cái khuôn(class) chuyên đúc ra
// các ngôi sao , ca sĩ nổi tiếng(object)
// ca sĩ nào cũng bước ra từ cái khuôn này
public class Star {
    //properties-props-fields-atrtribute : thuộc tính
    
    //methoud : phương thức : hành động
    public String name ;
    public int yob ;
    public String gender ;
    public String hotSong ;
    //method function : phương thức : hành động
    //constructor : cái phễu : để hứng giá trị
    // phải public : thì mới lấy xài và đúc được
    // ko được quy định đầu ra
    // this : this là đại diện cho class chứa nó

    public Star(String name, int yob, String gender, String hotSong) {
        this.name = name;
        this.yob = yob;
        this.gender = gender;
        this.hotSong = hotSong;
    }

    

    
    public void showInfor(){
        System.out.println("Toi ten la "+ name +
                            " Toi la " + gender +
                            " Sinh nam " + yob +
                            " hotsong " + hotSong);
    }
    
}
