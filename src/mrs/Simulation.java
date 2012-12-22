package mrs;

import java.io.*;
import java.util.Vector;


public class Simulation
{
    private Map map;
    private Vector<Robot> marsRovers;

    public Simulation()
    {
        this.map = new Map();
        this.marsRovers = new Vector<Robot>();
    }

     //设置地图信息
    public void SetMap(String thisLine)
    {
        String xMax,yMax;
        int i;
        for (i = 0; i < thisLine.length() && thisLine.charAt(i) != ' '; i++);
        xMax =thisLine.substring(0,i);
        yMax = thisLine.substring(i+1,thisLine.length());
        map.SetXBound(Integer.parseInt(xMax));
        map.SetYBound(Integer.parseInt(yMax));
    }

    //设置漫游者初始坐标
    public void SetRobotPosition(Robot robot,String thisLine)
    {
        String xOrigin,yOrigin;
        char direction;
        int i;
        for (i = 0; i < thisLine.length() && thisLine.charAt(i) != ' '; i++);
        xOrigin = thisLine.substring(0,i);
        yOrigin = thisLine.substring(i + 1, thisLine.length() - 2);
        direction = thisLine.charAt(thisLine.length()-1);
        robot.SetX(Integer.parseInt(xOrigin));
        robot.SetY(Integer.parseInt(yOrigin));
        robot.SetDirection(direction);
    }

    //设置漫游者地图
    public void SetRobotMap(Robot robot,Map map)
    {
         robot.SetMap(map);
    }

    //设置漫游者指令
    public void SetRobotCommand(Robot robot,String thisLine)
    {
        String cmdStr;
        cmdStr = thisLine;
        robot.SetCommand(cmdStr);
    }

    public void AddRobot(Robot robot)
    {
         if(!robot.IsOnMap())
         {
             System.out.println("Robot is not on the map!");
         }
         else if(robot.GetDirection() != 'E' && robot.GetDirection() != 'W' && robot.GetDirection() != 'S' && robot.GetDirection() != 'N')
         {
             System.out.println("Robot's direction is unkonwed!");
         }
         else
         {
             marsRovers.addElement(robot);
         }
    }

    public void ReadFile(String filename)  throws IOException
    {
        int i;
        File file = new File(filename);
        if(!file.exists() ||file.isDirectory())
            System.out.println("Open file failed!");
        FileReader fr = new FileReader(filename);
        BufferedReader bfr = new BufferedReader(fr);
        String thisLine = null;
        thisLine = bfr.readLine();

        //设置地图信息
        SetMap(thisLine);

        //设置漫游者信息�
        thisLine = bfr.readLine();
        while(thisLine != null && !thisLine.isEmpty() && thisLine.equalsIgnoreCase("") != true)
        {
            Rover rover =  new Rover();
            SetRobotPosition(rover,thisLine);     //设置漫游者初始坐标�
            SetRobotMap(rover,map);              //设置漫游者所在地图�
            thisLine = bfr.readLine();
            SetRobotCommand(rover,thisLine);     //设置指令信息
            AddRobot(rover);                     //漫游者加入Vector
            thisLine = bfr.readLine();
        }
    }

    public void Run()
    {
        Robot robot;
        for(int i = 0;i<marsRovers.size();i++)
        {
            robot = marsRovers.elementAt(i);
            robot.Go();
            robot.ToString();
        }
    }

}
