# Purpose #
To be able to make sense of the HQMF eMeasure .xml files.  One of the requirements for ONC/QRDA is to generate Category 3 files.  These files required GUID data that is available by mining the HQMF eMeasure .xml files.

Using this library one can glean this information from the files a bit more easily.

## What this is not... ##
 Not to be confused with Marc Hadley's hqmf-parser (https://github.com/hadleynet/hqmf-parser).

### How do I get set up? ###

Once you have cloned the project (git clone https://github.com/javapda/hqmf-parser-java.git) you can
get started by running:

*  mvn clean compile assembly:single
*  java -jar target/hqmf-parser-java-jar-with-dependencies.jar.jar 

You will be shown the general usage.



# Usage #

To use:

java -jar hqmf-parser-groovy.jar <command-line-options>

command-line options:

java -jar ... <command-line-options>
command-line options:

   --file path/to/eMeasure.xml

   --emeasurezip path/to/single/eMeasure/zipFile.xml

   --emeasurebundle path/to/bundle/eMeasures/zipFile.xml


## Examples ##

### Example 1: Information from an eMeasure xml file ###
java -jar hqmf-parser-java.jar --file /tmp/CMS129v3.xml

### Example 2: Process xml file in zip ###
java -jar hqmf-parser-java.jar --emeasurezip /tmp/CMS129v3.zip

### Example 3: Process all zips of emeasures in zip [UNDER DEVELOPMENT] ###
java -jar hqmf-parser-java.jar --emeasurezip /tmp/2014_eCQM_EligibleProfessional_July2014.zip


behind the scenes a QualityMeasureDocument class is instantiated.  It contains the methods needed to access interesting parts of a HQMF QualityMeasureDocument .xml.


This README would normally document whatever steps are necessary to get your application up and running.

### Where can I get the HQMF eMeasure files? ###
[EP From CMS 2014 eCQM here](http://cms.gov/Regulations-and-Guidance/Legislation/EHRIncentivePrograms/Downloads/2014_eCQM_EligibleProfessional_July2014.zip)



* [Learn Markdown](https://bitbucket.org/tutorials/markdowndemo)
