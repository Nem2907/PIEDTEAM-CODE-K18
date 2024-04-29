
package runtime;


public class Program {

   
    public static void main(String[] args) {
        int a = 10;//primitive datatype , 4byte trong ram
        // a là một đơn vị siêu nhỏ , nhỏ đến mức ko thể tách nhỏ
        // hơn được
        // a. cái đầu m
        // WrapperClass
        Integer b = new Integer(10);
        // lấy 1 cái class mang tên Integer(core = 10)
        // học lại stack , heap
        //new Integer(10) => tạo ra một vùng nhớ lưu trữ cái heap và 
        // vùng nhớ này rất lớn
        // b là 1 biến cpm trỏ nằm ở stack , đang trỏ vào 
        // vùng nhớ có core là 10
        // so về kích thước : a < b
        // nên anh ko khuyển khích lưu số nguyên = wrapper classs
        // gối 1 con số int = 10 vào 1 cái object =>
        // boxing xảy ra khi Wrapper = primitive
        // => gán primitive vào wrapper class
        System.out.println("a nè "+a);//10
        System.out.println("b nè "+b.toString());
        // trong java có cơ chế auto unboxing nên => 10
        // nên là sẽ có dòng lệnh toString ẩn để in ra số 10
        int c = b ;
        // đây cũng là cơ chế unboxing
        // auto unboxing , mở object , lấy core là 10
        // sau đó gán 10 cho c
        // ta có thể tạo obejct từ warper classs như sau :
        Integer d = 20000 ;
        // wrapper = primitive boxing 
        // gói con 20000 vào 1 cái object Integer
        // 
        d = 2000 ;
        b = 2000 ;
        a = 2000 ;
        
        if(d == b){
            System.out.println("= nhau");
        }else{
            System.out.println("ko = nhau");
        }
        //bảng chất : a là số nguyên , b là wrapper 
        // do b khi so sánh thì phải unboxing và lấy lỗi so sánh
        
    }   
    
}
