androidCEP
==========

This project is a Proof of Concept for Maven integration with Android and spring-android-rest-template library for web service communication.
The app returns an address given a number of CEP.

This is a tutorial for create android Maven projects

To setup your enviroment follow the steps:

1 JDK 1.6+ installed as required for Android developm
2 Android SDK (r17 or later, latest is best supported) installed, preferably with all platforms
3 Maven 3.0.3+ installed
4 Set environment variable ANDROID_HOME to the path of your installed Android SDK and add $ANDROID_HOME/tools as well as $ANDROID_HOME/platform-tools to your $PATH. (or on Windows %ANDROID_HOME%\tools and %ANDROID_HOME%\platform-tools).

Source:http://code.google.com/p/maven-android-plugin/wiki/GettingStarted

To create a maven project in Android platform, run on terminal:

mvn archetype:generate \
  -DarchetypeArtifactId=android-quickstart \
  -DarchetypeGroupId=de.akquinet.android.archetypes \
  -DarchetypeVersion=1.0.9 \
  -DgroupId=your.company \
  -DartifactId=my-android-application

Source:https://github.com/akquinet/android-archetypes

If you want import your project in Eclipse:
File -> Import -> Existing Maven Projects

To add the spring-android-rest-template library in project, add the follow lines in pom.xml file:

<repository>
  <id>springsource-repo</id>
  <name>SpringSource Repository</name>
  <url>http://repo.springsource.org/release</url>
</repository>

...

<dependency>
  <groupId>org.springframework.android</groupId>
  <artifactId>spring-android-rest-template</artifactId>
  <version>${org.springframework.android-version}</version>
</dependency>


