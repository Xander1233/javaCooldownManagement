import java.util.ArrayList;
import java.sql.Timestamp;

public class CooldownManager {

    private ArrayList<Cooldown> _cooldowns = new ArrayList<>();

    /**
     * Returns false when cooldown is still running or nothing was found
     * Returns true when cooldown has exceded its limit and deletes the cooldown
     */
    public boolean checkCooldown(String identifier) {

        Cooldown cooldown = null;

        for (int i = 0; i < _cooldowns.size(); i++) {
            Cooldown currentCooldown = _cooldowns.get(i);
            if (currentCooldown.getIdentifier().equals(identifier)) {
                cooldown = currentCooldown;
                break;
            }
        }
        if (cooldown == null) return false;

        Timestamp time = new Timestamp(System.currentTimeMillis());

        if ((time.getTime() - cooldown.getLength()) < cooldown.getTime()) {
            _cooldowns.remove(cooldown);
            return true;
        }

        return false;
    }

    public void createCooldown(String identifier, int length) {
        _cooldowns.add(new Cooldown(identifier, length));
    }
}
