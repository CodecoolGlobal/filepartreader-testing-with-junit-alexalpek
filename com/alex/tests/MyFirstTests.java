import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class MyFirstTests {

    @Test
    @DisplayName("FilePartReader read() method")
    void testRead(TestInfo testInfo) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("com/alex/file.txt", 1, 1);
        Assertions.assertEquals(
                "Tyger Tyger, burning bright,\n" +
                        "In the forests of the night;\n" +
                        "What immortal hand or eye,\n" +
                        "Could frame thy fearful symmetry?\n" +
                        "In what distant deeps or skies.\n" +
                        "Burnt the fire of thine eyes?\n" +
                        "On what wings dare he aspire?\n" +
                        "What the hand, dare seize the fire?\n" +
                        "And what shoulder, & what art,\n" +
                        "Could twist the sinews of thy heart?\n" +
                        "And when thy heart began to beat,\n" +
                        "What dread hand? & what dread feet?\n" +
                        "What the hammer? what the chain,\n" +
                        "In what furnace was thy brain?\n" +
                        "What the anvil? what dread grasp,\n" +
                        "Dare its deadly terrors clasp!", filePartReader.read());
    }

    @Test
    @DisplayName("Error check on setup(), toLine is 0")
    void errorCheckOfSetup() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                filePartReader.setup("com/alex/file.txt", 0, 0));
    }

    @Test
    @DisplayName("Error check on setup() fromLine lower than toLine")
    void errorCheckOfSetupTwo() {
        FilePartReader filePartReader = new FilePartReader();
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                filePartReader.setup("com/alex/file.txt", 4, 3));
    }

    @Test
    @DisplayName("Error check on read() wrong path")
    void errorCheckOfReadBadPath() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("asd", 2, 5);
        Assertions.assertEquals("IOException error", filePartReader.read());
    }

    @Test
    @DisplayName("Error check on readLines() wrong path")
    void errorCheckOfReadLinesBadPath() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("asd", 2, 5);
        Assertions.assertEquals("IOException error", filePartReader.readLines());
    }

    @Test
    @DisplayName("FilePartReader readLines() method")
    void testReadLines(TestInfo testInfo) {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("com/alex/file.txt", 2, 3);
        Assertions.assertEquals("In the forests of the night;What immortal hand or eye,", filePartReader.readLines());
    }

    @Test
    @DisplayName("FileWordAnalyzer testGetWordsOrderedAlphabetically() method")
    void testGetWordsOrderedAlphabetically() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("com/alex/file.txt", 1, 2);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(fpr);
        List<String> result = Arrays.asList("bright", "burning", "forests", "In", "night", "of", "the", "the", "Tyger", "Tyger");
        Assertions.assertEquals(result, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    @DisplayName("FileWordAnalyzer getStringsWhichPalindromes() method")
    void testGetStringsWhichPalindromes() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("com/alex/file.txt", 3, 4);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(fpr);
        List<String> result = Collections.singletonList("eye");
        Assertions.assertEquals(result, fileWordAnalyzer.getStringsWhichPalindromes());
    }

    @Test
    @DisplayName("FileWordAnalyzer getStringsWhichPalindromes() method")
    void testGetWordsContainingSubstring() {
        FilePartReader fpr = new FilePartReader();
        fpr.setup("com/alex/file.txt", 1, 7);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(fpr);
        List<String> result = Arrays.asList("What", "hand", "what", "what");
        Assertions.assertEquals(result, fileWordAnalyzer.getWordsContainingSubstring("ha"));
    }
}
