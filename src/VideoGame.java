public class VideoGame extends Media{
    private int maxPlayers;
    private boolean needConsole;
    
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needConsole = needConsole;
    }

    public VideoGame(Genre genre, String name, int rating) {
        super(genre, name, rating, 5.0);
        maxPlayers = 2;
        needConsole = false;
    }

    @Override
    public String toString() {
        return super.toString() + 
                String.format(", layers: %d, ", maxPlayers) +
                String.format("%s need a console", needConsole ? "does" : "does not");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        VideoGame videoGame = (VideoGame) other;
        return this.maxPlayers == videoGame.maxPlayers &&
               this.needConsole == videoGame.needConsole;
    }

    public boolean needConsole() {
        return needConsole;
    }
}
