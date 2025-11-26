import { DefaultMargin } from "../audio-input/style";
import { useState } from "react";
import { FaInfoCircle } from "react-icons/fa";
import { FaCirclePlay } from "react-icons/fa6";
import MusicLog from "./music-log/MusicLog";
import {
  MusicDataIcon,
  MusicInfoIcon,
  MusicOptionsToggle,
  TitleGeneratedMusicContainer,
  TitleHeader,
} from "./style";
import GuideLog from "./guide-log/GuideLog";

const MusicData: React.FC = () => {
  const [isInfo, setIsInfo] = useState(false);

  return (
    <DefaultMargin>
      <TitleHeader marginTop="1rem">
        {isInfo ? <MusicInfoIcon /> : <MusicDataIcon />}
        <TitleGeneratedMusicContainer>
          {isInfo ? "Guia de Mapeamento Pré-definido" : "Notas Geradas"}
        </TitleGeneratedMusicContainer>
        <MusicOptionsToggle>
          {isInfo ? (
            <FaCirclePlay className="icon" onClick={() => setIsInfo(false)} />
          ) : (
            <FaInfoCircle className="icon" onClick={() => setIsInfo(true)} />
          )}
        </MusicOptionsToggle>
      </TitleHeader>
      {isInfo ? <GuideLog /> : <MusicLog />}
    </DefaultMargin>
  );
};

export default MusicData;
