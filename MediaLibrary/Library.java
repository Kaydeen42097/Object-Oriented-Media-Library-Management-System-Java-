package block.projects.MediaLibrary;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Media> media = new ArrayList<>();

    public Library() {
        System.out.println("Welcome to your media library!");
        loadLibrary();
        runLibrary();
    }

    private void loadLibrary(){
        System.out.println(Song.getSongCount());
        System.out.println(Book.getBookCount());
        System.out.println(Movie.getMovieCount());
        System.out.println(TvSeries.getTvSeriesCount());
        System.out.println(BoardGame.getBoardGameCount());
        System.out.println(VideoGame.getVideoGameCount());

        // example read to file
        String data_raw = ExtFile.readFile("src/Block/projects/medialibrary","media.txt");
        String[] data = data_raw.split("\n");
        System.out.println(data[0]);


        for(int i = 0; i < data.length; i++) {
            String[] datum = data[i].split("\\|");
            if (datum[0].equals("Song")) media.add(Song.parseSong(data[i]));
            if (datum[0].equals("Movie")) media.add(Movie.parseMovie(data[i]));
            if (datum[0].equals("Book")) media.add(Book.parseBook(data[i]));
            if (datum[0].equals("boardGame")) media.add(BoardGame.parseBoardGame(data[i]));
            if (datum[0].equals("tvseries")) media.add(TvSeries.parseTvSeries(data[i]));
            if (datum[0].equals("video game")) media.add(VideoGame.parseVideoGame(data[i]));
        }
        System.out.println(Song.getSongCount());
        System.out.println(Book.getBookCount());
        System.out.println(Movie.getMovieCount());
        System.out.println(TvSeries.getTvSeriesCount());
        System.out.println(BoardGame.getBoardGameCount());
        System.out.println(VideoGame.getVideoGameCount());
        }

        private void runLibrary(){
            Boolean exit = false;
            Scanner scanner = new Scanner(System.in);
            while (!exit){
                System.out.println("Type what you would like to do, type help for a list of commands\n");
                String command = scanner.nextLine();
                command= command.replace(" ", "");
                if(command.toLowerCase().equals("printsongs") ){
                    printSongs();
                }
                else if(command.toLowerCase().equals("printmovies") ){
                    printMovies();
                }
                else if(command.toLowerCase().equals("printbooks") ){
                    printBooks();
                }
                else if(command.toLowerCase().equals("printtvseries") ){
                    printTvSeries();
                }
                else if(command.toLowerCase().equals("printvideogames") ){
                    printVideoGames();
                }
                else if(command.toLowerCase().equals("printboardgames") ){
                    printBoardGames();
                }
                else if(command.toLowerCase().equals("getsong") ){
                    System.out.println("Type the name of the artist of the song you are looking for\n");
                    String one = scanner.nextLine();
                    System.out.println("Type the name of the song you are looking for\n");
                    String two = scanner.nextLine();
                    getSong(one,two);
                }
                else if(command.toLowerCase().equals("getbook") ){
                    System.out.println("Type the name of the author of the book you are looking for\n");
                    String one = scanner.nextLine();
                    System.out.println("Type the name of the book you are looking for\n");
                    String two = scanner.nextLine();
                    getBook(one,two);
                }
                else if(command.toLowerCase().equals("getmovie") ){
                    System.out.println("Type the name of the director of the movie you are looking for\n");
                    String one = scanner.nextLine();
                    System.out.println("Type the name of the movie you are looking for\n");
                    String two = scanner.nextLine();
                    getMovie(one,two);
                }
                else if(command.toLowerCase().equals("gettvseries") ){
                    System.out.println("Type the name of the director of the TvSeries you are looking for\n");
                    String one = scanner.nextLine();
                    System.out.println("Type the name of the TvSeries you are looking for\n");
                    String two = scanner.nextLine();
                    getTvSeries(one,two);
                }
                else if(command.toLowerCase().equals("getvideogame") ){
                    System.out.println("Type the name of the creator of the video game you are looking for\n");
                    String one = scanner.nextLine();
                    System.out.println("Type the name of the video game you are looking for\n");
                    String two = scanner.nextLine();
                    getVideoGame(one,two);
                }
                else if(command.toLowerCase().equals("getboardgame") ){
                    System.out.println("Type the name of the creator of the board game you are looking for\n");
                    String one = scanner.nextLine();
                    System.out.println("Type the name of the board game you are looking for\n");
                    String two = scanner.nextLine();
                    getBoardGame(one,two);
                }
                else if(command.toLowerCase().equals("removemedia") ){
                    System.out.println("Type the name of the creator of the media you are looking to remove\n");
                    String one = scanner.nextLine();
                    System.out.println("Type the name of the media you are looking for\n");
                    String two = scanner.nextLine();
                    removeMedia(one,two);
                }
                else if(command.toLowerCase().equals("viewdetails") ){
                    viewDetails();
                }
                else if(command.toLowerCase().equals("savelibrary")){
                    saveLibrary();
                }
                else if(command.toLowerCase().equals("addmedia")){
                    addMedia();
                }
                else if(command.toLowerCase().equals("exit")){
                    exit = true;
                }
                else if(command.toLowerCase().equals("help") ){
                    help();
                }else{
                    System.out.println("Your command was invalid please retype what you want or type help to see a list of commands\n");
                }
            }
        }

        private void printSongs(){
            String output = "Songs in library ";
            for(Media m : media){
                if(m instanceof Song){
                    output += " :   " + m.getTitle() + " - " + m.getCreator();
                }
            }
            System.out.println(output);
        }

    private void printMovies(){
        String output = "Movies in library ";
        for(Media m : media){
            if(m instanceof Movie){
                output += " :   " + m.getTitle() + " - " + m.getCreator();
            }
        }
        System.out.println(output);
    }

    private void printBooks(){
        String output = "Books in library ";
        for(Media m : media){
            if(m instanceof Book){
                output += " :   " + m.getTitle() + " - " + m.getCreator();
            }
        }
        System.out.println(output);
    }

    private void printTvSeries(){
        String output = "Tv series in library ";
        for(Media m : media){
            if(m instanceof TvSeries){
                output += " :   " + m.getTitle() + " - " + m.getCreator();
            }
        }
        System.out.println(output);
    }

    private void printVideoGames(){
        String output = "video games in library ";
        for(Media m : media){
            if(m instanceof VideoGame){
                output += " :   " + m.getTitle() + " - " + m.getCreator();
            }
        }
        System.out.println(output);
    }

    private void printBoardGames(){
        String output = "Board games in library ";
        for(Media m : media){
            if(m instanceof BoardGame){
                output += " :   " + m.getTitle() + " - " + m.getCreator();
            }
        }
        System.out.println(output);
    }

    private Song getSong(String artist, String title) {
        for(Media m : media){
            if(m.getCreator().equals(artist) && m.getTitle().equals(title)){
                return (Song)m;
            }
        }
        return null;
    }

    private Book getBook(String author, String title) {
        for(Media m : media){
            if(m.getCreator().equals(author) && m.getTitle().equals(title)){
                return (Book)m;
            }
        }
        return null;
    }

    private Movie getMovie(String director, String title){
        for(Media m : media){
            if(m.getCreator().equals(director) && m.getTitle().equals(title)){
                return (Movie)m;
            }
        }
        return null;
    }

    private TvSeries getTvSeries(String director, String title){
        for(Media m : media){
            if(m.getCreator().equals(director) && m.getTitle().equals(title)){
                return (TvSeries)m;
            }
        }
        return null;
    }

    private VideoGame getVideoGame(String director, String title){
        for(Media m : media){
            if(m.getCreator().equals(director) && m.getTitle().equals(title)){
                return (VideoGame)m;
            }
        }
        return null;
    }

    private BoardGame getBoardGame(String creator, String title){
        for(Media m : media){
            if(m.getCreator().equals(creator) && m.getTitle().equals(title)){
                return (BoardGame)m;
            }
        }
        return null;
    }

    private boolean removeMedia(int index) {
        if(index <= media.size()) {
            media.remove(media.get(index));
            return true;
        }
        return false;
    }

    private boolean removeMedia(String arg1, String arg2) {
        for(int i = 0 ; i < media.size();i++) {
            if (media.get(1).equals(arg1) && media.get(2).equals(arg2)){
                media.remove(i);
                return true;
            }
        }
        return false;
    }

    private void help(){
        System.out.println("Type all the commands exactly as how you see them\n");
        System.out.println("Possible actions: \n");
        System.out.println("Print songs: prints out all the songs in the media library\n");
        System.out.println("Print books: prints out all the books in the media library\n");
        System.out.println("Print movies: prints out all the movies in the media library\n");
        System.out.println("Print tv series: prints out all the tv series in the media library\n");
        System.out.println("Print video games: prints out all the video games in the media library\n");
        System.out.println("Print board games: prints out all the board games in the media library\n");
        System.out.println("Get song: will give you the info on the song of your choice\n");
        System.out.println("Get book: will give you the info on the book of your choice\n");
        System.out.println("Get movie: will give you the info on the movie of your choice\n");
        System.out.println("Get tv series: will give you the info on the tv series of your choice\n");
        System.out.println("Get video game: will give you the info on the video game of your choice\n");
        System.out.println("Get board game: will give you the info on the board game of your choice\n");
        System.out.println("Remove media: will let you remove media from the library must save after to finalize\n");
        System.out.println("View details: will let you view the details of any media you want to\n");
        System.out.println("Save library: will save your current library\n");
        System.out.println("Add media: will let you add media of your choice needs to be saved after to finalize it\n");
        System.out.println("exit: will quit the program");
    }

    private String viewDetails() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the title of the media you would like to view\n");
        String name = scanner.nextLine();
        System.out.println("Type the name of the creator of the media you would like to view\n");
        String maker = scanner.nextLine();
        for(int i = 0 ; i < media.size();i++) {
            if (media.get(1).equals(name) && media.get(2).equals(maker)) {
                return viewDetails();
            }
        }
        return "Your media does not exist";
    }

    private void addMedia() {

    }



    private void saveLibrary(){
        StringBuilder sb = new StringBuilder();
        for (Media m : media){
            sb.append(m.toWriteString()).append("\n");
        }
        ExtFile.writeFile("src/block/projects/MediaLibrary","media.txt" ,sb.toString() );
    }
}
