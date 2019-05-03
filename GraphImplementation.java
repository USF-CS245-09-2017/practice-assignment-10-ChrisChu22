import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphImplementation implements Graph
{
    int[][] adjMatrix;
    int vertices;

    public GraphImplementation(int v)
    {
        adjMatrix = new int[v][v];
        vertices = v;
    } //graph implementation

    @Override
    public void addEdge(int src, int tar)
    {
        adjMatrix[src][tar]++;
    } //add edge

    @Override
    public List<Integer> topologicalSort()
    {
        int[] incident = new int[vertices];
        for (int i = 0; i < incident.length; i++)
            incident[i] = 0;
        for (int c = 0; c < adjMatrix.length; c++)
        {
            for (int r = 0; r < adjMatrix[0].length; r++)
            {
                if(adjMatrix[c][r] != 0)
                    incident[r]++;
            } //for
        } //for
        Stack schedule = new Stack();
        for (int j = 0; j < vertices; j++)
        {
            schedule.push(zero_count(incident));
        } //for
        System.out.println("sorted array list");
        System.out.println(schedule);

        return schedule;
    } //topological sort



    @Override
    public int[] neighbors(int vertex)
    {
        //getting size of id that depends on the number of neighbors
        int size = 0;
        for (int row = 0; row < vertices; row++)
        {
            if (adjMatrix[vertex][row] == 1)
                size++;
        } //for

        //creates id array
        int[] id = new int[size];
        //id index
        int idi = 0;

        //adds the neighbors to id array
        while(idi < id.length)
        {
            for (int r = 0; r < adjMatrix.length; r++)
            {
                if (adjMatrix[vertex][r] == 1)
                {
                    id[idi] = r;
                    idi++;
                } //if
            } //for
        } //while
        return id;
    } //neighbors

    public int zero_count(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] == 0)
            {
                for (int j = 0; j < arr.length; j++)
                    arr[j]--;
                return i;
            } //if
        } //for
        return -1;
//
    } //zero_count


}
