import java.util.*;
public class VolumeGroups extends LVM{

    private int size;
    private ArrayList<LogicalVolumes> Logical;
    private ArrayList<PhysicalVolumes> Physical;

    public VolumeGroups(String n, PhysicalVolumes pv) {
        super(n);
        Logical = new ArrayList<LogicalVolumes>();
        Physical = new ArrayList<PhysicalVolumes>();
        for(int i = 0; i < Physical.size(); i++) {
            size += Physical.get(i).getHardDrive().getSize();
        }
        Physical.add(pv);
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

    public void extendVg(PhysicalVolumes pv)
    {
        Physical.add(pv);
        size += pv.getHardDrive().getSize();
    }


    public boolean addLV(LogicalVolumes lv)
    {
        int lvSize = lv.getSize();
        if(getAvailableSize() < lvSize)
        {
            return false;
        }
        else
        {
            Logical.add(lv);
            size += lvSize;
            return true;
        }
    }
}
