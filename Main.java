public class Main{
    public static void main(String[] args) {
        Author author = new Author("Mike", "Wasowski", 5);
        Book book = new Book("Monster Inc.", 2000, author, 200);
        System.out.println("Is book big?: " + book.isBig());
        System.out.println("Does book contain word \"monster\"?: " + book.matches("monster"));
        System.out.println("Does book contain word \"flight\"?: " + book.matches("flight"));
        System.out.println("Book's price: " + book.estimatePrice());
    }
}