package learning.Harish;

public class ParkingSlot {
    private int slotNo;
    private Car parkedCar;
    private static int counter = 0;

    public ParkingSlot() {
        counter++;
        this.slotNo = counter;
        this.parkedCar = null;
    }

    public int getSlotNo() {
        return slotNo;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void setParkedCar(Car parkedCar) {
        this.parkedCar = parkedCar;
    }
}
