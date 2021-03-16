package learning.Harish;

import java.util.List;

public class CreateParkingLot implements Operations{
    private int numberOfSlots;

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    @Override
    public void doOperation(List<ParkingSlot> parkingSlotList) {
        ParkingSlot slot;
        for (int i = 0; i < numberOfSlots; i++) {
            slot = new ParkingSlot();
            parkingSlotList.add(slot);
        }
        System.out.println("Create parking lot "+numberOfSlots);
    }
}
