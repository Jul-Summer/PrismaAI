#  PrismaAI

AI Style Transfer Android App using TensorFlow Lite (CycleGAN)

##  О проекте

PrismaAI — это мобильное приложение для переноса стиля изображения с помощью нейросети, работающей полностью на устройстве.

Модель основана на CycleGAN и конвертирована в TensorFlow Lite для Android.

---

##  Возможности

-  Перенос стиля изображения
-  Работа на Android
-  Быстрый on-device inference
-  Полностью offline (без интернета)

##  AI Pipeline

Image → Preprocess → TFLite Model (G_A2B) → Output Image → UI

---

##  Модель

- Формат: TensorFlow Lite (.tflite)
- Архитектура: CycleGAN (Generator G_A2B)
- Вход: 256x256x3
- Выход: 256x256x3

##  Статус

✔ Training completed  
✔ Model exported to TFLite  
✔ Inference tested  
✔ Android integration ready  


##  Запуск

1. Скачать APK из Releases
2. Установить на Android устройство
3. Запустить приложение

## Технологии

- Kotlin
- Jetpack Compose
- TensorFlow Lite
- MVVM

---

##  Автор
Guljan Samarbekova


PrismaAI Project — 2026
