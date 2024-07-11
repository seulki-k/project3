package project3;

import project3.vo.AnsiCode;


public class LibraryMain {

    public static String[] mainMenus = {"등록", "조회", "대여","반납", "수정", "삭제", "종료"};


    public static void main(String[] args) {
        LibraryMain.printMainMenus();

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
