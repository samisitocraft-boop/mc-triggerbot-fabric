# MC TriggerBot Fabric 1.20.1

**Advanced PvP TriggerBot para Minecraft 1.20.1 con detección inteligente de cooldown**

## 🎯 Características

✅ **Detección de enemigos** en radio de 3 bloques en todos los ángulos
✅ **Sistema de cooldown inteligente** por arma
✅ **Críticos automáticos** al saltar
✅ **Golpes normales y barridos** cuando está en el suelo
✅ **Soporte para todas las espadas y hachas**
✅ **Rotación suave** sin giros drásticos
✅ **Activación con tecla B**

## 📊 Tiempos de Cooldown

### Espadas (Crítico/Salto)
- Netherite: 1.6s
- Diamante: 1.6s
- Hierro: 1.6s
- Oro: 1.6s
- Piedra: 1.6s
- Madera: 1.6s

### Hachas
- Netherite: 0.85s
- Diamante: 0.85s
- Oro: 0.85s
- Hierro: 0.93s
- Piedra: 1.02s
- Madera: 1.02s

## 🔧 Instalación

### Opción 1: PojavLauncher (Recomendado para Android)

#### Paso 1: Instalar PojavLauncher
1. Descarga PojavLauncher desde [GitHub](https://github.com/PojavLauncherTeam/PojavLauncher/releases)
2. Instala la APK en tu dispositivo Android

#### Paso 2: Configurar Minecraft 1.20.1
1. Abre PojavLauncher
2. Ve a **Settings** → **Game Settings**
3. Selecciona **Java version**: `Java 17`
4. Abre el juego con la versión **1.20.1**

#### Paso 3: Instalar Fabric
1. Descarga el instalador de Fabric desde [fabricmc.net](https://fabricmc.net/use/installer/)
2. En Windows/Linux:
   ```bash
   java -jar fabric-installer-0.14.22.jar client
   ```
3. Selecciona versión **1.20.1**
4. Haz clic en **Install**

#### Paso 4: Copiar el Mod
1. Ve a tu carpeta `.minecraft/mods`
2. Copia el archivo `mc-triggerbot-fabric-1.0.0.jar` aquí

### Opción 2: Minecraft Launcher (PC)

1. Instala Fabric para 1.20.1
2. Abre Minecraft Launcher
3. Selecciona la versión **fabric-loader-1.20.1**
4. Copia el mod en `.minecraft/mods/`
5. ¡Inicia el juego!

## 🎮 Cómo usar

1. **Presiona B** para activar/desactivar el TriggerBot
2. El bot detectará automáticamente enemigos en radio de 3 bloques
3. **Al saltar**: Realiza críticos automáticos
4. **Al caminar/correr**: Golpes normales o barridos
5. Los tiempos de cooldown se respetan automáticamente

## ⚙️ Compilar el Mod

```bash
# Clonar el repositorio
git clone https://github.com/samisitocraft-boop/mc-triggerbot-fabric.git
cd mc-triggerbot-fabric

# Compilar con Gradle
./gradlew build

# El JAR estará en: build/libs/mc-triggerbot-fabric-1.0.0.jar
```

## 📱 Comparativa: PojavLauncher vs Minecraft Launcher

| Característica | PojavLauncher | Minecraft Launcher |
|---|---|---|
| **Plataforma** | Android | Windows/Mac/Linux |
| **Mods** | Soporta | Soporta |
| **Rendimiento** | Bueno (~60 FPS) | Excelente |
| **Facilidad** | Media | Alta |
| **Instalación Fabric** | Manual | Instalador |

### ¿Cuál elegir?
- **PojavLauncher**: Si juegas en Android/tablet
- **Minecraft Launcher**: Si juegas en PC (mejor rendimiento)

## ⚠️ Disclaimer

Este mod está diseñado para uso **solo en servidores privados o locales**. Usar en servidores públicos puede resultar en ban. Respeta los términos de servicio de los servidores.

## 📝 Licencia

MIT License - Puedes usar, modificar y distribuir libremente

## 👨‍💻 Autor

**samisitocraft-boop**

---

¿Problemas? Abre un [issue](https://github.com/samisitocraft-boop/mc-triggerbot-fabric/issues) 🐛
