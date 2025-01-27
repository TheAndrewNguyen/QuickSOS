# Quick SOS
![Status](https://img.shields.io/badge/Status-In%20Development-orange) ![Android](https://img.shields.io/badge/Platform-Android-green) ![Kotlin](https://img.shields.io/badge/Kotlin-1.5-blue) ![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.0.0-blue) ![OSMDroid](https://img.shields.io/badge/OSMDroid-4.0.0-orange)![Room Database](https://img.shields.io/badge/Room%20Database-2.4.0-green)  ![Hilt](https://img.shields.io/badge/Hilt-DI-yellow) 
Quick SOS is a quick and reliable safety app that is designed to get in contact with emergency services with a single click of a button.

## Features

### Core Features (MVP):
- **One-Tap Emergency Actions:** Quickly call or text 911, send your live location, and share an emergency message—all with a single tap, either in the app or via the convenient home screen widget
- **Personalized Emergency Contacts:** Easily add, edit, and save your trusted contacts to ensure help is just a tap away when you need it.  Personalize messages to text 911 and emergency contacts
- **Live Location Details:** Access precise location information to direct emergency services or loved ones about your whereabouts.

### Additional Features:
- **Real-Time Location Sharing:** Keep loved ones informed by sharing your live location, giving them peace of mind during emergencies.
- **Comprehensive Safety Widget:** From your home screen, use the widget to call or text 911, send an SOS message to your contacts, and check your current location—all without opening the app.
- **Local emergency numbers:** Configure local emergency numbers manually or automatically through location

## Technical architecture:

### Android(MVP)
- **UI Layer:** 
    - Jetpack Compose
    - Toast Notifications 
- **Call and texting:** 
    - Android Intent (Calling and texting)
    - Work Manager (background tasks)
- **Location:** 
    - Fused Location Provider
- **Maps:**
    - OSMDroid
- **Storage:** 
    - Room database (storing contacts)
    - Jetpack datastore (storing user preferences)
- **Dependency Injection**
    - Hilt 

## License
See [LICENSE](/LICENSE)

## Contact
Andrew Nguyen 
Email: anguye34@uw.edu
