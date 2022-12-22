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
    public void test(){
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
        GroupAdmin admin = new GroupAdmin(" nir");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();

        // Register the ConcreteMember instance with the GroupAdmin instance
        admin.register(member);

        // Perform an insert operation on the document
        admin.insert(0, "Inserted  text at the beginning");
        admin.unregister(member);
        ConcreteMember member2 = new ConcreteMember();
        admin.register(member2);
        admin.insert(9,"bob");
        // Verify that the document has the expected value after the insert operation
        assertEquals(admin.getDocument().toString(), "Inserted bob text at the beginning nir");
        assertEquals(member.toString(),"Inserted  text at the beginning nir");
        assertEquals(member2.toString(),"Inserted bob text at the beginning nir");

    }

    @Test
    public void testAppend() {
        // Create a GroupAdmin instance with an initial document
        GroupAdmin admin = new GroupAdmin("shai ");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();
        ConcreteMember member1 = new ConcreteMember();
        // Register the ConcreteMember instance with the GroupAdmin instance
        admin.register(member);

        // Perform an append operation on the document
        admin.append("Appended text at the end");
        admin.unregister(member);
        admin.register(member1);
        admin.append(" bob");
        // Verify that the document has the expected value after the append operation
        assertEquals(admin.getDocument().toString(), "shai Appended text at the end bob");
        assertEquals(member.toString(),"shai Appended text at the end");
        assertEquals(member1.toString(),"shai Appended text at the end bob");
    }

    @Test
    public void testDelete() {
        // Create a GroupAdmin instance with an initial document
        GroupAdmin admin = new GroupAdmin("Initial document");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();
        ConcreteMember member1 = new ConcreteMember();
        admin.register(member);
        admin.delete(0,8);
        admin.unregister(member);
        admin.register(member1);
        admin.delete(0,4);
        assertEquals(member.toString(),"document");
        assertEquals(member1.toString(),"ment");
    }
    @Test
    public void testUndo(){
        // Create a GroupAdmin instance with an initial document
        GroupAdmin admin = new GroupAdmin("Initial document");

        // Create a ConcreteMember instance
        ConcreteMember member = new ConcreteMember();
        ConcreteMember member1 = new ConcreteMember();
        admin.register(member);
        admin.append("test");
        assertEquals(member.toString(),"Initial documenttest");
        admin.undo();
        System.out.println(member.toString());
        assertEquals(member.toString(),"Initial document");
        admin.register(member1);
        admin.delete(10,15);
        assertEquals(member1.toString(),"Initial dot");
        admin.undo();
        assertEquals(member.toString(),"Initial document");
    }
}
