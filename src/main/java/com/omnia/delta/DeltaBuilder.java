package com.omnia.delta;

public class DeltaBuilder
{
  private int insertionCost = 1;
  private int deletionCost = 1;
  private int editionCost = 1;

  public DeltaBuilder withInsertionCost(int insertionCost)
  {
    this.insertionCost = insertionCost;
    return this;
  }

  public DeltaBuilder withDeletionCost(int deletionCost)
  {
    this.deletionCost = deletionCost;
    return this;
  }

  public DeltaBuilder withEditionCost(int editionCost)
  {
    this.editionCost = editionCost;
    return this;
  }

  public Delta build()
  {
    return new Delta(this.insertionCost, this.deletionCost, this.editionCost);
  }
}
