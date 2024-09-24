package Homework;// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа DRY:Использование параметризованных методов

/* public void log(String messageType, String message) {
    System.out.println(messageType + ": " + message);
}

public void logError(String message) {
    log("ERROR", message);
}

public void logWarning(String message) {
    log("WARNING", message);
}

public void logInfo(String message) {
    log("INFO", message);
}*/

// Использование общих конфигурационных настроек

/* public class Config {
    private static final String connectionString = "Server=myServer; Database=myDb; UserId=myUser; Password=myPass;";

    public static String getConnectionString() {
        return connectionString;
    }
}

public class DatabaseService {
    public void connect() {
        String connectionString = Config.getConnectionString();
        // Логика подключения к базе данных с использованием общей строки подключения
        System.out.println("Connecting to database with: " + connectionString);
    }
}

public class LoggingService {
    public void log(String message) {
        String connectionString = Config.getConnectionString();
        // Логика записи лога в базу данных с использованием общей строки подключения
        System.out.println("Logging message to database with: " + connectionString);
    }
} */

// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа KISS:Избегание ненужного вложения кода

/* public void processNumbers(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
        return;
    }

    for (int number : numbers) {
        if (number > 0) {
            System.out.println(number);
        }
    }
}*/

// Избегание ненужного использования LINQ

/* import java.util.Arrays;

public void printPositiveNumbers(int[] numbers) {
    Arrays.sort(numbers);

    for (int number : numbers) {
        if (number > 0) {
            System.out.println(number);
        }
    }
}*/

// Избегание избыточного использования исключений

/* public int divide(int a, int b) {
    if (b == 0) {
        return 0;
    }
    return a / b;
}*/

// Произведите корректную (правильную) по вашему мнению реализацию с применением принципа YAGNI:Создание многофункционального класса

/* public class User {
    private String name;
    private String email;
    private String address;

    public User(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

public class UserRepository {
    public void saveToDatabase(User user) {
        // Логика сохранения пользователя в базу данных
        System.out.println("Saving user " + user.getName() + " to database");
    }
}

public class EmailService {
    public void sendEmail(User user) {
        // Логика отправки письма
        System.out.println("Sending email to " + user.getEmail());
    }
}

public class AddressLabelPrinter {
    public void printAddressLabel(User user) {
        // Логика печати ярлыка
        System.out.println("Printing address label for " + user.getAddress());
    }
}*/

// Добавление ненужных настроек или конфигураций

/* public class FileReader {

    public String readFile(String filePath) {
        // Логика чтения файла с использованием стандартного буфера
        int bufferSize = 1024;
        System.out.println("Reading file with buffer size: " + bufferSize);

        return "file content";
    }
}*/

// Добавление ненужных методов и функций

/* public class ReportGenerator {

    public void generateReport(String reportType) {
        switch (reportType.toLowerCase()) {
            case "pdf":
                generatePdfReport();
                break;
            case "excel":
                generateExcelReport();
                break;
            case "html":
                generateHtmlReport();
                break;
            default:
                System.out.println("Unsupported report type: " + reportType);
        }
    }

    private void generatePdfReport() {
        // Логика генерации PDF отчета
        System.out.println("Generating PDF report...");
    }

    private void generateExcelReport() {
        // Логика генерации Excel отчета
        System.out.println("Generating Excel report...");
    }

    private void generateHtmlReport() {
        // Логика генерации HTML отчета
        System.out.println("Generating HTML report...");
    }
}
*/




public void main() {
}