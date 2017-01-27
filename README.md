# file-crawler

Scans recursively the given file system path and copies specific files types on designated directory.

## Execution

- java -jar FileCrawler.jar "sourceDir" "outputDir" fileType copyFiles

## Examples

- java -jar FileCrawler.jar "C:\\\Music" "D:\\\Output" mp3 false
- java -jar FileCrawler.jar "C:\\\Video" "D:\\\Output" avi true
