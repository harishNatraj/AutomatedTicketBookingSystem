package learning.Harish;

import java.util.*;
import java.util.regex.Pattern;

public class Main {

    private static List<ParkingSlot> parkingSlotList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] command;
        boolean EnterParking = true;
        System.out.println("Follow commands: \n 1.create_parking_lot no_of_slots \n" +
                "2.park regNo color \n 3.leave slotNo \n 4.status\n " +
                "5.registration_numbers_for_car_with_color color\n " +
                "6.slot_number_for_registration_number regNo\n" +
                "7.slot_numbers_for_cars_with_color color \n 8.exit");
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
                        validateRegistrationNumber(registrationNo);
                        String color = command[2];
                        Car car = new Car(registrationNo,color);
                        Park park = new Park();
                        park.setCar(car);
                        park.doOperation(parkingSlotList);
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
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
                        validateRegistrationNumber(registrationNo);
                        SlotNumberByRegistrationNumber slotNumberByRegistrationNumber =
                                new SlotNumberByRegistrationNumber();
                        slotNumberByRegistrationNumber.setRegistrationNo(registrationNo);
                        slotNumberByRegistrationNumber.doOperation(parkingSlotList);
                    } catch (IndexOutOfBoundsException | InputMismatchException e) {
                        System.out.println("Provide valid registration number");
                    }
                    break;
                case "SLOT_NUMBERS_FOR_CARS_WITH_COLOR":
                    try {
                        String color = command[1];
                        SlotNumbersOfCarsByColor slotNumbersOfCarsByColor =
                                new SlotNumbersOfCarsByColor();
                        slotNumbersOfCarsByColor.setColor(color);
                        slotNumbersOfCarsByColor.doOperation(parkingSlotList);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Provide a color");
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

    public static void validateRegistrationNumber(String input) throws InputMismatchException{
        boolean b2= Pattern.compile("^[A-Za-z]{1,2}-[0-9]{1,2}-[A-Za-z]{1,2}-[0-9]{1,4}$")
                           .matcher(input)
                           .matches();
        if(!b2) {
            throw new InputMismatchException("Invalid registration number format");
        }
    }
}
