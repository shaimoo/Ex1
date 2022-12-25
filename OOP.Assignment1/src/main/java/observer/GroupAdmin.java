package observer;
import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    private List<Member> members = new ArrayList<>();
    private UndoableStringBuilder document;

    /**
     * Constructor
     * @param str the initial document
     */
    public GroupAdmin(String str) {
        this.document = new UndoableStringBuilder(str);
        this.document.push(str);
    }

    public UndoableStringBuilder getDocument() {
        return document;
    }
    /**
     * this function add the observer (member) to the observable (group admin).
     */
    @Override
    public void register(Member obj) {
        members.add(obj);
    }
    /**
     * this function removes the observer (member)  from the observable (group admin).
     */
    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }
    /**
     * this function insert new string to our stringBuilder in specific location.
     * @param offset= the current location we insert to our stringBuilder.
     * @param obj=this is the string we insert to our stringBuilder.
     */
    @Override
    public void insert(int offset, String obj) {
        document.insert(offset, obj);
        notifyObservers();
    }
    /**
     *  here we add a string for our stringBuilder and then we notify the observers.
     * @param obj = this is the string we append to document.
     */
    @Override
    public void append(String obj) {
        document.append(obj);
        notifyObservers();
    }
    /**
     * this function delete from the stringBuilder.
     * @param start:the index we start to delete our stringBuilder.
     * @param end:the index we finish to delete our stringBuilder.
     */
    @Override
    public void delete(int start, int end) {
        document.delete(start, end);
        notifyObservers();
    }
    /**
     * this function is pop from the stack the previous stringBuilder and update our stringBuilder.
     */
    @Override
    public void undo() {
        document.undo();
        notifyObservers();
    }
    /**
     * this function are update the document for every member that registered.
     */
    private void notifyObservers() {
        for (Member member : members) {
            member.update(this.document);
        }
    }
}
