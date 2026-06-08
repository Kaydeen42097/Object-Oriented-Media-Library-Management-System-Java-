package block.projects.MediaLibrary;

public abstract class Media {
    private String title;
    private String creator;
    private String genre;
    private int year;
    private double rating;
    private int length;

    public Media(){
        this("","");
    }

    public Media(String title , String creator){
        this(title,creator,"",-1,-1,-1);

    }

    public Media(String title, String creator, String genre, int year, double rating, int length){
        this.title = title;
        this.creator = creator;
        this.genre = genre;
        this.year = year;
        this.rating = rating;
        this.length = length;
    }

    public abstract String formatLength();
    public abstract String toWriteString();
    public abstract String viewDetails();


    public String getTitle(){return title;}
    public void setTitle(String title ){this.title = title;}
    public String getCreator(){return creator;}
    public void setCreator(String creator){this.creator = creator;}
    public String getGenre(){return genre;}
    public void setGenre(String genre){this.genre = genre;}
    public int getYear(){return year;}
    public void setYear(int year){this.year = year;}
    public double getRating(){return rating;}
    public void setRating(double rating){this.rating = rating;}
    public int getLength(){return length;}
    public void setLength(int length){this.length = length;}

}
