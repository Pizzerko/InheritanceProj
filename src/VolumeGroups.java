import java.util.*;
public class VolumeGroups extends LVM{

    private ArrayList<PhysicalVolumes> storageList;
    private ArrayList<LogicalVolumes> volumeList;

    public VolumeGroups(String n) {
        super(n);
        storageList = new ArrayList<PhysicalVolumes>();
        volumeList = new ArrayList<LogicalVolumes>();
    }

    
}
