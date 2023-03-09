import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MapOfClimbs {
    private Integer columns = 0;
    private Integer rows = 0;
    private char[][] map;

    public void createMap() throws IOException {
        String fileName = "C:\\Users\\Kinga\\Downloads\\input14.txt";
        File file = new File(fileName);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<char[]> lines = new ArrayList<>();
        String line;
        while ((line = br.readLine()) != null) {
            char[] oneLine = line.toCharArray();
            lines.add(oneLine);
        }
        rows = lines.size();
        columns = lines.get(0).length;
        map = new char[rows][columns];
        for(int i = 0; i < rows; i++) {
            map[i] = lines.get(i);
        }
    }

    public Integer getColumns() {
        return columns;
    }

    public Integer getRows() {
        return rows;
    }

    public char[][] getMap() {
        return map;
    }
}
