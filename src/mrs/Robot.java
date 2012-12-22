package mrs;

public interface  Robot {
    public abstract char GetDirection();
    public abstract void SetX(int x);
    public abstract void SetY(int y);
    public abstract void SetDirection(char newDir);
    public abstract void SetMap(Map map);
    public abstract void SetCommand(String cmdStr);
    public abstract boolean IsOnMap();
    public abstract void Move();
    public abstract void TurnLeft();
    public abstract void TurnRight();
    public abstract void Go();
    public abstract void ToString();
}
