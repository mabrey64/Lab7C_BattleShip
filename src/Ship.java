
public class Ship
{
    private int size;
    private int hits;
    private String name;

    // Constructor for the Ship class
    public Ship (String name, int size)
    {
        this.name = name;
        this.size = size;
        this.hits = 0;
    }

    /*
        * Getters and Setters
        * Some of the getters and setters are not used in the current implementation
        * But are kept in case they are needed in the future
     */
    public String GetName()
    {
        return name;
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
