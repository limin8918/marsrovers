package mrs;

public class Command
{
    private String cmdStr;  //指令
    private int index;      //当前指令字位

    public Command()
    {
        this.index = 0;
    }

    public Command(String cmd)
    {
        this.cmdStr = cmd;
        this.index = 0;
    }

    public int GetIndex()
    {
        return this.index;
    }

    public int GetLength()
    {
        return this.cmdStr.length();
    }

    public char GetNextOrder()
    {
        return this.cmdStr.charAt(this.index++);
    }


}
