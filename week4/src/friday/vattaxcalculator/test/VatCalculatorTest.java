package friday.vattaxcalculator.test;

import java.util.Map.Entry;
import java.util.Scanner;

import friday.vattaxcalculator.calculator.CurrencyConverter;
import friday.vattaxcalculator.calculator.VatCalculator;
import friday.vattaxcalculator.database.CountryManager;
import friday.vattaxcalculator.model.Country;

public class VatCalculatorTest {
	public static void main(String[] args) {
		CountryManager countryManager = CountryManager.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("Press ENTER to check list countries codes");
		sc.nextLine();
		for (Entry<Integer, Country> entry : countryManager) {
			System.out.println(entry.getValue().getCountryName() + " => " + entry.getKey());
		}
		System.out.println("Enter product net price and country code to calculate VAT and total price");
		double productPrice = sc.nextDouble();
		int countryCode = sc.nextInt();
		try {
			Country country = countryManager.getCountry(countryCode);
			System.out.println("You choose " + country.getCountryName());
			System.out.printf("VAT in %s is %d%%%n", country.getCountryName(), country.getVat());
			double totalPrice = VatCalculator.calculateTax(productPrice, countryCode);
			System.out.printf("Total price of the product in %s is %.1f %s%n", country.getCountryName(), totalPrice,
					country.getCurrency().name());
			double totalPriceInLeva = CurrencyConverter.convert(totalPrice, countryManager.getCountry(countryCode));
			System.out.printf("%.1f %s converted in leva is %.2f %s", totalPrice, country.getCurrency().name(),
					totalPriceInLeva, countryManager.getDefaultCountry().getCurrency().name());

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		sc.close();
	}
}
