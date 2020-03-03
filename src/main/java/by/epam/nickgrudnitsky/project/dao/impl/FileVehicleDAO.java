package by.epam.nickgrudnitsky.project.dao.impl;

import by.epam.nickgrudnitsky.project.dao.VehicleDAO;
import by.epam.nickgrudnitsky.project.entity.CargoAirplane;
import by.epam.nickgrudnitsky.project.entity.CargoShip;
import by.epam.nickgrudnitsky.project.entity.Truck;
import by.epam.nickgrudnitsky.project.entity.Vehicle;
import by.epam.nickgrudnitsky.project.exception.DAOException;
import by.epam.nickgrudnitsky.project.util.VehicleFileReader;

import java.io.File;
import java.util.*;

public class FileVehicleDAO implements VehicleDAO {
    private Map<String, Vehicle> vehicles = new HashMap<>();

    public FileVehicleDAO() {
        File vehiclesProperties = new File("src/main/resources/vehicleList.txt");
        List<List<String>> vehiclesData = VehicleFileReader.readPlansFromFile(vehiclesProperties);
        List<Vehicle> readeVehicles = VehicleFileReader.createVehicle(vehiclesData);

        for (Vehicle vehicle : readeVehicles) {
            this.vehicles.put(vehicle.getId(), vehicle);
        }
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws DAOException {
        vehicles.put(vehicle.getId(), vehicle);
    }

    @Override
    public void deleteVehicle(String id) throws DAOException {
        vehicles.remove(id);
    }

    @Override
    public Vehicle findById(String id) throws DAOException {
        return vehicles.get(id);
    }

    @Override
    public Map<String, Vehicle> getAll() throws DAOException {
        return vehicles;
    }

    @Override
    public Collection<Truck> getAllTrucks() throws DAOException {
        Collection<Truck> trucks = new ArrayList<>();

        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getClass().equals(Truck.class)) {
                trucks.add((Truck) vehicle);
            }
        }

        return trucks;
    }

    @Override
    public Collection<CargoAirplane> getAllCargoAirplanes() throws DAOException {
        Collection<CargoAirplane> cargoAirplanes = new ArrayList<>();

        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getClass().equals(CargoAirplane.class)) {
                cargoAirplanes.add((CargoAirplane) vehicle);
            }
        }

        return cargoAirplanes;
    }

    @Override
    public Collection<CargoShip> getAllCargoShips() throws DAOException {
        Collection<CargoShip> cargoShips = new ArrayList<>();

        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getClass().equals(CargoShip.class)) {
                cargoShips.add((CargoShip) vehicle);
            }
        }

        return cargoShips;
    }
}
