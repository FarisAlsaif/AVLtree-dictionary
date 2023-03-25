# <p style="font-size:32px;">AVL Tree Dictionary Implementation in Java</p>

This repository contains a Java implementation of a dictionary using AVL tree data structure. AVL tree is a self-balancing binary search tree that maintains a balanced height by performing rotations when necessary, which makes it an efficient data structure for dictionary implementations.

## Features

The AVL Tree Dictionary implementation has the following features:

| Feature | Description |
| --- | --- |
| Insert | Insert key-value pairs to the dictionary |
| Delete | Delete key-value pairs from the dictionary |
| Find | Find values by their associated keys |
| Modify | Modify existing word pair in the dictionary |
| Traverse | Traverse the dictionary in ascending order |

## Supported Operations

The AVL Tree Dictionary implementation supports the following operations:

| Method | Description |
| --- | --- |
| `public boolean isEmpty()` | Returns true if the dictionary is empty, false otherwise |
| `public int getSize()` | Returns and displays how many words are currently stored in the dictionary |
| `public boolean insert(WordPair wordpair)` | Inserts word pair into dictionary if not already present. Returns true if the insertion is successful; otherwise, it returns false if the word exists in the dictionary |
| `public WordPair find(String word)` | Returns and displays a WordPair if the word is present; otherwise, it returns null and displays the message: "Word not in dictionary" |
| `public boolean delete(String word)` | Deletes the wordPair associated with word if the word exists. It returns true if the word exists; otherwise, it returns false |
| `public boolean modifyWord(String word, String newMeanings)` | Modifies a word to a new meaning, if the word exists in the dictionary. Returns true if the word exits; false otherwise |
| `public void printAll(String prefix)` | Prints all words that start with prefix, together with their meanings. Prints the message: "No word starts with this prefix" if no such word exists |
| `public void printSorted()` | Prints the words in the data structure together with their meanings in lexicographic order |

## Contributing

If you find any issues or want to contribute to the AVL Tree Dictionary implementation, feel free to submit a pull request or open an issue on the GitHub repository.
