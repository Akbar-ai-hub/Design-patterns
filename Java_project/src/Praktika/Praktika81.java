package Praktika;

import java.text.SimpleDateFormat;
import java.util.Date;

interface IReport {
    String generate();
}

class SalesReport implements IReport {
    @Override
    public String generate() {
        return "Отчет по продажам: [Фиктивные данные]";
    }
}

class UserReport implements IReport {
    @Override
    public String generate() {
        return "Отчет по пользователям: [Фиктивные данные]";
    }
}

abstract class ReportDecorator implements IReport {
    protected IReport report;

    public ReportDecorator(IReport report) {
        this.report = report;
    }

    @Override
    public String generate() {
        return report.generate();
    }
}

class DateFilterDecorator extends ReportDecorator {
    private Date startDate;
    private Date endDate;

    public DateFilterDecorator(IReport report, Date startDate, Date endDate) {
        super(report);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String generate() {
        return super.generate() + "\nФильтрация по датам: с " + startDate + " по " + endDate;
    }
}

class SortingDecorator extends ReportDecorator {
    private String criterion;

    public SortingDecorator(IReport report, String criterion) {
        super(report);
        this.criterion = criterion;
    }

    @Override
    public String generate() {
        return super.generate() + "\nСортировка по: " + criterion;
    }
}

class CsvExportDecorator extends ReportDecorator {
    public CsvExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return super.generate() + "\nЭкспорт в CSV";
    }
}

class PdfExportDecorator extends ReportDecorator {
    public PdfExportDecorator(IReport report) {
        super(report);
    }

    @Override
    public String generate() {
        return super.generate() + "\nЭкспорт в PDF";
    }
}

class SalesAmountFilterDecorator extends ReportDecorator {
    private double minAmount;

    public SalesAmountFilterDecorator(IReport report, double minAmount) {
        super(report);
        this.minAmount = minAmount;
    }

    @Override
    public String generate() {
        return super.generate() + "\nФильтрация по сумме продаж: от " + minAmount;
    }
}

public class Praktika81 {
    public static void main(String[] args) throws Exception {
        IReport report = new SalesReport();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2023-01-01");
        Date endDate = sdf.parse("2023-12-31");

        report = new DateFilterDecorator(report, startDate, endDate);
        report = new SortingDecorator(report, "дата");
        report = new SalesAmountFilterDecorator(report, 1000.0);
        report = new CsvExportDecorator(report);

        System.out.println(report.generate());
    }
}
