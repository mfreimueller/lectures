class DocumentStorage {
    public void save(String document) {
        System.out.println("Document saved: " + document);
    }
}

class NetworkManager {
    public void send(String data, String address) {
        System.out.println("Sent to " + address + ": " + data);
    }
}

class Printer {
    private final DocumentStorage storage = new DocumentStorage();
    private final NetworkManager network = new NetworkManager();

    public void print(String document) {
        System.out.println("Printing: " + document);
        storage.save(document);
    }

    public String scan() {
        throw new UnsupportedOperationException("This printer cannot scan");
    }

    public void fax(String document, String number) {
        throw new UnsupportedOperationException("This printer cannot fax");
    }
}

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.print("Hello World");
        printer.scan();
    }
}
