package com.omnia.delta;

public class DeltaBuilder
{
  private int insertionCost = 1;
  private int editionCost = 1;
  private boolean caseSensitive = true;

  public DeltaBuilder withInsertionCost(int insertionCost)
  {
    this.insertionCost = insertionCost;
    return this;
  }

  public DeltaBuilder withEditionCost(int editionCost)
  {
    this.editionCost = editionCost;
    return this;
  }

  public DeltaBuilder caseSensitive()
  {
    caseSensitive = true;
    return this;
  }

  public DeltaBuilder caseInsensitive()
  {
    caseSensitive = false;
    return this;
  }

  public Delta build()
  {
    return new Delta(this.insertionCost, this.editionCost, this.caseSensitive);
  }
}
