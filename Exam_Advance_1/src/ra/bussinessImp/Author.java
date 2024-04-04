package ra.bussinessImp;

import config.InputMethods;
import ra.business.IShop;

public class Author implements IShop {
    private int authorId;
    private String authorName;
    private boolean sex;
    private int year;

    public Author() {
    }

    public Author(int authorId, String authorName, boolean sex, int year) {
        this.authorId = authorId;
        this.authorName = authorName;
        this.sex = sex;
        this.year = year;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
// nhập thông tin
    @Override
    public void inputData() {
        this.authorId = inputId();
        this.authorName = inputName();
        this.sex = inputSex();
        this.year = inputYear();
    }
// lấy id
    public int inputId() {
        System.out.println("Nhập Id tác giả:");
        return InputMethods.getInteger();
    }
// lấy tên
    public String inputName() {
        System.out.println("Nhập tên tác giả:");
        return InputMethods.getString();
    }
// lấy giới tính
    public boolean inputSex() {
        System.out.println("Nhập giới tính:");
        return InputMethods.getBoolean();
    }
// lấy năm sinh
    public int inputYear() {
        System.out.println("Nhập năm sinh tác giả:");
        return InputMethods.getInteger();
    }
// hiển thị thông tin
    @Override
    public void displayData() {
        System.out.printf("Mã Id: %-5d || Tên tác giả: %-10s\n",
                this.authorId, this.authorName);
        System.out.println("======================================");
    }
}
