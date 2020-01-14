package by.epam.nickgrudnitsky.project.entitie;

abstract class HomePlan extends Plan {

    private boolean drWebAntivirus;
    private boolean wifiRouter;
    private boolean tv;

    public boolean isDrWebAntivirus() {
        return drWebAntivirus;
    }

    public void setDrWebAntivirus(boolean drWebAntivirus) {
        this.drWebAntivirus = drWebAntivirus;
    }

    public boolean isWifiRouter() {
        return wifiRouter;
    }

    public void setWifiRouter(boolean wifiRouter) {
        this.wifiRouter = wifiRouter;
    }

    public boolean isTv() {
        return tv;
    }

    public void setTv(boolean tv) {
        this.tv = tv;
    }
}
