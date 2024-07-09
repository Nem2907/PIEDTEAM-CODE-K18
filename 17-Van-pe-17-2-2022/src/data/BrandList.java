package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import ui.Menu;
import utils.Inputter;

/*
tư duy 1 : BrandList : là anh quản lý danh sách các Brand(anh Điệp)
tư duy 2 : BrandList : là danh sách các Brand

*/
public class BrandList {
    //danh sách các Brand cần quản lý
    ArrayList<Brand> brandList = new ArrayList<>();
    //những method để xử lý danh sachas
    public BrandList() {
    }
 
public boolean loadFromFile(String url){
    File F = new File(url);
    try {
        //xử lý
        BufferedReader reader = new BufferedReader(new FileReader(F));
        String line = reader.readLine();
        while(line != null){
            //xử lý dòng
            StringTokenizer st = new StringTokenizer(url,",");
            String id = st.nextToken().trim();
            String name = st.nextToken().trim();
            String str = st.nextToken().trim();
            //stage 2 :
             st = new StringTokenizer(str,":");
             String sound = st.nextToken().trim();
             double price = Double.parseDouble(st.nextToken().trim());
             //dùng các nguyên liệu thu được để tạo brand và lưu vào danh sách
             Brand brand = new Brand(id, name, sound, price);
             brandList.add(brand);
             line = reader.readLine();// đọc dòng tiếp theo 
        }
        //true nếu xong
        return true ;
        // lưu ý ở cái đọc dòng đầu tiên + return true 
    } catch (Exception e) {
        System.err.println("File Brand error" + e);
        return false ;
    }
}

//hàm in
public void listBtands(){
    if(brandList.isEmpty()){
        System.out.println("Nothing to print");
    }else{
        System.out.println("________BrandList__________");
        for (Brand brand : brandList) {
            System.out.println(brand);//toString
        }
    }
}

public int searchID (String keyID){
    for (int i = 0; i < brandList.size()-1; i++) {
        if(brandList.get(i).getBrandID().equals(keyID)){
            return i ;
        }
    }
    return -1 ;
}
//hàm thêm một brand
public void addBrand(){
    //thu nhập dữ liệu
    //id cấm trùng
    boolean isDup ;
    String id ; 
    do{
        isDup = false ;// reset niềm tin
        id = Inputter.getString("Input brand id", 
                                  "This field is required !");
        //dùng id để xem có brandid nào trùng ko
        int pos = searchID(id);
        if(pos == -1){
            //nếu tìm được thì trả -1 
            isDup = true ; 
            System.out.println("This id has been used");
        }        
    }while(isDup);
    //name , sound , price 
    String name = Inputter.getString("Input brandname ", 
                                        "That field required!!");
    String sound = Inputter.getString("Input sound brand ", 
                                        "That field required!!");
    double price = Inputter.getADouble("Input prive brand", 
                                        "Price must be", 1, Math.pow(2, 53)-1 );
    //tạo
    Brand brand = new Brand(id, name, sound, price);
    brandList.add(brand);
    System.out.println("Brand adđing is successful");
}
public void updateBrand(){
    //xin brand id của brand muốn update
    String keyId = Inputter.getString("Input brand id you wanna update",
                                        "That field is required! ");
    // tìm brand dựa vào id đã xin
    int pos = searchID(keyId);
    Brand brand = pos == -1 ? null : brandList.get(pos);
    if(brand == null){
        System.out.println("Not found");
    }else{
        System.out.println("Brand information before update");
        System.out.println(brand);
        System.out.println("Updating....");
        //thu nhập thông tin mới cho name , sound , price
         String newname = Inputter.getString("Input brandname ", 
                                        "That field required!!");
        String newsound = Inputter.getString("Input sound brand ", 
                                        "That field required!!");
        double newprice = Inputter.getADouble("Input prive brand", 
                                        "Price must be", 1, Math.pow(2, 53)-1 );
        //set
        brand.setBrandName(newname);
        brand.setPrice(newprice);
        brand.setSoundBrand(newsound);
        System.out.println("Brand updating is successful");
    }
    // nếu có thì update còn ko thì báo ko có
}
    
    public void searchBrand(){
    //xin brand id của brand muốn update
    String keyId = Inputter.getString("Input brand id you wanna find",
                                        "That field is required! ");
    // tìm brand dựa vào id đã xin
    int pos = searchID(keyId);
    Brand brand = pos == -1 ? null : brandList.get(pos);
    if(brand == null){
        System.out.println("Not found");
    }else{
        System.out.println("Brand information");
        System.out.println(brand);
    }
    // nếu có thì update còn ko thì báo ko có
}
     public Brand getUserChoice(){
        //hiển thị danh sách các Brand kèm số SEQ
        int count = 1 ; 
        for (Brand brand : brandList) {
            System.out.println(count + ". " +brand);
            count++;
        }
        //mời chọn và bốc ra object tương ứng trong danh sách : ref_getChoice
        //ref_getChoice thuộc về menu
        Menu<Brand> brandMenu = new Menu("BrandListMenu");
        return brandMenu.ref_getChoice(brandList);
    }
     // saveFile
     public boolean saveToFile(String url){
         File f = new File(url);
         try {
             //xử lý file
             OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
             for (Brand brand : brandList) {
                 writer.write(brand.toString());
                 writer.write("\n");
             }
             writer.flush();
             //xong thì 
             return true ;
         } catch (Exception e) {
             System.out.println("Brand file error :" +e);
             return false ;
         }
     }
}
