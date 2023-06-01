package junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    static ArrayList<String> list;

    @BeforeEach
    void setUp() throws Exception {
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }

    // insert operation test
    @Test
    public void insertTest() {
        // Assertion for size
        assertEquals(2, list.size(), "Wrong size");
        // Add new element
        list.add(2, "gamma");
        // Assert with new elements
        assertEquals(3, list.size(), "Wrong size");

        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("gamma", list.get(2), "Wrong element");
    }

    // replace operation test
    @Test
    public void replaceTest() {
        // Replace new element
        list.set(1, "gamma");

        // Assert size of list
        assertEquals(2, list.size(), "Wrong size");
        // Assert individual elements
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("gamma", list.get(1), "Wrong element");
    }

}
