public class PhysicalVolumes extends LVM{

    private PhysicalHardDrive hardDrive;

    public PhysicalVolumes(String n, PhysicalHardDrive hardD) {
        super(n);
        hardDrive = hardD;
    }

    public PhysicalHardDrive getHardDrive() {
        return hardDrive;
    }
}
