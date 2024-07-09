package com.practicalexam;

import java.util.Scanner;

import com.practicalexam.student.TemplateQuestion;
import static javafx.scene.input.KeyCode.S;

/**
 *
 * @author FPT University - HCMC Java OOP Practical Exam Template
 */
public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Menu here (if needed)
        TemplateQuestion hello = new TemplateQuestion();
        // Your code here
        int choice = 0;
        do {

            // Menu here (if needed)
            System.out.println("1.Thêm một sinh viên");
            System.out.println("2.Tìm kiếm một sinh viên");
            System.out.println("3.Cập nhật một sinh viên");
            System.out.println("4.Xóa một sinh viên");
            System.out.println("5.Sắp xếp danh sách sinh viên theo điểm");
            // Your code here
            System.out.println("Nhap vao : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    hello.insert();
                    break;
                }
                case 2: {
                    hello.update();
                    break;
                }
                case 3: {
                    hello.search();
                    break;
                }
                case 4: {
                    hello.remove();
                    break;
                }
                case 5: {
                    hello.sort();
                    break;
                }

                // Other case here!!!
                default:{
                    return;
                }
            }
        } while (choice >= 1 && choice <= 5);  // Modify the condition to exit the loop!!!
    }

}
