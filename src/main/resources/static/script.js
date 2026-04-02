const translateBtn = document.getElementById("translateBtn");
const loading      = document.getElementById("loading");
const result       = document.getElementById("result");

translateBtn.addEventListener("click", processLyrics);

async function processLyrics() {
  const text       = document.getElementById("text").value.trim();
  const sourceLang = document.getElementById("sourceLang").value;
  const targetLang = document.getElementById("targetLang").value;

  if (!text) {
    shakeTextarea();
    return;
  }

  result.innerHTML = "";
  loading.classList.remove("hidden");
  translateBtn.disabled = true;

  try {
    const response = await fetch("/lyrics/process", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ text, sourceLang, targetLang }),
    });

    if (!response.ok) throw new Error(`Server error: ${response.status}`);

    const data = await response.json();
    renderVerses(data.verses, sourceLang);

  } catch (err) {
    console.error(err);
    showError("Something went wrong. Please try again.");
  } finally {
    loading.classList.add("hidden");
    translateBtn.disabled = false;
  }
}

function renderVerses(verses, sourceLang) {
  verses.forEach((v, i) => {
    const audioUrl = `/tts/audio?text=${encodeURIComponent(v.origin)}&lang=${sourceLang}`;

    const div = document.createElement("div");
    div.className = "verse";
    div.style.animationDelay = `${i * 60}ms`;

    div.innerHTML = `
      <div class="original">
        <span>${escapeHtml(v.origin)}</span>
        <button aria-label="Play pronunciation" title="Listen">🔊</button>
      </div>
      <div class="divider"></div>
      <div class="translated">${escapeHtml(v.translated)}</div>
    `;

    div.querySelector("button").addEventListener("click", () => {
      const audio = new Audio(audioUrl);
      audio.play().catch(() => showError("Audio playback failed."));
    });

    result.appendChild(div);
  });
}

/* ── Helpers ────────────────────────────────────── */

function escapeHtml(str) {
  return str
    .replace(/&/g, "&amp;")
    .replace(/</g, "&lt;")
    .replace(/>/g, "&gt;")
    .replace(/"/g, "&quot;");
}

function shakeTextarea() {
  const ta = document.getElementById("text");
  ta.style.borderColor = "#e05555";
  ta.style.animation = "none";

  // tiny shake
  let start = null;
  const duration = 300;
  const intensity = 6;

  function step(ts) {
    if (!start) start = ts;
    const elapsed = ts - start;
    const progress = elapsed / duration;
    if (progress < 1) {
      ta.style.transform = `translateX(${Math.sin(progress * Math.PI * 6) * intensity * (1 - progress)}px)`;
      requestAnimationFrame(step);
    } else {
      ta.style.transform = "";
      ta.style.borderColor = "";
      ta.focus();
    }
  }
  requestAnimationFrame(step);
}

function showError(msg) {
  const div = document.createElement("div");
  div.className = "verse";
  div.style.borderColor = "rgba(224,85,85,0.4)";
  div.style.color = "#e88";
  div.textContent = `⚠ ${msg}`;
  result.appendChild(div);
}
