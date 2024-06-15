/*
StudentV1 : là một cía khuôn chuyên đúc ra các sinh viên có tính ganh đua, đố kỵ
Comparable : tính đố kỵ
nó cũng chỉ là interface có duy nhất một method là compareTo()

sinh viên bình thường, tham gia vào hội "những người thích đố kỵ" thì sẽ được
thừa hưởng 1 ý chí "thích so sánh bản thân với người khác"(comparable)
*/
package data;
public class StudentV2 implements Comparable<StudentV2>{
    private String id ;
    private String fname ;
    private String lname ;
    private double score ;
    //constructor
    public StudentV2(String id, String fname, String lname, double score) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.score = score;
    }


    public StudentV2() {
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

    @Override
    public int compareTo(StudentV2 that ) {
        if(this.getId().compareTo(that.getId()) > 0){
            return 1 ;
        }
        return -1 ;
    }
    
    
}
