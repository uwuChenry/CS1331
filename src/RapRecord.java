/**
 * Represents a rap record in the music collection.
 *
 * @author Po Cheng Chen
 * @version 1.0
 */
public class RapRecord extends Record {
    private String producer;

    /**
     * Constructs a new RapRecord with the specified attributes.
     *
     * @param artist the musician or artist who performed the record
     * @param title the title of the record
     * @param duration the length of the record in MM:SS format
     * @param releaseDate the date when the record was released in MM-YYYY format
     * @param timesPlayed the number of times this record has been played
     * @param grade the condition grade of the record (M, E, G, F, or P)
     * @param playable whether the record is currently playable
     * @param producer the producer who produced the record
     * @throws IllegalArgumentException if producer is null or blank
     */
    public RapRecord(
        String artist, String title, String duration,
        String releaseDate, int timesPlayed, char grade,
        boolean playable, String producer) {
        super(artist, title, duration, releaseDate, timesPlayed, grade, playable);
        if (producer == null || producer.isBlank()) {
            throw new IllegalArgumentException("Producer cannot be null or blank");
        }
        this.producer = producer;
    }

    /**
     * Returns a string representation of this rap record.
     *
     * @return a string representation of this rap record
     */
    @Override
    public String toString() {
        return "RapRecord," + super.toString() + "," + producer;
    }

    /**
     * Two rap records are considered equal if they have the same basic record
     * attributes and the same producer.
     *
     * @param obj the reference object with which to compare
     * @return true if this rap record is the same as the obj argument
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RapRecord)) {
            return false;
        }
        RapRecord rapRecord = (RapRecord) obj;
        return super.equals(rapRecord)
            && producer.equals(rapRecord.producer);
    }
}
