import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
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

        @Test
        @DisplayName("throws IllegalArgumentException when addFirst with null")
        void throwsExceptionWhenAddFirstWithNull() {
            assertThrows(IllegalArgumentException.class, () -> deque.addFirst(null));
        }

        @Test
        @DisplayName("throws IllegalArgumentException when addLast with null")
        void throwsExceptionWhenAddLastWithNull() {
            assertThrows(IllegalArgumentException.class, () -> deque.addLast(null));
        }

        @Nested
        @DisplayName("when new - iterator")
        class WhenNewIterator {
            Iterator<Object> iterator;

            @BeforeEach
            void createDequeIterator() {
                iterator = deque.iterator();
            }

            @Test
            @DisplayName("hasNext can be false")
            void hasNext() {
                assertFalse(iterator.hasNext());
            }

            @Test
            @DisplayName("throws NoSuchElementException when next")
            void throwsExceptionWhenNext() {
                assertThrows(NoSuchElementException.class, () -> iterator.next());
            }

            @Test
            @DisplayName("throws UnsupportedOperationException when remove")
            void throwsExceptionWhenRemove() {
                assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
            }
        }

        @Nested
        @DisplayName("after addFirst")
        class AfterAddFirst {
            String anElement = "an element";

            @BeforeEach
            void addFirst() {
                deque.addFirst(anElement);
            }

            @Test
            @DisplayName("isEmpty can be false")
            void isEmpty() {
                assertFalse(deque.isEmpty());
            }

            @Test
            @DisplayName("size can be 1")
            void size() {
                assertEquals(1, deque.size());
            }

            @Nested
            @DisplayName("after addFirst - iterator")
            class AfterAddFirstIterator {
                Iterator<Object> iterator;

                @BeforeEach
                void createDequeIterator() {
                    iterator = deque.iterator();
                }

                @Test
                @DisplayName("hasNext can be true")
                void hasNext() {
                    assertTrue(iterator.hasNext());
                }

                @Test
                @DisplayName("next can be anElement")
                void next() {
                    assertEquals(anElement, iterator.next());
                }
            }
        }

        @Nested
        @DisplayName("after addLast")
        class AfterAddLast {
            String anElement = "an element";

            @BeforeEach
            void addLast() {
                deque.addLast(anElement);
            }

            @Test
            @DisplayName("isEmpty can be false")
            void isEmpty() {
                assertFalse(deque.isEmpty());
            }

            @Test
            @DisplayName("size can be 1")
            void size() {
                assertEquals(1, deque.size());
            }

            @Nested
            @DisplayName("after addLast - iterator")
            class AfterAddFirstIterator {
                Iterator<Object> iterator;

                @BeforeEach
                void createDequeIterator() {
                    iterator = deque.iterator();
                }

                @Test
                @DisplayName("hasNext can be true")
                void hasNext() {
                    assertTrue(iterator.hasNext());
                }

                @Test
                @DisplayName("next can be anElement")
                void next() {
                    assertEquals(anElement, iterator.next());
                }
            }
        }

        @Nested
        @DisplayName("after add some elements with random chose first or last")
        class AfterAddSomeElements {
            String anElement = "an element";
            int numberElements = 20;

            @BeforeEach
            void addSome() {
                for (int i = 0; i < numberElements; i++) {
                    if (Math.random() > 0.5) deque.addFirst(anElement);
                    else deque.addLast(anElement);
                }
            }

            @Test
            @DisplayName("isEmpty can be false")
            void isEmpty() {
                assertFalse(deque.isEmpty());
            }

            @Test
            @DisplayName("size can be numberElements")
            void size() {
                assertEquals(numberElements, deque.size());
            }

            @Nested
            @DisplayName("after add some elements - iterator")
            class AfterAddFirstIterator {
                Iterator<Object> iterator;

                @BeforeEach
                void createDequeIterator() {
                    iterator = deque.iterator();
                }

                @Test
                @DisplayName("hasNext can be true")
                void hasNext() {
                    assertTrue(iterator.hasNext());
                }

                @Test
                @DisplayName("next can be anElement")
                void next() {
                    assertAll(
                            () -> {
                                String lastElement = "";
                                int i;
                                for (i = 0; iterator.hasNext(); i++) {
                                    lastElement = (String) iterator.next();
                                }
                                assertEquals(anElement, lastElement);
                                assertEquals(numberElements, i);
                            });
                }
            }
        }

        @Nested
        @DisplayName("after add some elements and then remove all")
        class AfterAddSomeAndRemoveAll {
            String anElement = "an element";
            int numberElements = 20;

            @BeforeEach
            void addSome() {
                for (int i = 0; i < numberElements; i++) {
                    if (Math.random() > 0.5) deque.addFirst(anElement);
                    else deque.addLast(anElement);
                }
                for (int i = 0; i < numberElements; i++) {
                    if (Math.random() > 0.5) deque.removeFirst();
                    else deque.removeLast();
                }
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

            @Nested
            @DisplayName("when add some elements and then remove all - iterator")
            class WhenNewIterator {
                Iterator<Object> iterator;

                @BeforeEach
                void createDequeIterator() {
                    iterator = deque.iterator();
                }

                @Test
                @DisplayName("hasNext can be false")
                void hasNext() {
                    assertFalse(iterator.hasNext());
                }

                @Test
                @DisplayName("throws NoSuchElementException when next")
                void throwsExceptionWhenNext() {
                    assertThrows(NoSuchElementException.class, () -> iterator.next());
                }
            }
        }
    }
}