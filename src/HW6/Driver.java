package HW6;

import java.io.FileNotFoundException;
import java.util.ArrayList;



/**
 * Driver class.
 * 
 * @author Po Cheng Chen
 * @version 1.0
 */
public class Driver {
    /**
     * Main method.
     * 
     * @param args Command line args
     */
    public static void main(String[] args) {
        try {
            JazzRecord jazz1 = new JazzRecord(
                "Miles Davis", "So What", "9:22", "04-1959", 10, 'M', true, "Teo Macero");
            JazzRecord jazz2 = new JazzRecord(
                "John Coltrane", "A Love Supreme", "7:43", "01-1965", 15, 'E', true, "Bob Thiele");
            RapRecord rap1 = new RapRecord(
                "Tupac", "California Love", "4:45", "12-1995", 8, 'G', true, "Dr. Dre");
            RapRecord rap2 = new RapRecord(
                "Notorious B.I.G.", "Juicy", "5:02", "08-1994", 12, 'F', true, "Puff Daddy");
            JazzRecord jazz4 = new JazzRecord(
                "Mdfsfds", "wasfsft", "9:22", "04-1959", 10, 'M', true, "eeeeeo");

            ArrayList<Record> records = new ArrayList<>();
            records.add(jazz1);
            records.add(jazz2);
            records.add(rap1);
            records.add(rap2);

            System.out.println("Writing initial records to TestSongs.csv...");
            Songs.stockJukeBox("TestSongs.csv", records);

            JazzRecord jazz3 = new JazzRecord(
                "Duke Ellington", "Take the A Train", "3:55", "02-1941", 20, 'G', true, "Irving Townsend");
            ArrayList<Record> additionalRecords = new ArrayList<>();
            additionalRecords.add(jazz3);

            System.out.println("Adding another JazzRecord to TestSongs.csv...");
            Songs.stockJukeBox("TestSongs.csv", additionalRecords);

            System.out.println("\nReading all records from TestSongs.csv:");
            ArrayList<Record> retrievedRecords = Songs.retrieveRecords("TestSongs.csv");
            for (Record record : retrievedRecords) {
                System.out.println(record);
            }

            System.out.println("\nPlaying 'So What' by Miles Davis...");
            try {
                Songs.playSong("TestSongs.csv", jazz4);
                System.out.println("Song played successfully!");
            } catch (InvalidSongException e) {
                System.out.println("Error playing song: /////////////////" + e.getMessage());
            }

            System.out.println("\nRecords after playing 'So What':");
            retrievedRecords = Songs.retrieveRecords("TestSongs.csv");
            for (Record record : retrievedRecords) {
                System.out.println(record);
            }

            System.out.println("\nRemoving 'Juicy' by Notorious B.I.G...");
            try {
                Songs.removeRecord("TestSongs.csv", rap2);
                System.out.println("Song removed successfully!");
            } catch (InvalidSongException e) {
                System.out.println("Error removing song: " + e.getMessage());
            }

            System.out.println("\nFinal records after removing 'Juicy':");
            retrievedRecords = Songs.retrieveRecords("TestSongs.csv");
            for (Record record : retrievedRecords) {
                System.out.println(record);
            }

            // Songs.retrieveRecords("src/Songs.csv");

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (InvalidSongException e) {
            System.out.println("Invalid song: " + e.getMessage());
        }
    }
}