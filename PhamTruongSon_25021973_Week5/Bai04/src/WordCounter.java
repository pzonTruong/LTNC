
import java.util.*;

public class WordCounter {
    private Map<String, Integer> mp;

    public WordCounter(){
        this.mp = new HashMap<>();
    }

    public void analyze(String text){
        // 1. Chuẩn hóa chuỗi
        String cleanText = text.toLowerCase().replaceAll("\\p{Punct}", "");
        
        // 2. Tách chuỗi thành mảng các từ
        String[] words = cleanText.split("\\s+");

        // 3. Duyệt mảng
        for(String word: words){
            if(word.isEmpty()){
                continue;
            }

            // Kiem tra co tu nay trong Map chua
            if(mp.containsKey(word)){ // Neu co
                int cnt = mp.get(word);
                mp.put(word, cnt + 1);
            } else { // Neu chua co
                mp.put(word,1);
            }
        }
    }

    public void displayResult(){
        System.out.println("-----OUTPUT-----");
        String mostFrequentWord = "";
        int mxCnt = 0;

        for(Map.Entry<String, Integer> e: mp.entrySet()){
            System.out.println(e.getKey() + ": " + e.getValue());

            if(e.getValue() > mxCnt){
                mxCnt = e.getValue();
                mostFrequentWord = e.getKey();
            }
        }

        System.out.println("-----------------");
        if(!mostFrequentWord.isEmpty()){
            System.out.println("Most frequent word: " + mostFrequentWord + " (Count: " + mxCnt + ")");
        }
    }
}
