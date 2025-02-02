public abstract class ElementFileSystem {
    protected String name;
    protected Directory parentDirectory;

    public ElementFileSystem(String name, Directory parentDirectory){
        this.name = name;
        this.parentDirectory = parentDirectory;
        try{
            this.parentDirectory.addElementFileSystem(this);
        }catch(Exception e){
            System.out.println("No parent directory found");
        }
        
    }
    public abstract int getSize();
    public abstract String toString();

    public void setParentDirectory(Directory parentDirectory){
        this.parentDirectory = parentDirectory;
    }

    public String getPath(){
        String path = this.name;
        if (this.parentDirectory != null){
            path = this.parentDirectory.getPath() + "/" + path;
        }
        return path;
    }
}
