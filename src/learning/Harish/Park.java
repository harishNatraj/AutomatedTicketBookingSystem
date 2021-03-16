package learning.Harish;

import java.util.List;

public class Park implements Operations{
    private Car car;

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public void doOperation(List<ParkingSlot> parkingSlotList) {
        int slotNo = 0;
        boolean carAvailable = false;
        for(ParkingSlot slot : parkingSlotList) {
            if(car.equals(slot.getParkedCar())) {
                carAvailable = true;
                break;
            }
        }
        if(!carAvailable) {
            for (ParkingSlot slot : parkingSlotList) {
                if (slot.getParkedCar() == null) {
                    slot.setParkedCar(car);
                    slotNo = slot.getSlotNo();
                    break;
                }
            }
            if (slotNo > 0) {
                System.out.println("Car parked at slot number " + slotNo);
            } else {
                System.out.println("Sorry, Parking is full");
            }
        } else {
            System.out.println("Car with registration number is already been parked." +
                    " Provide valid registration no");
        }
    }
}
