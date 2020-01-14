package by.epam.nickgrudnitsky.project.entitie;


import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PrivateHousePlan that = (PrivateHousePlan) o;
        return Double.compare(that.getTrafficVolumeOn1MbeatSpeed(), getTrafficVolumeOn1MbeatSpeed()) == 0 &&
                Double.compare(that.getTurboButtonCost(), getTurboButtonCost()) == 0 &&
                this.getName().equals(that.getName()) &&
                this.getVolumeOfInternetTraffic() == that.getVolumeOfInternetTraffic() &&
                this.getSubscriptionFee() == that.getSubscriptionFee() &&
                this.getConnectedSubscribers() == that.getConnectedSubscribers() &&
                this.getConnectionPrice() == that.getConnectionPrice() &&
                this.isDrWebAntivirus() == that.isDrWebAntivirus() &&
                this.isWifiRouter() == that.isWifiRouter() &&
                this.isTv() == that.isTv();

    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTrafficVolumeOn1MbeatSpeed(), getTurboButtonCost());
    }
}
