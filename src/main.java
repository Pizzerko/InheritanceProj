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

            }

            else if(command.equals("pvcreate")){

            }

            else if(command.equals("vgcreate")) {

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
