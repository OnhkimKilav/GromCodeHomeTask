package lesson28;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by Valik on 01.10.2018.
 */
public class FullComparator implements Comparator<Capability> {
    @Override
    public int compare(Capability o1, Capability o2) {
        System.out.println("FullComparator is used");

        Validator<String, String, Date> capabilityValidator = new Validator<>();
        capabilityValidator.validator(o1.getChannelName(), o1.getFingerprint(), o1.getDateCreated());
        capabilityValidator.validator(o2.getChannelName(), o2.getFingerprint(), o2.getDateCreated());

        if(!o1.isActive() && o2.isActive())
            new IsActiveComparator();
        else if (!o1.getChannelName().equals(o2))
            return o1.getChannelName().compareTo(o2.getChannelName());
        else if (!o1.getFingerprint().equals(o2))
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        else
            new DateComparator();

        return 0;
    }
}
