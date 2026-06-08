package block.projects.MediaLibrary;

public class Book extends Media{
    private boolean hardcover;
    private static int bookCount;

    public Book(){
        this("","");
    }
    public Book(String title, String creator){
        this(title,creator,"",-1,-1,-1,false);
    }
    public Book(String title,String creator, String genre,int year,double rating,int length,boolean hardcover){
        super(title,creator,genre,year,rating,length);
        this.hardcover = hardcover;
        bookCount++;
    }

    public static int getBookCount(){return bookCount;}

    public String formatLength(){
        String pages = getLength() + " pages";
        return pages;
    }

    public String toWriteString(){
        return "Book|" + getTitle() + "|" + getCreator() + "|" + getGenre() + "|" + getYear() + "|" + getRating() +
                "|" + getLength() + "|" + hardcover;
    }

    public static Book parseBook(String data){

        String[] datum = data.split("\\|");
        return new Book(
                datum[1], // title
                datum[2], // creator
                datum[3], // genre
                Integer.parseInt(datum[4]), // year
                Double.parseDouble(datum[5]), //rating
                Integer.parseInt(datum[6]), // length
                Boolean.parseBoolean(datum[7]) //explicit
        );
    }

    public String viewDetails(){
        return "Title: " + getTitle() + "\n" +
                "Director: " + getCreator() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Year made: " + getYear() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Duration: " + getLength() + "\n" +
                "Is a hardcover: " + hardcover ;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Book)) return false;
        Book book = (Book)object;
        if(getTitle().equals(book.getTitle())){
            if(getCreator().equals(book.getCreator())){
                return true;
            }
        }
        return true;
    }

}
