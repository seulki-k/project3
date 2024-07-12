package project3;

import project3.command.*;
import project3.vo.AnsiCode;
import project3.vo.AuthGrade;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class LibraryMain {
    static Map<String, Command> commandMap = new HashMap<>();
    public static String[] menus = {"등록", "조회/변경", "대여", "반납", "삭제", "종료"};
    public static String[] guestMenus = {"대여", "반납", "종료"};

    public static TestCommand testCommand = new TestCommand();

    public static Scanner scanner = new Scanner(System.in);

    public LibraryMain() {
        commandMap.put("등록", new AddBookCommand());
        commandMap.put("조회/변경", new ViewBookCommand());
        commandMap.put("대여", new BorrowBookCommand());
        commandMap.put("반납", new ReturnBookCommand());
        commandMap.put("삭제", new DeleteBookCommand());
    }

    public static void main(String[] args) {
        new LibraryMain();
        testCommand.execute();
        while (true) {
            System.out.println("\n접속 권한을 입력해주세요[GUEST, ADMIN]. ");
            String grade = scanner.nextLine();
            if (grade.equalsIgnoreCase("admin") || grade.equalsIgnoreCase("guest")) {
                AuthGrade authGrade = AuthGrade.valueOf(grade.toUpperCase());
                System.out.println("당신의 등급은 " + authGrade.getDescription() + "입니다.");
                if (authGrade.getDescription().equalsIgnoreCase("관리자")) {
                    LibraryMain.adminMenus(authGrade);
                }
                if (authGrade.getDescription().equalsIgnoreCase("손님")) {
                    LibraryMain.guestMenus(authGrade);
                }
            } else {
                System.out.println("없는 권한입니다. 정확한 권한을 입력해주세요.");

            }
        }
    }

    public static void printMainMenus(AuthGrade grade) {
        System.out.println("\n" + AnsiCode.ANSI_YELLOW + "           [도서 관리 시스템]     " + AnsiCode.ANSI_RESET);

        if (grade.getDescription().equalsIgnoreCase("관리자")) {
            int count = 1;
            for (String mainMenu : menus) {
                System.out.println(count + ". " + mainMenu);
                count++;
            }
        }
        if (grade.getDescription().equalsIgnoreCase("손님")) {
            int count = 1;
            for (String mainMenu : guestMenus) {
                System.out.println(count + ". " + mainMenu);
                count++;
            }
        }
        System.out.println();

    }

    public static void adminMenus(AuthGrade grade) {
        printMainMenus(grade);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[Main] > ");
            try {
                String command = scanner.nextLine();
                if (command.equals("menu")) {
                    printMainMenus(grade); //menu 입력 시 메뉴 출력
                    continue;
                }
                if (command.equals("6")) return; // 6입력 시 종료
                Command com = commandMap.get(menus[Integer.parseInt(command) - 1]);
                com.execute();

            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }

    public static void guestMenus(AuthGrade grade) {
        printMainMenus(grade);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[Main] > ");
            ;
            try {
                String command = scanner.nextLine();
                if (command.equals("menu")) printMainMenus(grade); //menu 입력 시 메뉴 출력
                if (command.equals("3")) return; // 3입력 시 종료
                Command com = commandMap.get(menus[Integer.parseInt(command) - 1]);
                com.execute();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}

