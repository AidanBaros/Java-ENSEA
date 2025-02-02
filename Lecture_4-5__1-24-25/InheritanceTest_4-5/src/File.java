public class File extends ElementFileSystem{
    protected int size;
    public File(String name, Directory parentDirectory, int size){
        super(name, parentDirectory);
        this.size = size;
    }

    public int getSize(){
        return this.size;
    }

    public String toString(){
        return "name: " + this.name + ", " + "size: " + this.size;
    }

    public void move(Directory parentDirectory){
        this.parentDirectory.listOfElements.remove(this);
        this.parentDirectory = parentDirectory;
        this.parentDirectory.addElementFileSystem(this);
    }
}
