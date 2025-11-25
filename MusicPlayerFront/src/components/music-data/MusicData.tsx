import { DefaultMargin } from "../audio-input/style";
import { useState } from "react";
import { FaInfoCircle } from "react-icons/fa";
import { FaCirclePlay } from "react-icons/fa6";
import MusicLog from "./MusicLog/MusicLog";
import {
  MusicDataIcon,
  MusicOptionsToggle,
  TitleGeneratedMusicContainer,
  TitleHeader,
} from "./style";

const MusicData: React.FC = () => {
  const [isInfo, setIsInfo] = useState(false);

  return (
    <DefaultMargin>
      <TitleHeader marginTop="1rem">
        <MusicDataIcon />
        <TitleGeneratedMusicContainer>
          {"Notas Geradas"}
        </TitleGeneratedMusicContainer>
        <MusicOptionsToggle>
          {isInfo ? (
            <FaCirclePlay className="icon" onClick={() => setIsInfo(false)} />
          ) : (
            <FaInfoCircle className="icon" onClick={() => setIsInfo(true)} />
          )}
        </MusicOptionsToggle>
      </TitleHeader>
      {isInfo ? <></> : <MusicLog />}
    </DefaultMargin>
  );
};

export default MusicData;
