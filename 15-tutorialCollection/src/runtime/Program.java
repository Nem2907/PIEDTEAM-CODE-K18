package runtime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Program {
    public static void main(String[] args) {
        //playWithArrayList();//call
        playWithQueue();
    }
    public static void playWithArrayList(){//build
        /*
        Ghi nhớ :
        List thì có hàm get và set
        
        ArrayList là gì ? là một mảng đặc biệt , và là class triển khai cuat
        interface List(triển khai = implements)
        
        ArrayList rất giống array primitive(mảng cùi trong C)
        array primitive là mảng cố định ( ko có khả năng co giãn được)
        nhưng ArrayList là mảng động (có khả năng co giãn)
        */
        
        //ví dụ :  muốn lưu các số nguyên = mảng cùi
        
        int arrPrimitive[] = new int[10];// thiếu 10 là bug ngay
        //tạo ra mảng cùi có 10 phần tử mà thôi , muốn thêm cũng ko được
        // mà em muốn giảm cũng ko cho
        //arrPrimitive sẽ lưu được gì ? ==> primitive datatype
                                       // ngoài ra : object datatype(references datatype) : con trỏ
                                       // và cả wrapper và String
                                       
        // ArrayList : lại là mảng có khả năng co giãn , nhưng nó chỉ chơi được
        //              với object mà thôi
        ArrayList<Integer> arrIntList = new ArrayList<>();
                //dấu <> là generic : bổ nghĩa
        // các Collection ko chơi với primitive datatype
        // mà phải dùng wrapper las
        // ngoài ra em có thể khải báo như sau
        List<Integer> arrIntListV2 = new ArrayList<>();
        //khai cha new con
        //array primitive :  nhẹ , truy xuất nhanh
        //                   ko có giản đc ; thêm hoặc xóa cực
        
        //ArrayList :       nặng , truy xuất chậm
        //                  co giản đc , thêm và xóa nhanh
        
        
        // những method của ArrayList 
        //.add(value) : thêm value vào trong list
        arrIntList.add(new Integer(3));// ví mình lưu Integer chứ ko phải int
        arrIntList.add(new Integer(2));
        arrIntList.add(4);// vì đây là wrapper nên có cơ chế auto-boxing
        System.out.println(arrIntList);//vì Collection đã độ lại toString nên in như vậy cũng được
        //arrIntList [3 2 4]
        
        //.clear() : xóa sạch các phần tử
        arrIntList.clear();// xóa hết tất cả trong arrIntList
        //arrIntList []
        
        //.add(index,value) : 'nhét' value vào vị trí index trong list
        arrIntList.add(0, 3);// 3
        arrIntList.add(1, 5);// 3 5
        arrIntList.add(2, 4);// 3 5 4
        arrIntList.add(1, 4);// 3 4 4
        //arrIntList [3 4 4]
        arrIntListV2.add(9);
        arrIntListV2.add(12);
        //arrIntListV2 [9 12]
        
        // .addAll(index?,list) nhét list vào vị trí thứ index trong danh sách
        
        arrIntList.addAll(2,arrIntListV2);
        
        System.out.println(arrIntList);
        // nhét vòa vị trí thứ i (2) của danh sách (cụ thể làarrIntList )
        
        // biến mảng cùi thành mảng xịn
        Integer arrDemo[] = {3 , 5 , 7}; // tạo mảng cùi 3 phần tử
        // biến arrDemo thành mảng xịn
        // Arrays : là class chứa rất nhiều method giúp hỗ trợ cho array 
        // trong đó có : Arrays.asList(array) biến mảng cùi thành List(Collection)
        ArrayList<Integer> arrList = new ArrayList<>(Arrays.asList(arrDemo));
        //arrList là phiên bản arrayList của arrDemo
        //arrList sẽ co giãn được , nhưng truy xuất chậm
        
        //biến mảng xịn về thành mảng cùi
        //biến arrList thành mảng arrayPrimitive
        //1. Tạo mảng cùi để bỏ arrList vào
        Integer numList[] = new Integer[arrList.size()];
        // lấy size của mảng xịn để tạo array primitive , vì nó cần kích thước 
        // ban đầu lúc khởi tạo
        //2. nạp giá trị từ mảng xịn(arrList) vào mảng cùi (numList)
        //--> toArray(array) : truyền giá trị , sao chép giá trị của list vào array
        arrList.toArray(numList);// arrList đã truyền giá trị vào numList
        //3.in ra xem
        System.out.println(numList);//numList là mảng cùi nên chưa có độ .toString
        //nếu muốn in thì dùng for
        
        //.get(index):cho phép mình lấy ra phần tử ở vị trí index
        //arrList[3,5,7]
        // anh muốn lấy ra số 5 thì phải làm sao ?
        arrList.get(1); //số 5 ở vị trí 1
        System.out.println(arrList.get(1));
        //.set(index,value): 'gán' giá trị value vào giá trị index trong list
        //thay số 5 thành số 9 thì làm sao ?
        arrList.set(1, 9);
        
        //dùng get và set đổi chỗ của 3 và 7 trong list
        Integer i = arrList.get(0);// lưu 3
        arrList.set(0, arrList.get(2)); // thay số ở ví trị 0 là 7
        arrList.set(2, i); // thay số ở vị trí 2 là u ==> 3
        
        // arrList [7,9,3]
        
        //iterable : tính khả lập (hay là tính khả duyệt )
        //itertor : là người chuyên duyệt, 1 object có khả năng định nghĩa được 
        // trình tự và giá trị , có thể trả ra cho lần gọi tiếp theo
        
        //mô phỏng lại những gì fore đã làm để duyệt Collection 
        //fore muốn duyệt mảng arrayList , thì nó sẽ yêu cầu arrayList cung cấp
        //iterator cho nó
        Iterator<Integer> it = arrList.iterator();
        //arrList cung cấp it là một iterator của nó
        System.out.println(it.hasNext()); // còn hay ko ? true | false
        System.out.println(it.next());//7
        System.out.println(it.next());//9
        System.out.println(it.next());//3
        //System.out.println(it.next());//bug vì hết r
        
        //.remove(index) : xóa phần tử ở vị trí index
        //arrList[7,9,3]
        arrList.remove(1);//xóa 9
        //arrList[7,3]
        
        //nạp thêm nhiều tý
        arrList.add(5);
        arrList.add(9);
        arrList.add(2);
        arrList.add(12);
        //arrList[7 3 5 9 2 12];
        //arrListV2[9 12]
        arrList.removeAll(arrIntListV2);//arrList xóa hết các phần tử xuất hiện ở arrIntListV2
        //==> arrList [7 3 5 2]
        
        //.size() : lấy kích thước
        //.clone() : tạo ra 1 list mới có cùng phần tử và cùng kích thước dung lượng
        ArrayList<Integer> demoClone = (ArrayList)arrList.clone();
        // shallow copy và deep copyv : tìm hiểu
       
        //.contain(key) : tìm key có tồn tại ko ? : boolean
        
        //.notifyCapacity(): giới hạn lưu trữ
        //.isEmpty() : có rỗng ko? boolean
        //.indexOf(key) : tìm key ở index nào ?
        //.trimtoSize : thu nhỏ đến kích thước thật
        
        
    }                                  
      //overload : trong một method có 2 method cùng tên khác paramater
    public static void playWithQueue(){
        Queue<Integer> numList = new LinkedList<>();
        //khai cha new con
        
        //.add(value) : luôn nhét phần tử tail(true | illegal exception)
        numList.add(3);
        //.offer():(của hàm queue) luôn nhét phần tử vào tail(true | false)
        numList.offer(1);
        numList.offer(5);
        numList.offer(4);
        //numList: head[3 1 5 4]
        
        // ko có hàm .add(index,value) ko được chen hàng (thêm phần tử vào giữa)
        
        //nhìn
        //element(): 'nhìn' đầu head (chỉ nhìn , ko thể dùng) (phần tử , null pointer exception)
        //peek() : nhìn lén. 'nhìn' đầu head (chỉ nhìn , ko thể dùng) (phần tử , null)
        
        // không có .get() , vì ko đc lấy được giữa hàng    
        
        // lấy ra
        //.remove() : xóa phần tử ở head , vô tình hàm xóa thì return phần tử bị xóa
        // --> nên em có lụm lại để xử lý (true | null pointer exception)        
        //pool() : bốc ra phần tử ở head để xử lý (phần tử | null)
        //numList : head[3 1 5 4 ] tail
        numList.poll(); //3 
        numList.poll(); //1
        numList.poll(); //5
        numList.poll(); //4 
        numList.poll(); //null 
        
    }
}















/*

library : tập hộp rất nhiều cái hàm , chỉ đến lúc sài thì lấy ra
string.h
strlen();
strcmp();
MATH,.....

framework : là một cái trúc đã đc code sẵn , nhiệm vụ ta là phải 
thay đổi cấu trúc (body) để sài cho phù hợp với việc sử dụng 

Collection là chứa các array xịn
Collections là những công cụ để hỗ trợ những Array xịn (không với array cùi)

iterable : tính khả duyệt : là trạng thái có khả năng duyệt hay k
    ko quan tâm đế  vị trí
List là tập hợp những mảng : mảng này có đặc điểm chung là  StringOrderLet
ko quan tâm về trùng lặp 
LinkedList : theo xu hướng firstIn - FirstOut


*/