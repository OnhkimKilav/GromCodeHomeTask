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
        Validator<String, String> stringValidator = new Validator<>();
        int ret = 0;

        new IsActiveComparator();
        if (o1.getChannelName() == null || o2.getChannelName() == null)
            ret = stringValidator.validator(o1.getChannelName(), o2.getChannelName());
        else if (!o1.getChannelName().equals(o2)) {
            return o1.getChannelName().compareTo(o2.getChannelName());
        } else if (o1.getFingerprint() == null || o2.getFingerprint() == null)
            ret = stringValidator.validator(o1.getFingerprint(), o2.getFingerprint());
        else if (!o1.getFingerprint().equals(o2)) {
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        } else
            new DateComparator();

        return ret;
    }
}
