Spell Check Application

Inputs : 

1. Document.txt - This file contains words in the text form either in sentences or paragraphs.
2. Dictionary.txt - This is lookup file which contains valid words in the list form , which might contain words in the Document file.

Use case : The App should compare the words from Document with the Dictionary and spit out invalid/Misspelled words.

Program Flow :

- The App takes in two files as arguments during runtime.
- Load the Dictionary file 'Dictionary.txt' and store the words into a hashset ensuring no duplicate words present.
- Convert the words in dictionary to lowercase ensuring, words match with document.
- Load the document file 'Document.txt'.
- Remove the punctuations, whitespaces and split it into individual words.
- Compare each of the word parsed from document with the dictionary.
- If any unmatched words found add them into Misspelled list
- Once all the words are compared, return the list of missplelled/invalid words.
- Print the list of resulting missplelled words.

Compile/Run the Prog :

javac com/example/SpellCheck.java 

java com.example.SpellCheck ../resources/Document.txt ../resources/Dictionary.txt
