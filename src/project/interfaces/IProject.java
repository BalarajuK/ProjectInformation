package project.interfaces;

/**
 * An object for a project where it contains details like
 * customer of the project,
 * contract/contractor of the project,
 * team that have been worked on the project
 * Duration of the project
 * Location of project
 * customerId,contractId,geozone,teamcode,projectcode,buildduration
 */
public interface IProject {


    int getCustomerId();

    int getContractId();

    String getGeoZone();

    String getTeamCode();

    /**
     * Project code.
     *
     * @return Project code.
     */
    String getProjectCode();

    /**
     * Time required to complete the project in seconds.
     *
     * @return Time required.
     */
    long getBuildDuration();

}
