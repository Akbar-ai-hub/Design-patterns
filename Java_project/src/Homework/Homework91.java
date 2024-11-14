package Homework;
import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void display(int depth);
    int getSize();
    String getName();
}

class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "- File: " + name + " (" + size + " bytes)");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void add(FileSystemComponent component) {
        if (!children.contains(component)) {
            children.add(component);
        } else {
            System.out.println("Component " + component.getName() + " already exists in " + name);
        }
    }

    public void remove(FileSystemComponent component) {
        if (children.contains(component)) {
            children.remove(component);
        } else {
            System.out.println("Component " + component.getName() + " does not exist in " + name);
        }
    }

    @Override
    public void display(int depth) {
        System.out.println(" ".repeat(depth) + "- Directory: " + name);
        for (FileSystemComponent component : children) {
            component.display(depth + 2);
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }

    @Override
    public String getName() {
        return name;
    }
}

public class Homework91 {
    public static void main(String[] args) {
        Directory root = new Directory("Root");
        File file1 = new File("File1.txt", 500);
        File file2 = new File("File2.txt", 300);
        Directory subDir = new Directory("SubDirectory");
        File subFile1 = new File("SubFile1.txt", 100);

        root.add(file1);
        root.add(file2);
        subDir.add(subFile1);
        root.add(subDir);

        root.add(file1);

        root.remove(new File("NonExistentFile.txt", 100));

        System.out.println("File System Structure:");
        root.display(1);

        System.out.println("Total Size of Root Directory: " + root.getSize() + " bytes");
    }
}
