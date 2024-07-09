
package data;
public class Car implements Comparable<Car>{
    private String carID ;
    private Brand brand ;
    private String color ;
    private String frameID ;
    private String engineID ;

    //constructor 

    public Car(String carID, Brand brand, String color, String frameID, String engineID) {
        this.carID = carID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    public String getCarID() {
        return carID;
    }

    public Brand getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getFrameID() {
        return frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        String str = String.format("%s, %s, %s , %s , %s", 
                                    carID,brand.getBrandID(),color,engineID,frameID);
        return str;    
    }
    
    public String screenString(){
        String str = String.format("%s,\n %s, %s , %s , %s", 
                                    brand,carID,color,engineID,frameID);
        return str;
    }

    @Override
    public int compareTo(Car that) {
        String brandNameOfThis = this.getBrand().getBrandName();
        String brandNameOfThat = this.getBrand().getBrandName();
        if(brandNameOfThis.compareTo(brandNameOfThat) > 0){
            return 1 ;
        }else if(brandNameOfThis.compareTo(brandNameOfThat) == 0){
            return this.getCarID().compareTo(that.getCarID());//để return 1 hoặc 0
        }
        return -1 ;
    }
    
    
}
