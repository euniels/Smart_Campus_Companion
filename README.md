<div align="center">

<h1> Smart Campus Companion</h1>

<p><strong>Mobile Programming 2 – Case Study</strong></p>

<p>
An Android application designed to provide students with essential campus information<br>
through a clean and intuitive interface.
</p>

</div>

---

## App Description

Smart Campus Companion is an Android application built using Kotlin and Jetpack Compose. It follows the MVVM architecture and is designed to assist university students with viewing campus information, managing academic tasks and schedules, reading campus announcements, and personalizing app settings. 

---
<div align="Center">
<h2>Team Roles</h2>

| Role   | Name                    |
|------|-------------------------|
| Team Leader | Gonzales, Maria Manuela |
| Git Manager | Guarte, Eunel Angelo    |
| UI/UX Developer | Frisco, Mary Mae        |
| Feature Developer | Gacusana, John Lei      |
| QA / Documenter | Maurin, Kim Aldrin      |
</div>

---

## Project Structure

The system utilizes the **MVVM (Model-View-ViewModel)** architecture to ensure a clean separation of concerns and improved maintainability.

```text
app/src/main/java/com/example/smart_campus_companion/
├── data/
│   ├── model/
│   │   ├── Department.kt
│   │   └── User.kt
│   ├── CampusDeptData.kt
│   └── SessionManager.kt
├── domain/
│   ├── AuthLogic.kt
│   └── LoginState.kt
├── ui/
│   ├── navigation/
│   │   ├── AppNavGraph.kt
│   │   └── Routes.kt
│   ├── screens/
│   │   ├── CampusInfoScreen.kt
│   │   ├── DashboardScreen.kt
│   │   └── LoginScreen.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
└── MainActivity.kt
```


---

## Git Workflow

1. Each team member creates their own branch from `develop`
2. Work on the assigned tasks in their branch
3. Once done, open a Pull Request to `develop`
4. Git Manager reviews Pull Request, Team Manager Merges
5. Resolve any merge conflicts before merging
6. After all branches are merged, the code on `main` is the final output



---

## Testing Documentation

We maintain application reliability through a structured testing approach:

### 1. Unit Testing
Unit tests are used to verify the core business logic of the application without requiring a physical device or emulator.
- **Location:** `app/src/test/java/com/example/smart_campus_companion/`
- **Scope:** Primarily targets the `domain` layer (e.g., `AuthLogic.kt`).
- **Execution:** Run via the command line:
  ```bash
  ./gradlew test
  ```


### 2. UI & Instrumented Testing
These tests ensure that the UI components render correctly and navigation flows work as expected.
- **Location:** `app/src/androidTest/java/com/example/smart_campus_companion/`
- **Scope:** Testing Jetpack Compose screens and navigation.
- **Execution:** Run via the command line:
  ```bash
  ./gradlew connectedAndroidTest
  ```

### 3. Manual Testing
- Conducted on **Pixel 6 (API 33)** and physical devices to ensure responsiveness and stability across different screen sizes.

---

## Technologies Used
- **Language:** Kotlin
- **UI Framework:** Jetpack Compose
- **Architecture:** MVVM (Model-View-ViewModel)
- **Navigation:** Compose Navigation
- **Dependency Management:** Gradle (Kotlin DSL)
    
  
  