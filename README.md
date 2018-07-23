# InstantAppDemo
Sample application to demonstarte the development, installation and deployment of instant app on device.

## Prerequisites

### Install instant app sdk from SDK manager
  ![Instant App SDK](screenshots/instant_app_sdk.png)

## Building an Instant app

### Creating a feature modules:
* Feature modules are modules that applies the new 'com.android.feature' Gradle plugin. They are simply library projects, producing an aar when consumed by other modules.
* It’s worth noting that they do not have application IDs because they are just library projects.
* The feature module’s manifest is also worth noting because since it is functionally only a part of the full app, its manifest will be merged with others when the project is assembled.
* build.gradle for feature module will look like :

  ![Feature build.gradle](screenshots/non_base_feature_module_build_gradle.png)

### Creating a base module: 
* Every project that uses feature modules must have exactly one base module and every feature module must depend on the base module.
* The base feature module can be thought of as the root of your project. It contains the shared code and resources to be used by other modules.
* Feature module with the property 'baseFeature' set to 'true'.
* build.gradle for base feature module will look like :

  ![Base Feature build.gradle](screenshots/base_feature_build_gradle.png)

### Creating an installable(i.e. APK) module:
* This is the normal build module that we are all familiar with. Now it’s setup to consume the base and feature modules in order to produce an output apk which needs to be installed on user devices.
* Since it aims to output an installable artifact this module does have an application ID.
* We need to add 'com.android.application' plugin for installable module.
* The application manifest here is the result of merging all of the other manifests that it inherits from the other feature modules. As a result its manifest is pretty sparse.
* build.gradle for base feature module will look like :

  ![Installable build.gradle](screenshots/installable_app_build_gradle.png)

### Creating an instant module:
* Instant App module - implements the com.android.instant plugin. 
* The consume feature modules and produce a split APK zip containing all of the features that will go into the Instant App.
* It’s pretty much an empty shell of a project without a manifest that only implements other features feature modules in the project.
* build.gradle for base feature module will look like :

  ![Installable build.gradle](screenshots/instant_app_build_gradle.png)

## Installation of instant app:

### Creating the instant app build process:
* Users don't install your app when using Google Play Instant, so to open your app, users will usually click on a link. For Google Play Instant, URLs are the entry point into an app and they are associated with Activities. These URLs must be verified App Links.
* To create App Links, you'll use a feature built into Android Studio called "App Links Assistant." Open this tool by going to Tools -> Apps Links Assistant :

  ![App link assistance](screenshots/tools_app_url.png)

* From the sidebar, tap on the "Open URL Mapping Editor" button (which appears near the top): 

  ![App link editor](screenshots/app_link_url.png)

* From the editor, tap the "+" button to add a new app link entry:

  Create a new URL mapping with the following details:

  Host: http://avinash.weather.instantapp.com

  Select "pathPrefix" from dropdown

  Path: /list/

  Activity: com.avinash.instant.feature.list.weather.presentation.activity.WeatherListActivity
  
* Similarly add the remaining activities and finally the url map will look like as shown below:

  ![Url mapping](screenshots/url_mapping.png)

### Setup your Run Configuration:

* To run your creation, you'll need to setup a run configuration that says which URL to open. Click the Run configuration dropdown and choose "Edit Configurations..."

  ![Edit Configurations](screenshots/edit_configurations.png)

* Select instant under Android App. Replace the text ‘<< ERROR - NO URL SET>>' with http://avinash.weather.instantapp.com/list/ as shown below:

  ![Run Configurations](screenshots/run_configurations.png)

### Run your instant app:

#### Running instant app from Android studio:

* Make sure you uninstall the "InstatntAppDemo" app which was installed with a regular APK before proceeding further. If the regular APK is installed, the instant app will not be started as the device already has the full apk app.
* To run your instant app, select "instantapp_weather" from the Run configuration dropdown and click Run.
* Your instant app will be installed on your device.

#### Running instant app from command prompt:

* If you switch to Project mode, you should see the following generated files in InstatntAppDemo/instantapp_weather/build/outputs/apk/debug/instantapp_weather-debug.zip as shown below:

  ![Instant app zip](screenshots/instant_app_zip.png)

* You can also install the instant app with command prompt using 'adb multiple-install -r -t -- basefeature.apk requiredfeature.apk' command as shown below:

  ![Instant app install command](screenshots/installing_instant_app_command.png)

* Once installed successfully you can run the instant app with command prompt using 'adb shell am start -a android.intent.action.VIEW -d "feature_url"' command as shown below:

  ![Instant app run command](screenshots/running_instant_app_command.png)

* To verify the running app is, in fact, an instant app, go to the Recents screen and check. You should see "InstantAppDemo" with the lightning bolt icon.

  ![Instant app](instant_application.png)



