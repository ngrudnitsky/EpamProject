package by.epam.nickgrudnitsky.project.entitie;

import java.util.Objects;

public class CellularPlan extends Plan {
    private int minutesOnCall;
    private double outgoingCallsPrice;
    private double roamingCallPrice;
    private double outgoingInternetPrice;
    private double mobileHotspot;
    private double mtsTvTraffic;
    private double sms;

    public CellularPlan() {
    }

    public CellularPlan(String name, double outgoingInternetPrice, double mobileHotspot, int minutesOnCall,
                        double outgoingCallsPrice, double roamingCallPrice, double sms, double mtsTvTraffic,
                        double subscriptionFee, double connectionPrice, int connectedSubscribers) {

        this.setName(name);
        this.outgoingInternetPrice = outgoingInternetPrice;
        this.mobileHotspot = mobileHotspot;
        this.minutesOnCall = minutesOnCall;
        this.outgoingCallsPrice = outgoingCallsPrice;
        this.roamingCallPrice = roamingCallPrice;
        this.sms = sms;
        this.mtsTvTraffic = mtsTvTraffic;
        this.setSubscriptionFee(subscriptionFee);
        this.setConnectionPrice(connectionPrice);
        this.setConnectedSubscribers(connectedSubscribers);
    }

    public int getMinutesOnCall() {
        return minutesOnCall;
    }

    public void setMinutesOnCall(int minutesOnCall) {
        this.minutesOnCall = minutesOnCall;
    }

    public double getOutgoingCallsPrice() {
        return outgoingCallsPrice;
    }

    public void setOutgoingCallsPrice(double outgoingCallsPrice) {
        this.outgoingCallsPrice = outgoingCallsPrice;
    }

    public double getRoamingCallPrice() {
        return roamingCallPrice;
    }

    public void setRoamingCallPrice(double roamingCallPrice) {
        this.roamingCallPrice = roamingCallPrice;
    }

    public double getOutgoingInternetPrice() {
        return outgoingInternetPrice;
    }

    public void setOutgoingInternetPrice(double outgoingInternetPrice) {
        this.outgoingInternetPrice = outgoingInternetPrice;
    }

    public double getMobileHotspot() {
        return mobileHotspot;
    }

    public void setMobileHotspot(double mobileHotspot) {
        this.mobileHotspot = mobileHotspot;
    }

    public double getMtsTvTraffic() {
        return mtsTvTraffic;
    }

    public void setMtsTvTraffic(double mtsTvTraffic) {
        this.mtsTvTraffic = mtsTvTraffic;
    }

    public double getSms() {
        return sms;
    }

    public void setSms(double sms) {
        this.sms = sms;
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
        CellularPlan that = (CellularPlan) o;
        return minutesOnCall == that.minutesOnCall &&
                Double.compare(that.outgoingCallsPrice, outgoingCallsPrice) == 0 &&
                Double.compare(that.roamingCallPrice, roamingCallPrice) == 0 &&
                Double.compare(that.outgoingInternetPrice, outgoingInternetPrice) == 0 &&
                Double.compare(that.mobileHotspot, mobileHotspot) == 0 &&
                Double.compare(that.mtsTvTraffic, mtsTvTraffic) == 0 &&
                Double.compare(that.sms, sms) == 0 &&
                this.getName().equals(that.getName()) &&
                this.getVolumeOfInternetTraffic() == that.getVolumeOfInternetTraffic() &&
                this.getSubscriptionFee() == that.getSubscriptionFee() &&
                this.getConnectedSubscribers() == that.getConnectedSubscribers() &&
                this.getConnectionPrice() == that.getConnectionPrice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getConnectionPrice(), this.getConnectedSubscribers(), this.getSubscriptionFee(), this.getVolumeOfInternetTraffic(), this.getName(), minutesOnCall, outgoingCallsPrice, roamingCallPrice, outgoingInternetPrice, mobileHotspot, mtsTvTraffic, sms);
    }

    @Override
    public int compareTo(Plan o) {  //сортировка по умолчанию (в алфавитном порядке)
        return this.getName().compareTo(o.getName());
    }
}
