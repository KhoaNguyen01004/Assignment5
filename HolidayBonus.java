public class HolidayBonus {
    

    public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
    {
        double[] bonus = new double[data.length];
        int columMax = 0;

        for (int i = 0;i < data.length;i++)
        {
            if (columMax < data[i].length)
            {
                columMax = data[i].length;
            }
        }

        for (int j = 0; j < columMax; j++)
        {
            int indexHighBonus = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, j);
            int indexLowBonus = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, j);

            if (TwoDimRaggedArrayUtility.getHighestInColumn(data, j) > 0)
            {
                bonus[indexHighBonus] += high;
            }
            if (TwoDimRaggedArrayUtility.getLowestInColumn(data, j) > 0 && indexHighBonus != indexLowBonus)
            {
                bonus[indexLowBonus] += low;
            }

            for (int k = 0; k < data.length; k++)
            {
                if (j >= data[k].length || k==indexHighBonus || k==indexLowBonus || data[k][j] <= 0)
                {
                    continue;
                }
                else 
                {
                    bonus[k] += other;
                }
                System.out.println();
            }
        }

        return bonus;
    }

    public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
    {
        double[] arrayBonus = calculateHolidayBonus(data, high, low, other);
        double sum = 0;

        for (double bonus:arrayBonus)
        {
            sum += bonus;
        }

        return sum;
    }
}
