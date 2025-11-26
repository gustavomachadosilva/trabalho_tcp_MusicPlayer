import React from "react";
import { FiMusic, FiSliders, FiSettings, FiInfo } from "react-icons/fi";
import {
  GuideContainer,
  GuideItemBlock,
  GuideItemContainer,
  GuideItemInfoText,
  GuideScrollArea,
  GuideSection,
  GuideTitle,
} from "../style";

const GuideLog: React.FC = () => {
  return (
    <GuideContainer>
      <GuideScrollArea>
        <GuideSection>
          <GuideTitle>
            <FiMusic /> Notas Musicais
          </GuideTitle>

          <GuideItemContainer>
            <GuideItemBlock>A</GuideItemBlock>
            <GuideItemInfoText>Nota Lá</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>B</GuideItemBlock>
            <GuideItemInfoText>Nota Si</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>C</GuideItemBlock>
            <GuideItemInfoText>Nota Dó</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>D</GuideItemBlock>
            <GuideItemInfoText>Nota Ré</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>E</GuideItemBlock>
            <GuideItemInfoText>Nota Mi</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>F</GuideItemBlock>
            <GuideItemInfoText>Nota Fá</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>G</GuideItemBlock>
            <GuideItemInfoText>Nota Sol</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>H</GuideItemBlock>
            <GuideItemInfoText>Nota Si Bemol</GuideItemInfoText>
          </GuideItemContainer>
        </GuideSection>

        <GuideSection>
          <GuideTitle>
            <FiSliders /> Silêncio e Controle
          </GuideTitle>
          <GuideItemContainer>
            <GuideItemBlock>;</GuideItemBlock>
            <GuideItemInfoText>Silêncio</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>?</GuideItemBlock>
            <GuideItemInfoText>Troca nota aleatória</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock width="70px">Espaço</GuideItemBlock>
            <GuideItemInfoText>Dobra volume (máx: 200%)</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock width="100">BPM+</GuideItemBlock>
            <GuideItemInfoText>Aumenta BPM em 80 unidades</GuideItemInfoText>
          </GuideItemContainer>
        </GuideSection>

        <GuideSection>
          <GuideTitle>
            <FiSettings /> Mudanças de Instrumento
          </GuideTitle>
          <GuideItemContainer>
            <GuideItemBlock width="110px">Nova linha</GuideItemBlock>
            <GuideItemInfoText>
              Troca Instrumento aleatoriamente
            </GuideItemInfoText>
          </GuideItemContainer>
        </GuideSection>

        <GuideSection>
          <GuideTitle>
            <FiInfo /> Controles de Oitava
          </GuideTitle>
          <GuideItemContainer>
            <GuideItemBlock>+</GuideItemBlock>
            <GuideItemInfoText>Aumenta uma Oitava</GuideItemInfoText>
          </GuideItemContainer>
          <GuideItemContainer>
            <GuideItemBlock>-</GuideItemBlock>
            <GuideItemInfoText>Diminui uma Oitava</GuideItemInfoText>
          </GuideItemContainer>
        </GuideSection>
      </GuideScrollArea>
    </GuideContainer>
  );
};

export default GuideLog;
