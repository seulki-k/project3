package project3.command;

import project3.vo.Book;

import java.util.ArrayList;
import java.util.Scanner;

// 도서 삭제
public class DeleteBookCommand implements Command{

    public void execute(){
        ArrayList<Book> book = AddBookCommand.book;
        Scanner scanner = new Scanner(System.in);

        ViewBookCommand view = new ViewBookCommand();

        view.printAll(book);

        System.out.print("제거할 도서의 제목 : ");
        String deleteName =scanner.nextLine();
        book.removeIf(book1 -> book1.getName().equals(deleteName));

    }
}
