import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserDataProcessor {

    public static void main(String[] args) {
        processUserData();
    }

    public static void processUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество ДатаРождения НомерТелефона Пол");
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Неверное количество данных. Пожалуйста, введите данные в нужном формате.");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        long phoneNumber;
        char gender = data[5].charAt(0);

        try {
            phoneNumber = Long.parseLong(data[4]);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат данных для номера телефона.");
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        dateFormat.setLenient(false);

        try {
            dateFormat.parse(birthDate);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты рождения. Используйте формат dd.MM.yyyy.");
            return;
        }

        try {
            String fileName = lastName + ".txt";
            String userData = lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;

            FileWriter writer = new FileWriter(fileName, true);
            writer.write(userData + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException ex) {
            System.err.println("Ошибка при записи в файл: " + ex.getMessage());
        }
    }
}