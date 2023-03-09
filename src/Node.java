public class Node implements Comparable {
    private int row;
    private int column;
    private Integer length;
    private Character high;

    public Node(int row, int column, Integer length, Character high) {
        this.row = row;
        this.column = column;
        this.length = length;
        this.high = high;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public Character getHigh() {
        return high;
    }

    @Override
    public int compareTo(Object node) {
        return length - ((Node) node).getLength();
    }
}
