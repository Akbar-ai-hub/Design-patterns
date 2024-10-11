package Laboratory;

import java.util.ArrayList;
import java.util.List;

interface IPrototype<T> {
    T clone();
}

class Section implements IPrototype<Section> {
    private String title;
    private String content;

    public Section(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public Section clone() {
        return new Section(title, content);
    }
}

class Image implements IPrototype<Image> {
    private String url;

    public Image(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Image clone() {
        return new Image(url);
    }
}

class Document implements IPrototype<Document> {
    private String title;
    private String content;
    private List<Section> sections;
    private List<Image> images;

    public Document(String title, String content) {
        this.title = title;
        this.content = content;
        this.sections = new ArrayList<>();
        this.images = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void addSection(Section section) {
        this.sections.add(section);
    }

    public List<Image> getImages() {
        return images;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    @Override
    public Document clone() {
        Document clonedDocument = new Document(this.title, this.content);

        for (Section section : this.sections) {
            clonedDocument.addSection(section.clone());
        }

        for (Image image : this.images) {
            clonedDocument.addImage(image.clone());
        }

        return clonedDocument;
    }
}

class DocumentManager {
    public Document createDocument(IPrototype<Document> prototype) {
        return prototype.clone();
    }
}

public class Lab52 {
    public static void main(String[] args) {
        Document originalDocument = new Document("Original Title", "This is the content of the original document.");

        Section section1 = new Section("Introduction", "This is the introduction.");
        Section section2 = new Section("Conclusion", "This is the conclusion.");
        originalDocument.addSection(section1);
        originalDocument.addSection(section2);

        Image image1 = new Image("http://example.com/image1.jpg");
        Image image2 = new Image("http://example.com/image2.jpg");
        originalDocument.addImage(image1);
        originalDocument.addImage(image2);

        DocumentManager documentManager = new DocumentManager();
        Document clonedDocument = documentManager.createDocument(originalDocument);

        clonedDocument.setTitle("Cloned Title");
        clonedDocument.setContent("This is the content of the cloned document.");
        clonedDocument.getSections().get(0).setContent("This is the updated introduction.");
        clonedDocument.getImages().get(0).setUrl("http://example.com/cloned_image1.jpg");

        System.out.println("Original Document Title: " + originalDocument.getTitle());
        System.out.println("Original Document Content: " + originalDocument.getContent());
        System.out.println("Original Section 1 Content: " + originalDocument.getSections().get(0).getContent());
        System.out.println("Original Image 1 URL: " + originalDocument.getImages().get(0).getUrl());

        System.out.println("\nCloned Document Title: " + clonedDocument.getTitle());
        System.out.println("Cloned Document Content: " + clonedDocument.getContent());
        System.out.println("Cloned Section 1 Content: " + clonedDocument.getSections().get(0).getContent());
        System.out.println("Cloned Image 1 URL: " + clonedDocument.getImages().get(0).getUrl());
    }
}
