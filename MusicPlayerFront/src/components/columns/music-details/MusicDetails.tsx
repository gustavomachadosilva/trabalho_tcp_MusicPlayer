import React, { useEffect, useState } from "react";
import {
  GearIcon,
  MusicDetailsContainer,
  MusicDetailsTitleContainer,
  MusicScaleAndTunerContainer,
  MusicScaleAndTunerHolder,
  RangeInformationContainer,
  RangeInput,
  RangeInputContainer,
} from "./style";
import {
  BorderWrapper,
  MediumLabel,
  SmallSpan,
  OptionElement,
  SelectElement,
  TitleContainer,
  ButtonContainer,
  Button,
} from "../../style";
import { CiMusicNote1 } from "react-icons/ci";

interface IProps {
  title: string;
}

const MusicDetails: React.FC<React.PropsWithChildren<IProps>> = ({ title }) => {
  const [tempo, setTempo] = useState(120);
  const [octave, setOctave] = useState(4);
  const [noteDuration, setNoteDuration] = useState(0.5);
  const [scale, setScale] = useState("");
  const [key, setKey] = useState("");
  const [scaleOptions, setScaleOptions] = useState<
    { value: string; name: string }[]
  >([]);
  const [tuningOptions, setTuningOptions] = useState<
    { value: string; name: string }[]
  >([]);

  useEffect(() => {
    setScaleOptions([
      {
        value: "maior",
        name: "Maior",
      },
      {
        value: "menor",
        name: "Menor",
      },
      {
        value: "pentatonica",
        name: "Pentatônica",
      },
      {
        value: "blues",
        name: "Blues",
      },
    ]);

    setTuningOptions([
      {
        value: "A",
        name: "A (Lá)",
      },
      {
        value: "B",
        name: "B (Si)",
      },
      {
        value: "C",
        name: "C (Dó)",
      },
      {
        value: "D",
        name: "D (Ré)",
      },
      {
        value: "E",
        name: "E (Mi)",
      },
      {
        value: "F",
        name: "F (Fá)",
      },
      {
        value: "G",
        name: "G (Sol)",
      },
    ]);
  }, []);

  return (
    <BorderWrapper>
      <MusicDetailsContainer>
        <MusicDetailsTitleContainer>
          <GearIcon />
          <TitleContainer>{title}</TitleContainer>
        </MusicDetailsTitleContainer>

        <MusicScaleAndTunerContainer>
          <MusicScaleAndTunerHolder>
            <MediumLabel>Escala Musical</MediumLabel>
            <SelectElement
              value={scale}
              onChange={(e) => setScale(e.target.value)}
              disabled={scaleOptions.length == 0}
            >
              {!scale && <OptionElement value="" disabled hidden />}
              {scaleOptions.map((index) => (
                <OptionElement value={index.value}>{index.name}</OptionElement>
              ))}
            </SelectElement>
          </MusicScaleAndTunerHolder>

          <MusicScaleAndTunerHolder>
            <MediumLabel>Tonalidade</MediumLabel>
            <SelectElement
              value={key}
              onChange={(e) => setKey(e.target.value)}
              disabled={tuningOptions.length == 0}
            >
              {!key && <OptionElement value="" disabled hidden />}
              {tuningOptions.map((index) => (
                <OptionElement value={index.value}>{index.name}</OptionElement>
              ))}
            </SelectElement>
          </MusicScaleAndTunerHolder>
        </MusicScaleAndTunerContainer>

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
            min={2}
            max={6}
            value={octave}
            onChange={(e) => setOctave(Number(e.target.value))}
          />
          <RangeInformationContainer>
            <SmallSpan>Grave (2)</SmallSpan>
            <SmallSpan>Agudo (6)</SmallSpan>
          </RangeInformationContainer>
        </RangeInputContainer>

        <RangeInputContainer>
          <MediumLabel>Duração da Nota: {noteDuration}s</MediumLabel>
          <RangeInput
            type="range"
            min={0.1}
            max={2}
            step={0.1}
            value={noteDuration}
            onChange={(e) => setNoteDuration(Number(e.target.value))}
          />
          <RangeInformationContainer>
            <SmallSpan>Curta (0.1s)</SmallSpan>
            <SmallSpan>Longa (2.0s)</SmallSpan>
          </RangeInformationContainer>
        </RangeInputContainer>
        <ButtonContainer>
          <Button>
            <CiMusicNote1 />
            Gerar Musica
          </Button>
        </ButtonContainer>
      </MusicDetailsContainer>
    </BorderWrapper>
  );
};

export default MusicDetails;
