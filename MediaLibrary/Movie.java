package block.projects.MediaLibrary;

import java.util.ArrayList;

public class Movie extends Media{
    private String mpa;
    private int budget;
    private boolean sequel;
    private String[] actors;
    private static int movieCount;

    public Movie(){
        this("","");
    }
    public Movie(String title, String creator){
        this(title,creator,"",-1,-1,-1,"",-1,false,null);
    }
    public Movie(String title,String creator, String genre,int year,double rating,int length,String mpa,int budget,boolean sequel,String[] actors){
        super(title,creator,genre,year,rating,length);
        this.mpa = mpa;
        this.budget = budget;
        this.sequel = sequel;
        this.actors = actors;
        movieCount ++;
    }

    public static int getMovieCount(){return movieCount;}

    public String formatLength(){
        return "";
    }

    public String toWriteString(){
        return "Movie|" +  getTitle() + "|" + getCreator() + "|" + getGenre() + "|" + getYear() + "|" + getRating() +
                "|" + getLength() + "|" + mpa + "|" + budget + "|" + sequel + "|" + actors ;
    }

    public static Movie parseMovie(String data){

        String[] datum = data.split("\\|");
        String actorString = datum[10];
        actorString = actorString.substring(1,actorString.length() -1);
        String[] a = actorString.split(", ");

        return new Movie(
                datum[1], // title
                datum[2], // creator
                datum[3], // genre
                Integer.parseInt(datum[4]), // year
                Double.parseDouble(datum[5]), //rating
                Integer.parseInt(datum[6]), // length
                datum[7],
                Integer.parseInt(datum[8]),
                Boolean.parseBoolean(datum[9]),
                a
        );
    }

    public String viewDetails(){
        return "Title: " + getTitle() + "\n" +
                "Director: " + getCreator() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Year made: " + getYear() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Duration: " + getLength() + "\n" +
                "Mpa: " + mpa + "\n" +
                "Budget: " + budget + "\n" +
                "Part of a series: " + sequel + "\n" +
                "Top actors: " + actors ;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Movie)) return false;
        Movie movie = (Movie)object;
        if(getTitle().equals(movie.getTitle())){
            if(getCreator().equals(movie.getCreator())){
                return true;
            }
        }
        return true;
    }
}
