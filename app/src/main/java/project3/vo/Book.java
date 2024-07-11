package project3.vo;

public class Book {
    int name; // 책의 이름

    boolean available; // 책 대출 가능 여부

    String content; // 책의 간략한 내용

    public Book(int name, boolean available, String content) {
        this.name = name;
        this.available = available;
        this.content = content;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
