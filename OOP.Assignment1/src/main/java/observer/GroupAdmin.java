package observer;
import java.util.ArrayList;
import java.util.List;

public class GroupAdmin implements Sender {
    private List<Member> members = new ArrayList<>();
    private UndoableStringBuilder document;

    public GroupAdmin(String str) {
        this.document = new UndoableStringBuilder(str);
        this.document.push(str);
    }

    public UndoableStringBuilder getDocument() {
        return document;
    }

    @Override
    public void register(Member obj) {
        members.add(obj);
    }

    @Override
    public void unregister(Member obj) {
        members.remove(obj);
    }

    @Override
    public void insert(int offset, String obj) {
        document.insert(offset, obj);
        notifyObservers();
    }

    @Override
    public void append(String obj) {
        document.append(obj);
        notifyObservers();
    }

    @Override
    public void delete(int start, int end) {
        document.delete(start, end);
        notifyObservers();
    }

    @Override
    public void undo() {
        document.undo();
        notifyObservers();
    }

    private void notifyObservers() {
        for (Member member : members) {
            member.update(this.document);
        }
    }
}
