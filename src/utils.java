public class utils
{
    public static void printEllipses(int dots, int delay)
    {
        try
        {
            Thread.sleep(300);
        }
        catch(InterruptedException e)
        {
            System.out.println("failed!");
        }
        for (int i = 0; i < dots; i++)
        {
            try
            {
                System.out.print(".");
                Thread.sleep(delay);
            }
            catch(InterruptedException exception)
            {
                System.out.println("Ellipses animation failed! (This shouldn't happen)");
            }
        }
        System.out.println();
    }

    public static void delay(int delay)
    {
        try
        {
            Thread.sleep(300);
        }
        catch(InterruptedException e)
        {
            System.out.println("failed!");
        }
        System.out.println();
    }
}
