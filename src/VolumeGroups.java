import java.util.*;
public class VolumeGroups extends LVM{

    private ArrayList<PhysicalVolumes> storageList;
    private ArrayList<LogicalVolumes> volumeList;
    private int size;

    public VolumeGroups(String n) {
        super(n);
        storageList = new ArrayList<PhysicalVolumes>();
        volumeList = new ArrayList<LogicalVolumes>();
        for(int i = 0; i < storageList.size(); i++) {
            size += storageList.get(i).getHardDrive().getSize();
        }
    }

    public ArrayList<PhysicalVolumes> getStorageList() {
        return storageList;
    }

    public ArrayList<LogicalVolumes> getVolumeList() {
        return volumeList;
    }

    public void listStorage() {
        for(int i = 0; i < storageList.size(); i++) {
            System.out.println(storageList.get(i).getName());
        }
    }
    public void listVolume() {
        for(int i = 0; i < volumeList.size(); i++) {
            System.out.println(volumeList.get(i).getName());
        }
    }

    public boolean canAdd() {
        int addedSize = 0;
        for(int i = 0; i < volumeList.size(); i++) {
            addedSize += volumeList.get(i).getSize();
        }
        if(size - addedSize < 0) return false;
        return true;
    }

    public void addStorage(PhysicalVolumes pv) {
        
    }
    public void addVolume(LogicalVolumes lv) {

    }
}
