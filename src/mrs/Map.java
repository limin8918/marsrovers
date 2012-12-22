package mrs;

public class Map
{
    private int XBound;
    private int YBound;

    public Map()
    {
        this.XBound = 0;
        this.YBound = 0;
    }

    public Map(int x,int y)
    {
        this.XBound = x;
        this.YBound = y;
    }

    public void SetXBound(int x)
    {
        this.XBound = x;
    }

    public void SetYBound(int y)
    {
        this.YBound = y;
    }

    public int GetXBound()
    {
        return this.XBound;
    }

    public int GetYBound()
    {
        return this.YBound;
    }

    public void ExpandMap(int x,int y)
    {
        this.XBound += x;
        this.YBound += y;
    }

    public void ToString()
    {
        System.out.println("X = " + this.XBound +"  Y = " + this.YBound);
    }
}
