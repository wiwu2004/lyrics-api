# 🎧 Lyrics API

## 📖 Description

Lyrics API is a RESTful service developed in **Java with Spring Boot** that processes song lyrics and transforms them into a structured format to support language learning.

The application receives a full song lyric, automatically splits it into verses, and prepares each line for translation and audio generation. This enables a learning experience where users can read the original text alongside its translation and, in future versions, listen to the pronunciation of each verse.

---

## 🎯 Objective

The main goal of this project is to provide a backend service capable of:

- Processing raw song lyrics
- Structuring text into individual verses
- Supporting translation of each verse
- Enabling audio generation per verse (Text-to-Speech)

This API serves as the foundation for a platform focused on learning languages through music.

---

## 🚀 Features

- Receive full song lyrics as input
- Automatically split lyrics into verses
- Clean and normalize text (remove empty lines and extra spaces)
- Return structured data for each verse
- Prepare data for translation and audio integration

---

## 🛠️ Technologies

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Lombok**
- **Maven**

---

## 📌 API Endpoint

### ▶️ Process Lyrics

**POST** `/lyrics/process`

---

## 📥 Request

```json
{
  "text": "Hello, how are you?\nI'm fine, thank you.",
  "sourceLang": "en",
  "targetLang": "pt"
}
```

---

## 📤 Response

```json
{
  "verses": [
    {
      "original": "Hello, how are you?",
      "translated": null,
      "audioUrl": null
    },
    {
      "original": "I'm fine, thank you.",
      "translated": null,
      "audioUrl": null
    }
  ]
}
```

---

## 🔄 Processing Flow

1. The API receives the full lyrics text  
2. The text is split into individual lines (verses)  
3. Each line is cleaned and validated  
4. A structured response is created for each verse  
5. (Future) Each verse will be translated and converted to audio  

---

## 📁 Project Structure

```
controller/
service/
dto/
client/
```

---

## 🔮 Future Improvements

- 🌍 Integration with translation APIs (Google Translate / DeepL)  
- 🔊 Text-to-Speech (TTS) for audio playback  
- 💾 Database integration for storing processed lyrics  
- 🔐 Authentication and user management (JWT)  
- 🎵 Integration with lyrics/music APIs  
- 📱 Frontend application (React)  

---

## ⚠️ Notes

- This project is for educational and portfolio purposes  
- Lyrics should be provided by the user to avoid copyright issues  
- External API usage may introduce costs in future versions  

---

## 👨‍💻 Author

Developed by **Willian Wu**

---

## 📌 Status

🚧 In development — core processing functionality implemented
