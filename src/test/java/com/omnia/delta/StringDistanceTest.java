package com.omnia.delta;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

public class StringDistanceTest
{
  private Delta delta;

  @Before
  public void setup()
  {
    delta = new DeltaBuilder().build();
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

  @Test
  public void shouldRespectCaseSensitiveConfiguration()
  {
    String a = "InFlames";
    String b = "inflames";

    int distance = delta.distance(a, b);
    assertThat("case sensitive by default", distance, is(2));

    Delta caseInsensitiveDelta = new DeltaBuilder().caseInsensitive().build();
    int distance2 = caseInsensitiveDelta.distance(a, b);
    assertThat("can be configured to be case insensitive", distance2, is(0));
  }
}