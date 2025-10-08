public class InterfaceSandbox {
}

interface Container {
    public int totalContainers();
}

interface Folder {
    public int totalFolders();
}

class OrganizedRoom implements Container, Folder {
    private int folders;
    private int containers;

    public OrganizedRoom(int folders, int containers) {
        this.folders = folders;
        this.containers = containers;
    }

    @Override
    public int totalFolders() {
        return folders;
    }

    @Override
    public int totalContainers() {
        return containers;
    }
}
    
class DriverForInterfaceSandbox {
    public static void main(String [] args) {
        // notice how you can't declare the interface classes as objects
        //Container cont1 = new Container();    
        //Folder fold1 = new Folder();

        OrganizedRoom room1 = new OrganizedRoom(2, 5);
        System.out.printf("%nTotal containers: %d %nTotal folders: %d", room1.totalContainers(), room1.totalFolders());
    }
}
