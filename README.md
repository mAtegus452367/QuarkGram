<div align="center">

<img src="assets/logo.png" width="160" alt="QuarkGram">

# QuarkGram

**Независимый клиент Telegram для Android**
с гибкой настройкой, плагинами на Python и контролем разрешений

[![Канал](https://img.shields.io/badge/Telegram-@quarkgram-2CA5E0?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/quarkgram)
[![Android](https://img.shields.io/badge/Android-arm64--v8a%20%7C%20x86__64-3DDC84?style=for-the-badge&logo=android&logoColor=white)](#сборка)
[![Лицензия](https://img.shields.io/badge/license-GPLv3-blue?style=for-the-badge)](LICENSE)
[![Сборка](https://img.shields.io/github/actions/workflow/status/mAtegus452367/QuarkGram/release.yml?style=for-the-badge&label=build)](https://github.com/mAtegus452367/QuarkGram/actions)

[Что это](#что-это) · [Возможности](#возможности) · [Сборка](#сборка) · [Благодарности](#благодарности) · [English](#english)

</div>

---

## Что это

QuarkGram развивается как форк [exteraless](https://github.com/exteraless/exteraless), а тот,
в свою очередь, основан на [NagramX](https://github.com/risin42/NagramX).

> [!NOTE]
> Проект в **бете**. Часть возможностей исходных проектов ещё не перенесена или может
> работать нестабильно. Нашли проблему или не хватает функции — откройте issue или напишите в
> [канал](https://t.me/quarkgram).

## Возможности

| | |
|---|---|
| 🧩 **Плагины на Python** | Движок плагинов с моделью разрешений: плагин заранее объявляет, что ему нужно, это видно на экране установки, и он получает только заявленное |
| 🎨 **Оформление** | Подробные настройки внешнего вида и чатов, наборы иконок, выбор иконки приложения |
| 💊 **Pill Stack** | Полоса «пилюль» с быстрыми действиями |
| ☰ **Боковое меню** | Настраиваемый состав и порядок пунктов |
| ⚙️ **Экраны настроек** | Параметры чатов, интерфейса и поведения приложения |

### Ссылки

- 📢 Канал: [@quarkgram](https://t.me/quarkgram)
- 💻 Исходники: [github.com/mAtegus452367/QuarkGram](https://github.com/mAtegus452367/QuarkGram)
- 🌱 Основа: [exteraless](https://github.com/exteraless/exteraless)

---

## Сборка

### Быстрый старт

1. **Склонируйте репозиторий вместе с подмодулями:**

   ```bash
   git clone --recursive --shallow-submodules https://github.com/mAtegus452367/QuarkGram.git QuarkGram
   ```

   Если репозиторий уже склонирован без подмодулей:

   ```bash
   git submodule update --init --recursive --depth=1
   ```

2. **Получите ключи Telegram API** на [my.telegram.org](https://my.telegram.org/auth) и создайте
   `local.properties` в корне проекта:

   ```properties
   TELEGRAM_APP_ID=<ваш_app_id>
   TELEGRAM_APP_HASH=<ваш_app_hash>
   ```

   > Не публикуйте `local.properties` и не коммитьте его: в нём ваш `api_hash`.

3. **Подпись APK (необязательно).** Положите свой `TMessagesProj/release.keystore` и допишите
   в `local.properties`:

   ```properties
   KEYSTORE_PASS=<пароль_хранилища>
   ALIAS_NAME=<имя_ключа>
   ALIAS_PASS=<пароль_ключа>
   ```

   Ключа в репозитории нет намеренно. Без него сборка не падает: APK подписывается
   отладочным ключом Android.

4. **Push-уведомления (необязательно).** Положите свой `TMessagesProj/google-services.json`
   (Firebase, имя пакета `com.quarkgram.app`).

5. **Метаданные проекта (необязательно):**

   - ключ Google Maps в записи `com.google.android.maps.v2.API_KEY` в
     `TMessagesProj/src/main/AndroidManifest.xml`;
   - `BaseRemoteHelper.CHANNEL_METADATA_ID` — числовой id вашего канала метаданных, без
     префикса `-100`.

6. **Соберите:**

   ```bash
   ./gradlew :TMessagesProj:assembleDebug
   ```

   Или откройте проект в Android Studio.

<details>
<summary><b>Про ABI и переменную NATIVE_TARGET</b></summary>

<br>

Собираются только 64-битные `arm64-v8a` и `x86_64`: Chaquopy собирает Python 3.12 лишь под
них, и на `armeabi-v7a` конфигурация обрывается. Переменная `NATIVE_TARGET` задаёт цель:

| Значение | Что собирается |
|---|---|
| `arm64-v8a` | один ABI, быстрее всего |
| `universal` | оба ABI |
| `SKIP` | без нативной части, только Java и ресурсы |

</details>

### Сборка через GitHub Actions

Нужны два секрета репозитория (Settings → Secrets and variables → Actions):

| Секрет | Что в нём | Как получить |
|---|---|---|
| `LOCAL_PROPERTIES` | содержимое `local.properties` в base64 | `base64 -w0 local.properties` |
| `RELEASE_KEYSTORE` | файл ключа в base64 (необязательно) | `base64 -w0 TMessagesProj/release.keystore` |

Затем запустите workflow **Release Build** (Actions → Release Build → Run workflow). Готовый
APK лежит в артефактах прогона. Без `RELEASE_KEYSTORE` сборка подпишется отладочным ключом.

---

## Авторы дизайна

Иконки и оформление, унаследованные от exteraGram, созданы его дизайнером —
[@the8055u](https://t.me/the8055u) и студией [@BlueprintDsgn](https://t.me/BlueprintDsgn).
Права на эти материалы принадлежат авторам.

## Благодарности

QuarkGram стоит на плечах этих проектов:

- [exteraless](https://github.com/exteraless/exteraless)
- [exteraGram](https://github.com/exteraSquad/exteraGram)
- [NagramX](https://github.com/risin42/NagramX) и [Nagram](https://github.com/NextAlone/Nagram)
- [Nekogram](https://github.com/Nekogram/Nekogram)
- [Cherrygram](https://github.com/arsLan4k1390/Cherrygram)
- [OctoGram](https://github.com/OctoGramApp/OctoGram)
- [Inugram](https://github.com/teidesu/inugram)
- [AyuGram](https://github.com/AyuGram/AyuGram4A) и [Dr4iv3rNope](https://github.com/Dr4iv3rNope/NotSoAndroidAyuGram)
- [Telegram для Android](https://github.com/DrKLO/Telegram)

## Лицензия

Исходный код распространяется на условиях [GNU GPL v3](LICENSE), как и проекты, на которых он основан.

---

## English

<details>
<summary><b>Show English version</b></summary>

<br>

### What this is

QuarkGram is a standalone Telegram client for Android, developed as a fork of
[exteraless](https://github.com/exteraless/exteraless), which is itself based on
[NagramX](https://github.com/risin42/NagramX).

> [!NOTE]
> The project is in **beta**. Some features of the upstream projects have not been ported
> yet or may be unstable. If you find a problem or miss a feature, open an issue or write to
> the [channel](https://t.me/quarkgram).

### Highlights

- **Python plugins** with a permission model: a plugin declares what it needs, you see that
  on the install sheet, and it gets only what was declared.
- **Appearance and chat settings**, icon packs, selectable app icon.
- **Pill Stack** with quick actions and a **customizable side menu**.

### Building

1. Clone with submodules:

   ```bash
   git clone --recursive --shallow-submodules https://github.com/mAtegus452367/QuarkGram.git QuarkGram
   ```

2. Get `TELEGRAM_APP_ID` and `TELEGRAM_APP_HASH` from [my.telegram.org](https://my.telegram.org/auth)
   and put them into `local.properties` in the project root. Never commit this file.

3. Optional release signing: drop your own `TMessagesProj/release.keystore` and add
   `KEYSTORE_PASS`, `ALIAS_NAME`, `ALIAS_PASS` to `local.properties`. Without a keystore the
   build is signed with the Android debug key.

4. Optional push notifications: replace `TMessagesProj/google-services.json` with your own
   Firebase config for `com.quarkgram.app`.

5. Build with `./gradlew :TMessagesProj:assembleDebug` or from Android Studio.

Only 64-bit ABIs are built (`arm64-v8a`, `x86_64`): Chaquopy ships Python 3.12 for those
only, and `armeabi-v7a` fails at configuration time. `NATIVE_TARGET` selects the target:
`arm64-v8a`, `universal` (both) or `SKIP` (no native part).

**GitHub Actions.** Set the repository secrets `LOCAL_PROPERTIES` and (optionally)
`RELEASE_KEYSTORE`, both base64-encoded, then run the **Release Build** workflow. The APK ends
up in the run artifacts.

### Design credits

Icons and visual design inherited from exteraGram are the work of its designer,
[@the8055u](https://t.me/the8055u), and the [@BlueprintDsgn](https://t.me/BlueprintDsgn)
studio. Rights to those materials belong to their authors.

### License

Distributed under the [GNU GPL v3](LICENSE), like the projects it is based on.

</details>
