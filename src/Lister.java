import java.util.*;

public class Lister {
    private ArrayList<PhysicalHardDrive> hardDrives;
    private ArrayList<LogicalVolumes> Logical;
    private ArrayList<PhysicalVolumes> Physical;
    private ArrayList<VolumeGroups> VolumeGroups;

    public Lister() {
        hardDrives = new ArrayList<PhysicalHardDrive>();
        Logical = new ArrayList<LogicalVolumes>();
        Physical = new ArrayList<PhysicalVolumes>();
        VolumeGroups = new ArrayList<VolumeGroups>();
    }

    public ArrayList<PhysicalHardDrive> getHardDrives() {
        return hardDrives;
    }

    public ArrayList<LogicalVolumes> getLogical() {
        return Logical;
    }

    public ArrayList<PhysicalVolumes> getPhysical() {
        return Physical;
    }

    public ArrayList<VolumeGroups> getVolumeGroups() {
        return VolumeGroups;
    }

    public void listHardDrive() {
        for(int i = 0; i < hardDrives.size(); i++) {
            System.out.println(hardDrives.get(i).getName() + " [" + hardDrives.get(i).getSize() + "G]");
        }
    }
}
