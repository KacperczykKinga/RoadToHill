import java.io.IOException;

public class FastRoadToHill {
    private static Integer rows;
    private static Integer columns;


    public static void main(String[] args) throws IOException {
        MapOfClimbs mapOfClimbs = new MapOfClimbs();
        mapOfClimbs.createMap();

        rows = mapOfClimbs.getRows();
        columns = mapOfClimbs.getColumns();
        char[][] map = mapOfClimbs.getMap();

        Dijkstra dijkstra = new Dijkstra(map, rows, columns);
        dijkstra.checkLengthToNodesFromStart();

        System.out.println(dijkstra.getLengthToEnd());
    }
}