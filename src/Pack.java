/**
 * The Pack class represents a pack of dinosaurs.
 * @author Po Cheng, Chen
 * @version 1.0
 */
public class Pack {
    private final int size;
    private final String packName;
    /**
     * Constructs a new Pack with the specified size and name.
     *
     * @param size     the size of the pack
     * @param packName the name of the pack
     */
    public Pack(int size, String packName) {
        if (size < 0) {
            this.size = 4;
        } else {
            this.size = size;
        }
        if (packName == null || packName.equals("") || packName.trim().equals("") || packName.isBlank()) {
            this.packName = "The Power Pack";
        } else {
            this.packName = packName;
        }
    }

    /**
     * Returns a string representation of the pack.
     *
     * @return a string representation of the pack
     */
    @Override
    public String toString() {
        return String.format("%s is a family of dinosaurs of size %d!", packName, size);
    }

    /**
     * Returns the size of the pack.
     *
     * @return the size of the pack
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the name of the pack.
     *
     * @return the name of the pack
     */
    public String getName() {
        return packName;
    }
}