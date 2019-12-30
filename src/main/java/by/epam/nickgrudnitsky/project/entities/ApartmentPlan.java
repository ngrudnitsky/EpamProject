package by.epam.nickgrudnitsky.project.entities;

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
}
