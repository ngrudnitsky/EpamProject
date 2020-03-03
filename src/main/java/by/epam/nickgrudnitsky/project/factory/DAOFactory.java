package by.epam.nickgrudnitsky.project.factory;

import by.epam.nickgrudnitsky.project.dao.VehicleDAO;
import by.epam.nickgrudnitsky.project.dao.impl.FileVehicleDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final VehicleDAO fileVehicleDAO = new FileVehicleDAO();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public VehicleDAO getFileVehicleDAO() {
        return fileVehicleDAO;
    }
}
