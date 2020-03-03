package by.epam.nickgrudnitsky.project.dao;

import by.epam.nickgrudnitsky.project.entity.CargoAirplane;
import by.epam.nickgrudnitsky.project.entity.CargoShip;
import by.epam.nickgrudnitsky.project.entity.Truck;
import by.epam.nickgrudnitsky.project.entity.Vehicle;
import by.epam.nickgrudnitsky.project.exception.DAOException;

import java.util.Collection;
import java.util.Map;

public interface VehicleDAO {
    void addVehicle(Vehicle vehicle) throws DAOException;

    void deleteVehicle(String id) throws DAOException;

    Vehicle findById(String id) throws DAOException;

    Map<String, Vehicle> getAll() throws DAOException;

    Collection<Truck> getAllTrucks() throws DAOException;

    Collection<CargoAirplane> getAllCargoAirplanes() throws DAOException;

    Collection<CargoShip> getAllCargoShips() throws DAOException;
}
