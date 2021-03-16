package learning.Harish;

import java.util.List;

public class RegistrationNumbersByColor implements Operations{
    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void doOperation(List<ParkingSlot> parkingSlotList) {
        System.out.println("Registration Nos for car with color "+color);
        for(ParkingSlot parkingSlot : parkingSlotList) {
            if(parkingSlot.getParkedCar()!=null
                    && parkingSlot.getParkedCar().getColor().equalsIgnoreCase(color)) {
                System.out.println(parkingSlot.getParkedCar().getRegistrationNo());
            }
        }
    }
}
