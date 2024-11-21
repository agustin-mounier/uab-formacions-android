# UAB formacions: TMDB App Exercise

This application is designed as an educational exercise to learn Android development using Jetpack Compose and modern Android architecture. Follow the steps below to set up the project and complete the tasks to enhance your understanding of Compose, ViewModel logic, and unit testing.

---

## Steps to Get Started

### 1. Download Android Studio and Open the Project
- Download and install [Android Studio](https://developer.android.com/studio).
- Clone or download this repository to your local machine.
- Open the project in Android Studio.

---

### 2. Create an Emulator Device
- Open the **Device Manager** in Android Studio (accessible from the toolbar or via `Tools > Device Manager`).
- Click on **Create Device** and follow the prompts to set up an emulator. Any Pixel device should work fine.
- Choose a device configuration and system image, then click **Finish**.

---

### 3. Run the App
- Click the green **Play** button in the toolbar to run the app on your emulator.
- Once the app is running, observe the Movie Feed Screen. You’ll see that the sorting options (popularity, release date, and rating) are displayed but don’t work yet.

---

### 4. Modify the `MovieCard` Function
- Open the `MovieFeedScreen.kt` file. To do a global search tap 3 times the shift key.
- Locate the `MovieCard` composable function.
- Modify it to match the implementation provided in the image. This will improve the MovieCard UI, showing more details like the release date, rating and popularity.

#### Additional Info: Jetpack Compose Basics
To help you understand and modify the `MovieCard` function, here are a few key Jetpack Compose concepts:

1. **`Modifier`**
    - A `Modifier` is used to decorate or configure composables. For example:
        - Add padding: `Modifier.padding(8.dp)`
        - Set the size: `Modifier.size(100.dp)`
        - Handle user interaction: `Modifier.clickable { }`
    - [Learn more about Modifiers](https://developer.android.com/jetpack/compose/modifiers).

2. **`Text`**
    - The `Text` composable is used to display text. It supports customization like:
        - `style`: Apply typography from your app's theme.
        - `color`: Set the text color.
        - `maxLines`: Limit the number of visible lines.
    - Example:
      ```kotlin
      Text(
          text = "Movie Title",
          style = MaterialTheme.typography.h6,
          maxLines = 2,
          overflow = TextOverflow.Ellipsis
      )
      ```  
       - [Learn more about Text composable](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#Text).
3. **`Row`**
   - The `Row` composable is used to arrange child composables horizontally. It allows you to define how items are spaced, aligned, and distributed in a horizontal layout. For example:
     - Align items: `horizontalArrangement = Arrangement.SpaceBetween`
     - Handle alignment: `verticalAlignment = Alignment.CenterVertically`
   - Example:
    ```kotlin
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Left Item")
        Text("Right Item")
    }
    ```
   - [Learn more about Row composable](https://developer.android.com/jetpack/compose/layouts).

For a deeper understanding of Compose, refer to the [Jetpack Compose documentation](https://developer.android.com/jetpack/compose).

---

### 5. Run the Unit Tests
- Locate the `MovieViewModelTest` file and run the tests by clicking the green **Run** button next to each test or the class name.
- Observe that the tests fail because the sorting logic is not implemented yet.

---

### 6. Add Sorting Logic in the ViewModel
- Open the `MovieViewModel.kt` file.
- Implement logic to sort the list of movies by popularity, release date, and rating based on the selected sorting option.
- Ensure that the sorting logic updates the state, and the UI observes these changes dynamically.
- Run the app in the emulator to see it in action.

---

### 7. Rerun the Tests
- After adding the sorting logic, rerun the tests as described in Step 5.
- Continue debugging and refining the logic until all tests pass successfully.

---

## Additional Resources
- [Jetpack Compose Basics](https://developer.android.com/jetpack/compose/documentation)
- [Android ViewModel Documentation](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Unit Testing in Android](https://developer.android.com/training/testing/unit-testing)

---

Add: unit tests, improve desing, movie details excercise, pagination.

## Learning Goals
By following these steps, you’ll:
- Understand how to use Jetpack Compose to build declarative UIs.
- Learn to manage app state using a `ViewModel`.
- Write and debug unit tests for Android apps.
- Improve your problem-solving and debugging skills in an Android environment.

Good luck, and happy coding! 🚀
