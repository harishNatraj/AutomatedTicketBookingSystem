package learning.Harish;

import java.util.List;

public class Status implements Operations{
    @Override
    public void doOperation(List<ParkingSlot> parkingSlotList) {
        if(parkingSlotList.size() == 0) {
            System.out.println("Please create a parking lot");
        } else {
            System.out.println("SlotNo"+"\t\t"+"Registration No"+"\t\t"+"Color");
            for (ParkingSlot parkingSlot : parkingSlotList) {
                if (parkingSlot.getParkedCar() != null) {
                    System.out.println(parkingSlot.getSlotNo() + "\t\t" +
                            parkingSlot.getParkedCar().getRegistrationNo() +
                            "\t\t" + parkingSlot.getParkedCar().getColor());
                }
            }
        }
    }
}
