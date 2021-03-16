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
                    createParkingLot(numberOfLots);
                    break;
                case "PARK":
                    String registrationNo = command[1];
                    String color = command[2];
                    park(registrationNo,color);
                    break;
                case "LEAVE":
                    int slotNo = Integer.parseInt(command[1]);
                    leave(slotNo);
                    break;
                case "STATUS":
                    status();
                    break;
                case "REGISTRATION_NUMBERS_FOR_CAR_WITH_COLOR":
                    color = command[1];
                    registrationNumbersOfCarsByColor(color);
                    break;
                case "SLOT_NUMBER_FOR_REGISTRATION_NUMBER":
                    registrationNo = command[1];
                    slotNumberForRegistrationNumber(registrationNo);
                    break;
                case "EXIT":
                    EnterParking = false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
            }
        }
    }

    public static void createParkingLot(int numberOfLots) {
        ParkingSlot slot;
        for (int i = 0; i < numberOfLots; i++) {
            slot = new ParkingSlot();
            parkingSlotList.add(slot);
        }
        System.out.println("Created a parking with " + numberOfLots + " slots");
    }

    public static void park(String registrationNo, String color) {
        Car car = new Car(registrationNo, color);
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

    public static void leave(int slotNo) {
        ParkingSlot slot = parkingSlotList.get(slotNo - 1);
        slot.setParkedCar(null);
        System.out.println("Slot number " + slotNo + " is free");
    }

    public static void status() {
        System.out.println("SlotNo"+"\t\t"+"Registration No"+"\t\t"+"Color");
        for (ParkingSlot parkingSlot : parkingSlotList) {
            if (parkingSlot.getParkedCar() != null) {
                System.out.println(parkingSlot.getSlotNo() + "\t\t" +
                        parkingSlot.getParkedCar().getRegistrationNo() +
                        "\t\t" + parkingSlot.getParkedCar().getColor());
            }
        }
    }

    public static void registrationNumbersOfCarsByColor(String color) {
        System.out.println("Registration Nos for car with color "+color);
        for(ParkingSlot parkingSlot : parkingSlotList) {
            if(parkingSlot.getParkedCar()!=null
                    && parkingSlot.getParkedCar().getColor().equalsIgnoreCase(color)) {
                System.out.println(parkingSlot.getParkedCar().getRegistrationNo());
            }
        }
    }

    public static void slotNumberForRegistrationNumber(String registrationNo) {
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
