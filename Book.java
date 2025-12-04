public class Book {
    public String title;
    public int releaseYear;
    public Author author;
    int pages;

    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
    }

    public boolean isBig() {
        return (pages > 500);
    }

    public boolean matches(String word) {
        return (title.toLowerCase().contains(word.toLowerCase()) ||
                author.name.toLowerCase().contains(word.toLowerCase()) ||
                author.surname.toLowerCase().contains(word.toLowerCase()));
    }

    public int estimatePrice() {
        int price = pages * 3 * (int) Math.floor(Math.sqrt(author.rating));
        return Math.max(250, price);
    }
}
