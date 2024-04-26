package jobs4u.base.jobOpeningsManagement.utils;

import jobs4u.base.utils.ClientCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JobReferenceTest {

    @Test
    public void testValidJobReference() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        assertDoesNotThrow(() -> new JobReference(clientCode.code()));
    }


    @Test
    public void testJobReferenceEquality() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference jobReference1 = new JobReference(clientCode.code());
        JobReference jobReference2 = new JobReference(clientCode.code());
        assertEquals(jobReference1, jobReference2);
    }

    @Test
    public void testJobReferenceInequality() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        ClientCode clientCode1 = ClientCode.valueOf("isep2");

        JobReference jobReference1 = new JobReference(clientCode.code());
        JobReference jobReference2 = new JobReference(clientCode1.code());
        assertNotEquals(jobReference1, jobReference2);
    }

    @Test
    public void testJobReferenceComparison() {
        ClientCode clientCode = ClientCode.valueOf("isep");
        JobReference jobReference1 = new JobReference(clientCode.code());
        JobReference jobReference2 = new JobReference(clientCode.code());
        assertTrue(jobReference1.compareTo(jobReference2) == 0);
    }
}