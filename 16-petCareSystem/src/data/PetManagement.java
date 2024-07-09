package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;
import utils.Inputter;

/*
PetManager : lưu trữ những method để hỗ trợ
là một cái khuôn để đúc ra 1 anh quán lý danh sách các thú cưng 
vậy thì anh này phải sở hữu một danh sách các con thú (petList)
và kèm theo đó là các hàm xử lý danh sách đó
*/
public class PetManagement {
    //PetManagement là anh quản lý danh sách , ảnh phải sở hửu danh sách thú cưng
    public ArrayList<Pet> petList = new ArrayList<>();
    //Petmanagement sẽ sở hửu rất nhiều method giúp xử lý petList
    //method initData: hàm giúp nhét 1 vào thú cưng vào petList giúp test code
    
    public void initData(){
        //thêm 2 con chó , 2 con mèo
        petList.add(new Dog("D001", "Tuấn", "Red", 6.5, "I love you"));
        petList.add(new Dog("D002", "Toàn", "Yếlầu", 2.5, "Yellow"));
        petList.add(new Cat("C001", "Tùng", "Nâu", 4.2, "Mỹ Diệu"));
        petList.add(new Cat("C002", "Thông", "Tím", 5.2, "Thông tìm"));
        
    }
    
    //method showPetList : hàm giúp mình in ra danh sách các con thú cưng
    public void showPetList(){
        if(petList.isEmpty()){
            System.out.println("Nothing to print");
            return; // nếu ko có gì trong danh sách --> in thông báo + kết thúc chương trình
            }
        //nếu có thì in ra cho đẹp
            System.out.println("______PetList______");
            for (Pet item : petList) {
                item.showInfor();
        }
    }
    
    public void sortPetListByWeight(){
        //1. tạo ra anh trọng tài
        Comparator orderByWeight = new Comparator<Pet>() {
            @Override
            public int compare(Pet t1, Pet t2) {
               return t1.getWeight() > t2.getWeight() ? 1 : -1 ;
            }
        };
        //2. sau khi cosww anh trọng tài thì mình nạp vào danh sách thông qua
        Collections.sort(petList,orderByWeight);
    }
    //tìm kiếm thú cưng theo tên
        // + nhận vào id tìm vị trí
        public int searchPetIndexById(String keyId){
            for(int i = 0 ; i <= petList.size() - 1 ; i++){
                if(petList.get(i).getId().equals(keyId)){
                    return i ;
                }
            }
            return -1 ; // nếu ko có thì return -1 ;
        }
        // + nhận vào id tìm pet
        // m đưa t id , t đưa m con Pet --> return Pet
        
        public Pet searchPet(String keyId){
            int pos = searchPetIndexById(keyId);// tìm vị trí
            if(pos == -1) return null ;
            else return petList.get(pos);//trả về con pet ở vị trí tìm đc
            // hoặc return pos == -1 ? null : petList.get(pos);
        }
        // + xin id và thông báo tình trạng con pet
        public void searchPetById(){
            /*
            Scanner sc = new Scanner(System.in);
            System.out.println("Input PetId you wanna find :");
            String keyID = sc.nextLine();
            */
            String keyID = Inputter.getString("Input petId you wanna find",
                                               "That field is required !!");
            //dùng id để tìm pet
            Pet pet = searchPet(keyID);
            //thông báo
            if(pet == null){
                System.out.println("The pet not exist");
            }else{
                System.out.println("The pet information");
                pet.showInfor();// in ra
            }
        }
        
        //- xin id , không trả ra , xóa con pet
        public void removePetById(){
            /*
            Scanner sc = new Scanner(System.in);
            System.out.println("Input PetId you wanna find :");
            String keyID = sc.nextLine();
            */
            String keyID = Inputter.getString("Input petId you wanna remove",
                                               "That field is required !!");
            //dùng id để tìm pet
            Pet pet = searchPet(keyID);
            //thông báo
            if(pet == null){
                System.out.println("The pet not exist");
            }else{
                System.out.println("The pet information");
                pet.showInfor();// in ra
                petList.remove(pet);
                System.out.println("Remove succesfully");
            }
        }
            
