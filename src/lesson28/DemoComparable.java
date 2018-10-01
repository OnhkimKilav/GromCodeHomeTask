package lesson28;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Valik on 01.10.2018.
 */
public class DemoComparable {
    public static void main(String[] args) {
        Capability capability1 = new Capability(1001, "test", "rrrr", true, new Date());
        Capability capability2 = new Capability(1005, "test", "rrrr", true, new Date());
        Capability capability3 = new Capability(900, "test", "rrrr", true, new Date());

        Set<Capability> capabilitySet = new TreeSet<>();
        capabilitySet.add(capability1);
        capabilitySet.add(capability2);
        capabilitySet.add(capability3);

        System.out.println(capabilitySet);
    }
}
