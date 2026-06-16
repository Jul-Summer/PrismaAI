#  PrismaAI — AI Style Transfer for Android

![Android](https://img.shields.io/badge/Platform-Android-green)
![TensorFlow Lite](https://img.shields.io/badge/ML-TensorFlow%20Lite-orange)
![Kotlin](https://img.shields.io/badge/Code-Kotlin-blue)
![Status](https://img.shields.io/badge/Status-Production%20Ready-brightgreen)
![Model](https://img.shields.io/badge/Model-CycleGAN-purple)

---

##  Overview

**PrismaAI** — мобильное AI-приложение для **нейронного переноса стиля (Neural Style Transfer)**, работающее полностью **на устройстве (offline)** с использованием TensorFlow Lite.

Модель основана на **CycleGAN Generator (G_A2B)** и оптимизирована для мобильного инференса.

---

##  Key Features

-  Neural Style Transfer (CycleGAN)
-  Fully offline inference (no cloud)
-  Fast TensorFlow Lite execution
-  On-device AI processing
-  Gallery image support
-  MVVM Architecture

##  AI Pipeline


Image
  → Resize (256×256)
  → Normalize
  → TensorFlow Lite Model (G_A2B)
  → Output Tensor
  → Bitmap
  → UI Rendering (Jetpack Compose)

  
| Metric            | Value           |
| ----------------- | --------------- |
| Inference Latency | 90–180 ms       |
| Model Size        | 10–25 MB        |
| Input Resolution  | 256 × 256       |
| Output Resolution | 256 × 256       |
| Runtime           | On-device (CPU) |


## Model Information
-  Architecture: CycleGAN (Generator G_A2B)
-  Framework: TensorFlow Lite
-  Execution: Fully offline
-  Precision: Float32
-  Platform: Android
-  APK Download

### Latest Release

⬇ Download PrismaAI APK

▶️ How to Run
-  Option 1 — Install APK (Recommended)
Download APK from Releases
Open file on Android device
Enable “Install from unknown sources”
Launch PrismaAI
-  Option 2 — Run from Source
git clone https://github.com/Jul-Summer/PrismaAI.git
cd PrismaApp

Open in Android Studio → Run ▶

 Validation Results

✔ Model training completed successfully
✔ TensorFlow Lite export successful
✔ Inference tested via Interpreter
✔ Output tensor shape validated (1, 256, 256, 3)
✔ Stable Android integration confirmed

 Demo

Add screenshots in /screenshots

screenshots/
├── input.png
├── output.png
├── demo.gif
 System Status
PROJECT STATUS: PRODUCTION READY

✔ Training OK
✔ Export OK
✔ TFLite OK
✔ Android READY

 ### Tech Stack
Kotlin
Jetpack Compose
TensorFlow Lite
MVVM Architecture
CycleGAN
###  Author

Guljan Samarbekova

AI Mobile Vision Project — 2026
