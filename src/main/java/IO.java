public interface IO {

    String getString();

    int getInt();

    double getValidDoubleForRating();

    <T> void printAnything(T t);

    void exit();

    void pauseCode();
}
