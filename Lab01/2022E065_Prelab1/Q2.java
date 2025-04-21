//2022e065
//Question_02

// Main class
public class Q2{
    public static void main(String[] args) {
        // Creating an array of Book objects
        Book[] books = new Book[4];

        // Initializing the array with Book objects
        books[0] = new Book("Dark_Magic", "Renujan", 2500.99);
        books[1] = new Book("King_in_Black", "Kilshan", 3200.99);
        books[2] = new Book("FreeFire_Tips", "Gowtham", 3000.99);
		books[3] = new Book("Football_Forever", "Anojinth", 3800.99);

        // Displaying the details of each book
        for (Book book : books) {
            book.displayDetails();
        }
    }
}

// Book 
class Book {
    // Attributes of the Book class
    private String TITLE;
    private String AUTHOR;
    private double PRICE;

    // Constructor to initialize the book details
    public Book(String title, String author, double price) {
        this.TITLE = title;
        this.AUTHOR = author;
        this.PRICE = price;
    }

    //display the book
    public void displayDetails() {
        System.out.println("Title: " + TITLE);
        System.out.println("Author: " + AUTHOR);
        System.out.println("Price: Rs" + PRICE);
        System.out.println("------------------------");
    }
}