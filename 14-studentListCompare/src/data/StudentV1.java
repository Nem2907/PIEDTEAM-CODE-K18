/*
StudentV1 : là một fcais khuôn chuyên đúc ra các sinh viên bình thường
không hề có tính ganh đua, đố kỵ
*/
package data;
public class StudentV1 {
    private String id ;
    private String fname ;
    private String lname ;
    private double score ;
    //constructor
    public StudentV1(String id, String fname, String lname, double score) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.score = score;
    }


    public StudentV1() {
    }
    //getter
    public String getId() {
        return id;
    }
    //show
    public void showInFor(){
        String str = String.format("%-15s|%-20s|%-20s|%5.2f",
                                    id,fname,lname,score);
        System.out.println(str);
    }
    
    
}
