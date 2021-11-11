# Project Rewrite - Hash table

## Story

> This kind of exercise is a classic: your task is to reimplement some basic,
> built-in features of a language or its standard library for pedagogical
> reasons, without using the feature itself or similar features.
> Caveat: do not use this kind of code in your commercial projects!

An _associative array_ (also called as a _map_ or a _dictionary_) is an
abstract data type (ADT) that holds key-value pairs. Keys are unique in
associative arrays, but multiple keys can hold the same value.

A _hash table_ or _hash map_ is a _data structure_ that implements
an associative array by utilizing _hash functions_ to make the lookup
(finding the value for a key) effective.

On average, a well-implemented and properly used hash table has the following
time complexity characteristics.

- _get_ a value by key: `O(1)`
- _insert_ a new key-value pair: `O(1)`
- _remove_ an element by key: `O(1)`

This very impressive behavior is better than other associative array
implementations, but unfortunately, it can easily get much worse. This
is one of the reasons why it is important to understand what's happening under the hood in a hash table.

Python's built-in `dict` type, Java's `HashMap`, and C#'s `Dictionary` are all implemented as hash tables.

## What are you going to learn?

- Understand the hash table data structure.

## Tasks

1. Rewrite both `Entry` and `HashTable` to work with any generic `K` and `V` types as keys and values.
    - The hash table can be instantiated, and it works with generic `key` and `value` types.

2. Use lazy initialization for the buckets. Create the entry list for a bucket only at the first access attempt.
    - The `getBucketIndexForKey` method maps the provided key to an integer in range of buckets.
    - The `getBucketAtIndex` method returns the bucket at the given index.
    - Buckets are created during the first access.

3. Implement the `get` method for returning the value for the key if the hash table already contains an entry with the given key. Otherwise, it must return `null`.
    - The `get` method returns the value for an existing key in the hash table.
    - The `get` method returns `null` for an unused key in the hash table.

4. Implement the `put` method for finding the bucket for the key. If the bucket already contains an entry with the given key, it must swap the old value for the new one. Otherwise, it must create a new entry.
    - The `put` method overwrites the old value for the key if the key is used in the hash table.
    - The `put` method inserts a new entry for an unused key.

5. Implement the `remove()` method for removing the entry and returning the value for the given key. Also implement `clear()` to remove all entries.
    - The `remove()` method removes the entry and returns the value for an existing key in the hash table.
    - The `remove()` method returns `null` for an unused key in the hash table.
    - The `clear()` method removes all entries from the hash table.

## General requirements

- No ready-made collections other than lists are used in the implementation.

## Hints

- A key-value pair is called an _entry_. There is a class with this name in
  the code. The hash table holds buckets, and buckets hold entries.
- _Hash collision_ is the situation when multiple keys point at the same
  bucket. There are various strategies for handling collisions; here
  you are expected to create an implementation that uses _chaining_.
  This means that the "colliding" entries in a bucket are chained as a
  linked list, and new entries are just added to the end. As a consequence,
  the entries in the list of a bucket must be searched for the actual key
  during lookups. Long collision lists can ruin the shiny time complexity
  features of a hash table.
- You can see from the method signatures in the starter code that `HashTable`
  expects string type keys and integer type values. One of the tasks is to
  make it _generic_: it must work with any `K` type as keys and any `V`
  type as values, where `K` and `V` are fixed at instantiation. You can do
  this conversion step at any point, however, we suggest to start with this
  exercise.
- The included test class works only with the generic version.
- Use the included private methods, `@getBucketIndexForKey`, `@getBucketAtIndex`,
  and `@findEntryInBucket` for the implementation. These are common helper methods for the public
  operations (`get`, `put`, and `remove`).
- Consider using dynamic array (`ArrayList` / `List`) and `LinkedList` in your implementation. You cannot use other collections.

## Background materials

- <i class="far fa-exclamation"></i> [What is a hash table?](https://en.wikipedia.org/wiki/Hash_table)
- <i class="far fa-video"></i> <i class="far fa-exclamation"></i> [Hash tables and hash functions](https://www.youtube.com/watch?v=KyUTuwz_b7Q)
- <i class="far fa-exclamation"></i> [What is hashing?](https://en.wikipedia.org/wiki/Hash_function)
- <i class="far fa-exclamation"></i> [Explaining hash tables](https://www.freecodecamp.org/news/hash-tables/)
- <i class="far fa-exclamation"></i> [Generics in the diamond operator](project/curriculum/materials/competencies/java-data-structures/java-generics.md.html)

