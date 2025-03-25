public class VideoGame extends Media{
    private int maxPlayers;
    private boolean needsConsole;
    
    public VideoGame(Genre genre, String name, int rating, double rentalPrice, int maxPlayers, boolean needConsole) {
        super(genre, name, rating, rentalPrice);
        this.maxPlayers = maxPlayers;
        this.needsConsole = needConsole;
    }

    public VideoGame(Genre genre, String name, int rating) {
        super(genre, name, rating, 5.0);
        maxPlayers = 2;
        needsConsole = false;
    }

    @Override
    public String toString() {
        return super.toString() + 
                String.format(", Players: %d, ", maxPlayers) +
                String.format("%s need a console", needsConsole ? "does" : "does not");
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        if (!super.equals(other)) return false;
        VideoGame videoGame = (VideoGame) other;
        return this.maxPlayers == videoGame.maxPlayers &&
               this.needsConsole == videoGame.needsConsole;
    }

    public boolean needConsole() {
        return needsConsole;
    }
}
