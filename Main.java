public class Main {
    public static void main(String[] args) {
        CooldownManager cooldownManager = new CooldownManager();

        cooldownManager.createCooldown("1", 15);
        cooldownManager.createCooldown("2", 0);

        for (int i = 0; i < 2; i++) {
            System.out.println(cooldownManager.checkCooldown(String.valueOf(i)));
        }
    }
}
