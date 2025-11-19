import React, { useState } from "react";
import {
  GearIcon,
  MusicDetailsContainer,
  MusicDetailsTitleContainer,
  RangeInformationContainer,
  RangeInput,
  RangeInputContainer,
} from "./style";
import {
  BorderWrapper,
  MediumLabel,
  SmallSpan,
  TitleContainer,
  ButtonContainer,
  Button,
} from "../../style";
import { CiMusicNote1 } from "react-icons/ci";

interface IProps {
  title: string;
  handleGenerateMusic: (tempo: number, octave: number, volume: number) => void;
}

const MusicDetails: React.FC<React.PropsWithChildren<IProps>> = ({
  title,
  handleGenerateMusic,
}) => {
  const [tempo, setTempo] = useState(120);
  const [octave, setOctave] = useState(4);
  const [volume, setVolume] = useState(50);

  const handleGenerateClick = () => {
    handleGenerateMusic(tempo, octave, volume);

  };

  return (
    <BorderWrapper>
      <MusicDetailsContainer>
        <MusicDetailsTitleContainer>
          <GearIcon />
          <TitleContainer>{title}</TitleContainer>
        </MusicDetailsTitleContainer>
        <RangeInputContainer>
          <MediumLabel>Tempo (BPM): {tempo}</MediumLabel>
          <RangeInput
            type="range"
            min={60}
            max={200}
            value={tempo}
            onChange={(e) => setTempo(Number(e.target.value))}
          />
          <RangeInformationContainer>
            <SmallSpan>Lento (60)</SmallSpan>
            <SmallSpan>Rápido (200)</SmallSpan>
          </RangeInformationContainer>
        </RangeInputContainer>

        <RangeInputContainer>
          <MediumLabel>Oitava Base: {octave}</MediumLabel>
          <RangeInput
            type="range"
            min={1}
            max={8}
            value={octave}
            onChange={(e) => setOctave(Number(e.target.value))}
          />
          <RangeInformationContainer>
            <SmallSpan>Grave (1)</SmallSpan>
            <SmallSpan>Agudo (8)</SmallSpan>
          </RangeInformationContainer>
        </RangeInputContainer>

        <RangeInputContainer>
          <MediumLabel>Volume: {volume}</MediumLabel>
          <RangeInput
            type="range"
            min={0}
            max={127}
            step={1}
            value={volume}
            onChange={(e) => setVolume(Number(e.target.value))}
          />
          <RangeInformationContainer>
            <SmallSpan>Baixo (0)</SmallSpan>
            <SmallSpan>Alto (127)</SmallSpan>
          </RangeInformationContainer>
        </RangeInputContainer>
        <ButtonContainer>
          <Button onClick={handleGenerateClick}>
            <CiMusicNote1 />
            Gerar Música
          </Button>
        </ButtonContainer>
      </MusicDetailsContainer>
    </BorderWrapper>
  );
};

export default MusicDetails;
