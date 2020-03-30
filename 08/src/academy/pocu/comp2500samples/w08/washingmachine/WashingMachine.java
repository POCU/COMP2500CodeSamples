package academy.pocu.comp2500samples.w08.washingmachine;

public class WashingMachine {
    private State state;
    private LoadSize loadSize;
    private WashingCycle cycle;
    private WaterTemperature temperature;
    private boolean detergentAdded;

    public WashingMachine() {
        this.state = new IdleState();
        this.loadSize = LoadSize.SMALL;
        this.cycle = WashingCycle.NORMAL;
        this.temperature = WaterTemperature.COLD;
        this.detergentAdded = false;
    }

    public LoadSize getLoadSize() {
        return this.loadSize;
    }

    public boolean isDetergentAdded() {
        return this.detergentAdded;
    }

    public WashingCycle getWashingCycle() {
        return this.cycle;
    }

    public WaterTemperature getWaterTemperature() {
        return this.temperature;
    }

    public void selectLoadSize(LoadSize loadSize) {
        this.state.selectLoadSize(this, loadSize);
    }

    public void addDetergent() {
        this.state.addDetergent(this);
    }

    public void removeDetergent() {
        this.state.removeDetergent(this);
    }

    public void selectWashingCycle(WashingCycle cycle) {
        this.state.selectWashingCycle(this, cycle);
    }

    public void selectWaterTemperature(WaterTemperature temperature) {
        this.state.selectWaterTemperature(this, temperature);
    }

    public void start() {
        this.state.start(this);
    }

    public void next() {
        this.state.onFinish(this);
    }

    public void cancel() {
        this.state.cancel(this);
    }

    void setLoadSize(LoadSize loadSize) {
        this.loadSize = loadSize;
    }

    void setDetergentAdded(boolean detergentAdded) {
        this.detergentAdded = detergentAdded;
    }

    void setWashingCycle(WashingCycle cycle) {
        this.cycle = cycle;
    }

    void setWaterTemperature(WaterTemperature temperature) {
        this.temperature = temperature;
    }
}
