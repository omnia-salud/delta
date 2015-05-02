package com.omnia.delta;

public class Delta
{
  public static Delta build()
  {
    return new Delta();
  }

  public int distance(String a, String b)
  {
    int cols = a.length() + 1;
    int rows = b.length() + 1;
    int d[][] = new int[cols][rows];

    for (int i = 0; i < cols; i++)
    {
      d[i][0] = i;
    }
    for (int j = 0; j < rows; j++)
    {
      d[0][j] = j;
    }

    for (int i = 1; i < cols; i++)
    {
      for (int j = 1; j < rows; j++)
      {
        boolean charactersMatch = a.charAt(i-1) == b.charAt(j-1);
        if (charactersMatch)
        {
          d[i][j] = d[i-1][j-1];
        }
        else
        {
          int addCost = d[i][j-1] + 1;
          int delCost = d[i-1][j] + 1;
          int editCost = d[i-1][j-1] + 1;
          d[i][j] = minimumOf(addCost, delCost, editCost);
        }
      }
    }
    return d[cols - 1][rows - 1];
  }

  private int minimumOf(int a, int b, int c)
  {
    return Math.min(Math.min(a,b),c);
  }
}