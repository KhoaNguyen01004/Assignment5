import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.io.PrintWriter;

public class TwoDimRaggedArrayUtility {
 

    public static double getAverage(double[][] data) 
    {
        int index = 0;
        double total = 0;
        

        for(int i =0; i<data.length; i++)
        {
        	index += data[i].length;

            for (int j =0; j<data[i].length; j++)
            {
                total += data[i][j];
            }
        }
        return total/index;
    }

    public static double getColumnTotal(double[][] data, int col)
    {
        double totalColum = 0;

        for (int i = 0; i<data.length; i++)
        {
            if (col >= data[i].length)
            {
                continue;
            }

            totalColum += data[i][col];
        }

        return totalColum;
    }

    public static double getHighestInArray(double[][] data)
    {
        double max = -100000000;

        for (int i = 0; i<data.length; i++)
        {
            for (int j = 0; j< data[i].length; j++)
            {
                if (data[i][j]>max)
                {
                    max = data[i][j];
                }
            }
        }

        return max;
    }

    public static double getHighestInColumn(double[][] data, int col)
    {
        double max = -1000000000;

        for(int i = 0; i< data.length; i++)
        {
            if (col >= data[i].length)
            {
                continue;
            }
            if (data[i][col] > max)
            {
                max = data[i][col];
            }
        }

        return max;
    }

    public static int getHighestInColumnIndex(double[][] data, int col)
    {
        double max = -100000000;
        int index = -1;

        for (int i =0; i<data.length; i++)
        {
            if (col >= data[i].length)
            {
                continue;
            }
            if (data[i][col] > max)
            {
                max = data[i][col];
                index = i;
            }
        }

        return index;
    }

    public static double getHighestInRow(double[][] data, int row)
    {
        double max = -1000000;
        
        for(int i = 0; i<data[row].length;i++)
        {
            if (data[row][i] > max)
            {
                max = data[row][i];
            }
        }

        return max;
    }

    public static int getHighestInRowIndex(double[][] data, int row)
    {
        double max = -10000000;
        int index = -1;

        for(int i = 0; i < data[row].length; i++)
        {
            if (data[row][i] > max)
            {
                max = data[row][i];
                index = i;
            }
        }

        return index;
    }

    public static double getLowestInArray(double[][] data)
    {
        double min = 1000000;

        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0;j < data[i].length;j++)
            {
                if (data[i][j] < min)
                {
                    min = data[i][j];
                }
            }
        }

        return min;
    }

    public static double getLowestInColumn(double[][] data, int col)
    {
        double min = 1000000;

        for (int i = 0; i < data.length; i++)
        {
            if (col >= data[i].length)
            {
                continue;
            }
            if (data[i][col] < min)
            {
                min = data[i][col];
            }
        }

        return min;
    }

    public static int getLowestInColumnIndex(double[][] data, int col)
    {
       double min = 10000000;
       int index = -1;

       for (int i = 0; i < data.length; i++)
       {
           if (col >= data[i].length)
           {
               continue;
           }
           if (data[i][col] < min)
           {
               min = data[i][col];
               index = i;
           }
       }

       return index;
    }

    public static double getLowestInRow(double[][] data, int row)
    {
        double min = 9999999;

        for (int i = 0; i < data[row].length; i++)
        {
            if (data[row][i] < min)
            {
                min = data[row][i];
            }
        }

        return min;
    }

    public static int getLowestInRowIndex(double[][] data, int row)
    {
        double min = 10000000;
        int index = -1;

        for (int i=0; i<data[row].length; i++)
        {
            if (data[row][i] < min)
            {
                min = data[row][i];
                index = i;
            }
        }

        return index;
    }

    public static double getRowTotal(double[][] data, int row)
    {
        double total = 0;

        for (int i = 0; i < data[row].length; i++)
        {
            total += data[row][i];
        }

        return total;
    }

    public static double getTotal(double[][] data)
    {
        double total = 0;
        for (int i =0; i<data.length; i++)
        {
            for (int j= 0; j<data[i].length; j++)
            {
                total += data[i][j];
            }
        }

        return total;
    }

    public static double[][] readFile(File file) throws FileNotFoundException
    {
       Scanner scanner = new Scanner(file);

       int iRow = 0;
       String [][] tempStrings = new String [10][];
       
       while (scanner.hasNextLine())
       {
           String[] rowString = scanner.nextLine().split(" ");
           tempStrings[iRow] = new String [rowString.length];
           
           for (int i = 0; i<rowString.length; i++)
           {
               tempStrings[iRow][i] = rowString[i];
            }
            iRow++;
        }
        
        double[][] num = new double[iRow][];
        for (int i =0; i<iRow; i++)
        {
            num[i] = new double[tempStrings[i].length];
            for (int j= 0; j< tempStrings[i].length; j++)
            {
                System.out.print(tempStrings[i][j]+ " ");
                num[i][j] = Double.parseDouble(tempStrings[i][j]);
            }
            System.out.println();
        }

        scanner.close();
        return num;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
    {
        PrintWriter writer = new PrintWriter(outputFile);
        StringBuilder strBuilder = new StringBuilder();

        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0;j < data[i].length;j++)
            {
                strBuilder.append(data[i][j]+ " ");
            }
            strBuilder.append("\n");
        }

        writer.print(strBuilder.toString());
        writer.close();
    }
}
