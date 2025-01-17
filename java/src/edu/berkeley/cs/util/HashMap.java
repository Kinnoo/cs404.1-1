package edu.berkeley.cs.util;

import java.util.Iterator;
import java.util.Objects;

public class HashMap<Key extends Comparable<Key>, Value>
    implements Map<Key, Value>, Iterable<HashMap.Entry> {
  protected class Entry {
    protected Key key;
    protected Value value;

    Entry(Key key, Value value) {
      this.key = key;
      this.value = value;
    }

    @Override
    public boolean equals(Object other) {
      if (!(other instanceof HashMap.Entry)) {
        return false;
      }

      return ((Entry) other).key.equals(key);
    }

    @Override
    public int hashCode() {
      return Objects.hash(key, value);
    }
  }

  protected SplayList<Entry>[] table = new SplayList[32];
  private int size = 0;

  public HashMap() {
    for (int i = 0; i < table.length; i++) {
      table[i] = new SplayList<>();
    }
  }

  protected int hash(Key key) {
    return Math.abs(key.hashCode()) % table.length;
  }

  private void resize(int capacity) {
    SplayList<Entry>[] oldTable = table;

    table = new SplayList[capacity];
    for (int i = 0; i < table.length; i++) {
      table[i] = new SplayList<>();
    }

    for (SplayList<Entry> list : oldTable) {
      for (Entry entry : list) {
        int index = hash(entry.key);
        table[index].insertEnd(entry);
      }
    }
  }

  @Override
  public void clear() {
    size = 0;
    for (int i = 0; i < table.length; i++) {
      table[i] = new SplayList<>();
    }
  }

  @Override
  public boolean isEmpty() {
    return size() == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<HashMap.Entry> iterator() {
    return new Iterator<HashMap.Entry>() {
      private int index = 0;
      private Iterator<Entry> current = table[index].iterator();

      @Override
      public boolean hasNext() {
        if (index >= table.length) {
          return false;
        }

        if (current.hasNext()) {
          return true;
        }

        while (true) {
          index++;
          if (index >= table.length) {
            break;
          }

          current = table[index].iterator();
          if (current.hasNext()) {
            return true;
          }
        }

        return false;
      }

      @Override
      public Entry next() {
        return current.next();
      }
    };
  }

  public LinkedList<Key> keys() {
    LinkedList<Key> keys = new LinkedList<>();

    for (Entry entry : this) {
      keys.insertEnd(entry.key);
    }

    return keys;
  }

  @Override
  public Value get(Key key) {
    // TODO: complete this function
    return null;
  }

  @Override
  public void put(Key key, Value value) {
    // TODO: complete this function
  }

  public boolean contains(Key key) {
    // TODO: complete this function
    return false;
  }

  @Override
  public void delete(Key key) {
    // TODO: complete this function
  }
}
