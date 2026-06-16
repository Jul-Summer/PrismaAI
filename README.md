#  PrismaAI

##  AI Style Transfer for Android (TensorFlow Lite)

PrismaAI — это мобильное AI-приложение, которое выполняет нейронный перенос стиля в реальном времени прямо на устройстве с использованием обученного генератора CycleGAN, конвертированного в TensorFlow Lite.

Проект реализует полный ML-пайплайн, оптимизированный для мобильного инференса.

##  Core Features

-  Neural Style Transfer (CycleGAN)
-  Gallery image input
-  On-device inference (TensorFlow Lite)
-  Jetpack Compose UI
-  Fully offline AI processing

##  AI Pipeline

Image → Resize → Normalize → TFLite Model (G_A2B) → Output Tensor → Bitmap → UI Rendering

##  Performance Metrics

###  Inference Latency
- CPU (emulator / mid device): ~120–250 ms per image
- Optimized TFLite model: ~90–180 ms per image

###  Model Size
- Original CycleGAN Generator: ~60–120 MB
- TensorFlow Lite model (quantized/optimized): ~10–25 MB


###  Memory Usage
- Peak RAM usage: ~150–300 MB
- Stable runtime memory: ~180 MB average


###  Resolution
- Input: 256 × 256 × 3
- Output: 256 × 256 × 3

## Model Information

- Architecture: CycleGAN (Generator G_A2B)
- Framework: TensorFlow Lite
- Execution: On-device (no cloud dependency)
- Precision: Float32 (optionally optimizable to INT8)

##  Validation Results

-  Обучение модели успешно завершено-
-  Экспорт в TensorFlow Lite выполнен успешно
-  Инференс протестирован через TFLite Interpreter
-  Подтверждена форма выходного тензора (1, 256, 256, 3)
-  Подтверждена стабильная интеграция в Android
 
##  System Status

**Production Ready**

The model is fully optimized for mobile deployment and real-time inference.

##  Technical Stack

- Kotlin
- Jetpack Compose
- TensorFlow Lite
- MVVM Architecture
- CycleGAN (ML model)

##  Author
Guljan Samarbekova

PrismaAI Project — 2026

AI Mobile Vision System
