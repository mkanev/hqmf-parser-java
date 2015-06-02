# Usage #

To use:

java -jar hqmf-parser-groovy.jar <command-line-options>

command-line options:

--file path/to/eMeasure.xml
--zip path/to/file/with/many/emeasure/zipfiles/file.zip

## Examples ##

### Example 1: Information from an eMeasure xml file ###
java -jar hqmf-parser-groovy.jar --file /tmp/CMS129v3.xml

### Example 2: Prorcess all files in zips ###
java -jar hqmf-parser-groovy.jar --file /tmp/CMS129v3.xml


behind the scenes a QualityMeasureDocument class is instantiated.  It contains the methods needed to access interesting parts of a HQMF QualityMeasureDocument .xml.


This README would normally document whatever steps are necessary to get your application up and running.

### What is this repository for? ###

* Quick summary
* Version
* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)

### How do I get set up? ###

* Summary of set up
* Configuration
* Dependencies
* Database configuration
* How to run tests
* Deployment instructions

### Contribution guidelines ###

* Writing tests
* Code review
* Other guidelines

### Who do I talk to? ###

* Repo owner or admin
* Other community or team contact