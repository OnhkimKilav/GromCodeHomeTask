package lesson25.HomeTask;

import java.util.Arrays;

/**
 * Created by Valik on 24.09.2018.
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO<Sys> systemDAO = new GeneralDAO<>();
        Sys system1 = new Sys(11, "...");
        Sys system2 = new Sys(12, "...");
        Sys system3 = new Sys(13, "...");
        Sys system4 = new Sys(14, "...");
        Sys system5 = new Sys(15, "...");
        Sys system6 = new Sys(16, "...");
        Sys system7 = new Sys(17, "...");
        Sys system8 = new Sys(18, "...");
        Sys system9 = new Sys(19, "...");
        Sys system10 = new Sys(20, "...");
        systemDAO.save(system1);

        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        systemDAO.save(system2);
        systemDAO.save(system3);
        systemDAO.save(system4);
        systemDAO.save(system5);
        systemDAO.save(system6);
        systemDAO.save(system7);
        systemDAO.save(system8);
        systemDAO.save(system9);
        systemDAO.save(system10);

        System.out.println(Arrays.deepToString(systemDAO.getAll()));

        GeneralDAO<Tool> toolDAO = new GeneralDAO<>();
        Tool tool1 = new Tool("fds", "ddsf");
        toolDAO.save(tool1);

        System.out.println(Arrays.deepToString(toolDAO.getAll()));
    }
}
