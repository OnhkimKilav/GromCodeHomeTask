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

        new IsActiveComparator();
        if (!o1.getChannelName().equals(o2)) {

            if (stringValidator.validator(o1.getChannelName(), o2.getChannelName()) == 0)
                return o1.getChannelName().compareTo(o2.getChannelName());

            return stringValidator.validator(o1.getChannelName(), o2.getChannelName());
        } else if (!o1.getFingerprint().equals(o2)) {

            if (stringValidator.validator(o1.getFingerprint(), o2.getFingerprint()) == 0)
                return o1.getFingerprint().compareTo(o2.getFingerprint());

            return stringValidator.validator(o1.getFingerprint(), o2.getFingerprint());
        } else
            new DateComparator();

        return 0;
    }
}
