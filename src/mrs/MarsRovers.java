package mrs;

import java.io.IOException;

public class MarsRovers
{
    public static void main(String[] args) throws IOException
    {
        Simulation simulation =  new Simulation();
        simulation.ReadFile("MarsRovers.txt");
        simulation.Run();
    }
}
