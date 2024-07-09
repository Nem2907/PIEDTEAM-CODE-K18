package runtime;

import data.Pet;
import data.PetManagement;
import java.util.Scanner;
import ui.Menu;
import utils.Inputter;

public class Program {
    public static void main(String[] args) {
        //test code
        //tạo ra anh quản lý danh sách thay vì anh quản lý
        PetManagement pm = new PetManagement();
        //pm.initData();// nạp data 
        String url = "D:\\ExtraClass\\PIEDTEAM_CODE_JAVA\\16-petCareSystem\\petListDoc.txt";
        pm.loadFromFile(url);
        Menu menu = new Menu("Pet Care System");
        menu.addNewOption("Add new Dog");
        menu.addNewOption("Add new Cat");
        menu.addNewOption("Print pet list");
        menu.addNewOption("Search pet by list");
        menu.addNewOption("Update pet by id");
        menu.addNewOption("Remove pet by id");
        menu.addNewOption("Sort pet list order by weight");
        menu.addNewOption("Save file and quit");
        while(true){
            menu.print();
            int choice = menu.getChoice();
            switch(choice){
                case 1 :{
                    pm.addnewDog();
                    break;
                }
                case 2 :{
                    pm.addnewCat();
                    break;
                }
                case 3 :{
                    pm.showPetList();
                    break;
                }
                case 4 :{
                    pm.searchPetById();
                    break;
                }
                case 5 :{
                    pm.updatePetById();
                    break;
                }
                case 6 :{
                    pm.removePetById();
                    break;
                }
                case 7 :{
                    pm.sortPetListByWeight();
                    break;
                }
                case 8 :{
                    System.out.println("See you again");
                    pm.saveToFile(url);
                    return ; // ngưng chương trình
                }
               
            }
        }
        
    }
}

/*
        pm.sortPetListByWeight(); // sắp xếp đi e
        pm.showPetList();// show danh sách đi e
        
        int pos = pm.searchPetIndexById("D002");
        System.out.println(pos);
        
        // test hàm tìm pet
        Pet p = pm.searchPet("D003");
        System.out.println(p);
        //test
       // pm.searchPetById();
       
       //muốn nhập tuổi thì làm sao ?
       /*
       Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tuổi nhé");
        //ép "sc.nextline" thành số nguyên  ==> tránh trường hợp có buffer
        while(true){
            try {
                int age = Integer.parseInt(sc.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Mày bị ngoo hả ?");// câu chửi
            }
        }
       */
       
       /*
       int age = Inputter.getAnInteger("Nhập tuổi nha", 
                                        "Tuổi phải là số nguyên nha mậy",1,100);
       int yob = Inputter.getAnInteger("Nhập năm sinh nha", "Mầy ko biết số nguyên hả ");
       
        System.out.println("Tuổi nè :" + age);
        System.out.println("Năm nè : " + yob);
        */
/*
Viết 1 chương trình quản lý thú cưng (DOG | CAT)
    1. Thêm mới 1 con cún
    2. Thêm mới 1 con mèo
    3. in ra danh sách thú cưng
    4. tìm kiếm thú cưng theo tên
    5. update thú cưng theo id
    6. remove thú cưng theo id
    7. sắp xếp thú cưng theo trọng lượng
    8. save file and quit

    khi thêm mới id của pet k được trùng với id ở trong danh sách
    id của pet phải thỏa theo format "D001| C001"
    một con Pet có nhửng thuộc tính owner , color, weight
    
    Dog: necklace
    Cat: ribbon

    yêu cầu chung: nhập chuẩn | nhập bậy bạ là chữi
*/