package learning.Harish;

import java.util.List;

public class Leave implements Operations{
    private int slotNo;

    public void setSlotNo(int slotNo) {
        this.slotNo = slotNo;
    }

    @Override
    public void doOperation(List<ParkingSlot> parkingSlotList) throws IndexOutOfBoundsException{
        ParkingSlot slot = parkingSlotList.get(slotNo - 1);
        slot.setParkedCar(null);
        System.out.println("Slot "+slotNo+" is free");
    }
}
