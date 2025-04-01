public class JazzRecord extends Record {
    private String audioEngineer;

    public JazzRecord(String artist, String title, String duration, String releaseDate, int timesPlayed, char grade, boolean playable, String audioEngineer) {
        super(artist, title, duration, releaseDate, timesPlayed, grade, playable);
        if (audioEngineer == null || audioEngineer.isBlank()) {
            throw new IllegalArgumentException("Audio engineer cannot be null or blank");
        }
        this.audioEngineer = audioEngineer;
    }

    @Override
    public String toString() {
        return "JazzRecord," + super.toString() + "," + audioEngineer;
    }

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
