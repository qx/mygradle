# RobolectricSample

[![Build Status](https://secure.travis-ci.org/robolectric/RobolectricSample.png?branch=master)](http://travis-ci.org/robolectric/RobolectricSample)

This is a sample Android project configured and setup o use Robolectric.  This project shows how to configure your build file, how to layout your project, how to write sample tests, etc.

## Usage

Clone the git repository:

    git clone git://github.com/pivotal/RobolectricSample.git
    cd RobolectricSample
    
Run the tests with Maven:

    mvn clean test

For more information about how to get projects running in your IDE see:

http://robolectric.org/getting_started/


## Contributing

We welcome contributions. Please fork and submit pull requests!


Current project

Alternatively, you can install Robolectric for your current project by adding the following to your pom.xml:

<dependency>
   <groupId>org.robolectric</groupId>
   <artifactId>robolectric</artifactId>
   <version>2.3</version>
   <scope>test</scope>
</dependency>
Robolectric requires the Google APIs for Android (specifically, the maps JAR) and Android support-v4 library. To download this onto your development machine use the Android SDK tools and then run the following to install them to your local Maven repository:

mvn install:install-file -DgroupId=com.google.android.maps \
  -DartifactId=maps \
  -Dversion=18_r3 \
  -Dpackaging=jar \
  -Dfile="$ANDROID_HOME/add-ons/addon-google_apis-google-18/libs/maps.jar"

mvn install:install-file -DgroupId=com.android.support \
  -DartifactId=support-v4 \
  -Dversion=19.0.1 \
  -Dpackaging=jar \
  -Dfile="$ANDROID_HOME/extras/android/support/v4/android-support-v4.jar"
You will need to either replace or have ANDROID_HOME set to your local Android SDK for Maven to be able to install the jar.
