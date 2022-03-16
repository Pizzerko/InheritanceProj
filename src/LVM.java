import java.util.UUID;
public class LVM {
    private String name;
    private String uniqueID;

    public LVM(String n) {
        name = n;
        UUID u = UUID.randomUUID();
        uniqueID = u.toString();
    }

    public String getName() {
        return name;
    }

    public String UUID() {
        return uniqueID;
    }


}
