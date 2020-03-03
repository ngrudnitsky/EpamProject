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
    private static final String FILE_NAME = "src/main/resources/vehicleList.txt";

    public FileVehicleDAO() {
        File vehiclesProperties = new File(FILE_NAME);
        List<Vehicle> readeVehicles;
        readeVehicles = VehicleFileReader.createVehicles(vehiclesProperties);
        for (Vehicle vehicle : readeVehicles) {
            this.vehicles.put(vehicle.getId(), vehicle);
        }
    }

    @Override
    public void addVehicle(Vehicle vehicle) throws DAOException {
        if (vehicle == null) {
            throw new DAOException("Null vehicle was added.");
        }
        vehicles.put(vehicle.getId(), vehicle);
    }

    @Override
    public void deleteVehicle(String id) throws DAOException {
        if (id == null){
            throw new DAOException("Tried to delete vehicle with Null id.");
        }
        vehicles.remove(id);
    }

    @Override
    public Vehicle findById(String id) throws DAOException {
        if (id == null){
            throw new DAOException("Tried to find vehicle by Null id.\n");
        }
        return vehicles.get(id);
    }

    @Override
    public Map<String, Vehicle> getAll() throws DAOException {
        if (vehicles.isEmpty()){
            throw new DAOException("There are no vehicles.\n");
        }
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
        if (trucks.isEmpty()) {
            throw new DAOException("There are no trucks.\n");
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
        if (cargoAirplanes.isEmpty()) {
            throw new DAOException("There are no cargo airplanes.\n");
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
        if (cargoShips.isEmpty()) {
            throw new DAOException("There are no cargo ships.\n");
        }
        return cargoShips;
    }
}
