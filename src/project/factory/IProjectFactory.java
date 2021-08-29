package project.factory;

import project.interfaces.IProject;

public interface IProjectFactory {

    //customerId,contractId,geozone,teamcode,projectcode,buildduration
    IProject createProject(String customerId, String contractId, String geoZone, String teamCode, String projectCode, long buildDuration);
}
