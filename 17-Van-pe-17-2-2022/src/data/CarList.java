package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import static javafx.scene.input.KeyCode.F;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import utils.Inputter;

/*
CarList : là anh quản lý danh sách các car (các chiếc xe)
        có : danh sách các chiếc xe  (carList) để quản lý
        có : một anh quản lý các brand có tên là 'brandList'
                        có danh sách các brand tên là 'brandList'
        Vậy muốn lấy phần tử thứ 2 trong danh sách brand thì làm sao ?
        brandList.brandList.get(2)
*/
public class CarList {
    ArrayList<Car> carList = new ArrayList<>();
    BrandList brandlist; 
    //constructor

    public CarList(BrandList brandlist) {
        this.brandlist = brandlist;
    }
    
    public boolean loadFromFile(String url){
        File f = new File(url);
        
        try {
        //xử lý file
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String line = reader.readLine();
        while(line != null){
            StringTokenizer st = new StringTokenizer(line, ",");
            String cid = st.nextToken().trim();
            String bid = st.nextToken().trim();
            String color = st.nextToken().trim();
            String fid = st.nextToken().trim();
            String eid = st.nextToken().trim();
            //dùng bid tìm pos => tìm brand
            int pos = brandlist.searchID(bid);
            Brand brand = brandlist.brandList.get(pos);
            //tạo 
            Car nCar = new Car(cid, brand, color, fid, eid);
            carList.add(nCar);
            line = reader.readLine();// đọc dòng tiếp theo
        }
        //xong thì
        return true ;
        } catch (Exception e) {
            System.out.println("Cars file error" + e);
            return false ;
        }
    }
    
    //hàm in 
    public void listCars(){
        if(carList.isEmpty()){
            System.out.println("CarList has nothing to print");
            return ;
        }
        Collections.sort(carList);//sắp xếp
        System.out.println("____CarList_______");
        for (Car car : carList) {
            System.out.println(car.screenString());
        }
    }
    public int searchID(String carID){
        for (int i = 0; i < carList.size() - 1; i++) {
            if(carList.get(i).getCarID().equals(carID)){
                return i ;
            }
        }
        return -1 ;
    }
    public int searchFrame(String fid){
        for (int i = 0; i < carList.size() - 1; i++) {
            if(carList.get(i).getFrameID().equals(fid)){
                return i ;
            }
        }
        return -1 ;
    }
    public int searchEngine(String engine){
        for (int i = 0; i < carList.size() - 1; i++) {
            if(carList.get(i).getEngineID().equals(engine)){
                return i ;
            }
        }
        return -1 ;
    }
    //hàm thêm 1 chiếc xe
     public void addCar(){
         //thu thập thông tin
         //carId cấm trùng
         boolean isDup;
         String carId;
         do{
             isDup = false ;// reset niềm tin
             carId = Inputter.getString("Input carID ", 
                                        "That field is requird !!!");
             //dùng id vừa thi được tìm xem có không 
             int pos = searchID(carId);//pos != -1 ==> tìm đc ==> bị trùng
             if(pos != -1 ){
                 System.out.println("CarId has been used");
                 isDup = true ;
             }
         }while(isDup);//còn trung thì còn nhập
         
         //nhập frame
         Brand brand = brandlist.getUserChoice();
         //nhập color
         String color = Inputter.getString("Input color",
                                            "That field is required");
         
         //nhập frameid cấm tring và theo format F00000  
         String frameID;
         do{
             isDup = false ;// reset niềm tin
             frameID = Inputter.getString("Input frameID  ", 
                                        "That field must be match F00000!!!",
                                        "F\\d{5}" );
             //dùng id vừa thi được tìm xem có không 
             int pos = searchFrame(frameID);//pos != -1 ==> tìm đc ==> bị trùng
             if(pos != -1 ){
                 System.out.println("This frameID has been used");
                 isDup = true ;
             }
         }while(isDup);//còn trung thì còn nhập
         
         //nhập engineid cấm tring và theo format F00000  
         String engineID;
         do{
             isDup = false ;// reset niềm tin
             engineID = Inputter.getString("Input engineID", 
                                        "That field must be match E00000 !!!",
                                        "E\\d{5}" );
             //dùng id vừa thi được tìm xem có không 
             int pos = searchEngine(engineID);//pos != -1 ==> tìm đc ==> bị trùng
             if(pos != -1 ){
                 System.out.println("This engineId has been used");
                 isDup = true ;
             }
         }while(isDup);//còn trung thì còn nhập
         //TẠO NHAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
            Car nCar = new Car(carId, brand, color, frameID, engineID);
            carList.add(nCar);
            System.out.println("Adding succesfully");
     }
     //in ra danh sách các Car có brandName chứa key cần tìm
     public void printBaseBrandName(){
         String key = Inputter.getString("Input a part of Brand Name !",
                                          "That field is required !");
         int count = 0 ;
         for (Car car : carList) {
             if(car.getBrand().getBrandName().contains(key)){
                 System.out.println(car.screenString());
                 count++;
             }
         }
         
         if(count == 0){
             System.out.println("No car is detected ! ");
         }
     }
     
