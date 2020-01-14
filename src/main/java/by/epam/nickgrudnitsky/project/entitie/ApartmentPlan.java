package by.epam.nickgrudnitsky.project.entitie;

import java.util.Objects;

//тарифы для квартиры
public class ApartmentPlan extends HomePlan {
    private int accessSpeed;

    public ApartmentPlan() {
    }

    public ApartmentPlan(String name, double internetTraffic, double subscriptionFee, double connectionPrice,
                         int connectedSubscribers, boolean drWebAntivirus, boolean wifiRouter, boolean tv,
                         int accessSpeed) {

        this.setName(name);
        this.setVolumeOfInternetTraffic(internetTraffic);
        this.setSubscriptionFee(subscriptionFee);
        this.setConnectionPrice(connectionPrice);
        this.setConnectedSubscribers(connectedSubscribers);
        this.setDrWebAntivirus(drWebAntivirus);
        this.setWifiRouter(wifiRouter);
        this.setTv(tv);
        this.accessSpeed = accessSpeed;

    }

    public int getAccessSpeed() {
        return accessSpeed;
    }

    public void setAccessSpeed(int accessSpeed) {
        this.accessSpeed = accessSpeed;
    }

    @Override
    public int compareTo(Plan o) {  //сортировка по умолчанию (в алфавитном порядке)
        return this.getName().compareTo(o.getName());
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
        ApartmentPlan that = (ApartmentPlan) o;
        return accessSpeed == that.accessSpeed &&
                this.isDrWebAntivirus() == that.isDrWebAntivirus() &&
                this.isWifiRouter() == that.isWifiRouter() &&
                this.isTv() == that.isTv()&&
                this.getName().equals(that.getName()) &&
                this.getVolumeOfInternetTraffic() == that.getVolumeOfInternetTraffic() &&
                this.getSubscriptionFee() == that.getSubscriptionFee() &&
                this.getConnectedSubscribers() == that.getConnectedSubscribers() &&
                this.getConnectionPrice() == that.getConnectionPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessSpeed);
    }
}
