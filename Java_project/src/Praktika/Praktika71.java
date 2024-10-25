package Praktika;

import java.util.Scanner;

abstract class ReportGenerator {
    public final void generateReport() {
        log("Report generation started.");
        collectData();
        formatData();
        if (customerWantsSave()) {
            saveReport();
        } else {
            sendByEmail();
        }
        log("Report generation completed.");
    }

    protected void collectData() {
        System.out.println("Collecting data for report...");
        log("Data collected.");
    }

    protected boolean customerWantsSave() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to save the report? (yes/no): ");
        String answer = scanner.nextLine().toLowerCase();

        while (!answer.equals("yes") && !answer.equals("no")) {
            System.out.print("Invalid input. Please enter 'yes' or 'no': ");
            answer = scanner.nextLine().toLowerCase();
        }

        return answer.equals("yes");
    }

    protected abstract void formatData();
    protected abstract void saveReport();

    protected void sendByEmail() {
        System.out.println("Sending report by email...");
        log("Report sent by email.");
    }

    protected void log(String message) {
        System.out.println("[LOG] " + message);
    }
}

class PdfReport extends ReportGenerator {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for PDF report...");
        log("Data formatted for PDF.");
    }

    @Override
    protected void saveReport() {
        System.out.println("Saving PDF report...");
        log("PDF report saved.");
    }
}

class ExcelReport extends ReportGenerator {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for Excel report...");
        log("Data formatted for Excel.");
    }

    @Override
    protected void saveReport() {
        System.out.println("Saving Excel report...");
        log("Excel report saved.");
    }
}

class HtmlReport extends ReportGenerator {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for HTML report...");
        log("Data formatted for HTML.");
    }

    @Override
    protected void saveReport() {
        System.out.println("Saving HTML report...");
        log("HTML report saved.");
    }
}

class CsvReport extends ReportGenerator {
    @Override
    protected void formatData() {
        System.out.println("Formatting data for CSV report...");
        log("Data formatted for CSV.");
    }

    @Override
    protected void saveReport() {
        System.out.println("Saving CSV report...");
        log("CSV report saved.");
    }
}

public class Praktika71 {
    public static void main(String[] args) {
        ReportGenerator pdfReport = new PdfReport();
        ReportGenerator excelReport = new ExcelReport();
        ReportGenerator htmlReport = new HtmlReport();
        ReportGenerator csvReport = new CsvReport();

        System.out.println("Generating PDF Report...");
        pdfReport.generateReport();

        System.out.println("\nGenerating Excel Report...");
        excelReport.generateReport();

        System.out.println("\nGenerating HTML Report...");
        htmlReport.generateReport();

        System.out.println("\nGenerating CSV Report...");
        csvReport.generateReport();
    }
}

