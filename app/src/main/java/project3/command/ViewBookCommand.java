package project3.command;

import project3.vo.Book;

import java.util.ArrayList;

// 보관 도서 => if(반납여부.equals(true))
// 대여 도서=> if(반납여부.equals(false))
// 전체 도서
public class ViewBookCommand {

    public void execute(){
        ArrayList<Book> book =  AddBookCommand.book;

        for (Book book1 : book) {
            System.out.println(book1.getName() + book1.getContent());
        }
    }
}
