package by.epam.nickgrudnitsky.project.service;

import by.epam.nickgrudnitsky.project.entity.CargoAirplane;
import by.epam.nickgrudnitsky.project.entity.CargoShip;
import by.epam.nickgrudnitsky.project.entity.Truck;
import by.epam.nickgrudnitsky.project.entity.Vehicle;
import by.epam.nickgrudnitsky.project.exception.ServiceException;

import java.util.Collection;

public interface VehicleService {
    void addVehicle(Vehicle vehicle) throws ServiceException;

    void deleteVehicle(String id) throws ServiceException;

    Vehicle findById(String id) throws ServiceException;

    Collection<Vehicle> getAll() throws ServiceException;

    Collection<Truck> getAllTrucks() throws ServiceException;

    Collection<CargoAirplane> getAllCargoAirplanes() throws ServiceException;

    Collection<CargoShip> getAllCargoShips() throws ServiceException;
}
