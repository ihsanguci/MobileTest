## 🧪 Selenium + Cucumber + Gradle Automation Testing

📱 Appium Mobile Automation Project
This project is an implementation of BDD-based mobile automation testing using:

☕ Java

🤖 Appium 9

🥒 Cucumber

⚙️ Gradle (build tool)

📜 Tests executed via .sh script

---

## 🛠️ Prerequisites
Ensure the following are installed:

✅ Java JDK 11 or higher

✅ Gradle (or use ./gradlew wrapper)

✅ Appium 9 or higher installed globally (npm install -g appium)

✅ Android Emulator or real device

✅ Bash terminal (Linux/macOS) or Git Bash (for Windows)

✅ Appium Inspector (optional, for element inspection)

---

## ▶️ How to Run Tests

### 📄 1. Execute directly from the terminal using command
Configure `tag`depends on your requirements

` ./gradlew clean test "-Dcucumber.filter.tags=@test" `

### 📄 2. Execute directly from the terminal using sh runner
Configure `tag` on your requirements in file runner.sh

` sh runner.sh`



