import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CustomerManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<String> customerQueue = new LinkedList<>();
        boolean isExit = false;
        while (!isExit) {
            System.out.println("****************MENU***************\n" +
                    "1. Nhập tên khách hàng chờ mua vé xem phim\n" +
                    "2. Khách tiếp theo\n" +
                    "3. Thoát\n" +
                    "Mời nhập lụa chọn");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    CustomerManagement.addCustomer(scanner,customerQueue);
                    break;
                case 2:
                    CustomerManagement.getNextCustomer(customerQueue);
                    break;
                case 3:
                    isExit = true;
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
    }
/////////////////////////////////////CHỨC NĂNG/////////////////////////////
    //thêm khách hàng vào hàng đợi
    public static void addCustomer(Scanner scanner, Queue<String> customerQueue) {
        System.out.println("Nhập tên khách hàng chờ mua vé xem phim:");
        customerQueue.add(scanner.nextLine());
    }
// lấy ra và xóa khách hàng đầu hàng đợi
    public static void getNextCustomer(Queue<String> customerQueue) {
        if (customerQueue.isEmpty()) {
            System.err.println("không có khách nào cả");
        } else {
            System.out.println("Khách hàng tiếp theo: ");
            System.out.println(customerQueue.remove());
        }
    }
}
