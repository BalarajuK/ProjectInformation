package project.interfaces;

import java.util.Set;

public interface IProjectMgr {

    void addProject(IProject project);

    Set<Integer> getContractors();

    Set<String> getGeoZones();

}
