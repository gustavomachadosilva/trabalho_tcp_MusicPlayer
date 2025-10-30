import React, { useRef } from "react";
import { AudioInputText, AudioInputMargin } from "./style";
import { TitleContainer, BorderWrapper } from "../style";

interface IProps {
  title: string;
  placeholder: string;
}

const AudioInput: React.FC<React.PropsWithChildren<IProps>> = ({
  title,
  placeholder,
}) => {
  const inputRef = useRef<HTMLTextAreaElement>(null);

  return (
    <BorderWrapper>
      <AudioInputMargin>
        <TitleContainer>{title}</TitleContainer>
        <AudioInputText ref={inputRef} placeholder={placeholder} />
      </AudioInputMargin>
    </BorderWrapper>
  );
};

export default AudioInput;
