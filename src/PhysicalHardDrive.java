import java.util.ArrayList;

public class PhysicalHardDrive extends LVM{

    private int size;
    private boolean taken;

    public PhysicalHardDrive(String n, int size) {
        super(n);
        this.size = size;
        taken = false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public boolean getTaken() {
        return taken;
    }
    public void taken() {
        taken = true;
    }


}
