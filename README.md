# CurrencyConverter

Currency converter sample app.

<img src="https://user-images.githubusercontent.com/42023359/201511497-f00d9b09-81f8-4b65-b50c-17e448f5d447.png" width="216" height="480" />

<br/>

## Installation ⚙️

1. Clone this repository and import into Android Studio
```
git clone https://github.com/IrynaTsymbaliuk/CurrencyConverter.git
```
2. Create a Firebase project and register the app: https://console.firebase.google.com/
3. Download and then add the configuration file (```google-services.json```) into the ```/androidApp``` directory.
4. Create Remote Config parameter ```API_KEY```

<br/>

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - A modern programming language
that makes developers happier.
- [Koin](https://insert-koin.io/) - A lightweight pure Kotlin library for dependency injection.
- [Ktor](https://ktor.io/) - Multiplatform asynchronous HTTP client built on Kotlin and Coroutines.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous work.
- [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - A flow is an asynchronous version of a Sequence, a type of collection whose values are lazily produced.
- [Firebase Remote Config](https://firebase.google.com/products/remote-config) - Firebase cloud service 
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Screen level state holder.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android’s recommended modern toolkit for building native UI
- [Material3](https://m3.material.io/) - the latest version of Google’s open-source design system.

<br/>

## Architecture 📐

<img src="https://user-images.githubusercontent.com/42023359/207277698-671bb9ef-0a46-4c92-991d-12db623a9375.svg" />

<br/>

## Package Structure 📦 
    
    com.tsymbaliuk.currency.converter # Root

    ├── android                       # AndroidApp
        ├── di                        # Android module for DI
        ├── mvi                       # MVI related code
        │   ├── base                  # Base MVI interfaces
        │   ├── home                  # MVI components for Home screen
        ├── ui                        # UI related code
        │   ├── composable.component  # App design system components
        │   ├── home                  # Home screen and viewmodel
        │   ├── theme                 # App theme components (colorScheme, shapes, typography)
  
    ├── ios                           # iOSApp

    ├── shared                        # Shared module contains the core app logic used in both Android and iOS platforms
        ├── androidMain               # Android-specific parts, including actual implementations
        │   ├── network.datasource    # Android actual implementation for network datasources 

        ├── commonMain                # Code that works on both platforms, including the expect declarations
        |   ├── di                    # Common module for DI
        |   ├── model                 # External representation models
        |   ├── network               # Network related code
        |   |    ├── datasource       # Remote datasources (Firebase, Ktor client) and expect declarations
        |   |    ├── model            # Network representation models
        |   ├── repository            # Handles online, offline and fake data sources. 
        |   ├── usecase               # Usecases and UseCaseProvider

        ├── iosMain                   # iOS-specific parts, including actual implementations
        │   ├── network.datasource    # iOS actual implementation for network datasources

<br/>
    
## Contact 📩
Iryna.Tsymbaliuk.dev@gmail.com
