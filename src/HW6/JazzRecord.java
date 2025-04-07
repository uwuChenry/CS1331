package HW6;
/**
 * Represents a jazz record in the music collection.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public class JazzRecord extends Record {
    private String audioEngineer;

    /**
     * Constructs a new JazzRecord.
     *
     * @param artist the musician
     * @param title the title of the record
     * @param duration the length of the record in MM:SS format
     * @param releaseDate the date when the record was released in MM-YYYY format
     * @param timesPlayed the number of times this record has been played
     * @param grade the condition grade of the record (M, E, G, F, or P)
     * @param playable whether the record is currently playable
     * @param audioEngineer the engineer who recorded or mixed the record
     * @throws IllegalArgumentException if audioEngineer is null or blank
     */
    public JazzRecord(
        String artist, String title, String duration,
        String releaseDate, int timesPlayed, char grade,
        boolean playable, String audioEngineer) {
        super(artist, title, duration, releaseDate, timesPlayed, grade, playable);
        if (audioEngineer == null || audioEngineer.isBlank()) {
            throw new IllegalArgumentException("Audio engineer cannot be null or blank");
        }
        this.audioEngineer = audioEngineer;
    }

    /**
     * Returns a string representation of this jazz record.
     *
     * @return a string representation of this jazz record
     */
    @Override
    public String toString() {
        return "JazzRecord," + super.toString() + "," + audioEngineer;
    }

    /**
     * Two jazz records are considered equal if they have the same basic record
     * attributes and the same audio engineer.
     *
     * @param obj the reference object
     * @return true if this jazz record is the same as the obj argument
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof JazzRecord)) {
            return false;
        }
        JazzRecord jazzRecord = (JazzRecord) obj;
        return super.equals(jazzRecord)
            && audioEngineer.equals(jazzRecord.audioEngineer);
    }

}
