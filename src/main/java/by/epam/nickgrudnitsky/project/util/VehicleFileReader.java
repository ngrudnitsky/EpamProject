package by.epam.nickgrudnitsky.project.util;

import by.epam.nickgrudnitsky.project.entity.CargoAirplane;
import by.epam.nickgrudnitsky.project.entity.CargoShip;
import by.epam.nickgrudnitsky.project.entity.Truck;
import by.epam.nickgrudnitsky.project.entity.Vehicle;
import by.epam.nickgrudnitsky.project.exception.FileReaderException;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleFileReader {
    private static List<Vehicle> vehicles = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(VehicleFileReader.class);

    private VehicleFileReader() {
    }

    public static List<Vehicle> createVehicles(File file) {
        if (file.exists()) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                while (bufferedReader.ready()) {
                    String vehicleType = bufferedReader.readLine();
                    addVehicle(vehicleType, bufferedReader);
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            } catch ( FileReaderException e) {
                logger.error("Vehicle initialisation exception.");
            }
        }
        return vehicles;
    }

    private static void addVehicle(String vehicleType, BufferedReader bufferedReader) throws IOException, FileReaderException {
        if (vehicleType.startsWith("Cargo Airplane")) {
            vehicles.add(createCargoAirplane(bufferedReader));
        } else if (vehicleType.startsWith("Cargo Ship")) {
            vehicles.add(createCargoShip(bufferedReader));
        } else if (vehicleType.startsWith("Truck")) {
            vehicles.add(createTruck(bufferedReader));
        }
    }

    private static Truck createTruck(BufferedReader bufferedReader) throws IOException, FileReaderException {
        Truck truck = new Truck();
        setVehicleProperties(truck, bufferedReader);
        truck.setTypeOfDrive(readNextProperty(bufferedReader));
        truck.setEngineCapacity(Double.parseDouble(readNextProperty(bufferedReader)));
        truck.setNumberOfAxles(Integer.parseInt(readNextProperty(bufferedReader)));
        truck.setWheelFormula(readNextProperty(bufferedReader));
        truck.setOpenBodyType(Boolean.parseBoolean(readNextProperty(bufferedReader)));
        truck.setTrailer(Boolean.parseBoolean(readNextProperty(bufferedReader)));
        return truck;
    }

    private static CargoAirplane createCargoAirplane(BufferedReader bufferedReader) throws IOException, FileReaderException {
        CargoAirplane cargoAirplane = new CargoAirplane();
        setVehicleProperties(cargoAirplane, bufferedReader);
        cargoAirplane.setSpeed(Double.parseDouble(readNextProperty(bufferedReader)));
        cargoAirplane.setCargoCompartmentVolume(Double.parseDouble(readNextProperty(bufferedReader)));
        cargoAirplane.setRangeOfFlight(Double.parseDouble(readNextProperty(bufferedReader)));
        return cargoAirplane;
    }

    private static CargoShip createCargoShip(BufferedReader bufferedReader) throws IOException, FileReaderException {
        CargoShip cargoShip = new CargoShip();
        setVehicleProperties(cargoShip, bufferedReader);
        cargoShip.setSpeed(Double.parseDouble(readNextProperty(bufferedReader)));
        cargoShip.setCruisingRange(Double.parseDouble(readNextProperty(bufferedReader)));
        cargoShip.setDecksNumber(Integer.parseInt(readNextProperty(bufferedReader)));
        return cargoShip;
    }

    private static void setVehicleProperties(Vehicle vehicle, BufferedReader bufferedReader) throws IOException, FileReaderException {
        vehicle.setId(readNextProperty(bufferedReader));
        vehicle.setMark(readNextProperty(bufferedReader));
        vehicle.setModel(readNextProperty(bufferedReader));
        vehicle.setWeight(Double.parseDouble(readNextProperty(bufferedReader)));
        vehicle.setCarryingCapacity(Double.parseDouble(readNextProperty(bufferedReader)));
    }

    private static String readNextProperty(BufferedReader bufferedReader) throws IOException, FileReaderException {
        String property = null;
        if (bufferedReader.ready()) {
            String[] split = bufferedReader.readLine().split(" = ");
            if (split.length != 1) {
                property = split[1];
            }
        }
        if (property == null) {
            throw new FileReaderException("Exception in initialization of file.");
        }
        return property;
    }
}