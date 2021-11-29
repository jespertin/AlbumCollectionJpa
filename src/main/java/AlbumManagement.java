import entities.Album;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AlbumManagement {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU");
    IO io;

    public AlbumManagement(IO io) {
        this.io = io;
    }

    public Album createAlbum() {
        io.printAnything("Album name: ");
        String albumName = io.getString();
        io.printAnything("Artist name: ");
        String artistName = io.getString();
        io.printAnything("Song amount: ");
        int songAmount = io.getInt();
        io.printAnything("Album length in min: ");
        int albumLength = io.getInt();
        io.printAnything("Album rating (0-10) : ");
        double albumRating = io.getValidDoubleForRating();

        return new Album(albumName, artistName, songAmount, albumLength, albumRating);
    }

    public void addAlbum(Album a) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();

        io.printAnything("Album Added!");
        io.pauseCode();
    }

    public Album findAlbumById() {
        EntityManager em = emf.createEntityManager();

        io.printAnything("Id of Album: ");
        int id = io.getInt();
        Album a = em.find(Album.class, id);
        em.close();

        return a;
    }

    public void removeAlbum(Album a) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.merge(a));
        em.getTransaction().commit();
        em.close();

        io.printAnything("Album removed!");
        io.pauseCode();
    }

    public List<Album> getAllAlbums() {
        EntityManager em = emf.createEntityManager();

        return em.createQuery("select a from Album a", Album.class).getResultList();
    }

    public void printAllAlbums() {
        getAllAlbums().forEach(io::printAnything);
    }

    public void updateAlbumName(Album a) {
        EntityManager em = emf.createEntityManager();

        io.printAnything("New Album Name: ");
        a.setAlbumName(io.getString());

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();

        io.printAnything("Album Name updated!");
        io.pauseCode();
    }

    public void updateArtistName(Album a) {
        EntityManager em = emf.createEntityManager();

        io.printAnything("New Artist Name: ");
        a.setArtistName(io.getString());

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();

        io.printAnything("Artist Name updated!");
        io.pauseCode();
    }

    public void updateSongAmount(Album a) {
        EntityManager em = emf.createEntityManager();

        io.printAnything("New Song Amount: ");
        a.setSongAmount(io.getInt());

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
        io.printAnything("Song amount updated!");
        io.pauseCode();
    }

    public void updateLength(Album a) {
        EntityManager em = emf.createEntityManager();

        io.printAnything("New Album Length(min): ");
        a.setAlbumLengthInMin(io.getInt());

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();

        io.printAnything("Length updated!");
        io.pauseCode();
    }

    public void updateRating(Album a) {
        EntityManager em = emf.createEntityManager();

        io.printAnything("New Rating 0-10: ");
        a.setRatingOutOfTen(io.getValidDoubleForRating());

        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();

        io.printAnything("Rating updated!");
        io.pauseCode();
    }

}
