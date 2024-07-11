package project3.command;

import project3.vo.AnsiCode;
import project3.vo.Book;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

// 보관 도서 => if(반납여부.equals(true))
// 대여 도서=> if(반납여부.equals(false))
// 전체 도서
public class ViewBookCommand implements Command {

    public void execute() {
        ArrayList<Book> book = AddBookCommand.book;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. 보관 도서    2. 대여 도서    3.전체 도서\n");
            System.out.print("조회할 도서(이전 0) : ");
            String command = scanner.nextLine();
            System.out.println();
            if (command.equals("0")) return;
            try {
                int command2 = Integer.parseInt(command);
                switch (command2) {
                    case 1:
                        availableTure(book);
                        break;
                    case 2:
                        availableFalse(book);
                        break;
                    case 3:
                        availableTure(book);
                        availableFalse(book);
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");

            }
        }
    }

    public void availableTure(ArrayList<Book> book) {
        for (Book book1 : book) {
            if (book1.isAvailable()) {
                System.out.println("제목 : " + book1.getName() + " /  "
                        + "저자 : " + book1.getAuthors() + "\n" + "도서 상태 :" + AnsiCode.ANSI_BLUE
                        + "  보관 중" + AnsiCode.ANSI_RESET + "\n");
            }
        }
    }

    public void availableFalse(ArrayList<Book> book) {
        for (Book book1 : book) {
            if (!book1.isAvailable()) {
                if (book1.getDate().isBefore(LocalDate.now())) {
                    System.out.println("제목 : " + book1.getName() + " /  "
                            + "저자 : " + book1.getAuthors() + "\n도서 상태 :" + AnsiCode.ANSI_RED
                            + "  대여 중" + AnsiCode.ANSI_RESET + " /  반납 예정 일 : " + AnsiCode.ANSI_STRIKETHROUGH
                            + book1.getDate().getYear() + "." + book1.getDate().getMonth().getValue() + "."
                            + book1.getDate().getDayOfMonth() + AnsiCode.ANSI_RESET + AnsiCode.ANSI_RED
                            + "  미정" + AnsiCode.ANSI_RESET + "\n");
                } else {
                    System.out.println("제목 : " + book1.getName() + " /  "
                            + "저자 : " + book1.getAuthors() + "\n도서 상태 :" + AnsiCode.ANSI_RED
                            + "  대여 중" + AnsiCode.ANSI_RESET + " /  반납 예정 일 : " + book1.getDate().getYear()
                            + "." + book1.getDate().getMonth().getValue() + "." + book1.getDate().getDayOfMonth() + "\n");
                }
            }
        }
    }
}