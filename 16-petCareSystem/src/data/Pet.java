package data;
public abstract class Pet {
    protected String id ;
    protected String owner ;// chủ sở hửu
    protected String color ;
    protected double weight ;
    //construtor
    public Pet(String id, String owner, String color, double weight) {
        this.id = id;
        this.owner = owner;
        this.color = color;
        this.weight = weight;
    }

    //getter
    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }
    
    //setter


    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
    //method showInfor : tạo ra chuỗi đẹp và chỉ 'in' ra màn hình
    // chó thì có necklace nhưng mèo thì có ribbon
    //==> con chó và con mèo in khác nhau
    public abstract void showInfor();
} 
