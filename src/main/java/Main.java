
public class Main {

    public static void main(String[] args) {

        IO io = new StandardIO();
        AlbumManagement am = new AlbumManagement(io);
        Menus menus = new Menus(io, am);

        menus.mainMenuSwitch();
    }
}
