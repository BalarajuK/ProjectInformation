package project.query;

import project.interfaces.IProject;
import project.interfaces.query.IBuildDurationQuery;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildDurationQuery implements IBuildDurationQuery {


    private final Map<String, Duration> buildDurationMap;

    public BuildDurationQuery() {
        buildDurationMap = new HashMap<>();
    }

    @Override
    public long getAverageBuildDuration(String geoZone) {
        Duration duration = buildDurationMap.get(geoZone);
        if (duration != null) {
            return duration.getAverage();
        }
        return 0;
    }

    @Override
    public void projectAdded(IProject project) {
        Duration duration = buildDurationMap.computeIfAbsent(project.getGeoZone(), key -> new Duration());
        duration.addDuration(project.getBuildDuration());
    }

    static class Duration {
        private int projectCount = 0;
        private long duration = 0;

        long getAverage() {
            return duration / projectCount;
        }

        public void addDuration(long duration) {
            this.duration += duration;
            projectCount++;
        }
    }

    @Override
    public List<String> getGeoZones() {
        return List.copyOf(buildDurationMap.keySet());
    }
}
