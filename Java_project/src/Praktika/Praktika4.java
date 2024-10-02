package Praktika;

interface IDocument{
    void open();
}

class Report implements IDocument{
    @Override
    public void open() {
        System.out.println("Report open!");
    }
}

class Letter implements IDocument{
    @Override
    public void open() {
        System.out.println("Letter open!");
    }
}

class Resume implements IDocument{
    @Override
    public void open() {
        System.out.println("Resume open!");
    }
}

class Invoice implements IDocument{
    @Override
    public void open() {
       System.out.println("Invoice open!");
    }
}

abstract class DocumentCreator{
    public abstract IDocument CreateDocument();
}

class ReportCreator extends DocumentCreator{
    public IDocument CreateDocument(){
        return new Report();
    }
}

class LetterCreator extends DocumentCreator{
    public IDocument CreateDocument(){
        return new Letter();
    }
}

class ResumeCreator extends DocumentCreator{
    public IDocument CreateDocument(){
        return new Resume();
    }
}

class InvoiceCreator extends DocumentCreator{
    @Override
    public IDocument CreateDocument() {
        return new Invoice();
    }
}

enum DocType{
    Report, Resume, Letter, Invoice
}

public class Praktika4 {
    public static void main(String[] args) throws Exception {
        GetDocument(DocType.Report).open();
    }

    public static IDocument GetDocument(DocType docType) throws Exception {
        DocumentCreator creator = null;
        IDocument document = null;

        switch (docType) {
            case DocType.Report:
                creator = new ReportCreator();
                break;
            case DocType.Resume:
                creator = new ResumeCreator();
                break;
            case DocType.Letter:
                creator = new LetterCreator();
                break;
            case DocType.Invoice:
                creator = new InvoiceCreator();
                break;
            default:
                throw new Exception("Не корректный тип");
        }
        document = creator.CreateDocument();
        return document;

    }
}
