public class PhysicalHardDrive extends LVM{

    private int size;

    public PhysicalHardDrive(String n, int size) {
        super(n);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

}
