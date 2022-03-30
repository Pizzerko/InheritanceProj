import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        Scanner response = new Scanner(System.in);
        Lister runner = new Lister();
        boolean end = false;
        String answer = "";
        while (!end) {
            System.out.println("Input a command: \ncmd# ");
            answer = response.nextLine();
            String[] split = answer.split(" ");
            String command = split[0];
            LVM obj = new LVM("System");

            if(command.equals("install-drive")) {
                if(runner.installDrive(split[1], Integer.parseInt(split[2])) == false) System.out.println("Error 404");
                else{
                    System.out.println("Drive Installion Successful");
                }
            }

            else if(command.equals("pvcreate")){
            if(runner.pvCreate(split[1], split[2]) == false) System.out.println("Error, broken.");
            else {
                System.out.println("Physical Volume Scucessfully Installed");
            }
            }

            else if(command.equals("vgcreate")) {
            if(runner.vgCreate(split[1], split[2]) == false) System.out.println("Fix your error, same name, taken physical v, or doesn't exist.");
            else{
                System.out.println("Volume Group Scucessfully Installed");
            }
            }

            else if(command.equals("vgextend")) {
                if(runner.vgExtend(split[1], split[2]) == false) System.out.println("A mistake was made, same name,taken physical volume, or doesn't exist.");
                else{
                    System.out.println("Volume Group Sucessfully Extended");
                }
            }

            else if(command.equals("lvcreate")) {
            if(runner.lvCreate(split[1], Integer.parseInt(split[2]), split[3]) == false) System.out.println("Program broken, overloaded.");
            else{
                System.out.println("Logical Volume Scucessfully Installed");
            }
            }

            else if(command.equals("list-drives")) {
                runner.listHardDrive();
            }
            else if(command.equals("pvlist")){
            runner.listPhysical();
            }
            else if(command.equals("vglist")) {
            runner.vgList();
            }
            else if(command.equals("lvlist")) {
            runner.listLogical();
            }
            else if(command.equals("exit")) {
                System.out.println("Saving progress. Goodbye!");
                end = true;
            }
        }
    }
}
