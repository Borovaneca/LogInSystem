public class Main {
    public static void main(String[] args) {

        IdAndPassword idAndPassword = new IdAndPassword();


        LoginPage loginPage = new LoginPage(idAndPassword.getLoginInfo());
    }
}
