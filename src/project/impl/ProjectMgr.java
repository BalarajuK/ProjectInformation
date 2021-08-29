package project.impl;

import project.interfaces.IProject;
import project.interfaces.IProjectMgr;
import project.listeners.IProjectListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Container for projects registered with the system.
 */
public class ProjectMgr implements IProjectMgr {
    private final List<IProject> projectList;
    private final List<IProjectListener> listeners;

    public ProjectMgr(List<IProjectListener> listeners) {
        projectList = new ArrayList<>();
        this.listeners = listeners;
    }

    /**
     * Adds a new project to the system.
     *
     * @param project project
     */
    @Override
    public void addProject(IProject project) {
        projectList.add(project);
        listeners.forEach(listener -> listener.projectAdded(project));
    }
}
