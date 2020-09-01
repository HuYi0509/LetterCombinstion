import main.LetterTable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @auth huyi
 * @date 2020/08/19 17:51
 * @Description
 */
public class TestLetter {
    /**
     * 這邊測試隨機生成letterTable
     */
    @Test
    public void Test1() {
        LetterTable letterTable = new LetterTable();
        letterTable.randomTable(100, -1, 5);
        System.out.println("letterTable:");
        System.out.println(letterTable);
    }

    /**
     * 這邊測試給定生成letterTable
     */
    @Test
    public void Test2() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        System.out.println("letterTable:");
        System.out.println(letterTable);
    }

    /**
     * 這邊測試給定生成letterTable
     * inputRange=[0,9]
     * 進行轉換
     */
    @Test
    public void Test3() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        System.out.println("letterTable:");
        System.out.println(letterTable);
        int[] input = {1, 2, 3};
        System.out.println("input:" + Arrays.toString(input));
        List<String> output = letterTable.convert(input);
        System.out.println("output:" + output);
    }

    /**
     * 這邊是輸入越界1
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void Test4() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        System.out.println("letterTable:");
        System.out.println(letterTable);
        int[] input = {11};
        System.out.println("input:" + Arrays.toString(input));
        List<String> output = letterTable.convert(input);
        System.out.println("output:" + output);
    }

    /**
     * 這邊是輸入越界2
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void Test5() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        System.out.println("letterTable:");
        System.out.println(letterTable);
        int[] input = {-1};
        System.out.println("input:" + Arrays.toString(input));
        List<String> output = letterTable.convert(input);
        System.out.println("output:" + output);
    }

    /**
     * 測試隨機輸入生成
     */
    @Test()
    public void Test6() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        int[] input = letterTable.randomInput(5, 0, 10);
        System.out.println("input:" + Arrays.toString(input));
    }

    /**
     * 測試隨機輸入生成
     * size<0時 自動修正 size=1
     */
    @Test()
    public void Test7() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        int[] input = letterTable.randomInput(-1, 0, 1);
        System.out.println("input:" + Arrays.toString(input));
    }

    /**
     * 測試隨機輸入生成
     * base<0時 自動修正 base=0
     */
    @Test()
    public void Test8() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        int[] input = letterTable.randomInput(5, -1, 1);
        System.out.println("input:" + Arrays.toString(input));
    }

    /**
     * 測試隨機輸入生成
     * base>=length時 自動修正 base=length-1
     */
    @Test()
    public void Test9() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        int[] input = letterTable.randomInput(5, 10, 1);
        System.out.println("input:" + Arrays.toString(input));
    }

    /**
     * 測試隨機輸入生成
     * raise<=0時 自動修正 raise=1
     */
    @Test()
    public void Test10() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        int[] input = letterTable.randomInput(5, 0, 0);
        System.out.println("input:" + Arrays.toString(input));
    }

    /**
     * 測試隨機輸入生成
     * raise+base>length時 自動修正 raise=length-base
     */
    @Test()
    public void Test11() {
        LetterTable letterTable = new LetterTable(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        int[] input = letterTable.randomInput(5, 0, 50);
        System.out.println("input:" + Arrays.toString(input));
    }

    /**
     * 這邊測試隨機生成letterTable
     * 隨機生成input
     */
    @Test
    public void Test12() {
        LetterTable letterTable = new LetterTable();
        letterTable.randomTable(100, -1, 6);
        System.out.println("letterTable:");
        System.out.println(letterTable);
        int[] input = letterTable.randomInput(5, 0, 100);
        ;
        System.out.println("input:" + Arrays.toString(input));
        List<String> output = letterTable.convert(input);
        System.out.println("output:" + output);
    }

    /**
     * 測試生成方法
     */
    @Test
    public void Test13() {
        List<String[]> list = Arrays.asList(new String[][]{{""}, {""}, {"a", "b", "c"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}});
        LetterTable letterTable = new LetterTable(list);
        System.out.println(letterTable);
    }

    /**
     * 測試錯誤輸入
     */
    @Test
    public void Test14() {
        LetterTable letterTable = new LetterTable();
        letterTable.randomTable(50, 26, 10);
        System.out.println(letterTable);

    }
}
