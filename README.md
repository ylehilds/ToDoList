# Task Management Android App

A lightweight, privacy-friendly **Android To-Do list application** written in **Java**. It focuses on clean structure and the core task flows—**add**, **toggle complete**, **list**, and **delete**—without unnecessary permissions or third-party services. Ideal as a compact, portfolio-ready Android project.

## Features
- Add new tasks with a simple input flow
- Mark tasks as completed / uncompleted
- View a clean, minimal task list UI
- Delete tasks safely
- Privacy-first: minimal permissions; no external accounts required

## Tech Stack
- **Language:** Java (Android SDK)
- **Framework:** Native Android
- **Build:** Gradle (via Android Studio)

## Project Structure
- `src/` — Android source code (Activities, adapters, models, utilities)
- `LICENSE`, `README.md` — project metadata

> Open this repository directly in **Android Studio**. If prompted, import as a Gradle/Android project so the IDE configures the correct SDK, build tools.

## Getting Started
**Clone**

    git clone https://github.com/ylehilds/ToDoList.git
    cd ToDoList

**Run via Android Studio (Recommended)**
1. Open **Android Studio** → **Open** → select the project folder.
2. Let **Gradle** sync dependencies.
3. Connect an Android device or start an emulator (AVD).
4. Click **Run ▶** to build and launch the app.

## Usage
1. Launch the app on your device/emulator.
2. Enter a task (e.g., “Buy groceries”) and add it to the list.
3. Tap to mark a task as done/undone.
4. Remove tasks you no longer need.

## Extensibility Ideas
- **Persistence:** Add Room/SQLite (or lightweight JSON) to keep tasks across app restarts.
- **UX:** Swipe-to-delete, undo snackbar, drag-and-drop reordering.
- **Productivity:** Due dates, reminders/notifications, priorities, and tags.
- **Sync:** Optional backend or cloud sync for multi-device access.
- **Testing:** Unit tests for view-models/utils and instrumentation tests for UI flows.

## License
This project is licensed under the **MIT License** — see `LICENSE` for details.

## Author
**Lehi Alcantara**  
🌐 https://www.lehi.dev  
✉️ lehi@lehi.dev