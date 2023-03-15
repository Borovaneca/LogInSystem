import java.util.HashMap;

public class IdAndPassword {

    private HashMap<String, String> loginInfo;

    public IdAndPassword() {
        this.loginInfo = new HashMap<>();
        this.loginInfo.put("Borovaneca", "Borovaneca1");
    }

    public HashMap<String, String> getLoginInfo() {
        return this.loginInfo;
    }
}
