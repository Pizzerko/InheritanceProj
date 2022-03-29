public class LogicalVolumes extends LVM{

    private int size;
    private VolumeGroups group;

    public LogicalVolumes(String n, int size, VolumeGroups group) {
        super(n);
        this.size = size;
        this.group = group;
    }

    public int getSize() {
        return size;
    }

}
