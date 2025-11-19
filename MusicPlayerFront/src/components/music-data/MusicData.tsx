import { useMusic } from "../../shared/hook/useMusic";
import { DefaultMargin } from "../audio-input/style";
import { TitleContainer } from "../style";
import {
  MusicDataIcon,
  NoDataFoundContainer,
  NoDataFoundIcon,
  NoDataFoundSubtitle,
  NoDataFoundTitle,
  NoDataFoundWrapper,
  TitleHeader,
} from "./style";

const MusicData: React.FC = () => {
  const { octave, bpm, volume, text, isMusicAvailable } = useMusic();
  const base64 =
    "TVRoZAAAAAYAAQABAeBNVHJrAAACTQDAGgD/UQMST4AAwCAA/1EDEk+AALAHMgCQPAAA/1EDEk+AAP9RAxJPgAD/UQMST4AA/1EDEk+AAP9RAxJPgAD/UQMST4AA/1EDEk+AAP9RAxJPgAD/UQMST4AA/1EDEk+AAP9RAxJPgAD/UQMST4AA/1EDEk+AAP9RAxJPgAD/UQMST4AA/1EDEk+AAP9RAxJPgAD/UQMST4AA/1EDEk+AAP9RAwcK4gD/UQMHCuIA/1EDBwriAP9RAwcK4gD/UQMHCuKDYIA8AADAIACwB2QAkDwAg2CAPAAAwCAAsAdkAJBFAINggEUAAMAgALAHZACQRgCDYIBGAADAIACwB2QAkEEAg2CAQQAAwCAAsAdkAJBFAINggEUAAMAgALAHZACQRQCDYIBFAADAfQCwB2QAkEUAg2CARQAAwH0AsAdkAJBFAINggEUAAMB9ALAHZACQTACDYIBMAADAfQCwB2QAkFIAg2CAUgAAwH0AsAdkAJBNAINggE0AAMB9ALAHfwCQTQCDYIBNAADAfQCwB38AkE0Ag2CATQAAwH0AsAd/AJBKAINggEoAAMB9ALAHfwCQSgCDYIBKAADAfQCwBwAAkEoAg2CASgAAwH0AsAcAAJBKAINggEoAAMB9ALAHfwCQSgCDYIBKAADAfQCwB38AkEoAg2CASgAAwH0AsAd/AJBKAINggEoAAMATALAHfwCQSgCDYIBKAADAEwCwB38AkFMAg2CAUwAAwBMAsAd/AJBTAINggFMAAMATALAHfwCQUwCDYIBTAAD/LwA=";

  const baixarMidi = () => {
    const bytes = atob(base64);
    const buffer = new Uint8Array(bytes.length);

    for (let i = 0; i < bytes.length; i++) {
      buffer[i] = bytes.charCodeAt(i);
    }

    const blob = new Blob([buffer], { type: "audio/midi" });
    const url = URL.createObjectURL(blob);

    const a = document.createElement("a");
    a.href = url;
    a.download = "musica.mid";
    a.click();
  };

  return (
    <DefaultMargin>
      <TitleHeader>
        <MusicDataIcon />
        <TitleContainer>{"Notas Geradas"}</TitleContainer>
      </TitleHeader>
      {isMusicAvailable ? (
        <>
          <h2>{text}</h2>
          <h3>{octave}</h3>
          <h3>{bpm}</h3>
          <h3>{volume}</h3>
        </>
      ) : (
        <NoDataFoundWrapper>
          <NoDataFoundContainer>
            <NoDataFoundIcon />
            <NoDataFoundTitle>{"Nenhuma música gerada ainda"}</NoDataFoundTitle>
            <NoDataFoundSubtitle>
              {'Digite um texto e clique em "Gerar Música"'}
            </NoDataFoundSubtitle>
          </NoDataFoundContainer>
        </NoDataFoundWrapper>
      )}
    </DefaultMargin>
  );
};

export default MusicData;
