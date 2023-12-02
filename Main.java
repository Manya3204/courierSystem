import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Package {
    private String trackingNumber;
    private String description;
    private String destination;
    private boolean delivered;

    public Package(String trackingNumber, String description, String destination) {
        this.trackingNumber = trackingNumber;
        this.description = description;
        this.destination = destination;
        this.delivered = false;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public String getDescription() {
        return description;
    }

    public String getDestination() {
        return destination;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void markDelivered() {
        this.delivered = true;
    }
}

class CourierSystem {
    private List<Package> packages;

    public CourierSystem() {
        this.packages = new ArrayList<>();
    }

    public void addPackage(String trackingNumber, String description, String destination) {
        Package newPackage = new Package(trackingNumber, description, destination);
        packages.add(newPackage);
        System.out.println("Package added successfully.");
    }

    public void trackPackage(String trackingNumber) {
        for (Package p : packages) {
            if (p.getTrackingNumber().equals(trackingNumber)) {
                System.out.println("Package Found:");
                System.out.println("Tracking Number: " + p.getTrackingNumber());
                System.out.println("Description: " + p.getDescription());
                System.out.println("Destination: " + p.getDestination());
                System.out.println("Status: " + (p.isDelivered() ? "Delivered" : "In Transit"));
                return;
            }
        }
        System.out.println("Package not found with tracking number: " + trackingNumber);
    }

    public void markPackageDelivered(String trackingNumber) {
        for (Package p : packages) {
            if (p.getTrackingNumber().equals(trackingNumber)) {
                p.markDelivered();
                System.out.println("Package marked as delivered.");
                return;
            }
        }
        System.out.println("Package not found with tracking number: " + trackingNumber);
    }
}

public class Main {
    public static void main(String[] args) {
        CourierSystem courierSystem = new CourierSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCourier System Menu:");
            System.out.println("1. Add Package");
            System.out.println("2. Track Package");
            System.out.println("3. Mark Package as Delivered");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Tracking Number: ");
                    String trackingNumber = scanner.nextLine();
                    System.out.print("Enter Package Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter Destination: ");
                    String destination = scanner.nextLine();
                    courierSystem.addPackage(trackingNumber, description, destination);
                    break;

                case 2:
                    System.out.print("Enter Tracking Number to Track: ");
                    trackingNumber = scanner.nextLine();
                    courierSystem.trackPackage(trackingNumber);
                    break;

                case 3:
                    System.out.print("Enter Tracking Number to Mark as Delivered: ");
                    trackingNumber = scanner.nextLine();
                    courierSystem.markPackageDelivered(trackingNumber);
                    break;

                case 4:
                    System.out.println("Exiting Courier System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
