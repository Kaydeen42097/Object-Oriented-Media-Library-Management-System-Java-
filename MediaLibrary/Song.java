package block.projects.MediaLibrary;

public class Song extends Media{
    private boolean explicit;
    private static int songCount;

    public Song(){
        this("","");
    }
    public Song(String title, String creator){
        this(title,creator,"",-1,-1,-1,false);
    }
    public Song(String title,String creator, String genre,int year,double rating,int length,boolean explicit){
        super(title,creator,genre,year,rating,length);
        this.explicit = explicit;
        songCount++;
    }

    public static int getSongCount(){return songCount;}

    public String formatLength(){
        int mins = getLength() / 60;
        int secs = getLength() - (mins * 60 );
        String time = mins + " mins " + secs + " secs";
        return time;
    }

    public String toWriteString(){
        return "Song|" + getTitle() + "|" + getCreator() + "|" + getGenre() + "|" + getYear() + "|" +
                getRating() + "|" + getLength() + "|" + explicit;
    }

    public static Song parseSong(String data){

        String[] datum = data.split("\\|");
        return new Song(
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
                "Is explicit: " + explicit;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof Song)) return false;
        Song song = (Song)object;
        if(getTitle().equals(song.getTitle())){
            if(getCreator().equals(song.getCreator())){
                return true;
            }
        }
        return true;
    }
}
