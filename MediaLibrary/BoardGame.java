package block.projects.MediaLibrary;

public class BoardGame extends Media {
    private int players;
    private double cost;
    private static int boardGameCount;

    public BoardGame(){
        this("","");
    }
    public BoardGame(String title, String creator){
        this(title, creator,"",-1,-1,-1,-1,-1);
    }
    public BoardGame(String title,String creator, String genre,int year,double rating,int length,int players,double cost){
        super(title,creator,genre,year,rating,length);
        this.players = players;
        this.cost = cost;
        boardGameCount++;
    }
    public static int getBoardGameCount(){return boardGameCount;}

    public String formatLength(){
        int hrs = getLength() / 60;
        int mins = getLength() - (hrs * 60 );
        String time = hrs + " hours " + mins + " minutes";
        return time;
    }

    public String toWriteString(){
        return "BoardGame|" + getTitle() + "|" + getCreator() + "|" + getGenre() + "|" + getYear() + "|" +
                getRating() + "|" + getLength() + "|" + players + "|" + cost;
    }

    public static BoardGame parseBoardGame(String data){

        String[] datum = data.split("\\|");
        return new BoardGame(
                datum[1], // title
                datum[2], // creator
                datum[3], // genre
                Integer.parseInt(datum[4]), // year
                Double.parseDouble(datum[5]), //rating
                Integer.parseInt(datum[6]),// length
                Integer.parseInt(datum[7]), // players
                Double.parseDouble(datum[8]) // cost

        );
    }

    public String viewDetails(){
        return "Title: " + getTitle() + "\n" +
                "Director: " + getCreator() + "\n" +
                "Genre: " + getGenre() + "\n" +
                "Year made: " + getYear() + "\n" +
                "Rating: " + getRating() + "\n" +
                "Duration: " + getLength() + "\n" +
                "Players: " + players + "\n"+
                "Cost: " + cost;
    }

    @Override
    public boolean equals(Object object){
        if(!(object instanceof BoardGame)) return false;
        BoardGame boardGame = (BoardGame)object;
        if(getTitle().equals(boardGame.getTitle())){
            if(getCreator().equals(boardGame.getCreator())){
                return true;
            }
        }
        return true;
    }
}
