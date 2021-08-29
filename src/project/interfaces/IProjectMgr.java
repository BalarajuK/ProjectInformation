package project.interfaces;

/**
 * Container for projects registered with the system.
 */
public interface IProjectMgr {

    /**
     * Adds a new project to the system.
     *
     * @param project project
     */
    void addProject(IProject project);
}
