import { useAlert } from "../../../shared/hook/useAlert";
import AudioInput from "../../audio-input/AudioInput";
import MusicDetails from "../music-details/MusicDetails";
import {
  BottomSideContainer,
  ColumnLeftWrapper,
  TopSideContainer,
} from "./style";
import { useMusic } from "../../../shared/hook/useMusic";

const ColumnLeft: React.FC = () => {
  const { text, setText, setBpm, setOctave, setVolume, postGeneratedMusic } =
    useMusic();
  const { setAlert, closeAlert } = useAlert();

  const handleGenerateMusic = async (
    bpm: number,
    octave: number,
    volume: number
  ) => {
    if (!text.length) {
      setAlert("Por favor insira um texto no input de música", "error");
    } else {
      closeAlert();
      setBpm(bpm);
      setOctave(octave);
      setVolume(volume);
      await postGeneratedMusic();
    }
  };

  return (
    <ColumnLeftWrapper>
      <TopSideContainer>
        <AudioInput
          setTypedMusic={setText}
          placeholder="Digite o texto que será convertido em música..."
          title="Texto de Entrada"
        />
      </TopSideContainer>
      <BottomSideContainer>
        <MusicDetails
          title="Parâmetros Musicais"
          handleGenerateMusic={handleGenerateMusic}
        />
      </BottomSideContainer>
    </ColumnLeftWrapper>
  );
};

export default ColumnLeft;
