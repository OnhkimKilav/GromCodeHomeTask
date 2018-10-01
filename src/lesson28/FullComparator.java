package lesson28;

import java.util.Comparator;

/**
 * Created by Valik on 01.10.2018.
 */
public class FullComparator implements Comparator<Capability>{
    @Override
    public int compare(Capability o1, Capability o2) {
        //если channelName не равно - сравниваю по нему
        //если равно - перехожу к fingerprint
        //если fingerprint не равно - сравниваю по нему
        //если равно - перехожу к dateCreated
        //если dateCreated не равно - сравниваю по нему
        //если равно - объекты равны

        System.out.println("FullComparator is used");

        if(!o1.getChannelName().equals(o2))
            return o1.getChannelName().compareTo(o2.getChannelName());
        else if(!o1.getFingerprint().equals(o2))
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        else
            new DateComparator();

        return 0;
    }
}
