package learning.Harish;

import java.util.*;

public class Main {

    private static List<ParkingSlot> parkingSlotList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] command;
        boolean EnterParking = true;
        while (EnterParking) {
            System.out.println("Enter command : ");
            command = scanner.nextLine().split(" ");
            switch (command[0].toUpperCase()) {
                case "CREATE_PARKING_LOT":
                    int numberOfLots = Integer.parseInt(command[1]);
                    CreateParkingLot createParkingLot = new CreateParkingLot();
                    createParkingLot.setNumberOfSlots(numberOfLots);
                    createParkingLot.doOperation(parkingSlotList);
                    break;
                case "PARK":
                    String registrationNo = command[1];
                    String color = command[2];
                    Car car = new Car(registrationNo,color);
                    Park park = new Park();
                    park.setCar(car);
                    park.doOperation(parkingSlotList);
                    break;
                case "LEAVE":
                    int slotNo = Integer.parseInt(command[1]);
                    Leave leave = new Leave();
                    leave.setSlotNo(slotNo);
                    leave.doOperation(parkingSlotList);
                    break;
                case "STATUS":
                    Status status = new Status();
                    status.doOperation(parkingSlotList);
                    break;
                case "REGISTRATION_NUMBERS_FOR_CAR_WITH_COLOR":
                    color = command[1];
                    RegistrationNumbersByColor registrationNumbersByColor =
                            new RegistrationNumbersByColor();
                    registrationNumbersByColor.setColor(color);
                    registrationNumbersByColor.doOperation(parkingSlotList);
                    break;
                case "SLOT_NUMBER_FOR_REGISTRATION_NUMBER":
                    registrationNo = command[1];
                    SlotNumberByRegistrationNumber slotNumberByRegistrationNumber =
                            new SlotNumberByRegistrationNumber();
                    slotNumberByRegistrationNumber.setRegistrationNo(registrationNo);
                    slotNumberByRegistrationNumber.doOperation(parkingSlotList);
                    break;
                case "EXIT":
                    EnterParking = false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }
    }
}
