package by.epam.nickgrudnitsky.project.service;



import by.epam.nickgrudnitsky.project.entities.Plan;

import java.util.Comparator;

public class InternetTrafficComparator implements Comparator<Plan> {
    @Override
    public int compare(Plan o1, Plan o2) {

        // -1 означает безлимитный трафик
        if (o1.getVolumeOfInternetTraffic() == -1 && o2.getVolumeOfInternetTraffic() != -1) {
            return -1;
        }
        if (o1.getVolumeOfInternetTraffic() != -1 && o2.getVolumeOfInternetTraffic() == -1) {
            return 1;
        }
        return Double.compare(o1.getVolumeOfInternetTraffic(), o2.getVolumeOfInternetTraffic());
    }
}
