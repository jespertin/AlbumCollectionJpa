import entities.Album;

public class Menus {

    IO io;
    AlbumManagement am;

    public Menus(IO io, AlbumManagement am) {
        this.io = io;
        this.am = am;
    }

    public void printMainMenu() {
        io.printAnything("""
                          Welcome to your Album Collection
                               
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    Main Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1. Show all albums
                2. Add Album
                3. Update Album
                4. Remove Album
                0. Exit
                __________________________________________________
                """);
    }

    public void mainMenuSwitch() {
        boolean keepGoing = true;

        while (keepGoing) {
            printMainMenu();
            int menuChoice = io.getInt();

            switch (menuChoice) {
                case 1 -> {
                    am.printAllAlbums();
                    io.pauseCode();
                }
                case 2 -> am.addAlbum(am.createAlbum());
                case 3 -> {
                    am.printAllAlbums();
                    Album a = am.findAlbumById();
                    updateMenuSwitch(a);
                }
                case 4 -> {
                    am.printAllAlbums();
                    am.removeAlbum(am.findAlbumById());
                }
                case 0 -> keepGoing = false;
            }
        }
    }

    public void printUpdateMenu() {
        io.printAnything("""
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                                    Update Menu
                -_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-
                1.Update Album Name
                2.Update Artist Name
                3.Update Song Amount
                4.Update Length(min)
                5.Update Rating
                0.Exit to Main Menu
                __________________________________________________
                """);
    }

    public void updateMenuSwitch(Album a) {
        boolean keepGoing = true;

        while (keepGoing) {
            io.printAnything("Currently updating this album: \n" + a);
            printUpdateMenu();
            int menuChoice = io.getInt();
            switch (menuChoice) {
                case 1 -> am.updateAlbumName(a);
                case 2 -> am.updateArtistName(a);
                case 3 -> am.updateSongAmount(a);
                case 4 -> am.updateLength(a);
                case 5 -> am.updateRating(a);
                case 0 -> keepGoing = false;
            }
        }
    }

}
