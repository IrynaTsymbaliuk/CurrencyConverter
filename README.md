# CurrencyConverter

Currency converter sample app.

<img src="https://user-images.githubusercontent.com/42023359/201511497-f00d9b09-81f8-4b65-b50c-17e448f5d447.png" width="216" height="480" />

<br/>

## Installation โ๏ธ

1. Clone this repository and import into Android Studio
```
git clone https://github.com/IrynaTsymbaliuk/CurrencyConverter.git
```
2. Create a Firebase project and register the app: https://console.firebase.google.com/
3. Download and then add the configuration file (```google-services.json```) into the ```/androidApp``` directory.
4. Create Remote Config parameter ```API_KEY```

<br/>

## Built With ๐ 
- [Kotlin](https://kotlinlang.org/) - A modern programming language
that makes developers happier.
- [Koin](https://insert-koin.io/) - A lightweight pure Kotlin library for dependency injection.
- [Ktor](https://ktor.io/) - Multiplatform asynchronous HTTP client built on Kotlin and Coroutines.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous work.
- [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - A flow is an asynchronous version of a Sequence, a type of collection whose values are lazily produced.
- [Firebase Remote Config](https://firebase.google.com/products/remote-config) - Firebase cloud service 
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Screen level state holder.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) - Androidโs recommended modern toolkit for building native UI
- [Material3](https://m3.material.io/) - the latest version of Googleโs open-source design system.

<br/>

## Architecture ๐

<img src="https://user-images.githubusercontent.com/42023359/207277698-671bb9ef-0a46-4c92-991d-12db623a9375.svg" />

<br/>

## Package Structure ๐ฆ 
    
    com.tsymbaliuk.currency.converter # Root

    โโโ android                       # AndroidApp
        โโโ di                        # Android module for DI
        โโโ mvi                       # MVI related code
        โ   โโโ base                  # Base MVI interfaces
        โ   โโโ home                  # MVI components for Home screen
        โโโ ui                        # UI related code
        โ   โโโ composable.component  # App design system components
        โ   โโโ home                  # Home screen and viewmodel
        โ   โโโ theme                 # App theme components (colorScheme, shapes, typography)
  
    โโโ ios                           # iOSApp

    โโโ shared                        # Shared module contains the core app logic used in both Android and iOS platforms
        โโโ androidMain               # Android-specific parts, including actual implementations
        โ   โโโ network.datasource    # Android actual implementation for network datasources 

        โโโ commonMain                # Code that works on both platforms, including the expect declarations
        |   โโโ di                    # Common module for DI
        |   โโโ model                 # External representation models
        |   โโโ network               # Network related code
        |   |    โโโ datasource       # Remote datasources (Firebase, Ktor client) and expect declarations
        |   |    โโโ model            # Network representation models
        |   โโโ repository            # Handles online, offline and fake data sources. 
        |   โโโ usecase               # Usecases and UseCaseProvider

        โโโ iosMain                   # iOS-specific parts, including actual implementations
        โ   โโโ network.datasource    # iOS actual implementation for network datasources

<br/>
    
## Contact ๐ฉ
Iryna.Tsymbaliuk.dev@gmail.com
