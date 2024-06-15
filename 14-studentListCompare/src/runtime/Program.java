/*
mình có thể so sánh object bằng cách nào ? 
== : so sánh về mặt địa chỉ của object
.equalTo() : boolean
.compareTo() : int
2 cái trên đc dùng cho Wrapper Class và String
String là object có dạng immuntal


nếu mà đối tượng so sánh là Sinh viên thì điều này sẽ khó hơn rất nhiều 
Vì sao ?
Vì sinh Viên được miêu tả = rất nhiều thuộc tính , nên khi mình nói về việc so sánh
sinh viên ,thì mình nên chọn ra 1 thuộc tính để làm tiêu chuẩn 
để mà dễ dàng so sánh hơn

vậy thì nếu như là Wrapper Class và String thì cứ thông thả dùng .equalTo()
.compartTo()

nhưng nếu phải só sánh 2 đối tượng phức tạp thì phải quy về String , hoặc primitive


Cơ chế của Sort
comparable : tính đố kị                  comparator : anh trọng tài

*/
package runtime;

import data.StudentV1;
import data.StudentV2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Program
{
    public static void main(String[] args) {
       //sortV1();
       sortV2();
    }
    public static void sortV1() {//build 
        //tạo ra danh sách sinh viên
        ArrayList<StudentV1> stuList = new ArrayList<>();
        stuList.add(new StudentV1("SE001", "Lê", "An", 8.2));
        stuList.add(new StudentV1("SE005", "Nguyễn", "Bình", 7));
        stuList.add(new StudentV1("SE002", "Lý", "Cường", 9));
        stuList.add(new StudentV1("SE004", "Trần", "Dũng", 5));
        stuList.add(new StudentV1("SE003", "Võ", "Em", 9.9));
        /*
        Phân tích :
        ta có hàm SortV1() : mình sẽ sort danh sách sinh viên bình thường
        cụ thể : thông qua việc sử dụng comparator, vì studentV1 sẽ tạo ra các
        sinh viên không có tính đố kỵ , nên mình sẽ tạo ra một anh trọng tài
        giúp mình so sánh , từ đó đưa ra kết quả sắp xếp 
        - compartor là gì ? 
            + về mặt đời sống , hiểu biết : comparator là một người đứng ra xem xét
            2 đối tượng dựa trên 1 tiêu chí nào đó , từ đó cho kết quả 1(lớn) và -1(bé)
            + về mặt lý thuyết : comparator là một interface có 1 method duy nhất 
            cụ thể là compare(t1,t2), tức là ảnh biết ảnh phải so sánh t1 và t2 
            (là 2 đối tượng bất kỳ),nhưng ko biết so sánh làm sao và cần chúng
            ta implement cách so sánh
        
        - sau khi mình tạo được anh trọng tài , thì mình sẽ bỏ anh trọng tài vào
        trong cái stuList của mình , ảnh sẽ tự so sánh và từ đó sort thành công
        --> thông qua collections.sort()
        
        */
        // lưu ý là phải có dấu <> vì nếu ko có thì máy tính sẽ mặc định là
        // object bình thường ==> ko có đối tượng cụ thể ==> ko so sánh được
        Comparator ordByID = new Comparator<StudentV1>() {
            @Override
            public int compare(StudentV1 t1, StudentV1 t2) {
                if(t1.getId().compareTo(t2.getId()) > 0){
                    return 1; // nói rằng t1 lớn hơn t2
                }
                return -1 ; // nói rằng t1 bé hơn t2
            }
        };
        //Collections là một class chứa rất nhiều method giúp xử lý nhiều danh sách
        //nhưng những danh sách đó phải thuộc Collections thì mới đc xài
        //ArrayList là một thằng thuộc Collection
        Collections.sort(stuList, ordByID);
        // in ra xem
        for (StudentV1 item : stuList) {
            item.showInFor();
        }
    }
    
    public static void sortV2(){
         ArrayList<StudentV2> stuList = new ArrayList<>();
        stuList.add(new StudentV2("SE001", "Lê", "An", 8.2));
        stuList.add(new StudentV2("SE005", "Nguyễn", "Bình", 7));
        stuList.add(new StudentV2("SE002", "Lý", "Cường", 9));
        stuList.add(new StudentV2("SE004", "Trần", "Dũng", 5));
        stuList.add(new StudentV2("SE003", "Võ", "Em", 9.9));
        
        // lần này stuList chứa toàn StudentV2 là 1 đám sinh viên có 
        // tính đố kỵ , và chúng nó thì k cần đến trọng tài
        Collections.sort(stuList);
        
        for (StudentV2 item : stuList) {
            item.showInFor();
        }
    }
}