     //remove 
     public boolean removeCar(){
         String keyID = Inputter.getString("Input keyID you wanna remove",
                                            "This field is required !");
         //dùng keyId tìm  Car cần xóa
         int pos = searchID(keyID);
         Car car = pos != -1 ? null : carList.get(pos);
         if(car == null){
             System.out.println("Not found");
             return false;
         }else{
             System.out.println("Car information");
             System.out.println(car.screenString());
             carList.remove(pos);
             System.out.println("Car removing is succesfully");
             return true ;
         }
     
     }
     //update
     public boolean updateCar(){
         String keyID = Inputter.getString("Input keyID you wanna update",
                                            "This field is required !");
         //dùng keyId tìm  Car cần update
         int pos = searchID(keyID);
         Car car = pos == -1 ? null : carList.get(pos);
         if(car == null){
             System.out.println("Not found");
             return false;
         }else{
             System.out.println("Car information");
             System.out.println(car.screenString());
             carList.remove(pos);
             System.out.println("Updating.....................");
             //thu thập thông tin
               boolean isDup ;
             //nhập frame
            Brand brand = brandlist.getUserChoice();
            //nhập color
            String color = Inputter.getString("Input color",
                                               "That field is required");

            //nhập frameid cấm tring và theo format F00000  
            String frameID;
            do{
                isDup = false ;// reset niềm tin
                frameID = Inputter.getString("Input frameID  ", 
                                           "That field must be match F00000!!!",
                                           "F\\d{5}" );
                //dùng id vừa thi được tìm xem có không 
                pos = searchFrame(frameID);//pos != -1 ==> tìm đc ==> bị trùng
                if(pos != -1 ){
                    System.out.println("This frameID has been used");
                    isDup = true ;
                }
            }while(isDup);//còn trung thì còn nhập

            //nhập engineid cấm tring và theo format F00000  
            String engineID;
            do{
                isDup = false ;// reset niềm tin
                engineID = Inputter.getString("Input engineID", 
                                           "That field must be match E00000 !!!",
                                           "E\\d{5}" );
                //dùng id vừa thi được tìm xem có không 
                pos = searchEngine(engineID);//pos != -1 ==> tìm đc ==> bị trùng
                if(pos != -1 ){
                    System.out.println("This engineId has been used");
                    isDup = true ;
                }
            }while(isDup);//còn trung thì còn nhập
             //set
             car.setBrand(brand);
             car.setColor(color);
             car.setFrameID(frameID);
             car.setEngineID(engineID);
             System.out.println("Car updating is successful");
             return true ;
         }
    } 
     public boolean saveToFile(String url){
         File f = new File(url);
         try {
             //xử lý file
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
             for (Car car : carList) {
                 writer.write(car.toString());
                 writer.write("\n");
             }
             writer.flush();
             //xong thì 
             return true ;
         } catch (Exception e) {
             System.out.println("Car file error :" +e);
             return false ;
         }
     }
}
