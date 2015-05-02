package com.omnia.delta;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ObjectDistanceTest
{
  private Delta delta;

  public class Person implements Diffable
  {
    private final String name;
    private final String lastName;
    private final String birthday;

    public Person(String name, String lastName, String birthday)
    {
      this.name = name;
      this.lastName = lastName;
      this.birthday = birthday;
    }

    @Override
    public String diffString()
    {
      return this.name + this.lastName + this.birthday;
    }
  }

  @Before
  public void setup()
  {
    delta = new DeltaBuilder().build();
  }

  @Test
  public void shouldReturnNoDistanceBetweenTwoIdenticalObjects()
  {
    Person self = new Person("Pablo", "Fernandez", "17/01/1985");
    Person clone = new Person("Pablo", "Fernandez", "17/01/1985");
    int distance = delta.distance(self, clone);
    assertThat(distance, is(0));
  }

  @Test
  public void shouldReturnDistanceBetweenDifferentObjects()
  {
    Person self = new Person("Pablo", "Fernandez", "17/01/1985");
    Person impostor = new Person("Pablo", "Fernandes", "27/01/1985");
    int distance = delta.distance(self, impostor);
    assertThat(distance, is(2));
  }
}
