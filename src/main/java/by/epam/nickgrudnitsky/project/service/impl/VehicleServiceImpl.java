package by.epam.nickgrudnitsky.project.service.impl;

import by.epam.nickgrudnitsky.project.dao.VehicleDAO;
import by.epam.nickgrudnitsky.project.entity.CargoAirplane;
import by.epam.nickgrudnitsky.project.entity.CargoShip;
import by.epam.nickgrudnitsky.project.entity.Truck;
import by.epam.nickgrudnitsky.project.entity.Vehicle;
import by.epam.nickgrudnitsky.project.exception.DAOException;
import by.epam.nickgrudnitsky.project.exception.ServiceException;
import by.epam.nickgrudnitsky.project.service.VehicleService;
import by.epam.nickgrudnitsky.project.factory.DAOFactory;
import org.apache.log4j.Logger;

import java.util.Collection;

public class VehicleServiceImpl implements VehicleService {
    static final Logger logger = Logger.getLogger(VehicleServiceImpl.class);
    private final VehicleDAO vehicleDAO;
    private static final String ID_PATTERN = "[0-9]{4}[AST]";

    public VehicleServiceImpl() {
        DAOFactory daoFactory = DAOFactory.getInstance();
        vehicleDAO = daoFactory.getFileVehicleDAO();
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws ServiceException {
        if (vehicle == null) {
            throw new ServiceException("Incorrect vehicle.");
        }
        try {
            vehicleDAO.addVehicle(vehicle);
            logger.info(String.format("Vehicle %s added", vehicle.toString()));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteVehicle(String id) throws ServiceException {
        if (id == null || !id.matches(ID_PATTERN)) {
            throw new ServiceException("Incorrect id - " + id);
        }
        try {
            vehicleDAO.deleteVehicle(id);
            logger.info(String.format("Vehicle with id %s was deleted", id));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Vehicle findById(String id) throws ServiceException {
        try {
            Vehicle vehicle = vehicleDAO.findById(id);
            if (vehicle != null) {
                logger.info(String.format("Vehicle with id %s was found", id));
                return vehicle;
            }
            throw new ServiceException(String.format("Vehicle with id %s wasn't found", id));
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Collection<Vehicle> getAll() throws ServiceException {
        try {
            logger.info("Get all vehicles");
            return vehicleDAO.getAll().values();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Collection<Truck> getAllTrucks() throws ServiceException {
        try {
            logger.info("Get all trucks");
            return vehicleDAO.getAllTrucks();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Collection<CargoAirplane> getAllCargoAirplanes() throws ServiceException {
        try {
            logger.info("Get all cargo airplanes");
            return vehicleDAO.getAllCargoAirplanes();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public Collection<CargoShip> getAllCargoShips() throws ServiceException {
        try {
            logger.info("Get all cargo ships");
            return vehicleDAO.getAllCargoShips();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
