package block.projects.MediaLibrary;

import java.util.ArrayList;

public class MediaLibrary {
    public static void main(String[] args) {

        addMediaData();

        new Library();
    }

    private static void addMediaData(){
        ArrayList<Media> media = new ArrayList<>();
        media.addAll(addSongData());
        media.addAll(addBookData());
        media.addAll(addMovieData());
        media.addAll(addBoardGameData());
        media.addAll(addVideoGameData());
        media.addAll(addTvSeriesData());
        StringBuilder sb = new StringBuilder();
        for (Media m : media){
            sb.append(m.toWriteString()).append("\n");
        }
        ExtFile.writeFile("src/block/projects/MediaLibrary","media.txt" ,sb.toString() );
    }

    private static ArrayList<Song> addSongData(){
        ArrayList<Song> songs = new ArrayList<>();
        songs.add( new Song("Goosebumps" , "Travis Scott" , "Hip-Hop",2016,4.7,244,true));
        songs.add(new Song("Stargazing","Travis Scott","Hip-Hop",2018,4.8,270,true));
        songs.add(new Song("Riptide" , "Vance Joy", "Indie" , 2013,4.6,203,false));
        songs.add(new Song("Sunflower","Post Malone & Swae Lee","Pop",2018,4.9,158,false));
        songs.add(new Song("Blinding Lights","The Weekend","Pop",2019,4.9,200,false));
        songs.add(new Song("The Less I Know the Better" , "Tame Impala" , "Indie",2015,4.8,216,false));
        songs.add ( new Song("Bad Habit","Steve Lacy","R&B",2022,4.7,231,true));
        songs.add (new Song("Heat Waves" , "Glass Animals", "Pop" , 2020,4.6,238,false));
        songs.add (new Song("X Gon’ Give It to Ya","DMX","Hip-Hop",2003,4.5,210,true));
        songs.add ( new Song("See You Again","Tyler, The Creator ft. Kali Uchis","Hip-Hop",2017,4.9,180,false));
        return songs;
    }
    private static ArrayList<Movie> addMovieData() {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Inception", "Christopher Nolan", "Sci-Fi", 2010, 8.8, 148, "PG-13", 160000000, false, new String[]{"Leonardo DiCaprio", "Joseph Gordon-Levitt", "Ellen Page"} ));
        movies.add(new Movie("The Dark Knight", "Christopher Nolan", "Action", 2008, 9.0, 152, "PG-13", 185000000, true, new String[]{"Christian Bale", "Heath Ledger", "Aaron Eckhart"} ));
        movies.add(new Movie("Interstellar", "Christopher Nolan", "Sci-Fi", 2014, 8.6, 169, "PG-13", 165000000, false,new String[]{"Matthew McConaughey", "Anne Hathaway", "Jessica Chastain"} ));
        movies.add(new Movie("The Matrix", "The Wachowskis", "Sci-Fi", 1999, 8.7, 136, "R", 63000000, true,new String[]{"Keanu Reeves", "Laurence Fishburne", "Carrie-Anne Moss"} ));
        movies.add(new Movie("Gladiator", "Ridley Scott", "Drama", 2000, 8.5, 155, "R", 103000000, true,new String[]{"Russell Crowe", "Joaquin Phoenix", "Connie Nielsen"} ));
        movies.add(new Movie("The Social Network", "David Fincher", "Drama", 2010, 7.8, 120, "PG-13", 40000000, false,new String[]{"Jesse Eisenberg", "Andrew Garfield", "Justin Timberlake"} ));
        movies.add(new Movie("Get Out", "Jordan Peele", "Horror", 2017, 7.8, 104, "R", 4500000, false,new String[]{"Daniel Kaluuya", "Allison Williams", "Bradley Whitford"} ));
        movies.add(new Movie("Whiplash", "Damien Chazelle", "Drama", 2014, 8.5, 107, "R", 3300000, false,new String[]{"Miles Teller", "J.K. Simmons", "Paul Reiser"} ));
        movies.add(new Movie("The Shawshank Redemption", "Frank Darabont", "Drama", 1994, 9.3, 142, "R", 25000000, false,new String[]{"Tim Robbins", "Morgan Freeman", "Bob Gunton"} ));
        movies.add(new Movie("La La Land", "Damien Chazelle", "Romance", 2016, 8.0, 128, "PG-13", 30000000, false,new String[]{"Ryan Gosling", "Emma Stone", "John Legend"} ));
        return movies;
    }
    private static ArrayList<Book> addBookData(){
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("To Kill a Mockingbird","Harper Lee","Fiction",1960,9.6,336,true));
        books.add(new Book("1984","George Orwell","Dystopian",1949,9.4,328,false));
        books.add(new Book("The Great Gatsby","F. Scott Fitzgerald","Classic",1925,9.1,180,true));
        books.add(new Book("Moby-Dick","Herman Melville","Adventure",1851,8.5,635,false));
        books.add(new Book("Pride and Prejudice","Jane Austen","Romance",1813,9.3,279,true));
        books.add(new Book("The Hobbit","J.R.R. Tolkien","Fantasy",1937,9.2,310,true));
        books.add(new Book("The Catcher in the Rye","J.D. Salinger","Fiction",1951,8.8,277,false));
        books.add(new Book("Fahrenheit 451","Ray Bradbury","Dystopian",1953,9.0,194,true));
        books.add(new Book("The Alchemist","Paulo Coelho","Adventure",1988,8.9,208,false));
        books.add(new Book("Harry Potter and the Sorcerer’s Stone","J.K. Rowling","Fantasy",1997,9.5,309,true));
        return books;
    }
    private static ArrayList<BoardGame> addBoardGameData(){
        ArrayList<BoardGame> boardGames = new ArrayList<>();
        boardGames.add(new BoardGame("Catan","Klaus Teuber","Strategy",1995,8.1,60,4,49.99));
        boardGames.add(new BoardGame("Ticket to Ride","Alan R. Moon","Strategy",2004,7.9,45,5,54.99));
        boardGames.add(new BoardGame("Pandemic","Matt Leacock","Cooperative",2008,8.4,45,4,44.99));
        boardGames.add(new BoardGame("Chess","Unknown","Abstract",1475,9.2,60,2,19.99));
        boardGames.add(new BoardGame("Monopoly","Charles Darrow","Economic",1935,6.2,120,6,24.99));
        boardGames.add(new BoardGame("Splendor","Marc André","Engine Building",2014,8.0,30,4,39.99));
        boardGames.add(new BoardGame("Azul","Michael Kiesling","Abstract",2017,8.2,40,4,39.99));
        boardGames.add(new BoardGame("Gloomhaven","Isaac Childres","Adventure",2017,9.0,120,4,139.99));
        boardGames.add(new BoardGame("Clue","Anthony E. Pratt","Mystery",1949,7.0,45,6,19.99));
        boardGames.add(new BoardGame("Carcassonne","Klaus-Jürgen Wrede","Tile Placement",2000,8.1,40,5,34.99));
        return boardGames;
    }
    private static ArrayList<VideoGame> addVideoGameData() {
        ArrayList<VideoGame> videoGame = new ArrayList<>();
        videoGame.add(new VideoGame("Ultrakill", "Hakita", "Shooter", 2020, 9.7, 10, "New Blood Interactive", 2.59, true, false));
        videoGame.add(new VideoGame("Outer Wilds", "Mobius Digital", "Puzzle", 2020, 9.5, 25, "Annapurna Interactive", 10.85, false, false));
        videoGame.add(new VideoGame("Lobotomy Corporation", "Project Moon", "Simulator", 2018, 9.3, 120, "Project Moon", 5.15, false, false));
        videoGame.add(new VideoGame("Disillusion ST", "Disillusion Dev", "Adventure", 2024, 9.5, 20, "Disillusion Dev", 5.05, false, false));
        videoGame.add(new VideoGame("Omori", "Omocat", "RPG", 2020, 9.7, 20, "Omocat", 1.9, false, false));
        videoGame.add(new VideoGame("Signalis", "rose-engine", "Survival Horror", 2022, 9.6, 12, "Humble Games", 0.97, false, false));
        videoGame.add(new VideoGame("Fortnite", "Epic Games", "Shooter", 2017, 7.8, -1, "Epic Games", 50, false, true));
        videoGame.add(new VideoGame("Endless Monday: Dreams and Deadlines", "hcnone", "Visual Novel", 2023, 9,8, "hcnone", 0.22, false, false));
        videoGame.add(new VideoGame("NieR:Automata", "Square Enix", "RPG", 2017, 9.0, 30, "Square Enix", 43.64, false, false));
        videoGame.add(new VideoGame("Crow Country", "SFB Games", "Survival Horror", 2024, 9.8, 7, "SFB Games", 1.22, false, false));
        videoGame.add(new VideoGame("Tom Clancy's Rainbow Six Siege", "Ubisoft Montreal", "Shooter", 2015, 9.0, -1, "Ubisoft", 60, false, true));
        videoGame.add(new VideoGame("Terraria", "Re-Logic", "Adventure", 2011, 9.7, 50, "Re-Logic", 0.66, false, true));
        videoGame.add(new VideoGame("Undertale", "tobyfox", "RPG", 2015, 9.6, 10, "tobyfox", 0.16, false, false));
        videoGame.add(new VideoGame("Deltarune", "tobyfox", "RPG", 2025, 9.8, 16, "tobyfox", 1, false, false));
        return videoGame;
    }
    private static ArrayList<TvSeries> addTvSeriesData() {
        ArrayList<TvSeries> tvSeries = new ArrayList<>();
        tvSeries.add(new TvSeries("Rick and Morty", "Dan Harmon", "Satire, Comedy", 2013, 9.0, 23, 8, new String[]{"Dan Harmon", "Chris Parnell", "Elon Musk (guest)", "Mathew Broderick (guest)"}));
        tvSeries.add(new TvSeries("Game of Thrones", "David Benioff", "Adventure epic", 2011, 9.2, 60, 74, new String[]{"Peter Dinklage", "Emilia Clarke", }));
        tvSeries.add(new TvSeries("The Simpsons", "Matt Groening", "Animation, Comedy", 1989, 8.7, 22, 760, new String[]{"Dan Castellaneta", "Nancy Cartwright", "Harry Shearer", "Yeardley Smith"}));
        tvSeries.add(new TvSeries("Severance", "Dan Erickson", "Sci-Fi, Thriller", 2022, 8.7, 55, 9, new String[]{"Adam Scott", "Patricia Arquette", "John Turturro", "Britt Lower"}));
        tvSeries.add(new TvSeries("Breaking Bad", "Vince Gilligan", "Crime, Drama, Thriller", 2008, 9.5, 47, 62, new String[]{"Bryan Cranston", "Aaron Paul", "Anna Gunn", "Giancarlo Esposito"}));
        tvSeries.add(new TvSeries("Stranger Things", "The Duffer Brothers", "Science Fiction", 2016, 8.8, 50, 34, new String[] {"Millie Bobby Brown", "Finn Wolfhard", "Winona Ryder"}));
        tvSeries.add(new TvSeries("The Office", "Greg Daniels", "Comedy", 2005, 8.9, 22, 201, new String[] {"Steve Carell", "John Krasinski", "Jenna Fischer"}));
        tvSeries.add(new TvSeries("Avatar: The Last Airbender", "Michael Dante DiMartino & Bryan Konietzko", "Animation", 2005, 9.3, 24, 61, new String[] {"Zach Tyler Eisen", "Mae Whitman", "Jack De Sena"}));
        tvSeries.add(new TvSeries("Sherlock", "Mark Gatiss & Steven Moffat", "Mystery Crime", 2010, 9.1, 90, 13, new String[] {"Benedict Cumberbatch", "Martin Freeman", "Andrew Scott"}));
        tvSeries.add(new TvSeries("The Mandalorian", "Jon Favreau", "Science Fiction", 2019, 8.7, 40, 24, new String[] {"Pedro Pascal", "Gina Carano", "Carl Weathers"}));
        return tvSeries;
    }
}
