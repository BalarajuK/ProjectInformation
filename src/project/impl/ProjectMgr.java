package project.impl;

import project.interfaces.IProject;
import project.interfaces.IProjectMgr;
import project.listeners.IProjectListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ProjectMgr implements IProjectMgr {
    private final List<IProject> projectList;
    private final List<IProjectListener> listeners;

    public ProjectMgr(List<IProjectListener> listeners) {
        projectList = new ArrayList<>();
        this.listeners = listeners;
    }

    @Override
    public void addProject(IProject project) {
        projectList.add(project);
        listeners.forEach(listener->listener.projectAdded(project));
    }

    @Override
    public Set<Integer> getContractors() {
        return projectList.stream()
                .map(IProject::getContractId)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getGeoZones() {
        return projectList.stream()
                .map(IProject::getGeoZone)
                .collect(Collectors.toSet());
    }
}