         //- xin id , không trả ra , cập nhật con pet
        public void updatePetById(){
            /*
            Scanner sc = new Scanner(System.in);
            System.out.println("Input PetId you wanna find :");
            String keyID = sc.nextLine();
            */
            String keyID = Inputter.getString("Input petId you wanna update",
                                               "That field is required !!");
            //dùng id để tìm pet
            Pet pet = searchPet(keyID);
            //thông báo
            if(pet == null){
                System.out.println("The pet not exist");
            }else{
                System.out.println("The pet information before updating");
                pet.showInfor();// in ra
                System.out.println("Updating.........");
                //tiến hành cập nhật
                // id ko đc cập nhập 
                //xin người dùng owner , color , weight
                String newOwner = Inputter.getString("Input owner :", 
                                                    "That field is required !!");
                String newColor= Inputter.getString("Input Color :", 
                                                    "That field is required !!");
                double newWeight = Inputter.getADouble("Input Weight: ", 
                                                    "That field is required !!",1,100);
                
                pet.setColor(newColor);
                pet.setOwner(newOwner);
                pet.setWeight(newWeight);
                //nếu là chó thì là necklace
                // còn là mèo thì ribbon
                if(pet instanceof Dog){
                    //hỏi rằng nếu pet tìm được có nguồn gốc từ con chó hay ko 
                    String newNecklace = Inputter.getString("Input Necklace :", 
                                                             "That field is required !!");
                    ((Dog)pet).setNecklace(newNecklace);
                }else{ // nếu là con mèo
                     //hỏi rằng nếu pet tìm được có nguồn gốc từ con chó hay ko 
                    String newRibbon = Inputter.getString("Input Ribbon :", 
                                                             "That field is required !!");
                    ((Cat)pet).setRibbon(newRibbon);
                }
                System.out.println("Updating is succesful");
            }
        }
        //addnewDog():thêm mới 1 con chó
        public void addnewDog(){
            //thu thập thông tin : id , owner , color , weight , necklace
            //trong đó id khó nhập nhất , vì phải check trùng
            boolean isDup;
            String id ;
            do{
                isDup = false ;// anh tin em chưa bị trùng
                id = Inputter.getString("Input your Dog's id :",
                                        "This id isn't matched DXXX !!!!",
                                        "[dD]\\d{3}").toUpperCase(); // nhập chữ d hoặc viết hoa đều oke và chỉ nhập 3 số
                Pet pet = searchPet(id);// tìm con pet nào có mã đó k 
                if(pet != null){
                    isDup = true ;
                    System.out.println("This id has been used ");
                }
                
            }while(isDup);
            
            String owner = Inputter.getString("Input owner : ",
                                               "That field is required");
            String color = Inputter.getString("Input color : ",
                                               "That field is required");
            double weight = Inputter.getADouble("Input weight : ",
                                               "That field is required");
            String necklace = Inputter.getString("Input necklace", 
                                                 "That field is required");
            
            //bỏ vào cái phễu đầy đủ để tạo 
            Dog nDog = new Dog(id, owner, color, weight, necklace);
            //tạo xong thì lưu vào danh sách
            petList.add(nDog);
            System.out.println("Adđing is succesfully");
            //bỏ vào cái phểu đầy đủ để tạo luôn
            //tạo xong thì lưu vào danh sách
        }
        
         public void addnewCat(){
            //thu thập thông tin : id , owner , color , weight , ribbon
            //trong đó id khó nhập nhất , vì phải check trùng
            boolean isDup;
            String id ;
            do{
                isDup = false ;// anh tin em chưa bị trùng
                id = Inputter.getString("Input your Cat's id :",
                                        "This id isn't matched CXXX !!!!",
                                        "[dD]\\d{3}").toUpperCase(); // nhập chữ d hoặc viết hoa đều oke và chỉ nhập 3 số
                Pet pet = searchPet(id);// tìm con pet nào có mã đó k 
                if(pet != null){
                    isDup = true ;
                    System.out.println("This id has been used ");
                }
                
            }while(isDup);
            
            String owner = Inputter.getString("Input owner : ",
                                               "That field is required");
            String color = Inputter.getString("Input color : ",
                                               "That field is required");
            double weight = Inputter.getADouble("Input weight : ",
                                               "That field is required");
            String ribbon = Inputter.getString("Input ribbon", 
                                                 "That field is required");
            
            //bỏ vào cái phễu đầy đủ để tạo 
            Cat nCat = new Cat(id, owner, color, weight, ribbon);
            //tạo xong thì lưu vào danh sách
            petList.add(nCat);
            System.out.println("Adđing is succesfully");
            //bỏ vào cái phểu đầy đủ để tạo luôn
            //tạo xong thì lưu vào danh sách
        }
         
    // method đọc file
    // method nhận vào url . đọc file từ url và nập giá trị vào danh sách
         public boolean loadFromFile(String url){
        petList.clear();
        //xóa hết trước khi nạp giá trị (option)
        File f = new File(url); //từ url tạo object xứ lý file
        try {
            //xử lý
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line = reader.readLine(); //ra lệnh nó đọc 1 dòng và lưu lại
            while(line != null){ //còn dòng thì còn làm
                //xử lý dòng
                StringTokenizer st = new StringTokenizer(line, "|");
                String id = st.nextToken().trim();
                String owner = st.nextToken().trim();
                String color = st.nextToken().trim();
                double weight = Double.parseDouble(st.nextToken().trim());
                String special = st.nextToken().trim(); 
                Pet pet;
                if(id.matches("[dD]\\d{3}")){
                    pet = new Dog(id, owner, color, weight, special);
                }else{
                    pet = new Cat(id, owner, color, weight, special);
                }
                petList.add(pet);
                line = reader.readLine();
            }
            //return true báo đọc thành công
            return true;
        }catch(Exception e){
            System.err.println("File lỗi rồi: " + e);
            return false;
        }
    }
    //method lưu file 
         public boolean saveToFile(String url){
             File f = new File(url);
             try {
                 OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(f));
                 for (Pet pet : petList) {
                     writer.write(pet.toString());
                     writer.write("\n");
                 }
                 writer.flush();//save xong mới được dùng
                 return true ;
             } catch (Exception e) {
                 System.out.println("Lỗi đọc file" + e);
                 return false ;
             }
         }
}

// in --> kiếm --> update --> remove --> sắp xếp --> thêm 
/*
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit
*/