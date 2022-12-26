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
        // Create a GroupAdmin instance with an alice
        GroupAdmin admin = new GroupAdmin("alice");

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
        assertEquals(admin.getDocument().toString(), "Inserted text at the beginningalicebob");
        System.out.println(member.toString());
        System.out.println(member2.toString());

        logger.info(()->JvmUtilities.objectFootprint(member));

        logger.info(()->JvmUtilities.objectFootprint(member,member2));

        logger.info(()->JvmUtilities.objectFootprint(member,member2,admin));

        logger.info(()->JvmUtilities.objectTotalSize(member));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void testAppend() {
        // Create a GroupAdmin instance with an bob
        GroupAdmin admin = new GroupAdmin("bob");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();

        // Register the ConcreteMember instance with the GroupAdmin instance
        admin.register(member);

        // Perform an append operation on the document
        admin.append("Appended text at the end");

        // Verify that the document has the expected value after the append operation
        assertEquals(admin.getDocument().toString(), "bobAppended text at the end");
        logger.info(()->JvmUtilities.objectFootprint(member));

        logger.info(()->JvmUtilities.objectFootprint(member,admin));

        logger.info(()->JvmUtilities.objectTotalSize(member));

        logger.info(() -> JvmUtilities.jvmInfo());
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

        logger.info(()->JvmUtilities.objectFootprint(member));

        logger.info(()->JvmUtilities.objectFootprint(member,admin));

        logger.info(()->JvmUtilities.objectTotalSize(member));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void testUndo() {
        // Create a GroupAdmin instance with an shai
        GroupAdmin admin = new GroupAdmin("shai");
        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();
        admin.register(member);
        admin.insert(0, "Inserted text at the beginning");
        admin.undo();
        assertEquals(admin.getDocument().toString(), "shai");

        logger.info(()->JvmUtilities.objectFootprint(member));

        logger.info(()->JvmUtilities.objectFootprint(member,admin));

        logger.info(()->JvmUtilities.objectTotalSize(member));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    @Test
    public void testUpdate() {
        // Create a GroupAdmin instance with an nir
        GroupAdmin admin = new GroupAdmin("nir");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();

        // Register the ConcreteMember instance with the GroupAdmin instance
        admin.register(member);

        // Perform some operations on the document
        admin.insert(0, "Inserted text at the beginning ");
        admin.append(" Appended text at the end");

        // Verify that the ConcreteMember instance has the expected document copy
        assertEquals(member.toString(), "Inserted text at the beginning nir Appended text at the end");

        logger.info(()->JvmUtilities.objectFootprint(member));

        logger.info(()->JvmUtilities.objectFootprint(member,admin));

        logger.info(()->JvmUtilities.objectTotalSize(member));

        logger.info(() -> JvmUtilities.jvmInfo());
    }
    @Test
    public void testMultipleUpdates() {
        // Create a GroupAdmin instance with an test
        GroupAdmin admin = new GroupAdmin("test");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();

        // Register the ConcreteMember instance with the GroupAdmin instance
        admin.register(member);

        // Perform some operations on the document
        admin.insert(0, "Inserted text at the beginning");
        admin.append("Appended text at the end");
        admin.delete(5, 10);
        admin.undo();

        // Verify that the ConcreteMember instance has the expected document copy
        assertEquals(member.toString(), "Inserted text at the beginningtestAppended text at the end");
        
        logger.info(()->JvmUtilities.objectFootprint(member));

        logger.info(()->JvmUtilities.objectFootprint(member,admin));

        logger.info(()->JvmUtilities.objectTotalSize(member));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

}

