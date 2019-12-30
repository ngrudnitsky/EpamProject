package by.epam.nickgrudnitsky.project.entities;


//тарифы для частного дома
public class PrivateHousePlan extends HomePlan {
    private double trafficVolumeOn1MbeatSpeed;
    private double turboButtonCost;

    public PrivateHousePlan() {
    }

    public PrivateHousePlan(String name, double internetTraffic, double trafficVolumeOn1MbeatSpeed,
                            double subscriptionFee, double connectionPrice, int connectedSubscribers,
                            boolean drWebAntivirus, boolean wifiRouter, boolean tv, double turboButtonCost) {
        this.setName(name);
        this.setVolumeOfInternetTraffic(internetTraffic);
        this.trafficVolumeOn1MbeatSpeed = trafficVolumeOn1MbeatSpeed;
        this.setSubscriptionFee(subscriptionFee);
        this.setConnectionPrice(connectionPrice);
        this.setConnectedSubscribers(connectedSubscribers);
        this.setDrWebAntivirus(drWebAntivirus);
        this.setWifiRouter(wifiRouter);
        this.setTv(tv);
        this.turboButtonCost = turboButtonCost;
    }

    @Override
    public int compareTo(Plan o) {  //сортировка по умолчанию (в алфавитном порядке)
        return this.getName().compareTo(o.getName());
    }

    public double getTurboButtonCost() {
        return turboButtonCost;
    }

    public void setTurboButtonCost(double turboButtonCost) {
        this.turboButtonCost = turboButtonCost;
    }

    public double getTrafficVolumeOn1MbeatSpeed() {
        return trafficVolumeOn1MbeatSpeed;
    }

    public void setTrafficVolumeOn1MbeatSpeed(double trafficVolumeOn1MbeatSpeed) {
        this.trafficVolumeOn1MbeatSpeed = trafficVolumeOn1MbeatSpeed;
    }

    @Override
    public String toString() {
        return this.getName() +
                "\nВключено интернет трафика " + this.getVolumeOfInternetTraffic() +
                "\nабонентская плата " + this.getSubscriptionFee() +
                "\n";
    }
}
