public class Record {
    private String artist;
    private String title;
    private String duration;
    private String releaseDate;
    private int timesPlayed;
    private char grade;
    private boolean playable;

    public Record (String artist, String title, String duration, String releaseDate, int timesPlayed, char grade, boolean playable) {
        artist = artist.trim();
        title = title.trim();
        duration = duration.trim();
        releaseDate = releaseDate.trim();
        if (artist == null || duration == null || releaseDate == null || artist.isBlank() || duration.isBlank() || releaseDate.isBlank()) {
            throw new IllegalArgumentException("Artist, title, duration, and release date cannot be null or blank");
        }
        if (!(grade == 'M' || grade == 'E' || grade == 'G' || grade == 'F' || grade == 'P')) {
            throw new IllegalArgumentException("Grade must be 'M', 'E', 'G','F' or 'P'");
        }
        if (timesPlayed < 0) {
            throw new IllegalArgumentException("Times played cannot be negative");
        }
        this.artist = artist;
        this.title = title;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.timesPlayed = timesPlayed;
        this.grade = grade;
        this.playable = playable;
    }
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %d, %c, %b", artist, title, duration, releaseDate, timesPlayed, grade, playable);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Record)) {
            return false;
        }
        Record record = (Record) obj;
        return timesPlayed == record.timesPlayed
            && grade == record.grade
            && playable == record.playable
            && artist.equals(record.artist)
            && title.equals(record.title)
            && duration.equals(record.duration)
            && releaseDate.equals(record.releaseDate);
    }
    public char getGrade() {
        return grade;
    }
    public void setGrade(char grade) {
        if (!(grade == 'M' || grade == 'E' || grade == 'G' || grade == 'F' || grade == 'P')) {
            return;
        }
        this.grade = grade;
    }
    public int getTimesPlayed() {
        return timesPlayed;
    }
    public void setTimesPlayed(int timesPlayed) {
        if (timesPlayed < 0) {
            return;
        }
        this.timesPlayed = timesPlayed;
    }

    public boolean isPlayable() {
        return playable;
    }
}
