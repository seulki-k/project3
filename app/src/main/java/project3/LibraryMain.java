package project3;

import project3.command.*;
import project3.vo.AnsiCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LibraryMain {
    static Map<String, Command> commandMap = new HashMap<>();
    public static String[] menus = {"등록", "조회/변경", "대여", "반납", "삭제", "종료"};

    public static TestCommand testCommand = new TestCommand();

    public LibraryMain() {
        commandMap.put("등록", new AddBookCommand());
        commandMap.put("조회/변경", new ViewBookCommand());
        commandMap.put("대여", new BorrowBookCommand());
        commandMap.put("반납", new ReturnBookCommand());
        commandMap.put("삭제", new DeleteBookCommand());
    }

    public static void main(String[] args) {
        new LibraryMain();
        LibraryMain.printMainMenus();
        testCommand.execute();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[Main] > ");
            try {
                String command = scanner.nextLine();
                if (command.equals("menu")) printMainMenus(); //menu 입력 시 메뉴 출력
                if (command.equals("6")) return; // 6입력 시 종료
                Command com = commandMap.get(menus[Integer.parseInt(command) - 1]);
                com.execute();

            } catch (Exception e) {
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
