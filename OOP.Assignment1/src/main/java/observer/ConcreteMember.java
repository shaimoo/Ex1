package observer;



public class ConcreteMember implements Member {
    private String document;

    @Override
    public void update(UndoableStringBuilder usb) {
        // Update the document copy
        document = usb.toString();
        // Perform some action based on the updated document
        System.out.println("ConcreteMember: Document has been updated: " + document);
        }

    @Override
    public String toString() {
        return document;
    }
}