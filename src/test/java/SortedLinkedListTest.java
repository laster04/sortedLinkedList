import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SortedLinkedListTest {

    private SortedLinkedList sortedLinkedList;

    @BeforeEach
    void before() {
        this.sortedLinkedList = new SortedLinkedList();
    }

    @Test
    void baseTests() {
        assertNull(sortedLinkedList.getHlava());
    }

    @Test
    void pridatVice() {
        this.sortedLinkedList.pridatUzel(15);
        this.sortedLinkedList.pridatUzel(10);
        this.sortedLinkedList.pridatUzel(13);
        assertEquals(3, this.sortedLinkedList.getListSize());
        List<Integer> add = List.of(8, 6, 11, 58);
        this.sortedLinkedList.pridatVice(add);
        assertEquals(7, this.sortedLinkedList.getListSize());
    }

    @Test
    void addOneTests() {
        List<Integer> expected = List.of(2, 7, 10, 13, 15, 19, 25);
        this.sortedLinkedList.pridatUzel(15);
        this.sortedLinkedList.pridatUzel(10);
        this.sortedLinkedList.pridatUzel(13);
        this.sortedLinkedList.pridatUzel(19);
        this.sortedLinkedList.pridatUzel(25);
        this.sortedLinkedList.pridatUzel(2);
        this.sortedLinkedList.pridatUzel(7);
        List<Integer> actual = this.sortedLinkedList.getHodnotyList();
        assertEquals(expected, actual);
    }

    @Test
    void sizeTest() {
        this.sortedLinkedList.pridatUzel(15);
        this.sortedLinkedList.pridatUzel(10);
        this.sortedLinkedList.pridatUzel(13);
        this.sortedLinkedList.pridatUzel(19);
        assertEquals(4, this.sortedLinkedList.getListSize());
    }

    @Test
    void removeAt() {
        this.sortedLinkedList.pridatUzel(15);
        this.sortedLinkedList.pridatUzel(10);
        this.sortedLinkedList.pridatUzel(13);
        this.sortedLinkedList.pridatUzel(19);
        this.sortedLinkedList.removeUzetAt(3);
        List<Integer> expected = List.of(10, 13, 19);
        List<Integer> actual = this.sortedLinkedList.getHodnotyList();
        assertEquals(expected, actual);

    }
}
