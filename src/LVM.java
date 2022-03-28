import java.util.*;
import java.util.UUID;
public class LVM {
    private String name;
    private String uniqueID;
    private ArrayList<VolumeGroups> VolumeGroups;

    public LVM(String n) {
        name = n;
        UUID u = UUID.randomUUID();
        uniqueID = u.toString();
        VolumeGroups = new ArrayList<VolumeGroups>();
    }

    public String getName() {
        return name;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public ArrayList<VolumeGroups> getVolumeGroups() {
        return VolumeGroups;
    }

}
