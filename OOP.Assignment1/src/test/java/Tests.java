import observer.ConcreteMember;
import observer.GroupAdmin;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import static org.junit.Assert.assertEquals;

public class Tests {
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test() {
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void testInsert() {
        // Create a GroupAdmin instance with an initial document
        GroupAdmin admin = new GroupAdmin("Initial document");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();

        // Register the ConcreteMember instance with the GroupAdmin instance
        admin.register(member);

        // Perform an insert operation on the document
        admin.insert(0, "Inserted text at the beginning");
        admin.unregister(member);
        ConcreteMember member2 = new ConcreteMember();
        admin.register(member2);
        admin.append("bob");
        // Verify that the document has the expected value after the insert operation
        assertEquals(admin.getDocument().toString(), "Inserted text at the beginningInitial documentbob");
        System.out.println(member.toString());
        System.out.println(member2.toString());
    }

    @Test
    public void testAppend() {
        // Create a GroupAdmin instance with an initial document
        GroupAdmin admin = new GroupAdmin("Initial document");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();

        // Register the ConcreteMember instance with the GroupAdmin instance
        admin.register(member);

        // Perform an append operation on the document
        admin.append("Appended text at the end");

        // Verify that the document has the expected value after the append operation
        assertEquals(admin.getDocument().toString(), "Initial documentAppended text at the end");
    }

    @Test
    public void testDelete() {
        // Create a GroupAdmin instance with an initial document
        GroupAdmin admin = new GroupAdmin("Initial document");
        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();

        // Register the ConcreteMember instance with the Group
        admin.register(member);
        admin.delete(0,8);
        assertEquals(admin.getDocument().toString(), "document");
    }

    @Test
    public void testUndo() {
        // Create a GroupAdmin instance with an initial document
        GroupAdmin admin = new GroupAdmin("Initial document");
        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();
        admin.register(member);
        admin.insert(0, "Inserted text at the beginning");
        admin.undo();
        assertEquals(admin.getDocument().toString(), "Initial document");
    }
}

