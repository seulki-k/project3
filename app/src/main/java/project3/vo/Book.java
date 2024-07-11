package project3.vo;

import java.time.LocalDate;

public class Book {
    String name; // 책의 이름

    String content; // 책의 간략한 내용

    boolean available; // 책 대출 가능 여부, true 대여가능, false 대여 중.

    LocalDate date; //반납 예정일 혹은 대여 예정일. available 값에 따라 용도 변경

    public Book(String name, String content, boolean available, LocalDate date) {
        this.name = name;
        this.content = content;
        this.available = available;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
