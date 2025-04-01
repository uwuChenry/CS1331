public class RapRecord extends Record {
    private String producer;

    public RapRecord(String artist, String title, String duration, String releaseDate, int timesPlayed, char grade, boolean playable, String producer) {
        super(artist, title, duration, releaseDate, timesPlayed, grade, playable);
        if (producer == null || producer.isBlank()) {
            throw new IllegalArgumentException("Producer cannot be null or blank");
        }
        this.producer = producer;
    }

    @Override
    public String toString() {
        return "RapRecord," + super.toString() + "," + producer;
    }

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
