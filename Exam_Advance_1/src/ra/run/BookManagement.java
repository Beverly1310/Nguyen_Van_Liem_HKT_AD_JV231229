package ra.run;

import config.InputMethods;
import ra.bussinessImp.Author;
import ra.bussinessImp.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagement {
    public static List<Author> authorList = new ArrayList<>();
    public static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("****************MENU***************\n" +
                    "1. Nhập số tác giả và nhập thông tin các tác giả \n" +
                    "2. Nhập số sách và nhập thông tin các sách \n" +
                    "3. Sắp xếp sách theo giá xuất sách tăng dần \n" +
                    "4. Tìm kiếm sách theo tên tác giả sách \n" +
                    "5. Thoát\n" +
                    "Mời nhập lựa chọn");
            int choice = InputMethods.getInteger();
            switch (choice) {
                case 1:
                    BookManagement.createAuthor();
                    break;
                case 2:
                    BookManagement.createBook();
                    break;
                case 3:
                    BookManagement.sortBook();
                    break;
                case 4:
                    BookManagement.searchByAuthorName();
                    break;
                case 5:
                    isExit = true;
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
    }

    /////////////////////////////////////////CHỨC NĂNG//////////////////////////////
    // thêm mới n tác giả
    public static void createAuthor() {
        System.out.println("Nhập số lượng tác giả muốn thêm:");
        int count = InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            Author newAuthor = new Author();
            System.out.println("Nhập thông tin cho tác giả thứ " + (i + 1));
            newAuthor.inputData();
            authorList.add(newAuthor);
        }
    }
// thêm mới n sách
    public static void createBook() {
        System.out.println("Nhập số lượng sách muốn thêm:");
        int count = InputMethods.getInteger();
        for (int i = 0; i < count; i++) {
            Book newBook = new Book();
            System.out.println("Nhập thông tin cho sách thứ " + (i + 1));
            newBook.inputData();
            bookList.add(newBook);
        }
    }
// sắp xếp sách theo giá bán tăng dần bằng comparator
    public static void sortBook() {
        Collections.sort(bookList, (o1, o2) -> {
            return Float.compare(o1.getExportPrice(), o2.getExportPrice());
        });
        bookList.forEach(Book::displayData);
    }
    // tìm kiếm sách theo tên tác giả
    public static void searchByAuthorName(){
        System.out.println("Nhập tên tác giả");
        String inputAuthorName = InputMethods.getString();
        if (bookList.stream().anyMatch(book -> book.getAuthor().getAuthorName().equals(inputAuthorName))){
            bookList.stream().filter(book -> book.getAuthor().getAuthorName().equals(inputAuthorName)).forEach(Book::displayData);
        } else {
            System.out.println("Không có sách nào");
        }
    }
}
