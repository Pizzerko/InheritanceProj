import java.util.*;
import java.util.UUID;
public class LVM {
    private String name;
    private String uniqueID;
    private ArrayList<VolumeGroups> VolumeGroups;
    private ArrayList<PhysicalHardDrive> hardDrives;

    public LVM(String n) {
        name = n;
        UUID u = UUID.randomUUID();
        uniqueID = u.toString();
        VolumeGroups = new ArrayList<VolumeGroups>();
        hardDrives = new ArrayList<PhysicalHardDrive>();
    }

    public String getName() {
        return name;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public ArrayList<PhysicalHardDrive> getHardDrives() {
        return hardDrives;
    }
    public ArrayList<VolumeGroups> getVolumeGroups() {
        return VolumeGroups;
    }
    public void listHardDrive() {
        for(int i = 0; i < hardDrives.size(); i++) {
            System.out.println(hardDrives.get(i).getName() + " [" + hardDrives.get(i).getSize() + "G]");
        }
    }
    public void listGroups() {

    }

    public void addToListGroup(VolumeGroups obj) {
        VolumeGroups.add(obj);
    }

    public void addToListHardDrive(PhysicalHardDrive obj) {
        hardDrives.add(obj);
    }
}
