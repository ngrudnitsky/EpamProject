package by.epam.nickgrudnitsky.project.util;

import by.epam.nickgrudnitsky.project.entity.CargoAirplane;
import by.epam.nickgrudnitsky.project.entity.CargoShip;
import by.epam.nickgrudnitsky.project.entity.Truck;
import by.epam.nickgrudnitsky.project.entity.Vehicle;
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

    public static List<List<String>> readPlansFromFile(File file) {
        List<List<String>> vehiclesProperties = new ArrayList<>();

        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                while (in.ready()) {
                    List<String> vehicleInfo = new ArrayList<>();
                    String planName = in.readLine();

                    if (planName.startsWith("Truck")) {
                        vehicleInfo.add(planName);
                        for (int i = 0; i < 11; i++) {
                            if (in.ready()) {
                                String[] split = in.readLine().split(" = ");
                                vehicleInfo.add(split[1]);
                            }
                        }
                        vehiclesProperties.add(vehicleInfo);
                    } else if (planName.startsWith("Cargo Airplane") || planName.startsWith("Cargo Ship")) {
                        vehicleInfo.add(planName);
                        for (int i = 0; i < 8; i++) {
                            if (in.ready()) {
                                String[] split = in.readLine().split(" = ");
                                vehicleInfo.add(split[1]);
                            }
                        }
                        vehiclesProperties.add(vehicleInfo);
                    }
                }
            } catch (IOException e) {
                logger.error(e.getMessage());
            }
        }

        return vehiclesProperties;

    }

    public static List<Vehicle> createVehicle(List<List<String>> plansInfo) {

        for (List<String> vehicleInfo : plansInfo) {

            String vehicleType = vehicleInfo.get(0);

            if (vehicleType.startsWith("Truck")) {
                vehicles.add(createTruck(vehicleInfo));
            } else if (vehicleType.startsWith("Cargo Airplane")) {
                vehicles.add(createCargoAirplane(vehicleInfo));
            } else if (vehicleType.startsWith("Cargo Ship")) {
                vehicles.add(createCargoShip(vehicleInfo));
            }
        }
        return vehicles;
    }

    private static Truck createTruck(List<String> vehicleInfo) {
        Truck truck = new Truck();

        truck.setId(vehicleInfo.get(1));
        truck.setMark(vehicleInfo.get(2));
        truck.setModel(vehicleInfo.get(3));
        truck.setWeight(Double.parseDouble(vehicleInfo.get(4)));
        truck.setCarryingCapacity(Double.parseDouble(vehicleInfo.get(5)));
        truck.setTypeOfDrive(vehicleInfo.get(6));
        truck.setEngineCapacity(Double.parseDouble(vehicleInfo.get(7)));
        truck.setNumberOfAxles(Integer.parseInt(vehicleInfo.get(8)));
        truck.setWheelFormula(vehicleInfo.get(9));
        truck.setOpenBodyType(Boolean.parseBoolean(vehicleInfo.get(10)));
        truck.setTrailer(Boolean.parseBoolean(vehicleInfo.get(11)));

        return truck;
    }

    private static CargoAirplane createCargoAirplane(List<String> vehicleInfo) {
        CargoAirplane cargoAirplane = new CargoAirplane();

        cargoAirplane.setId(vehicleInfo.get(1));
        cargoAirplane.setMark(vehicleInfo.get(2));
        cargoAirplane.setModel(vehicleInfo.get(3));
        cargoAirplane.setWeight(Double.parseDouble(vehicleInfo.get(4)));
        cargoAirplane.setCarryingCapacity(Double.parseDouble(vehicleInfo.get(5)));
        cargoAirplane.setSpeed(Double.parseDouble(vehicleInfo.get(6)));
        cargoAirplane.setCargoCompartmentVolume(Double.parseDouble(vehicleInfo.get(7)));
        cargoAirplane.setRangeOfFlight(Double.parseDouble(vehicleInfo.get(8)));

        return cargoAirplane;
    }

    private static CargoShip createCargoShip(List<String> vehicleInfo) {
        CargoShip cargoShip = new CargoShip();

        cargoShip.setId(vehicleInfo.get(1));
        cargoShip.setMark(vehicleInfo.get(2));
        cargoShip.setModel(vehicleInfo.get(3));
        cargoShip.setWeight(Double.parseDouble(vehicleInfo.get(4)));
        cargoShip.setCarryingCapacity(Double.parseDouble(vehicleInfo.get(5)));
        cargoShip.setSpeed(Double.parseDouble(vehicleInfo.get(6)));
        cargoShip.setCruisingRange(Double.parseDouble(vehicleInfo.get(7)));
        cargoShip.setDecksNumber(Integer.parseInt(vehicleInfo.get(8)));

        return cargoShip;
    }


}
