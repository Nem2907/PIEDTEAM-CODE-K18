package runtime;

public class Program {

    public static void main(String[] args) {
        // comment : ghi chú
        // trong java có 2 dạng datatype :
        // + Dạng 1: primitive datatype : kiểu dữ  liệu nguyên thủy
        // lấy 1 vùng nhớ nhỏ , để lưu trữ dữ liệu
        // vùng nhớ này nhỏ đến mức không thể tách nhỏ được nữa
        // 1 - byte      1 byte - 8 bits số nguyên rất rất nhỏ
        // 2 - short     2 byte          số nguyên rất nhỏ
        // 3 - int       4 byte          số nguyên nhỏ
        // 4 - long      8 byte          số nguyên lớn
        // 5 - float     4 byte          số thực nhỏ
        // 6 - double    8 byte          số thực lớn
        // 7 - char      2 byte          ký tự : unicode
        // 8 - boolean   1 bit           true / false

        byte numByte = -128;
        int intNum = 257;
        float numFloat = 1234.5F;
        // số thực trong java luôn mặc định là double)
        double x = 123.5;
        // numInt = num ID
        //primitve databyte : có sẵn
        //  Student (name-char-string, yob-int , gra - float){
        long money = 1000000000000000000L;
        // số nguyên luôn được java hiểu là int
        int num1 = 10000000;
        num1 = 076;
        // số 0 đứng đầu là prefix của octal( hệ tám) : hệ 8
        // 2 : object datatype : references datatype , kiểu dữ liệu hướng đối tiẹn
        // là kiểu dữ liệu do ng dùng tự định nghĩ ra dựa vào primitive datatype có sẳn 
        System.out.printf("%d\n", num1);
        System.out.println("num1 ne " + num1); // line new

        //operator
        // trong java có ít nhật 10 lại toán tử
        // Athrimetic : toán tử toán hạng
        // + - * / ++ --
        //-= += /= &= %=
        int a = 10;
        int b = a++ + ++a - --a - a--;
        System.out.println(+b);
        
        // comparision : toán tử so sánh
        //  > < >= <= == !=
        
        
        // logical
        // AND(&&) , or(||)
        //      &     |
        //&& : tìm false : có false là ngừng
        //|| : tìm true : có true là ngừng
        
        
        //String
        //Umary : Phép giao , hay còn là Toán tử 1 ngôi
        //comma : phẩy
        
        
        //Shift bit : toán tử dịch bit
        // >> <<
        int num2 = 8 ;
        num2 = num2 << 2 ;
        System.out.println(num2);
        // n >> x  :  n / 2^x
        // n << x  :  n * 2^x
        
        // Bitwise : toán tử bit 
        // ( | & ^ ~  )
        // | tìm true : tìm 1 
        // & tìm false : tìm 0 , nếu có 2 số 1 là 1 còn lại là 0
        // ^ (XOR) : giống nhau là 0 , khác nhau là 1 
        // ~ (Not : phủ định) :
    }
    
}
