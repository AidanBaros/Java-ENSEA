import java.util.LinkedList;

public class Directory extends ElementFileSystem{
    protected LinkedList<ElementFileSystem> listOfElements;

    public Directory(String name, Directory parentDirectory){
        super(name, parentDirectory);
        listOfElements = new LinkedList<>();
    }

    public void addElementFileSystem(ElementFileSystem e){
        listOfElements.add(e);
    }

    public int getSize(){
        int size = 0;
        for (ElementFileSystem e : listOfElements)
            size += e.getSize();
        return size;
    }

    public String toString(){
        String path = "";
        for (ElementFileSystem e : listOfElements){
            path = path + e.name + "\n";
        }
        return path;
    }
}
