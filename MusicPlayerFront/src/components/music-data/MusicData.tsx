import { useMusic } from "../../shared/hook/useMusic";
import { DefaultMargin } from "../audio-input/style";
import { LuMusic2 } from "react-icons/lu";
import { FaRegClock } from "react-icons/fa6";
import {
  GeneratedMusicLogContainer,
  GeneratedMusicLogData,
  GeneratedMusicLogSubtitle,
  GeneratedMusicLogWrapper,
  MusicDataIcon,
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
  TitleGeneratedMusicContainer,
  TitleHeader,
} from "./style";

const MusicData: React.FC = () => {
  const { isMusicAvailable,  musicInfo } = useMusic();


  return (
    <DefaultMargin>
      <TitleHeader marginTop="1rem">
        <MusicDataIcon />
        <TitleGeneratedMusicContainer>
          {"Notas Geradas"}
        </TitleGeneratedMusicContainer>
      </TitleHeader>
      {isMusicAvailable ? (
        <>
          <SubtitleMusicInfoContainer>
            <SubtitleMusicInfo>
              <LuMusic2 />
              <span>{musicInfo.numNotes && `${musicInfo.numNotes} notas`}</span>
            </SubtitleMusicInfo>
            <SubtitleMusicInfo>
              <FaRegClock />
              <span>{musicInfo.numNotes && `${musicInfo.duration}s`}</span>
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
                <GeneratedMusicLogData>
                  {`${musicInfo.duration}s`}
                </GeneratedMusicLogData>
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

            <audio
              controls
              src={`data:audio/mp3;base64,${musicInfo.mp3File}`}
              // onLoadedMetadata={(e) => {
              
              //   setDuration(e.currentTarget.duration);
              // }}
            />
          </>
        </>
      ) : (
        // <>
        //   <audio controls style={{ minWidth: "500px" }} src={testeURL} />
        // </>
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
