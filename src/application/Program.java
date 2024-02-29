package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Reservation res = null;
		LocalDate now = LocalDate.now();

		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), fmt1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), fmt1);

		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		
		} else {
			res = new Reservation(number, checkIn, checkOut);
			System.out.println(res);
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkInUpdate = LocalDate.parse(sc.next(), fmt1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOutUpdate = LocalDate.parse(sc.next(), fmt1);
			
			if(checkInUpdate.isBefore(now) || checkOutUpdate.isBefore(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}else {if (!checkOutUpdate.isAfter(checkInUpdate)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
			res.updateDates(checkInUpdate, checkOutUpdate);
			System.out.println(res);
			}
		}
		}
		sc.close();
	}

}
