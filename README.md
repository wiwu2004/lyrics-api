# 🎧 Lyrics API

## 📖 Description
Lyrics API is a reactive REST service built with **Java + Spring Boot**, capable of processing song lyrics, automatically splitting them into verses, and translating each verse **in parallel** using WebFlux.  
The API serves as a foundation for language‑learning through music, allowing users to read the original text, its translation, and in the future, audio (TTS).

---

## 🎯 Objectives
- Process full song lyrics sent by the user  
- Automatically split text into verses (`\n`)  
- Translate each verse individually  
- Execute multiple translations in parallel  
- Maintain the original order of verses  
- Prepare data structure for Text‑to‑Speech  
- Return clean and structured JSON  

---

## 🚀 Features
- Receives full song lyrics as input  
- Automatically splits into lines  
- Cleans and normalizes spaces  
- Translates each verse using **Langbly API**  
- Uses **WebFlux + WebClient** for real parallel processing  
- Maintains verse order using `flatMapSequential`  
- Final structure includes:  
  - `origin`  
  - `translated`  
  - `audioUrl` (future implementation)  

---

## 🛠 Technologies
- **Java 17+**  
- **Spring Boot**  
- **Spring WebFlux**  
- **Project Reactor (Flux/Mono)**  
- **WebClient**  
- **Maven**  
- **Lombok**  
- **Langbly Translation API**  

---

## 🔌 Langbly API Configuration
In the `application.properties` file:
```properties
langbly.api.key=${LANGBLY_API_KEY}
```

Environment variable:
```bash
setx LANGBLY_API_KEY "your_key_here"
```

---

## 📡 Endpoint
### ▶️ POST `/lyrics/process`

---

## 📥 Request Example
```json
{
  "text": "Hello darkness my old friend\nI've come to talk with you again",
  "sourceLang": "en",
  "targetLang": "pt"
}
```

---

## 📤 Response Example
```json
{
  "verses": [
    {
      "origin": "Hello darkness my old friend",
      "translated": "Olá escuridão minha velha amiga",
      "audioUrl": null
    },
    {
      "origin": "I've come to talk with you again",
      "translated": "Eu vim falar com você novamente",
      "audioUrl": null
    }
  ]
}
```

---

## 🔄 Processing Flow
1. The API receives the full lyrics  
2. Splits text into lines using `split("\n")`  
3. Removes empty or invalid lines  
4. Converts all lines into a `Flux<String>`  
5. Translates each verse **in parallel** using `flatMap`  
6. Preserves the original order using `flatMapSequential`  
7. Collects all verses into a list with `collectList()`  
8. Returns a structured `LyricsResponse`  

---

## ⚠️ Notes
- The user must provide the lyrics (copyright reasons)  
- Translation API may incur costs  
- Project created for educational and portfolio purposes  

---

## 👨‍💻 Author
Developed by **Willian Wu**

---

## 📌 Current Status
🚀 Reactive parallel translation functional  
🔧 Continuous improvements in progress  
