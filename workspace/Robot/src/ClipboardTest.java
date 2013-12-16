import java.awt.*;
import java.awt.datatransfer.*;
import java.io.*;

class ClipboardTest
{
    public static void main(String[] args)
        throws UnsupportedFlavorException, IOException
    {
        Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection testData;

        //  Add some test data

        if (args.length > 0)
            testData = new StringSelection( args[0] );
        else
            testData = new StringSelection( "Test Data" );

        c.setContents(testData, testData);

        //  Get clipboard contents, as a String

        Transferable t = c.getContents( null );

        if ( t.isDataFlavorSupported(DataFlavor.stringFlavor) )
        {
            Object o = t.getTransferData( DataFlavor.stringFlavor );
            String data = (String)t.getTransferData( DataFlavor.stringFlavor );
            System.out.println( "Clipboard contents: " + data );
        }
        

        System.exit(0);
    }
    
    
}