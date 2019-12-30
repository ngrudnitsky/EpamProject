package by.epam.nickgrudnitsky.project.entities;


public abstract class Plan implements Comparable<Plan> {

    private String name;
    private double connectionPrice;
    private double subscriptionFee;
    private int connectedSubscribers;
    private double volumeOfInternetTraffic;

    String getName() {
        return name;
    }

    public double getVolumeOfInternetTraffic() {
        return volumeOfInternetTraffic;
    }

    public void setVolumeOfInternetTraffic(double volumeOfInternetTraffic) {
        this.volumeOfInternetTraffic = volumeOfInternetTraffic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getConnectionPrice() {
        return connectionPrice;
    }

    public void setConnectionPrice(double connectionPrice) {
        this.connectionPrice = connectionPrice;
    }

    public double getSubscriptionFee() {
        return subscriptionFee;
    }

    public void setSubscriptionFee(double subscriptionFee) {
        this.subscriptionFee = subscriptionFee;
    }

    public int getConnectedSubscribers() {
        return connectedSubscribers;
    }

    public void setConnectedSubscribers(int connectedSubscribers) {
        this.connectedSubscribers = connectedSubscribers;
    }
}
