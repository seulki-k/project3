package project3;

public class LibraryMain {

    public static String[] mainMenus = {"등록", "조회","삭제","종료"};

    public static void main(String[] args) {
        LibraryMain.printMainMenus();
    }

    public static void printMainMenus(){
        for (String mainMenu : mainMenus) {
            System.out.println(mainMenu);
        }
    }
}
