import java.util.Scanner;
import java.util.Stack;

public class URLManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> urlStack = new Stack<>();
        boolean isExit = false;
        while (!isExit) {
            System.out.println("****************MENU***************\n" +
                    "1. Nhập URL muốn truy cập\n" +
                    "2. Quay lại\n" +
                    "3. Thoát\n" +
                    "Mời nhập lựa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    URLManagement.addURL(scanner,urlStack);
                    break;
                case 2:
                    URLManagement.returnURL(urlStack);
                    break;
                case 3:
                    isExit=true;
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
    }
    //thêm URL và stack
    public static void addURL(Scanner scanner,Stack<String> urlStack){
        System.out.println("Nhập URL mà bạn muốn thêm");
        urlStack.push(scanner.nextLine());
    }
    //xóa URL trên cùng và trả vè URL tiếp theo
    public static void returnURL(Stack<String> urlStack){
        urlStack.pop();
        System.out.println("URL trước đó:");
        if (urlStack.size()>=1){
        System.out.println(urlStack.peek());
    } else {
            System.out.println("Bạn đã quay lại trang ban đầu");
        }
    }
}
