
public class Ship
{
    private int size;
    private int hits;

    public Ship (String name, int size)
    {
        this.size = size;
        this.hits = 0;
    }

    public int GetSize()
    {
        return size;
    }

    public void SetSize(int size)
    {
        this.size = size;
    }

    public boolean IsHit()
    {
        return hits > 0;
    }

    public boolean IsSunk()
    {
        return hits >= size;
    }

    public void RegisterHit()
    {
        if (hits < size)
        {
            hits++;
        }
    }
}
