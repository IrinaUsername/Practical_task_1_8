package oaosugar;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Main {
    public static boolean yearCheck(String year){
        String pattern = "[^0-9]";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(year);
        if (m.matches()){
            return false;
        }
        else {
            int intYear = Integer.parseInt(year);
            if ((intYear>=1940)&&(intYear<=2024)) {
                return true;
            }
            else{return false;}
            }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zadanie 1.6 Milovantseva Irina RIBO-01-22 Variant 16(1)");
        System.out.println("The following list is available:\n");
        List<Car> cars = new ArrayList<>();

        cars.add(new Car("Lada Vesta",2004,"B717TC"));
        cars.add(new Car("Ford Focus",1998,"A917KA"));
        cars.add(new Car("Hyundai Casper",2021,"A717EH"));

        for(Car car: cars){
            System.out.println(car.getMark()+" "+car.getYear()+" "+car.getRegistrNumber());
        }
        System.out.println(" ");
        while (true) {
            System.out.println("Please choose an option:\n");
            System.out.println("1. Add a new car");
            System.out.println("2. Remove a car by registration number");
            System.out.println("3. Remove all cars");
            System.out.println("4. Exit");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    int intYear;
                    System.out.println("Enter brand:");
                    String mark = scanner.nextLine();
                    System.out.println("Enter year:");
                    String year = scanner.nextLine();
                    if (yearCheck(year)==true){
                        intYear=Integer.parseInt(year);
                    }
                    else {
                        System.out.println("Try again.");
                        continue;
                    }
                    System.out.println("Enter registration number:");
                    String registrNumber = scanner.nextLine();
                    String pattern = "[A-Za-z]\\d{3}[A-Za-z]{2}";
                    Pattern p = Pattern.compile(pattern);
                    Matcher m = p.matcher(registrNumber);
                    if (m.matches()) {
                        boolean alreadyExists = false;
                        for (Car car : cars) {
                            if (car.registrNumber.equals(registrNumber)) {
                                alreadyExists = true;
                                break;
                            }
                        }
                        if (alreadyExists) {
                            System.out.println("Car with registration number " + registrNumber + " already exists in the list.");
                        }
                        else{
                            cars.add(new Car(mark, intYear, registrNumber.toUpperCase()));
                        }
                    }
                    else {
                        System.out.println("The data for the registration number was entered incorrectly! Try again.");
                    }
                    break;
                case "2":
                    System.out.println("Enter registration number of the car to remove:");
                    String regNumToRemove = scanner.nextLine();
                    Iterator<Car> iter = cars.iterator();
                    int flag=0;
                    while (iter.hasNext()){
                        Car car = iter.next();
                        if (car.getRegistrNumber().equals(regNumToRemove.toUpperCase())){
                            iter.remove();
                            flag+=1;
                            break;
                        }
                    }
                    if(flag==0){System.out.println("ERROR. There is no information about such a registration number.Try again.");}
                    break;
                case "3":
                    cars.clear();
                    break;
                case "4":
                    System.out.println("Exiting program.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println("\nThe updated data looks like this:\n");
            for(Car car: cars){
                System.out.println(car.getMark()+" "+car.getYear()+" "+car.getRegistrNumber());
            }
            System.out.println(" ");
        }
    }
}
