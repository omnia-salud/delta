package com.omnia.delta;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class DistanceTest
{
  private Delta delta;

  @Before
  public void setup() {
    delta = Delta.build();
  }

  @Test
  public void shouldReturnNoDistanceBetweenTwoIdenticalStrings()
  {
    String a = "abcde";
    String b = "abcde";
    int distance = delta.distance(a, b);
    assertThat(distance, is(0));
  }

  @Test
  public void shouldReturnOneForInsertionDistance()
  {
    String a = "abcde";
    String b = "abcdef";
    int distance = delta.distance(a, b);
    assertThat(distance, is(1));
  }

  @Test
  public void shouldReturnOneForDeletionDistance()
  {
    String a = "abcdef";
    String b = "abcde";
    int distance = delta.distance(a, b);
    assertThat(distance, is(1));
  }

  @Test
  public void shouldReturnOneForSimpleEditDistance()
  {
    String a = "abcdef";
    String b = "abcdeg";
    int distance = delta.distance(a, b);
    assertThat(distance, is(1));
  }

  @Test
  public void shouldReturnKittenDistance()
  {
    String a = "kitten";
    String b = "sitting";
    int distance = delta.distance(a, b);
    assertThat(distance, is(3));
  }

  @Test
  public void shouldReturnSundayDistance()
  {
    String a = "saturday";
    String b = "sunday";
    int distance = delta.distance(a, b);
    assertThat(distance, is(3));
  }
}