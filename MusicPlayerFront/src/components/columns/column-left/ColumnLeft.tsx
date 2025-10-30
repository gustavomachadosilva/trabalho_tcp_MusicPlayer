import AudioInput from "../../audio-input/AudioInput";
import MusicDetails from "../music-details/MusicDetails";
import {
  BottomSideContainer,
  ColumnLeftWrapper,
  TopSideContainer,
} from "./style";

const ColumnLeft: React.FC = () => {
  return (
    <ColumnLeftWrapper>
      <TopSideContainer>
        <AudioInput
          placeholder="Digite o texto que será convertido em música..."
          title="Texto de Entrada"
        />
      </TopSideContainer>

      <BottomSideContainer>
        <MusicDetails title="Parâmetros Musicais"/>
      </BottomSideContainer>
    </ColumnLeftWrapper>
  );
};

export default ColumnLeft;
