# Delta

A simple, fast library to detect similarities between strings (and even arbitrary objects).

[![Build Status](https://secure.travis-ci.org/omnia-salud/delta.svg?branch=master)](http://travis-ci.org/omnia-salud/delta)

## How to use it?

Just create a `Delta` object using the builder interface and then pass in two strings to get the edit distance:

```java
    Delta delta = new DeltaBuilder().build();
    int distance = delta.distance("saturday", "sunday");
    assert(distance == 3);
```

## How does it work?
Delta uses a fast java implementation of the [Levenshtein distance algorithm](http://en.wikipedia.org/wiki/Levenshtein_distance). It's versatile since you can configure the costs of insertions and editions at your will (for example, considering editions twice as expensive than insertions).

## Does it only compute differences between strings?

No, you can calculate differences between any object that implements `Diffable`:

```java
  // given the following definition of a Person.
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

  // you can then do
  Person self = new Person("Pablo", "Fernandez", "17/01/1985");
  Person impostor = new Person("Pablo", "Fernandes", "27/01/1985");
  int distance = delta.distance(self, impostor);
  assert(distance == 2);
```

## Need help?

send me an [email](mailto:pablo@omniasalud.com) or ask me via [twitter](http://twitter.com/fernandezpablo)