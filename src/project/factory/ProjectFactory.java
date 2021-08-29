package project.factory;

import project.impl.Project;
import project.interfaces.IProject;

/**
 * Factory for creating projects.
 */
public class ProjectFactory {
    /**
     * Creates project with given details.
     *
     * @param customerId    Customer Id of the project.
     * @param contractId    Contract Id of the project.
     * @param geoZone       Geo Zone of the project.
     * @param teamCode      Team code of the project.
     * @param projectCode   Project code of the project.
     * @param buildDuration Build duration fo the project.
     * @return project
     */
    public IProject createProject(int customerId, int contractId, String geoZone, String teamCode, String projectCode, long buildDuration) {
        return new Project(customerId, contractId, geoZone, teamCode, projectCode, buildDuration);
    }
}
