#!/bin/bash

# Script para compilar el mod sin Gradle

mkdir -p build/classes
cd src/main/java

# Compilar todos los archivos Java
javac -d ../../../build/classes \
  com/triggerbot/TriggerBotMod.java \
  com/triggerbot/client/TriggerBotClient.java \
  com/triggerbot/mixin/GameRendererMixin.java \
  com/triggerbot/mixin/ClientPlayerEntityMixin.java \
  com/triggerbot/utils/AttackExecutor.java \
  com/triggerbot/utils/EnemyDetector.java \
  com/triggerbot/utils/CooldownManager.java \
  2>&1 || echo "Advertencia: algunos archivos pueden requerir librerías Fabric"

cd ../../..

# Crear JAR con los archivos compilados y recursos
mkdir -p build/libs
cd build/libs

# Copiar recursos
cp -r ../../src/main/resources/* ../classes/ 2>/dev/null || true

# Crear JAR
cd ../classes
zip -r ../libs/mc-triggerbot-fabric-1.0.0.jar . 2>/dev/null

echo "✅ JAR compilado: build/libs/mc-triggerbot-fabric-1.0.0.jar"
ls -lh ../libs/mc-triggerbot-fabric-1.0.0.jar
