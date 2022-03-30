import java.util.*;

public class Lister {
    private ArrayList<PhysicalHardDrive> hardDrives;
    private ArrayList<LogicalVolumes> Logical;
    private ArrayList<PhysicalVolumes> Physical;
    private ArrayList<VolumeGroups> VGroups;

    public Lister() {
        hardDrives = new ArrayList<PhysicalHardDrive>();
        Logical = new ArrayList<LogicalVolumes>();
        Physical = new ArrayList<PhysicalVolumes>();
        VGroups = new ArrayList<VolumeGroups>();
    }

    public boolean installDrive(String name, int size) {
        for(PhysicalHardDrive drives : hardDrives) {
            if(drives.getName().equals(name)) return false;
        }
        PhysicalHardDrive hd1 = new PhysicalHardDrive(name, size);
        hardDrives.add(hd1);
        return true;
    }

    public void listHardDrive() {
        for(int i = 0; i < hardDrives.size(); i++) {
            System.out.println(hardDrives.get(i).getName() + " [" + hardDrives.get(i).getSize() + "G]");
        }
    }
    public boolean pvCreate(String name, String driveName) {
        PhysicalHardDrive phd = null;
        for(PhysicalHardDrive drives : hardDrives) {
            if(drives.getName().equals(driveName)) phd = drives;
        }
        if(phd == null) return false;
        if(phd.getTaken()) return false;
        PhysicalVolumes pv = new PhysicalVolumes(name, phd);
        Physical.add(pv);
        phd.taken();
        return true;
    }

    public void listPhysical() {
        for(int i = 0; i < Physical.size(); i++) {
            if (Physical.get(i).getTaken()) {
                System.out.println("pv" + (i + 1) + ": [" + Physical.get(i).getHardDrive().getSize() + "] [" + Physical.get(i).getVolumeGroup().getName() + "] [" + Physical.get(i).getUniqueID() + "]");
            }
            else{
                System.out.println("pv" + (i + 1) + ": [" + Physical.get(i).getHardDrive().getSize() + "] [" + Physical.get(i).getUniqueID() + "]");
            }
        }
    }

    public boolean lvCreate(String name, int size, String vgName) {
        VolumeGroups vg = null;
        for(VolumeGroups groups : VGroups) {
            if(groups.getName().equals(vgName)) vg = groups;
        }
        if(vg == null) return false;
        LogicalVolumes lv = new LogicalVolumes(name, size, vg);
        if(vg.addLV(lv) == false) return false;
        Logical.add(lv);
        vg.addLV(lv);
        return true;
    }
    public void listLogical() {
        for(int i = 0; i < Logical.size(); i++) {
            System.out.println("lv" + (i + 1) + ": [" + Logical.get(i).getSize() + "] [" + Logical.get(i).getName() + "] [" + Logical.get(i).getUniqueID() + "]");
        }
    }

    public boolean vgCreate(String vgName, String pvName) {
        PhysicalVolumes pv = null;
        for(PhysicalVolumes physicalV : Physical) {
            if(physicalV.getName().equals(pvName)) pv = physicalV;
        }
        if(pv == null) return false;
        if(pv.getTaken()) return false;
        VolumeGroups vg = new VolumeGroups(vgName, pv);
        VGroups.add(vg);
        pv.taken();
        pv.addVolumeG(vg);
        return true;
    }

    public boolean vgExtend(String vgName, String pvName) {
        PhysicalVolumes pv = null;
        for(PhysicalVolumes physicalV : Physical) {
            if(physicalV.getName().equals(pvName)) pv = physicalV;
        }
        if(pv == null) return false;
        VolumeGroups vg = null;
        for(VolumeGroups vGroup : VGroups) {
            if(vGroup.getName().equals(vgName)) vg = vGroup;
        }
        if(vg == null) return false;
        vg.extendVg(pv);
        Physical.add(pv);
        pv.taken();
        return true;
    }

    public void vgList() {
        for(int i = 0; i < VGroups.size(); i++) {
            System.out.print("vg" + (i + 1) + ": total: [" + VGroups.get(i).getSize() + "G] available: [" + VGroups.get(i).getAvailableSize() + "G] [");
        for(int ii = 0; ii < VGroups.get(i).getPhysical().size(); ii++) {
            System.out.print(VGroups.get(i).getPhysical().get(ii).getName() + "] [");
        }
        System.out.println(VGroups.get(i).getUniqueID() +"]");
        }
    }

}
