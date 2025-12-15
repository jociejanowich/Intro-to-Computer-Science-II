public abstract class Item{
    //variables
    private int id;
    private String title;
    private int numberCopies;
    //default constructors 
    public Item(){
        id = 0;
        title = "";
        numberCopies = 0;
    }
    //alternate constructors
    public Item(int id, String title, int numberCopies){
        this.id = id;
        this.title = title;
        this.numberCopies = numberCopies;
    }
    //get id
    public int getId(){
        return id;
    }
    //get title
    public String getTitle(){
        return title;
    }
    //get number of copies
    public int getNumberCopies(){
        return numberCopies;
    }
    //set id
    public void setId(int id){
        this.id = id;
    }
    //set title
    public void setTitle(String title){
        this.title = title;
    }
    //set number of copies 
    public void setNumberOfCopies(int numberCopies){
        this.numberCopies = numberCopies;
    }
    //equals
    public boolean equals(Item otherItem){
        if(otherItem == null) return false;
        if(!(otherItem instanceof Item)) return false;

        Item other = (Item) otherItem;
        return this.id == other.id &&
               this.numberCopies == other.numberCopies &&
               this.title.equals(other.title);
    }
    //toString 
    public String toString(){
        return "ID: " + id + " Title: " + title + " Number of Copies: " + numberCopies;
    }
    //print
    public void print(){
        System.out.println("ID: " + id + " Title: " + title + " Number of Copies: " + numberCopies);
    }
    //check in
    public void checkIn(){
        numberCopies++;
    }
    //check out 
    public void checkOut(){
        if(numberCopies > 0){
            numberCopies--;
        }
        else{
            System.out.println("No copies available");
        }
    }
    //add item
    public void addItem(int number){
        numberCopies += number;
    }
    //main
   public static void main(String [] args){
        Book b = new Book(123456, "To Kill a mocking bird", 4, "Harper Lee");
        b.print();
        b.checkOut();
        System.out.println("After check-out: ");
        b.print();

        Video v = new Video(1111, "The Godfather", 3, 215, "Francis Ford Coppola", "drama",1981);
        v.print();
        System.out.println("");
        v.checkIn();
        System.out.println("After check-in:");
        v.print();
    }
}

//written item sublclass
abstract class WrittenItem extends Item{
    private String author;
    //constructor
    public WrittenItem(int id, String title, int numberCopies, String author){
        super(id, title, numberCopies);
        this.author = author;
    }
    //getter
    public String getAuthor(){
        return author;
    }
    //setter
    public void setAuthor(String author){
        this.author = author;
    }
    //toString
    public String toString(){
        return super.toString() + " Author: " + author; 
    }
}
class Book extends WrittenItem{
    //constructor
    public Book(int id, String title, int numberCopies, String author){
        super(id, title, numberCopies, author);
    }
    //overide print BOOK info
    public void print(){
        System.out.println("Information of book: ");
        System.out.println(this.toString());
    }
}
class JournalPaper extends WrittenItem{
    private int yearPublished;
    //constructor
    public JournalPaper(int id, String title, int numberCopies, String author, int yearPublished){
        super(id, title, numberCopies,author);
        this.yearPublished = yearPublished;
    }
    //getter
    public int getYearPublished(){
        return yearPublished;
    }
    //setter
    public void setYearPublished(int yearPublished){
        this.yearPublished = yearPublished;
    }
    //overide print JOURNAL PAPER method
    public void print(){
        System.out.println("Journal Paper Information: ");
        System.out.println(this.toString());
    }
}
abstract class MediaItem extends Item{
    private int runtime;
    //constructor
    public MediaItem(int id, String title, int numberCopies, int runtime){
        super(id, title, numberCopies);
        this.runtime = runtime;
    }
    //getter
    public int getRuntime(){
        return runtime;
    }
    //setter
    public void setRuntime(int runtime){
        this.runtime = runtime;
    }
    //toString
    public String toString(){
        return super.toString() + "Runtime: " + runtime;
    }
}
class Video extends MediaItem{
    private String director; 
    private String genre;
    private int yearReleased;
    public Video(int id, String title, int numberCopies, int runtime, String director, String genre, int yearReleased){
        super(id, title, numberCopies, runtime);
        this.director = director;
        this.genre = genre;
        this.yearReleased = yearReleased;
    }
    //getters
    public String getDirector(){
        return director;
    }
    public String getGenre(){
        return genre;
    }
    public int getYearReleased(){
        return yearReleased;
    }
    //setters
    public void setDirector(String director){
        this.director = director;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    public void setYearReleased(int yearReleased){
        this.yearReleased = yearReleased;
    }
    //overide print VIDEO title
    public void print(){
        System.out.print("Video Information: ");
        System.out.print(this.toString());
    }
}
class CD extends MediaItem{
    private String artist;
    private String genre;
    //constructor
    public CD(int id, String title, int numberCopies, int runtime, String artist, String genre){
        super(id, title, numberCopies, runtime);
        this.artist = artist;
        this.genre = genre;
    }
    //getter
    public String getArtist(){
        return artist;
    }
    public String getGenre(){
        return genre;
    }
    //setter
    public void setArtist(String artist){
        this.artist = artist;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    //overide print CD title
    public void print(){
        System.out.print("CD Information: ");
        System.out.print(this.toString());
    }
}