import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Deque")
class DequeTest {
    Deque<Object> deque;

    @Test
    @DisplayName("is instantiated with new Deque()")
    void isInstantiatedWithNew() {
        new Deque<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {

        @BeforeEach
        void createNewDeque() {
            deque = new Deque<>();
        }

        @Test
        @DisplayName("isEmpty can be true")
        void isEmpty() {
            assertTrue(deque.isEmpty());
        }

        @Test
        @DisplayName("size can be 0")
        void size() {
            assertEquals(0, deque.size());
        }

        @Test
        @DisplayName("throws NoSuchElementException when removeFirst")
        void throwsExceptionWhenRemoveFirst() {
            assertThrows(NoSuchElementException.class, () -> deque.removeFirst());
        }

        @Test
        @DisplayName("throws NoSuchElementException when removeLast")
        void throwsExceptionWhenRemoveLast() {
            assertThrows(NoSuchElementException.class, () -> deque.removeLast());
        }
    }
}