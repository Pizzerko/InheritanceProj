public class PhysicalVolumes extends LVM{

    private PhysicalHardDrive hardDrive;
    private boolean taken;
    private VolumeGroups volumeGroup;

    public PhysicalVolumes(String n, PhysicalHardDrive hardD) {
        super(n);
        hardDrive = hardD;
    }


    public PhysicalHardDrive getHardDrive() {
        return hardDrive;
    }
    public boolean getTaken() {
        return taken;
    }
    public void taken() {
        taken = true;
    }
    public VolumeGroups getVolumeGroup() {
        return volumeGroup;
    }
    public void addVolumeG(VolumeGroups vg) {
        volumeGroup = vg;
    }
}
