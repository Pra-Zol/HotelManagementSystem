import java.util.ArrayList;
import java.util.Scanner;

public class HotelDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize room types and amenities
        Room[] rooms = new Room[6];
        rooms[0] = new DeluxeQueenRoom(1, "Queen bed, King-size", "Deluxe room with queen bed", 250, true);
        rooms[1] = new DeluxeQueenRoom(2, "King bed", "Deluxe room with king bed", 300, false);
        rooms[2] = new DeluxeSpaRoom(3, "Queen bed, spa", "Deluxe room with hot tub", 280, true);
        rooms[3] = new DeluxeSpaRoom(4, "Single bed", "Deluxe room without spa", 230, false);
        rooms[4] = new TwoBedroomFamilySuite(5, "Two Queen Beds, Two Bathrooms", "Family Suite with two rooms", 400, 2,
                2);
        rooms[5] = new FamilySuite(6, "Queen Bed, Single Bed", "Family Suite for larger families", 350, 1, 3);

        // Initialize amenities
        ArrayList<Amenity> amenities = new ArrayList<>();
        amenities.add(new Amenity(1, "Free WIFI", "Access to unlimited WIFI", 0));
        amenities.add(new Amenity(2, "TV with Netflix", "Watch Netflix on the in-room TV", 10));
        amenities.add(new Amenity(3, "Laundry", "Includes washer and dryer", 15));
        amenities.add(new Amenity(4, "Air Conditioner", "Cool your room with air conditioning", 20));
        amenities.add(new Amenity(5, "Heater", "Keep your room warm with a heater", 20));
        amenities.add(new Amenity(6, "Coffee machine", "Coffee machine in your room", 10));
        amenities.add(new Amenity(7, "Breakfast", "Enjoy breakfast at the hotel", 30));
        amenities.add(new Amenity(8, "Lunch", "Enjoy lunch at the hotel", 40));
        amenities.add(new Amenity(9, "Dinner", "Enjoy dinner at the hotel", 50));

        // Welcome message
        printWelcomeMessage();

        // Get user details
        System.out.println("Would you like to place an order? (yes/no)");
        String orderResponse = scanner.nextLine().toLowerCase();

        if (orderResponse.equals("yes")) {
            // Get customer info
            System.out.println("Enter your name: ");
            String name = scanner.nextLine();
            System.out.println("Enter your status (Active/VIP/New): ");
            String status = scanner.nextLine();
            Customer customer = new Customer(name, status);

            double totalAmount = 0.0;

            while (true) {
                // Display rooms
                System.out.println("\nSelect a room to book:");
                for (Room room : rooms) {
                    System.out.println(room.getRoomID() + ". " + room.toString());
                }

                System.out.print("Enter room ID to book: ");
                int roomID = Integer.parseInt(scanner.nextLine());

                Room selectedRoom = null;
                for (Room room : rooms) {
                    if (room.getRoomID() == roomID) {
                        selectedRoom = room;
                        break;
                    }
                }

                if (selectedRoom == null) {
                    System.out.println("Invalid room ID. Try again.");
                    continue;
                }
                selectedRoom.getAmenities().clear();

                // Display amenities
                System.out.println("\nSelect amenities to add to your room:");
                for (Amenity amenity : amenities) {
                    System.out.println(amenity.getAmenityID() + ". " + amenity.toString());
                }

                ArrayList<Amenity> selectedAmenities = new ArrayList<>();
                while (true) {
                    System.out.print("Enter Amenity ID to add (or type 'done' to finish): ");
                    String amenityChoice = scanner.nextLine().toLowerCase();

                    if (amenityChoice.equals("done")) {
                        break;
                    }

                    try {
                        int amenityID = Integer.parseInt(amenityChoice);
                        Amenity selectedAmenity = null;

                        // Find selected amenity by ID
                        for (Amenity amenity : amenities) {
                            if (amenity.getAmenityID() == amenityID) {
                                selectedAmenity = amenity;
                                break;
                            }
                        }

                        if (selectedAmenity != null) {
                            selectedRoom.addAmenity(selectedAmenity); // Add selected amenity to the room
                            selectedAmenities.add(selectedAmenity); // Track selected amenities
                            System.out.println("Added: " + selectedAmenity.getname());
                        } else {
                            System.out.println("Invalid Amenity ID!");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number or 'done'.");
                    }
                }

                // Calculate total for the room with amenities
                double roomPrice = selectedRoom.calculatePrice(); // Price with amenities
                totalAmount += roomPrice;
                System.out.println("Room " + selectedRoom.getRoomID() + " price with amenities: $" + roomPrice);

                // Ask if they want to book another room
                System.out.print("Do you want to book another room? (yes/no): ");
                String continueBooking = scanner.nextLine().toLowerCase();

                if (continueBooking.equals("no")) {
                    break;
                }
            }

            // Apply discount and calculate final total
            double discount = customer.getDiscount();
            double discountAmount = totalAmount * (discount / 100);
            double finalAmount = totalAmount - discountAmount;

            // Print order summary
            System.out.println("\nBooking Summary:");
            System.out.println("Customer: " + customer.getName());
            System.out.println("Status: " + customer.getStatus());
            System.out.println("Discount: " + discount + "%");
            System.out.println("Total amount: $" + totalAmount);
            System.out.println("Discount amount: -$" + discountAmount);
            System.out.println("Final amount due: $" + finalAmount);
        } else {
            System.out.println("Thank you for visiting our hotel!");
        }

        scanner.close();
    }

    // Method to print the welcome message
    public static void printWelcomeMessage() {
        String message = "WELCOME TO HOTEL MANAGEMENT SYSTEM";
        String info = "Developed by Prajwal Khanal(K240609), Alex Dware(k240698), Bipin Khatiwada(k240812), Bikash Khadka(k240815)\n"
                +
                "OODP101 Object Oriented Design and Programming Assessment Task 4\n" +
                "Date and Time: " + java.time.LocalDateTime.now();

        int width = Math.max(message.length(), info.length()) + 4; // Calculate width for border

        System.out.println("*".repeat(width));
        System.out.println(message);
        System.out.println();
        System.out.println(info);
        System.out.println();
        System.out.println("*".repeat(width));
    }
}
