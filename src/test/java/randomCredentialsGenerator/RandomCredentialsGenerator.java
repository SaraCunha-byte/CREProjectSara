package randomCredentialsGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class RandomCredentialsGenerator {
	public String randomUserID;
	public String randomNewPassword;
	public String randomFirstName;
	public String randomLastName;
	public String randomEmail;
	public String randomPhone;
	public String randomAddress;
	public String randomCity;
	public String randomState;
	public String randomZip;
	public String randomCountry;
	public String randomCardNumber;

	private static List<String> firstNamesList = Arrays.asList("Susana", "Margarida", "Filipa", "Maria das Dores");
	private static List<String> lastNamesList = Arrays.asList("Antunes", "Cunha", "Cavalinhos", "Reis");
	private static List<String> domainList = Arrays.asList("@gmail.com", "@hotmail.com", "@outlook.pt");
	private static List<String> addressList = Arrays.asList("Rua das Flores Nº11", "Largo Camões Nº2",
			"Rua das Orquídeas Nº5", "Praceta Marcelino Nº10");
	private static List<String> cityList = Arrays.asList("Loures", "Odivelas", "Lisboa", "Gondomar", "Porto");
	private static List<String> stateList = Arrays.asList("Washington", "Phoenix", "Florida", "Las Vegas");
	private static List<String> countryList = Arrays.asList("Portugal", "Estados Unidos", "Espanha", "França",
			"Itália");

	private Random random;

	public RandomCredentialsGenerator() {
		this.random = new Random();
		this.randomUserID = generateRandomUser();
		this.randomNewPassword = generateRandomPassword();
		this.randomFirstName = generateRandomFirstName();
		this.randomLastName = generateRandomLastName();
		this.randomEmail = generateRandomEmail();
		this.randomPhone = generateRandomPhone();
		this.randomAddress = generateRandomAddress();
		this.randomCity = generateRandomCity();
		this.randomState = generateRandomState();
		this.randomZip = generateRandomZip();
		this.randomCountry = generateRandomCountry();
	}

	private String generateRandomUser() {
		String prefix = "user_";
		String uniqueID = UUID.randomUUID().toString().substring(0, 5);
		return prefix + uniqueID;
	}

	private String generateRandomPassword() {
		return UUID.randomUUID().toString().substring(0, 25);
	}

	private String generateRandomFirstName() {
		int index = random.nextInt(firstNamesList.size() - 1);
		return firstNamesList.get(index);
	}

	private String generateRandomLastName() {
		int index = random.nextInt(lastNamesList.size() - 1);
		return lastNamesList.get(index);
	}

	private String generateRandomEmail() {
		int index = random.nextInt(domainList.size() - 1);
		return this.randomUserID + domainList.get(index);
	}

	private String generateRandomPhone() {
		int number = random.nextInt(999999999);
		return String.format("%9d", number);
	}

	private String generateRandomAddress() {
		int index = random.nextInt(addressList.size() - 1);
		return addressList.get(index);
	}

	private String generateRandomCity() {
		int index = random.nextInt(cityList.size() - 1);
		return cityList.get(index);
	}

	private String generateRandomState() {
		int index = random.nextInt(stateList.size() - 1);
		return stateList.get(index);
	}

	private String generateRandomZip() {
		int number = random.nextInt(9999);
		return String.format("%4d", number);
	}

	private String generateRandomCountry() {
		int index = random.nextInt(countryList.size() - 1);
		return countryList.get(index);
	}
}
