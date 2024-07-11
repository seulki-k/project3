package project3;

import project3.command.*;
import project3.vo.AnsiCode;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;


public class LibraryMain {
    Map<String, Command> commandMap = new HashMap<>();
    public static String[] menus = {"등록", "조회", "대여", "반납", "수정", "삭제", "종료"};

    public static AddBookCommand addBookCommand = new AddBookCommand();
    public static ViewBookCommand viewBookCommand = new ViewBookCommand();
    public static BorrowBookCommand borrowBookCommand = new BorrowBookCommand();
    public static ReturnBookCommand returnBookCommand = new ReturnBookCommand();
    public static UpdateBookCommand updateBookCommand = new UpdateBookCommand();
    public static DeleteBookCommand deleteBookCommand = new DeleteBookCommand();
    public static TestCommand testCommand = new TestCommand();

    public static void main(String[] args) {


        LibraryMain.printMainMenus();
        testCommand.execute();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[Main] > ");
            try {
                String command = scanner.nextLine();
                if (command.equals("menu")) {
                    printMainMenus();
                }
                int commandParse = Integer.parseInt(command);
                switch (commandParse) {
                    case 1:
                        addBookCommand.execute();
                        break;
                    case 2:
                        viewBookCommand.execute();
                        break;
                    case 3:
                        borrowBookCommand.execute();
                        break;
                    case 4:
                        returnBookCommand.execute();
                        break;
                    case 5:
                        updateBookCommand.execute();
                        break;
                    case 6:
                        deleteBookCommand.execute();
                        break;
                    case 7:
                        System.out.println("도서 관리 시스템을 종료합니다.");
                        return;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }

    public static void printMainMenus() {
        System.out.println("\n" + AnsiCode.ANSI_YELLOW + "           [도서 관리 시스템]     " + AnsiCode.ANSI_RESET);
        int count = 1;
        for (String mainMenu : menus) {
            System.out.println(count + ". " + mainMenu);
            count++;
        }
        System.out.println();
    }
}
