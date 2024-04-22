package jobs4u.base.jobOpeningsManagement.utils;

import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobReferenceTest {

    @Test
    public void testValidJobReference() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        assertDoesNotThrow(() -> new JobReference(clientCode, 123456));
    }


    @Test
    public void testJobReferenceEquality() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference jobReference1 = new JobReference(clientCode, 123456);
        JobReference jobReference2 = new JobReference(clientCode, 123456);
        assertEquals(jobReference1, jobReference2);
    }

    @Test
    public void testJobReferenceInequality() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference jobReference1 = new JobReference(clientCode, 123456);
        JobReference jobReference2 = new JobReference(clientCode, 654321);
        assertNotEquals(jobReference1, jobReference2);
    }

    @Test
    public void testJobReferenceComparison() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference jobReference1 = new JobReference(clientCode, 123456);
        JobReference jobReference2 = new JobReference(clientCode, 654321);
        assertTrue(jobReference1.compareTo(jobReference2) < 0);
    }
}