Use case : The App should compare the words from Document with the Dictionary and spit out invalid/Misspelled words.

Inputs : 

1. Document.txt - This file contains words in the text form either in sentences or paragraphs.
2. Dictionary.txt - This is lookup file which contains valid words in the list form , which might contain words in the Document file.

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

Issues Considered :

1. Case Sensitivity

  - Words in English may be written with uppercase or lowercase letters.
  - Addressed by converting both dictionary words and document words to lowercase before comparison.

2. Punctuation Handling

  - Words in the document may include punctuation (e.g., "problem?", "document.").
  - Addressed by stripping non-alphabetic characters using a regex before checking against the dictionary.

3. Duplicate Misspelled Words

  - A misspelled word might appear multiple times in the document.
  - Addressed by storing results in a list and filtering unique entries before reporting.

4. File Input Errors

  - If files are missing or paths are wrong, the program should fail with exceptions handled gracefully.
  - Addressed by adding exception handling around file I/O with clear error messages.

5. Portability

  - The program should run on Linux, Windows, and macOS.
  - Addressed by relying on standard Java APIs and avoiding OS-specific commands.


Possible Extensions :

If this were expanded into a larger project, I would consider the following improvements:

- User Interface : Provide a graphical or web-based interface to make the tool more user-friendly.

- User Api : Provide this as an utility api to use this tool, so that can used by other applications seamlessly.

- Suggestions for Corrections : Use logic/algorithms to suggest closest dictionary words for each misspelled word.

- Multi-language Support : Allow the user to choose different dictionaries (English, French, Spanish, etc.).

- Performance for Large Documents : Optimize file reading with streaming APIs and consider parallel processing for very large texts.

- Custom Dictionary : Allow users to add their own words to a personal dictionary that persists across runs.
