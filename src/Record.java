/**
 * Abstract class representing a music record.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public abstract class Record {
    private String artist;
    private String title;
    private String duration;
    private String releaseDate;
    private int timesPlayed;
    private char grade;
    private boolean playable;

    /**
     * Constructs a new Record with the specified attributes.
     *
     * @param artist the musician or band who performed the record
     * @param title the title of the record
     * @param duration the length of the record in MM:SS format
     * @param releaseDate the date when the record was released in MM-YYYY format
     * @param timesPlayed the number of times this record has been played
     * @param grade the condition grade of the record (M, E, G, F, or P)
     * @param playable whether the record is currently playable
     * @throws IllegalArgumentException if any of the string parameters are null or blank,
     *         if grade is not one of the valid values, or if timesPlayed is negative
     */
    public Record(
        String artist, String title, String duration,
        String releaseDate, int timesPlayed, char grade,
        boolean playable) {
        if (artist == null || duration == null || releaseDate == null
            || artist.isBlank() || duration.isBlank() || releaseDate.isBlank()) {
            throw new IllegalArgumentException("Artist, title, duration, release date null or blank");
        }
        artist = artist.trim();
        title = title.trim();
        duration = duration.trim();
        releaseDate = releaseDate.trim();
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

    /**
     * Returns a string representation of this record.
     * The format is artist,title,duration,releaseDate,timesPlayed,grade,playable.
     *
     * @return a string representation of this record
     */
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%d,%c,%b",
            artist, title, duration, releaseDate, timesPlayed, grade, playable);
    }

    /**
     * Two records are considered equal if they have the same artist, title,
     * duration, release date, times played, grade, and playability.
     *
     * @param obj the reference object with which to compare
     * @return true if this record is the same as the obj argument
     */
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

    /**
     * Gets the grade of this record.
     *
     * @return the condition grade of the record (M, E, G, F, or P)
     */
    public char getGrade() {
        return grade;
    }

    /**
     * Sets the grade of this record.
     * If the provided grade is not one of the valid values (M, E, G, F, P),
     * the grade remains unchanged.
     *
     * @param grade the new condition grade of the record
     */
    public void setGrade(char grade) {
        if (!(grade == 'M' || grade == 'E' || grade == 'G' || grade == 'F' || grade == 'P')) {
            return;
        }
        this.grade = grade;
    }

    /**
     * Gets the number of times this record has been played.
     *
     * @return the number of plays
     */
    public int getTimesPlayed() {
        return timesPlayed;
    }

    /**
     * Sets the number of times this record has been played.
     * If the provided value is negative, the times played remains unchanged.
     *
     * @param timesPlayed the new number of plays
     */
    public void setTimesPlayed(int timesPlayed) {
        if (timesPlayed < 0) {
            return;
        }
        this.timesPlayed = timesPlayed;
    }

    /**
     * Checks if this record is currently playable.
     *
     * @return true if the record is playable, false otherwise
     */
    public boolean isPlayable() {
        return playable;
    }
}
