# file-crawler

Scans recursively the given file system path and copies specific files types on designated directory.<br/>
Created to ease the finding of media content (music, photos...) dispersed throw a system and extract it.

## Execution

- `java -jar FileCrawler.jar "sourceDir" "outputDir" [fileType] [copyFiles]`

## Examples

- `java -jar FileCrawler.jar "C:\\\Music" "D:\\\Output" mp3 false`
- `java -jar FileCrawler.jar "C:\\\Video" "D:\\\Output" avi true`
