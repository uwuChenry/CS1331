public class Pack {
    private int size = 0;
    private String packName;

    public Pack(int size, String packName) {
        if (size < 0) {
            this.size = 4;
        } else {
            this.size = size;
        }
        if (packName == null || packName.equals("")) {
            this.packName = "The Pwer Pack";
        } else {
            this.packName = packName;
        }
    }

    public String toString() {
        return String.format("%s is a family of dinosaurs of size %d!", packName, size);
    }

    public int getSize() {
        return size;
    }

    public String getName() {
        return packName;
    }
}
