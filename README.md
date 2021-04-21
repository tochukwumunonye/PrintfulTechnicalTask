# PrintfulTechnicalTask  ![Android Build](https://github.com/mayokunthefirst/CardInfoFinder/workflows/Android%20Build/badge.svg) [![BCH compliance](https://bettercodehub.com/edge/badge/mayokunthefirst/CardInfoFinder?branch=master)](https://bettercodehub.com/)

PrintfulTechnicalTask is an Android application that uses an retrofit to fetch data from a web through an API and displays the data as a list.
This application makes use of the [Unsplash API](https://unsplash.com/developers/).


![IMG_20210421_151229](https://user-images.githubusercontent.com/61085272/115569773-76274f00-a2b5-11eb-8ef9-2bad930d2188.jpg)
![IMG_20210421_151052](https://user-images.githubusercontent.com/61085272/115569785-77587c00-a2b5-11eb-88bc-89bb6cda78bf.jpg)
![IMG_20210421_151132](https://user-images.githubusercontent.com/61085272/115569810-7c1d3000-a2b5-11eb-85d6-0418c5582098.jpg)
![IMG_20210421_151152](https://user-images.githubusercontent.com/61085272/115569763-745d8b80-a2b5-11eb-9e17-9235bce854e1.jpg)


## Project Characteristics

This project makes use of the following tools and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Modern architecture (Clean Architecture, Model-View-ViewModel)
* [Android Jetpack](https://developer.android.com/jetpack)
* A single-activity architecture ( using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage Fragment operations.)
* [Pagination](https://developer.android.com/jetpack/androidx/releases/paging)
* Dependency Injection
* Material design


## Tech Stack


Minimum API level is set to 22, so the presented approach is suitable for over 92.3% of devices running Android as at the time of writing this. 

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android/) - dependency injection
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
        * [View Binding](https://developer.android.com/topic/libraries/view-binding/) -  a feature that allows you to more easily write code that interacts with views
   
    * [and more...](https://github.com/tochukwumunonye/CardInfoFinder/blob/master/buildSrc/src/main/kotlin/Dependencies.kt)
* Architecture
    * Clean Architecture (at module level)
    * MVVM (presentation layer)
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
    
* Gradle
    * [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    * Plugins ([SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args))
    
    
## Architecture
Clean Architecture is the "core architecture" of this application. The main purpose of this approach is to achieve a separation of concerns which Clean architecture helps with and in
making the code loosely coupled. This approach results in a more testable and flexible code. This approach divides the project in 3 modules: **presentation, data and domain**.

<p align="center"><a><img src="https://github.com/mayokunthefirst/CardInfoFinder/blob/master/media/clean-arch.png" width="700"></a></p>

* **Presentation**: Layer with the Android Framework, the MVVM pattern and the DI module. Depends on domain to access the use cases and on DI, to inject dependencies. This is the layer closest 
to what the user sees on the screen. 
    - **MVVM**: The Model View ViewModel pattern helps with the separation of concerns, dividing the user interface with the logic behind. It combines very well with Android Architecture Components like LiveData and DataBinding.
* **Domain**: This is also known as viewModel. It is the core layer of the application with the business logic. It contains the use cases, in charge of calling the correct repository or data member.The domain layer is independent of any other layers. 
* **Data**: Layer with the responsibility of managing the application data and exposes these data sources as repositories to the domain layer. Typical responsibilities of this layer is to retrieve data from the internet and optionally cache this data locally.

### Dependency Injection with DaggerHilt
Dependency injection is closely related to two SOLID concepts: dependency inversion, which states that high level modules should not depend on low level modules, 
both should depend on abstractions; and single responsibility principle, 
which states that every class or module is responsible for just a single piece of functionality. This application makes use of DaggerHilt as a DI library.
    
