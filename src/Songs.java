import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Songs {
    public static ArrayList<Record> retrieveRecords(String path) throws FileNotFoundException, InvalidSongException {
        ArrayList<Record> records = new ArrayList<>();
        try (java.util.Scanner scanner = new java.util.Scanner(new java.io.File(path))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                records.add(processInfo(line));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        return records;
    }

    private static Record processInfo(String line) throws InvalidSongException{
        String[] parts = line.split(",");
        if (!(parts[0].trim().equals("JazzRecord") || parts[0].trim().equals("RapRecord"))) {
            throw new InvalidSongException();
        }
        String type = parts[0].trim();
        String artist = parts[1].trim();
        String title = parts[2].trim();
        String duration = parts[3].trim();
        String releaseDate = parts[4].trim();
        int timesPlayed = Integer.parseInt(parts[5].trim());
        char grade = parts[6].trim().charAt(0);
        boolean playable = Boolean.parseBoolean(parts[7].trim());
        String producer = parts[8].trim();

        if (type.equals("JazzRecord")) {
            return (new JazzRecord(artist, title, duration, releaseDate, timesPlayed, grade, playable, producer));
        } else if (type.equals("RapRecord")) {
            return (new RapRecord(artist, title, duration, releaseDate, timesPlayed, grade, playable, producer));
        } else {
            throw new InvalidSongException();
        }
    }

    public void stockJukeBox(String path, ArrayList<Record> records) throws FileNotFoundException, InvalidSongException {
        java.io.File file = new java.io.File(path);
        ArrayList<Record> oldRecords = new ArrayList<>();
        if (file.exists()) {
            try (java.util.Scanner scanner = new java.util.Scanner(file)) {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    oldRecords.add(processInfo(line));
                }
            } catch (FileNotFoundException e) {
                throw new FileNotFoundException();
            }
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (java.io.IOException e) {
                throw new FileNotFoundException();
            }
        }
        oldRecords.addAll(records);
        try (java.io.PrintWriter writer = new java.io.PrintWriter(file)) {
            for (Record record : oldRecords) {
                if (record.getGrade() =='P') {
                    continue;
                }
                writer.println(record.toString());
            }
        } catch (java.io.IOException e) {
            throw new FileNotFoundException();
        }

    }

    public static ArrayList<Integer> findSongs(String path, Record record) throws FileNotFoundException, IllegalArgumentException, InvalidSongException {
        if (record == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<Record> records = retrieveRecords(path);
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < records.size(); i++) {
            if (records.get(i).equals(record)) {
                indexes.add(i);
            }
        }
        if (indexes.isEmpty()) {
            throw new InvalidSongException();
        } else {
            return indexes;
        }
    }

    public static void playSong (String path, Record record) throws FileNotFoundException, InvalidSongException {
        ArrayList<Integer> indexes = findSongs(path, record);
        ArrayList<Record> records = retrieveRecords(path);
        ArrayList<Record> newRecords = new ArrayList<>();

        for (int index : indexes) {
            Record r = records.get(index);
            r.setTimesPlayed(r.getTimesPlayed() + 1);
            if (Math.random() < 0.3) {
                // Lower the grade
                char currentGrade = r.getGrade();
                char newGrade;
                
                switch (currentGrade) {
                    case 'M': // Mint -> Excellent
                        newGrade = 'E';
                        break;
                    case 'E': // Excellent -> Good
                        newGrade = 'G';
                        break;
                    case 'G': // Good -> Fair
                        newGrade = 'F';
                        break;
                    case 'F': // Fair -> Poor
                        newGrade = 'P';
                        break;
                    default:
                        newGrade = currentGrade; // Shouldn't happen but just in case
                }
                
                // Set the new grade
                r.setGrade(newGrade);
                System.out.println("Record scratched! Grade lowered to: " + newGrade);
            }
            newRecords.add(r);
        }

    }
}
