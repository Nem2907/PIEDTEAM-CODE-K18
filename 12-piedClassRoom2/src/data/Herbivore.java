package data;
/*
Herbivore : động vật ăn cỏ
Herbivore  có nên tham gia hội studyEnthusiasts ko ?
nếu tham gia thì các con vật ăn cỏ đều ham học
-> con bò cũng có ham học thì k ai chửi "Ngu như bò"
*/
public abstract class Herbivore {
    //properties
    protected String name ;
    protected int yob ;
    protected double weight ;
    //constructor
    public Herbivore(String name, int yob, double weight) {
        this.name = name;
        this.yob = yob;
        this.weight = weight;
    }
    //method
    //1-getter 

    public String getName() {
        return name;
    }

    public int getYob() {
        return yob;
    }

    public double getWeight() {
        return weight;
    }
    //2- showInfor : tạo ra cái chuỗi đẹp 
    // sau đó sout cái chuỗi đẹp đó
    // ai gọi showInfor thì sẽ in được chuỗi đẹp ra bên ngoài
    // những cái chuỗi ko lưu đc cũng như sài cho việc khác

    // - toString : tạo ra chuỗi đep sau đó ném cho mình
    // một trong các xài phổ biến là sout(h1) luôn ko cần .toString
    @Override
    public String toString() {
        String str = String.format("%-20s|%-10s|%4d|6.2f",
                                    "Herbivore",name,yob,weight);
        return str ;
    }
    //không có công thức chung nào cho các động vật ăn cỏ
    //vd : con ngựa thì nó vừa học vừa hú hí =))
    //còn con khỉ thì học kiểu bắt chước(mimic)
    
    // vì herbivore thì lại quá lớn để có thể dịnh nghãi cụ thể công 
    // thức học nhưng ngựa và khỉ thì có , nên herbivore để study là 
    // abstract methods
    public abstract double study();
    
    // và vì mỗi đứa nó học mỗi cách khác nhau nên việc show
    // thành tích cũng có phần khác nhau
    public abstract void showLearningOutComes();
    
    
}

/*
gồm có 3 thành phần chính :
properties
constructor
method
*/
