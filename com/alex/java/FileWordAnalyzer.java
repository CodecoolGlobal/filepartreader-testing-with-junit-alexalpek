import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class FileWordAnalyzer {

    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader){
        this.filePartReader = filePartReader;
    }

    public List getWordsOrderedAlphabetically(){
        List<String> contentList = new ArrayList<>();
        String content = filePartReader.readLines();
        Collections.addAll(contentList, content.split(" "));
        Collections.sort(contentList);
        return contentList;
    }

    public List getWordsContainingSubstring(String subString ){
        List<String> contentList = new ArrayList<>();
        List<String> containsList = new ArrayList<>();
        String content = filePartReader.readLines();
        Collections.addAll(contentList, content.split(" "));
        for (String word : contentList){
            if (word.contains(subString)){
                containsList.add(word);
            }
        }
        return containsList;
    }

    public List getStringsWhichPalindromes(){
        StringBuilder wrd = new StringBuilder();

        List<String> contentList = new ArrayList<>();
        List<String> palidromeList = new ArrayList<>();
        String content = filePartReader.readLines();
        Collections.addAll(contentList, content.split(" "));
        for (String word : contentList){
            wrd = wrd.append(word).reverse();
            if (word.contentEquals(wrd)){
                palidromeList.add(word);
            }
            wrd.deleteCharAt(0);
        }
        return palidromeList;
    }
}