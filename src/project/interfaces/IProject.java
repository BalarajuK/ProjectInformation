package project.interfaces;

/**
 * An object for a project where it contains details like
 * customer of the project,
 * contract/contractor of the project,
 * team that have been worked on the project
 * Duration of the project
 * Location of project *
 */
public interface IProject {

    /**
     * Gets the customerId of the project.
     *
     * @return customerId
     */
    int getCustomerId();

    /**
     * Gets the ContractId for the project.
     *
     * @return ContractId
     */
    int getContractId();

    /**
     * Gets the geo zone of the project.
     *
     * @return geo zone.
     */
    String getGeoZone();

    /**
     * Gets the team code of the project.
     *
     * @return team code
     */
    String getTeamCode();

    /**
     * Get the project code.
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