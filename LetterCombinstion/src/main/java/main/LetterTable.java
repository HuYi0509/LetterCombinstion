package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @auth huyi
 * @date 2020/08/19 17:27
 * @Description
 */
public class LetterTable {
    //Fields
    private List<String[]> letterTable;

    //Constructors
    public LetterTable() {
        letterTable = new ArrayList<String[]>();
    }
    public LetterTable(List<String[]> letterTable) {
        this.letterTable = letterTable;
    }
    public LetterTable(String[][] letterTable) {
        this.letterTable = Arrays.asList(letterTable);
    }

    //Methods

    /**
     * @param size  要隨機幾組
     * @param base  每組基礎幾個
     * @param raise 每組額外增加數量最大
     * @return  執行成功與否
     */
    public boolean randomTable(int size,int base,int raise){
        Random r = new Random();
        letterTable.clear();
        try {
            for (int i = 0; i < size; i++) {
                int size_1 = Math.min(r.nextInt(raise) + base,23);//23個字母，不能再更多了
                String[] newStrings;
                if (size_1 <= 0){
                    newStrings = new String[]{""};
                }else {
                    newStrings = new String[size_1];
                    for (int j = 0; j < size_1; j++) {
                        char c = (char) (r.nextInt('z' - 'a') + 'a');
                        if(Arrays.asList(newStrings).contains(String.valueOf(c)))
                            j--;//有重複的就要重來
                        newStrings[j] = String.valueOf(c);
                    }
                }
                letterTable.add(newStrings);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 隨機輸入
     * @param size  輸入幾個
     * @param base  數字最小值
     * @param raise 數字最大值
     * @return input
     */
    public int[] randomInput(int size,int base,int raise){
        Random r = new Random();
        if(size<=0)
            size=1;
        if(base<0)
            base=0;
        if(base>=letterTable.size())
            base=letterTable.size()-1;
        if(raise<=0)
            raise=1;
        if(raise+base>letterTable.size())
            raise=letterTable.size()-base;
        int[] input = new int[size];
        for (int i = 0; i < size; i++) {
            input[i]=r.nextInt(raise)+base;
        }
        return input;
    }

    public List<String> convert(int[] input){
        List<String> result = new ArrayList<String>();
        result.add("");
        for (int in : input) {
            String[] strings = new String[result.size() * letterTable.get(in).length];
            for (int i = 0; i < result.size(); i++) {
                for (int j = 0; j < letterTable.get(in).length; j++) {
                    strings[i * letterTable.get(in).length + j] = result.get(i).concat(letterTable.get(in)[j]);
                }
            }
            result = Arrays.asList(strings);
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < letterTable.size(); i++) {
            sb.append(i);
            sb.append(":");
            sb.append(Arrays.asList(letterTable.get(i)));
            sb.append("\n");
        }
        return sb.toString();
    }
}
