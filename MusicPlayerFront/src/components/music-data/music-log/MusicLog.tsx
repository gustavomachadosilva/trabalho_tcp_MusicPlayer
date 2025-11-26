import { LuMusic2 } from "react-icons/lu";
import { FaRegClock } from "react-icons/fa6";
import {
  AudioPlayer,
  GeneratedMusicLogContainer,
  GeneratedMusicLogData,
  GeneratedMusicLogSubtitle,
  GeneratedMusicLogWrapper,
  NoDataFoundContainer,
  NoDataFoundIcon,
  NoDataFoundSubtitle,
  NoDataFoundTitle,
  NoDataFoundWrapper,
  NoteDetailItem,
  NoteInfo,
  NoteLabel,
  NoteMetrics,
  NotesDetailsContainer,
  NoteText,
  SubtitleMusicInfo,
  SubtitleMusicInfoContainer,
  MusicLogAndButtonSpaceBetween,
  TitleGeneratedMusicContainer,
  TitleHeader,
  DownloadAndPlayerContainer,
} from "../style";
import { useState } from "react";
import { useMusic } from "../../../shared/hook/useMusic";
import { Button, ButtonContainer } from "../../style";

const MusicLog: React.FC = () => {
  const { isMusicAvailable, musicInfo } = useMusic();
  const [duration, setDuration] = useState(0);

  const downloadMidiFromBase64 = () => {
    const base64 = musicInfo.midiFile;
    const fileName = "musica.mid";

    const byteCharacters = atob(base64);
    const byteNumbers = new Array(byteCharacters.length)
      .fill(0)
      .map((_, i) => byteCharacters.charCodeAt(i));
    const byteArray = new Uint8Array(byteNumbers);

    const blob = new Blob([byteArray], { type: "audio/midi" });

    const link = document.createElement("a");
    const url = URL.createObjectURL(blob);
    link.href = url;
    link.download = fileName;
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);

    setTimeout(() => URL.revokeObjectURL(url), 100);
  };

  return (
    <>
      {isMusicAvailable ? (
        <>
          <SubtitleMusicInfoContainer>
            <SubtitleMusicInfo>
              <LuMusic2 />
              <span>{musicInfo.numNotes && `${musicInfo.numNotes} notas`}</span>
            </SubtitleMusicInfo>
            <SubtitleMusicInfo>
              <FaRegClock />
              <span>{duration > 0 && `${duration}s`}</span>
            </SubtitleMusicInfo>
          </SubtitleMusicInfoContainer>

          <>
            <GeneratedMusicLogWrapper>
              <GeneratedMusicLogContainer>
                <GeneratedMusicLogData>
                  {musicInfo.numNotes}
                </GeneratedMusicLogData>
                <GeneratedMusicLogSubtitle>
                  Total de Notas
                </GeneratedMusicLogSubtitle>
              </GeneratedMusicLogContainer>

              <GeneratedMusicLogContainer>
                <GeneratedMusicLogData>
                  {musicInfo.numPauses}
                </GeneratedMusicLogData>
                <GeneratedMusicLogSubtitle>Pausas</GeneratedMusicLogSubtitle>
              </GeneratedMusicLogContainer>

              <GeneratedMusicLogContainer>
                <GeneratedMusicLogData>{`${duration}s`}</GeneratedMusicLogData>
                <GeneratedMusicLogSubtitle>Duração</GeneratedMusicLogSubtitle>
              </GeneratedMusicLogContainer>
            </GeneratedMusicLogWrapper>
          </>
          <>
            <TitleHeader marginTop="1rem">
              <TitleGeneratedMusicContainer>
                {"Detalhes das Notas"}
              </TitleGeneratedMusicContainer>
            </TitleHeader>
            <MusicLogAndButtonSpaceBetween>
              <NotesDetailsContainer>
                {musicInfo.logRegister &&
                  musicInfo.logRegister.map((value, index) => (
                    <NoteDetailItem key={index}>
                      <NoteInfo>
                        <NoteText>{index + 1}</NoteText>
                        <NoteLabel>{value.note}</NoteLabel>
                        <NoteMetrics>
                          <span>{value.instrument}</span>
                          <span>Oitava: {value.octave}</span>
                        </NoteMetrics>
                      </NoteInfo>
                    </NoteDetailItem>
                  ))}
              </NotesDetailsContainer>

              <DownloadAndPlayerContainer>
                <AudioPlayer
                  controls
                  src={`data:audio/mp3;base64,${musicInfo.mp3File}`}
                  onLoadedMetadata={(e) => {
                    setDuration(Number(e.currentTarget.duration.toFixed(1)));
                  }}
                />
                <ButtonContainer>
                  <Button onClick={downloadMidiFromBase64}>Download</Button>
                </ButtonContainer>
              </DownloadAndPlayerContainer>
            </MusicLogAndButtonSpaceBetween>
          </>
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
    </>
  );
};

export default MusicLog;
