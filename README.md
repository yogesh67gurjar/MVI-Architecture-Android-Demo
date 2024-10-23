# MVI Architecture Demo - Android App

This is a simple Android app demonstrating the **Model-View-Intent (MVI)** architecture. The app fetches random cat facts from the **CatFact API** and displays them to the user.

## Features
- **API Integration**: Retrieves random cat facts from the CatFact API.
- **MVI Architecture**: Implements the MVI pattern, separating business logic and user interaction intents.
- **LiveData & Retrofit**: Uses LiveData for observing results and Retrofit for networking.
- **User Interface**: Simple UI with a button to fetch cat facts and a text view to display them.

## Project Structure
- **Intents**: Defines various user intents for the ViewModel to act upon.
- **ViewModel**: Contains the `MainViewModel` class, which handles API interactions and updates LiveData based on user intents.
- **View**: The `MainActivity` class handles user interactions and observes LiveData to update the UI.

## MVI Architecture Explanation

### Components in the Code

1. **Intents (`MainIntents`)**:
   - Sealed class representing different actions the user can take (e.g., `GetFact` intent).
   - **Responsibilities**:
     - Captures user intentions, like fetching a fact.

2. **ViewModel (`MainViewModel`)**:
   - Responds to user intents by invoking the appropriate business logic.
   - **Responsibilities**:
     - Handles API calls to fetch data.
     - Processes API responses and posts results to LiveData.
     - Observes and updates the UI based on the success or failure of the API call.

3. **View (`MainActivity`)**:
   - Responsible for displaying the user interface and reacting to user input.
   - **Responsibilities**:
     - Fires intents (e.g., fetching a fact) based on user actions.
     - Observes LiveData from the ViewModel and updates the UI accordingly.

### Summary of MVI Roles
- **Model**: API (`ApiService`) and the `CatFactResponse` data class.
- **View**: `MainActivity`, which observes data and displays it.
- **Intent**: Sealed class `MainIntents` to define actions.

## How to Run
1. Clone this repository.
2. Open the project in Android Studio.
3. Build and run the app on an emulator or a real device.
4. Click the button to fetch a random cat fact.

## Libraries Used
- **Retrofit**: For networking and API calls.
- **LiveData**: For observing and updating UI states.
- **Gson**: For parsing JSON responses.

## API Reference
- [CatFact API](https://catfact.ninja/)

## Contact
- **Email**: [yogesh67gurjar@gmail.com](mailto:yogesh67gurjar@gmail.com)
- **GitHub**: [github.com/yogesh67gurjar](https://github.com/yogesh67gurjar)
