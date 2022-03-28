import java.util.*;
public class VolumeGroups extends LVM{

    private int size;
    private ArrayList<LogicalVolumes> Logical;
    private ArrayList<PhysicalVolumes> Physical;

    public VolumeGroups(String n) {
        super(n);
        Logical = new ArrayList<LogicalVolumes>();
        Physical = new ArrayList<PhysicalVolumes>();
        for(int i = 0; i < Physical.size(); i++) {
            size += Physical.get(i).getHardDrive().getSize();
        }
    }

    public int getSize() {
        return size;
    }

    public ArrayList<PhysicalVolumes> getPhysical() {
        return Physical;
    }

    public ArrayList<LogicalVolumes> getLogical() {
        return Logical;
    }

    public void listPhysical() {
        for(int i = 0; i < Physical.size(); i++) {
            System.out.println("vg" + (i + 1) + ": [" + Physical.get(i).getName() + "] [" + Physical.get(i).getHardDrive().getName() + "]") ;
        }
    }

    public void listLogical() {
        for(int i = 0; i < Logical.size(); i++) {
            System.out.println("lv" + (i + 1) + ": [" + Logical.get(i).getSize() + "] [" + Logical.get(i).getName() + "] [" + Logical.get(i).getUniqueID() + "]");
        }
    }

    public int getAvailableSize() {
        int addedSize = 0;
        for(int i = 0; i < Logical.size(); i++) {
            addedSize += Logical.get(i).getSize();
        }
        return size - addedSize;
    }

    public boolean canAdd(LogicalVolumes obj) {
        int addedSize = 0;
        for(int i = 0; i < Logical.size(); i++) {
            addedSize += Logical.get(i).getSize();
        }
        if(size - addedSize < obj.getSize()) return false;
        return true;
    }

    public void addToListLogical(LogicalVolumes obj) {
        Logical.add(obj);
    }
    public void addToListPhysical(PhysicalVolumes obj) {
        Physical.add(obj);
    }
}
