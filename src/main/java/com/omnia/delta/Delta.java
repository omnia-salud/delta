package com.omnia.delta;

public class Delta
{
  private final int insertionCost;
  private final int deletionCost;
  private final int editionCost;

  Delta(int insertionCost, int deletionCost, int editionCost)
  {
    this.insertionCost = insertionCost;
    this.deletionCost = deletionCost;
    this.editionCost = editionCost;
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
          int addCost = d[i][j-1] + insertionCost;
          int delCost = d[i-1][j] + deletionCost;
          int editCost = d[i-1][j-1] + editionCost;
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