package project3;

import project3.command.LibraryCommand;
import project3.util.Prompt;
import project3.vo.AnsiCode;

import java.util.Scanner;

public class LibraryMain {

    public static String[] mainMenus = {"등록", "조회", "대출", "삭제", "종료"};
    static LibraryCommand libraryCommand = new LibraryCommand();


    public static void main(String[] args) {
        LibraryMain.printMainMenus();
        Scanner scanner = new Scanner(System.in);
        int command = Prompt.inputInt("입력할 번호는?", (Object) mainMenus);
        System.out.println(command);
        libraryCommand.excute();
    }

    public static void printMainMenus() {
        System.out.println("\n" + AnsiCode.ANSI_YELLOW + "           [도서 관리 시스템]     " + AnsiCode.ANSI_RESET);
        int count = 1;
        for (String mainMenu : mainMenus) {
            System.out.println(count + ". " + mainMenu);
            count++;
        }
        System.out.println();
    }
}
