package ra.bussinessImp;

import config.InputMethods;
import ra.business.IShop;

import java.util.List;

import static ra.run.BookManagement.authorList;

public class Book implements IShop {
    private int bookId;
    private String bookName;
    private String title;
    private int numberOfPages;
    private Author author;
    private float importPrice;
    private float exportPrice;
    private int quantity;
    private boolean bookStatus;

    public Book() {
    }

    public Book(int bookId, String bookName, String title, int numberOfPages, Author author, float importPrice, float exportPrice, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    //nhập thông tin sách
    @Override
    public void inputData() {
        this.bookId = inputId();
        this.bookName = inputName();
        this.title = inputTitle();
        this.numberOfPages = inputNumberOfPages();
        this.author = inputAuthor();
        this.importPrice = inputImportPrice();
        this.exportPrice = this.importPrice * RATE;
        this.quantity = inputQuantity();
        this.bookStatus = inputStatus();
    }

    //lấy id sách
    public int inputId() {
        System.out.println("Nhập mã sách");
        return InputMethods.getInteger();
    }

    //lấy tên sách
    public String inputName() {
        System.out.println("Nhập tên sách");
        return InputMethods.getString();
    }

    // lấy tiêu đề sách
    public String inputTitle() {
        System.out.println("Nhập tiêu đề sách");
        return InputMethods.getString();
    }

    // lấy số trang sách
    public int inputNumberOfPages() {
        System.out.println("Nhập số trang sách");
        return InputMethods.getInteger();
    }

    // lấy tác giả
    public Author inputAuthor() {
        if (authorList.isEmpty()) {
            System.err.println("Danh sách tác giả trống, hãy thêm mới tác giải trước");
        } else {
            System.out.println("Nhập Id của tác giả");
            authorList.forEach(Author::displayData);
            int inputAuthorId = InputMethods.getInteger();
            for (int i = 0; i < authorList.size(); i++) {
                if (authorList.get(i).getAuthorId() == inputAuthorId) ;
                return authorList.get(i);
            }
        }
        System.out.println("Tác giả không có trong danh sách");
        return null;
    }

    // lấy giá nhập
    public float inputImportPrice() {
        System.out.println("Nhập giá sách nhập vào");
        return InputMethods.getFloat();
    }

    //lấy số lượng sách
    public int inputQuantity() {
        System.out.println("Nhập số lượng sách");
        return InputMethods.getInteger();
    }

    // lấy trạng thái
    public boolean inputStatus() {
        System.out.println("Nhập trạng thái");
        return InputMethods.getBoolean();
    }

    // hiển thị thông tin sách
    @Override
    public void displayData() {
        System.out.printf("Mã sách: %-5d || Tên sách: %-10s || Tên tác giả: %-10s\nGiá bán: %-6s || Số lượng sách: %-5d\nTrạng thái: %-5s",
                this.bookId, this.bookName, this.author != null ? this.author.getAuthorName() : "n/a", this.exportPrice, this.quantity, this.bookStatus ? "Còn hàng" : "Hết hàng");
    }
}
