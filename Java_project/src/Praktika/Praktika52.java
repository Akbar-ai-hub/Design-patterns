package Praktika;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

interface IReportBuilder {
    void setHeader(String header);
    void setContent(String content);
    void setFooter(String footer);
    void addSection(String sectionName, String sectionContent);
    void setStyle(ReportStyle style);
    Reports getReport();
}

class TextReportBuilder implements IReportBuilder {
    private Reports reports = new Reports();

    @Override
    public void setHeader(String header) {
        reports.setHeader(header);
    }

    @Override
    public void setContent(String content) {
        reports.setContent(content);
    }

    @Override
    public void setFooter(String footer) {
        reports.setFooter(footer);
    }

    @Override
    public void addSection(String sectionName, String sectionContent) {
        reports.addSection(sectionName, sectionContent);
    }

    @Override
    public void setStyle(ReportStyle style) {
        reports.setStyle(style);
    }

    @Override
    public Reports getReport() {
        return reports;
    }
}

class HtmlReportBuilder implements IReportBuilder {
    private Reports reports = new Reports();

    @Override
    public void setHeader(String header) {
        reports.setHeader("<h1>" + header + "</h1>");
    }

    @Override
    public void setContent(String content) {
        reports.setContent("<p>" + content + "</p>");
    }

    @Override
    public void setFooter(String footer) {
        reports.setFooter("<footer>" + footer + "</footer>");
    }

    @Override
    public void addSection(String sectionName, String sectionContent) {
        reports.addSection("<h2>" + sectionName + "</h2>", "<p>" + sectionContent + "</p>");
    }

    @Override
    public void setStyle(ReportStyle style) {
        reports.setStyle(style);
    }

    @Override
    public Reports getReport() {
        return reports;
    }
}

class PdfReportBuilder implements IReportBuilder {
    private Reports reports = new Reports();

    @Override
    public void setHeader(String header) {
        reports.setHeader(header);
    }

    @Override
    public void setContent(String content) {
        reports.setContent(content);
    }

    @Override
    public void setFooter(String footer) {
        reports.setFooter(footer);
    }

    @Override
    public void addSection(String sectionName, String sectionContent) {
        reports.addSection(sectionName, sectionContent);
    }

    @Override
    public void setStyle(ReportStyle style) {
        reports.setStyle(style);
    }

    @Override
    public Reports getReport() {
        return reports;
    }
}

class ReportStyle {
    private String backgroundColor;
    private String fontColor;
    private int fontSize;

    // Getters и setters

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
}

class Reports {
    private String header;
    private String content;
    private String footer;
    private Map<String, String> sections = new HashMap<>();
    private ReportStyle style;

    // Getters и setters

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public Map<String, String> getSections() {
        return sections;
    }

    public void addSection(String sectionName, String sectionContent) {
        sections.put(sectionName, sectionContent);
    }

    public ReportStyle getStyle() {
        return style;
    }

    public void setStyle(ReportStyle style) {
        this.style = style;
    }

    public void export(String format) {
        switch (format) {
            case "text":
                exportAsText();
                break;
            case "html":
                exportAsHtml();
                break;
            case "pdf":
                exportAsPdf();
                break;
            default:
                throw new IllegalArgumentException("Unsupported format: " + format);
        }
    }

    private void exportAsText() {
        System.out.println("Экспорт в текстовый формат:");
        System.out.println(header);
        System.out.println(content);
        for (Map.Entry<String, String> section : sections.entrySet()) {
            System.out.println(section.getKey());
            System.out.println(section.getValue());
        }
        System.out.println(footer);
    }

    private void exportAsHtml() {
        System.out.println("Экспорт в HTML формат:");
        System.out.println("<html><body style='background-color:" + style.getBackgroundColor() + ";color:" + style.getFontColor() + ";font-size:" + style.getFontSize() + "px;'>");
        System.out.println(header);
        System.out.println(content);
        for (Map.Entry<String, String> section : sections.entrySet()) {
            System.out.println(section.getKey());
            System.out.println(section.getValue());
        }
        System.out.println(footer);
        System.out.println("</body></html>");
    }

    private void exportAsPdf() {
        System.out.println("Экспорт в PDF формат (но без использования библиотек):");
        try {
            FileWriter writer = new FileWriter("reports.pdf");
            writer.write(header + "\n");
            writer.write(content + "\n");
            for (Map.Entry<String, String> section : sections.entrySet()) {
                writer.write(section.getKey() + "\n");
                writer.write(section.getValue() + "\n");
            }
            writer.write(footer + "\n");
            writer.close();
            System.out.println("Отчет экспортирован в reports.pdf (это просто текстовый файл).");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class ReportDirector {
    public void constructReport(IReportBuilder builder, ReportStyle style) {
        builder.setStyle(style);
        builder.setHeader("Отчет о продажах");
        builder.setContent("Основной раздел отчета.");
        builder.addSection("Раздел 1", "Содержание раздела 1.");
        builder.addSection("Раздел 2", "Содержание раздела 2.");
        builder.setFooter("Конец отчета.");
    }
}


public class Praktika52 {
    public static void main(String[] args) {
        ReportDirector director = new ReportDirector();
        ReportStyle style = new ReportStyle();
        style.setBackgroundColor("white");
        style.setFontColor("black");
        style.setFontSize(12);

        IReportBuilder textBuilder = new TextReportBuilder();
        director.constructReport(textBuilder, style);
        Reports textReports = textBuilder.getReport();
        textReports.export("text");

        IReportBuilder htmlBuilder = new HtmlReportBuilder();
        director.constructReport(htmlBuilder, style);
        Reports htmlReports = htmlBuilder.getReport();
        htmlReports.export("html");

        IReportBuilder pdfBuilder = new PdfReportBuilder();
        director.constructReport(pdfBuilder, style);
        Reports pdfReports = pdfBuilder.getReport();
        pdfReports.export("pdf");
    }
}
