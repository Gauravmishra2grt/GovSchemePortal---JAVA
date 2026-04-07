# 🏛️ Government Welfare Schemes Portal (Java Swing)

A robust, desktop-based Graphical User Interface (GUI) application developed in **Core Java & Swing**. This application allows citizens to seamlessly search, filter, and explore various government welfare schemes and securely redirects them to official portals.

## 🚀 Tech Stack & Core Concepts
* **Language:** Java (JDK 8+)
* **GUI Framework:** Java Swing & AWT
* **Data Processing:** Java 8 Streams API
* **Architecture:** Separation of Concerns (Model, Data Source, UI)
* **Tools Used:** Git, GitHub

## ✨ Key Features
* **Live Search:** Implemented dynamic document listeners for real-time search filtering.
* **Category Filtering:** Dropdown-based sorting to easily navigate schemes by category (Agriculture, Education, Healthcare).
* **Responsive Card Layout:** Used `BoxLayout` and `GridLayout` to create a clean, modern card-based UI.
* **Secure Redirection:** Utilized Java's `Desktop` API to seamlessly open official government `.gov.in` URLs directly in the user's default web browser.

## 📂 Project Structure (Separation of Concerns)
To maintain clean, scalable, and readable code, the project is divided into three distinct modules:
1. `Scheme.java`: The Data Model (POJO) representing the structure of a scheme.
2. `SchemeDatabase.java`: The Data Source acting as a central repository for scheme data.
3. `GovSchemePortal.java`: The main GUI class handling layout, event listeners, and data rendering.

## ⚙️ How to Run Locally
1. Clone this repository to your local machine:
   ```bash![WhatsApp Image 2026-04-08 at 12 29 40 AM](https://github.com/user-attachments/assets/be9d5458-d483-4f19-b238-93419cf97523)

   git clone [https://github.com/YourUsername/GovSchemePortal-Java.git](https://github.com/YourUsername/GovSchemePortal-Java.git)


