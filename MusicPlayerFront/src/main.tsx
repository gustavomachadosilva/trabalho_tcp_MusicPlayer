import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./components/App.tsx";
import { AlertContainer } from "./components/style.ts";
import { MusicProvider } from "./shared/context/MusicContext.tsx";

createRoot(document.getElementById("root")!).render(
  <StrictMode>
    <AlertContainer>
      <MusicProvider>
        <App />
      </MusicProvider>
    </AlertContainer>
  </StrictMode>
);
