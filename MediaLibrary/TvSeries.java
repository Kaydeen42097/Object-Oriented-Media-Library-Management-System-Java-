package block.projects.MediaLibrary;

import java.util.Arrays;

public class TvSeries extends Media{
    private int episodes;
    private String[] actors;
    private static int tvSeriesCount;

    public TvSeries() { super();
        tvSeriesCount ++;}

    public TvSeries(String title, String creator){ super(title,creator);
        tvSeriesCount ++;}

    public TvSeries(String title, String creator, String genre, int releaseYear, double rating, int length, int episodes, String[] actors){
        super(title, creator, genre, releaseYear, rating, length);
        this.episodes = episodes;
        this.actors = actors;
        tvSeriesCount ++;
    }

    public static int getTvSeriesCount(){return tvSeriesCount;}

    public String formatLength(){
        int mins = getLength()%60;
        int hours = (getLength()-mins)/60;
        if (mins<=9) return Integer.toString(hours) + ": 0" + Integer.toString(mins);
        return Integer.toString(hours) + ":" + Integer.toString(mins);
    }

    public String toWriteString(){
        return "TvSeries|" + getTitle() + "|" + getCreator() + "|" + getGenre() + "|" + getYear() + "|" + getRating() + "|" + getLength() + "|" + episodes + "|" + Arrays.toString(actors);
    }

    public static TvSeries parseTvSeries(String data) {
        String[] datum = data.split("\\|");
        String[] actors = datum[8].substring(1, datum[8].length() - 1).split(", ");
        return new TvSeries(
                datum[1], // title
                datum[2], // creator
                datum[3], // genre
                Integer.parseInt(datum[4]), // release year
                Double.parseDouble(datum[5]), // rating
                Integer.parseInt(datum[6]), // length
                Integer.parseInt(datum[7]), // episodes
                actors
        );
    }

    public String viewDetails(){
        return "Title: " + getTitle() + "\n" +
                "Director: " + getCreator() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Year made: " + getYear() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Duration: " + getLength() + "\n" +
                "Episode count: " + episodes + "\n" +
                "Top actors: " + actors;
    }
}