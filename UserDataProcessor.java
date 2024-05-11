import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class UserDataProcessor {

    public static void main(String[] args) {
        processUserData();
    }

    public static void processUserData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");

        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Неверное количество данных. Пожалуйста, введите данные в нужном формате.");
            return;
        }

        try {
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            String fileName = lastName + ".txt";
            String userData = lastName + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " " + gender;

            FileWriter writer = new FileWriter(fileName, true);
            writer.write(userData + "\n");
            writer.close();

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат данных для номера телефона.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Произошла ошибка: " + e.getMessage());
        }
    }
}