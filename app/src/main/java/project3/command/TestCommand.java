package project3.command;

import project3.vo.Book;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestCommand {


    public void execute(){
        ArrayList<Book> book = AddBookCommand.book;
        /* Test 더미 자료 */
        LocalDate localDate = LocalDate.now();
        Book book1 = new Book("인어공주", "거품거품 보글보글", true, localDate);
        LocalDate localDate2 = LocalDate.of(2024, 7, 29);
        Book book2 = new Book("백성공주", "독사과 사각사각", false, localDate2);
        Book book3 = new Book("라프텔", "긴머리 샤랄라", true, localDate);
        LocalDate localDate3 = LocalDate.of(2024, 7, 5);
        Book book4 = new Book("알라딘", "양탄자 슈슈슉", false, localDate3);

        book.add(book1);
        book.add(book2);
        book.add(book3);
        book.add(book4);
    }
}
