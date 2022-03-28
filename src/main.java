import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner response = new Scanner(System.in);
        boolean end = false;
        String answer = "";
        while (!end) {
            System.out.println("Input a command: \ncmd# ");
            answer = response.nextLine();
            String[] split = answer.split(" ");
            String command = split[0];
            LVM obj = new LVM("System");

            if(command.equals("install-drive")) {
            int size = Integer.parseInt(split[2]);
            PhysicalHardDrive hd1 = new PhysicalHardDrive(split[1], size);
            obj.addToListHardDrive(hd1);
            hd1.taken();
            }

            else if(command.equals("pvcreate")){
            String name = split[2];
            PhysicalHardDrive hDrive = null;
                for(int ii = 0; ii < obj.getHardDrives().size(); ii++) {
                    if(obj.getHardDrives().get(ii).getName().equals(name)) {
                        if(obj.getHardDrives().get(ii).getTaken())
                        System.out.println("This hard drive already belongs elsewhere!");
                        break;
                    }
                }

            for(int i = 0; i < obj.getHardDrives().size(); i++) {
                if(obj.getHardDrives().get(i).getName().equals(name)) {
                    hDrive = obj.getHardDrives().get(i);
                }
            }
            if(hDrive == null) {
                System.out.println("Error 404, hard drive doesn't exist.");
            }
            else {
                PhysicalVolumes pv1 = new PhysicalVolumes(split[1], hDrive);
            }
            }

            else if(command.equals("vgcreate")) {
                PhysicalVolumes temp = null;
            VolumeGroups vg1 = new VolumeGroups(split[1]);
                for(PhysicalVolumes stuff : vg1.getPhysical()) {
                    if (stuff.getName().equals(split[2])) temp = stuff;
                }
                    vg1.addToListPhysical(temp);
            }

            else if(command.equals("lvcreate")) {

            }

            else if(command.equals("list-drives")) {

            }
            else if(command.equals("pvlist")){

            }
            else if(command.equals("vglist")) {

            }
            else if(command.equals("lvlist")) {

            }
            else if(command.equals("exit")) {
                System.out.println("Saving progress. Goodbye!");
                end = true;
            }
        }
    }
}
