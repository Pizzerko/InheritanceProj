public class LogicalVolumes extends LVM{

    private int size;

    public LogicalVolumes(String n, int size) {
        super(n);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
