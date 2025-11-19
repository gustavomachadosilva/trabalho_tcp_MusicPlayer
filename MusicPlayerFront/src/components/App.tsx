// import { useEffect, useState } from "react";
// import { AudioService } from "../shared/services/api/audio/Audio";
import Header from "./header/Header";
import ColumnContainer from "./columns/column-container/ColumnContainer";
import { AlertProvider } from "../shared/context/AlertContext";
import Alert from "./alert/Alert";

const App = () => {
  // const { getAudio } = AudioService;
  // const [audioSrc, setAudioSrc] = useState("");

  // const handleAudioRequest = async () => {
  //   const result = await getAudio();

  //   if (result.Success) {
  //     setAudioSrc(result.Data);
  //   } else {
  //     console.error(result.Message);
  //     // Tratar o erro adequadamente
  //   }
  // };

  // useEffect(() => {
  //   // handleAudioRequest();
  //   if (audioSrc) {
  //     URL.revokeObjectURL(audioSrc);
  //   }
  // }, []);

  return (
    <AlertProvider>
      <Alert />
      <Header
        subtitle="Digite um texto e converta-o em uma sequência de notas musicais usando parâmetros personalizáveis"
        children="Gerador de Música a partir de Texto"
      />

      <ColumnContainer />

      {/* <div style={{ textAlign: "center", marginTop: "3rem" }}>
        <h1>Reprodutor de Áudio 🎶</h1>

        {audioSrc ? (
          <audio
            controls
            style={{ minWidth: "500px" }}
            ref={audioRef}
            src={audioSrc}
          />
        ) : (
          <></>
        )}
      </div> */}
    </AlertProvider>
  );
};

export default App;
