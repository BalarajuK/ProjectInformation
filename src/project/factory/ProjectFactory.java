package project.factory;

import project.impl.Project;
import project.interfaces.IProject;

public class ProjectFactory {
    //customerId,contractId,geozone,teamcode,projectcode,buildduration
    public IProject createProject(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new Project(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
