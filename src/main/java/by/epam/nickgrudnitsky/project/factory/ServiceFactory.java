package by.epam.nickgrudnitsky.project.factory;

import by.epam.nickgrudnitsky.project.service.VehicleService;
import by.epam.nickgrudnitsky.project.service.impl.VehicleServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final VehicleService vehicleService = new VehicleServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public VehicleService getVehicleService() {
        return vehicleService;
    }
}
