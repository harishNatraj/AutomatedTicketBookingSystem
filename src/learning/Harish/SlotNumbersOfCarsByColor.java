package learning.Harish;

import java.util.List;

public class SlotNumbersOfCarsByColor implements Operations{
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void doOperation(List<ParkingSlot> parkingSlotList) {
        System.out.println("Slot Numbers where "+color+" cars are parked :");
        for(ParkingSlot parkingSlot : parkingSlotList) {
            if(parkingSlot.getParkedCar().getColor().equalsIgnoreCase(color)) {
                System.out.println(parkingSlot.getSlotNo());
            }
        }
    }
}
