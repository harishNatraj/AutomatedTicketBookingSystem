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
                    try {
                        int numberOfLots = Integer.parseInt(command[1]);
                        CreateParkingLot createParkingLot = new CreateParkingLot();
                        createParkingLot.setNumberOfSlots(numberOfLots);
                        createParkingLot.doOperation(parkingSlotList);
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Provide valid slot count");
                    }
                    break;
                case "PARK":
                    try {
                        String registrationNo = command[1];
                        String color = command[2];
                        Car car = new Car(registrationNo,color);
                        Park park = new Park();
                        park.setCar(car);
                        park.doOperation(parkingSlotList);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Provide valid car details(RegistrationNo and color)");
                    }
                    break;
                case "LEAVE":
                    try {
                        int slotNo = Integer.parseInt(command[1]);
                        Leave leave = new Leave();
                        leave.setSlotNo(slotNo);
                        leave.doOperation(parkingSlotList);
                    } catch (IndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("Invalid slot number");
                    }
                    break;
                case "STATUS":
                    Status status = new Status();
                    status.doOperation(parkingSlotList);
                    break;
                case "REGISTRATION_NUMBERS_FOR_CAR_WITH_COLOR":
                    try {
                        String color = command[1];
                        RegistrationNumbersByColor registrationNumbersByColor =
                                new RegistrationNumbersByColor();
                        registrationNumbersByColor.setColor(color);
                        registrationNumbersByColor.doOperation(parkingSlotList);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Provide a color");
                    }
                    break;
                case "SLOT_NUMBER_FOR_REGISTRATION_NUMBER":
                    try {
                        String registrationNo = command[1];
                        SlotNumberByRegistrationNumber slotNumberByRegistrationNumber =
                                new SlotNumberByRegistrationNumber();
                        slotNumberByRegistrationNumber.setRegistrationNo(registrationNo);
                        slotNumberByRegistrationNumber.doOperation(parkingSlotList);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Provide registration number");
                    }
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
