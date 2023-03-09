import java.util.PriorityQueue;
import java.util.Queue;

public class Dijkstra {
    private Queue<Node> queue;
    private Node[][] nodes;
    private Integer endRow;
    private Integer endColumn;
    private Integer rows;
    private Integer columns;

    public Dijkstra(char[][] map, Integer rows, Integer columns) {
        this.queue = new PriorityQueue<>();
        this.rows = rows;
        this.columns = columns;
        this.nodes = new Node[rows][columns];
        fillNodes(map, rows, columns);
    }

    public Integer getLengthToEnd() {
        return nodes[endRow][endColumn].getLength();
    }

    public void checkLengthToNodesFromStart() {
        while (queue.size() > 0) {
            Node nearest = queue.peek();
            Integer nearestRow = nearest.getRow();
            Integer nearestColumn = nearest.getColumn();
            addToQueueIfPossible(queue, nearestRow, nearestColumn - 1, nearest);
            addToQueueIfPossible(queue, nearestRow, nearestColumn + 1, nearest);
            addToQueueIfPossible(queue, nearestRow - 1, nearestColumn, nearest);
            addToQueueIfPossible(queue, nearestRow + 1, nearestColumn, nearest);
            queue.poll();
        }
    }

    private void addToQueueIfPossible(Queue<Node> queue, Integer nearestRow, Integer nearestColumn, Node nearestNode) {
        if (isInRange(nearestRow, nearestColumn)) {
            Node checkingNode = nodes[nearestRow][nearestColumn];
            if (isGoodDifference(checkingNode, nearestNode) && isFasterWay(checkingNode, nearestNode)) {
                queue.add(updateNodeLength(checkingNode, nearestNode));
            }
        }
    }

    private Node updateNodeLength(Node checkingNode, Node neighbour) {
        checkingNode.setLength(neighbour.getLength() + 1);
        return checkingNode;
    }

    private boolean isFasterWay(Node checkingNode, Node neighbour) {
        return neighbour.getLength() + 1 < checkingNode.getLength();
    }

    private boolean isGoodDifference(Node checkingNode, Node neighbour) {
        char neighoburHigh = neighbour.getHigh() == 'S' ? 'a' - 1 : neighbour.getHigh();
        char checkingHigh = checkingNode.getHigh() == 'E' ? 'z' : checkingNode.getHigh();
        return checkingHigh - neighoburHigh <= 1;
    }

    private boolean isInRange(int row, int column) {
        return row >= 0 && column >= 0 && row < rows && column < columns;
    }

    private void fillNodes(char[][] map, Integer rows, Integer columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                addNode(map, i, j);
            }
        }
    }

    private void addNode(char[][] map, int i, int j) {
        if (isStartNode(map[i][j])) {
            nodes[i][j] = new Node(i, j, 0, map[i][j]);
            queue.add(nodes[i][j]);
        } else {
            nodes[i][j] = new Node(i, j, Integer.MAX_VALUE, map[i][j]);
            if (isEndNode(map[i][j])) {
                endRow = i;
                endColumn = j;
            }
        }
    }

    private boolean isEndNode(char node) {
        return node == 'E';
    }

    private boolean isStartNode(char node) {
        return node == 'S'; //can be changed to 'a' for second part od riddle
    }
}
