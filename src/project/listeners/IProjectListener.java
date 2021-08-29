package project.listeners;

import project.interfaces.IProject;

/**
 * The interface has to be implemented by classes which wants to listen new project addition to the service.
 */
public interface IProjectListener {

    /**
     * This method will be called on all registered listeners with IProjectMgr.
     *
     * @param project project that was newly added into the system.
     */
    void projectAdded(IProject project);
}
