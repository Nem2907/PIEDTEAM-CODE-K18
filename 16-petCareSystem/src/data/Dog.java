package data;
public class Dog extends Pet{
    private String necklace ;
    //constutor
    public Dog( String id, String owner, String color, double weight , String necklace) {
        super(id, owner, color, weight);
        this.necklace = necklace;
    }
    //getter

    public String getNecklace() {
        return necklace;
    }
    //setter

    public void setNecklace(String necklace) {
        this.necklace = necklace;
    }
    
    
    @Override
    public void showInfor() {
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s",
                                    id,owner,color, weight,necklace);
        System.out.println(str);
        //đặc trưng của str là chỉ cho mình xem , ko có mình chỉnh sửa
    }

    @Override
    public String toString() {// là tạo ra chuỗi và ném ra bên ngoài
        String str = String.format("%4s|%-12s|%-12s|%6.2f|%s",
                                    id,owner,color, weight,necklace);
        return str; // ném chuỗi đẹp ra ngoài , ai muốn sài thì sài
    }
    
    
}
