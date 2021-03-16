package learning.Harish;

import java.util.List;

public class SlotNumberByRegistrationNumber implements Operations{
    private String registrationNo;

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public void doOperation(List<ParkingSlot> parkingSlotList) {
        int slotNumber = 0;
        for(ParkingSlot parkingSlot : parkingSlotList) {
            if(parkingSlot.getParkedCar().getRegistrationNo().equalsIgnoreCase(registrationNo)) {
                slotNumber = parkingSlot.getSlotNo();
                break;
            }
        }
        if(slotNumber > 0) {
            System.out.println("Car parked at slot "+slotNumber);
        } else {
            System.out.println("Not found");
        }
    }
}
