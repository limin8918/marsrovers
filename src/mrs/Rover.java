package mrs;

public class Rover implements Robot
{
    private int x;
    private int y;
    private char direction;
    private Command command;
    private char cmd;
    private Map map;

    public Rover()
    {
        this.x = 0;
        this.y = 0;
        this.direction = 'N';
        command = null;
        map = null;
    }

    public int GetX()
    {
        return x;
    }

    public int GetY()
    {
        return y;
    }

    public char GetDirection()
    {
        return direction;
    }

    public void SetX(int x)
    {
        this.x = x;
    }

    public void SetY(int y)
    {
        this.y = y;
    }

    public void SetDirection(char newDir)
    {
        this.direction =  newDir;
    }

    public void SetCommand(String cmdStr)
    {
        Command command = new Command(cmdStr);
        this.command = command;
    }

    public void SetMap(Map map)
    {
        this.map = map;
    }

    public void GetNextCmd()
    {
        this.cmd = command.GetNextOrder();
    }

    public boolean IsOnMap()
    {
        if(x >= 0 && x <= map.GetXBound() && y >= 0 && y<= map.GetYBound())
        {
            return true;
        }
        else
            return false;
    }

    public void ParseOrder()
    {
        switch(cmd)
        {
            case 'L':
                TurnLeft();
                break;
            case 'R':
                TurnRight();
                break;
            case 'M':
                Move();
                break;
            default:
                break;
        }
    }

    public void Move()
    {
        switch(direction)
        {
            case 'N':
                y++;
                if(!IsOnMap())
                    y--;
                break;
            case 'E':
                x++;
                if(!IsOnMap())
                    x--;
                break;
            case 'S':
                y--;
                if(!IsOnMap())
                    y++;
                break;
            case 'W':
                x--;
                if(!IsOnMap())
                    x++;
                break;
        }
    }
	public void TurnLeft()
    {
        switch (this.direction)
        {
            case 'E':
                this.direction = 'N';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'E';
                break;
            case 'N':
                this.direction = 'W';
                break;
            default:
                System.out.println("FALSE");
        }
    }
	public void TurnRight()
    {
        switch (this.direction)
        {
            case 'E':
                this.direction = 'S';
                break;
            case 'W':
                this.direction = 'N';
                break;
            case 'S':
                this.direction = 'W';
                break;
            case 'N':
                this.direction = 'E';
                break;
            default:
                System.out.println("FALSE");
        }
    }

    public void Go()
    {
        for(;command.GetIndex() < command.GetLength();)
        {
            cmd = command.GetNextOrder();
            ParseOrder();
        }
    }

    public void ToString()
    {
        System.out.println(x + "  " + y + "  " + direction);
    }
}

