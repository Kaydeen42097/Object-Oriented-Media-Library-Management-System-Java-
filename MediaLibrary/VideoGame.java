package block.projects.MediaLibrary;

public class VideoGame extends Media{
    String publisher; // publisher of the game
    double size; // size in gb of the game
    boolean earlyAccess; // if the game is early access
    boolean multiplayer; // if the game supports multiplayer
    private static int videoGameCount;

    //#region Constructors
    public VideoGame(){
        super();
        this.publisher = "";
        this.size = -1;
        this.earlyAccess = false;
        this.multiplayer = false;
        videoGameCount ++;
    }

    public static int getVideoGameCount(){return videoGameCount;}

    public VideoGame(String title, String creator){
        super(title, creator);
        this.publisher = "";
        this.size = -1;
        this.earlyAccess = false;
        this.multiplayer = false;
        videoGameCount ++;
    }

    public VideoGame(String title, String creator, String genre, int releaseYear, double rating, int length, String publisher, double size, boolean earlyAccess, boolean multiplayer) {
        super(title, creator, genre, releaseYear, rating, length);
        this.publisher = publisher;
        this.size = size;
        this.earlyAccess = earlyAccess;
        this.multiplayer = multiplayer;
        videoGameCount ++;
    }
    //#endregion

    //#region Accessors & Mutators

    public String getPublisher() { return publisher; }
    public Double getSize() { return size; }
    public Boolean isEarlyAccess() { return earlyAccess; }
    public Boolean isMultiplayer() { return multiplayer; }

    public void setPublisher(String publisher) { this.publisher = publisher; }
    public void setSize(double size) { this.size = size; }
    public void setEarlyAccess(boolean earlyAccess) { this.earlyAccess = earlyAccess; }
    public void setMultiplayer(boolean multiplayer) { this.multiplayer = multiplayer; }

    public String viewDetails(){
        return "Title: " + getTitle() + "\n" +
                "Director: " + getCreator() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Year made: " + getYear() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Duration: " + getLength() + "\n" +
                "Publisher: " + publisher + "\n" +
                "Size: " + size + "\n" +
                "EarlyAccess: " + earlyAccess + "\n" +
                "Multiplayer: " + multiplayer;
    }

    //#endregion

    @Override
    public String formatLength() {
        // get variables
        String dur = "";
        int length = getLength();

        // find number of hours
        int hours = (int)(Math.floor(length/60));

        // find remaining minutes
        int minutes = length - hours*60;

        // add leading zero if neccessary
        // then add hours/minutes to string
        //if (hours < 10) dur += "0";
        dur += (hours) + ":";
        if (minutes < 10) dur += "0";
        dur += (minutes);

        return dur;
    }

    @Override
    public String toWriteString() {
        return "VideoGame|" + getTitle() + "|" + getCreator() + "|" + getGenre() + "|" + getYear() + "|" + getRating() + "|" + getLength()  + "|" + publisher + "|" + size + "|" + earlyAccess + "|" + multiplayer;
    }

    public static VideoGame parseVideoGame(String data) {
        String[] datam = data.split("\\|");
        return new VideoGame(
            datam[1], // title
            datam[2], // creator
            datam[3], // genre
            Integer.parseInt(datam[4]), // release year
            Double.parseDouble(datam[5]), // rating
            Integer.parseInt(datam[6]), // length
            datam[7], // publisher
            Double.parseDouble(datam[8]), // size
            Boolean.parseBoolean(datam[9]), // early access
            Boolean.parseBoolean(datam[10]) // multiplayer
        );
    }

}
