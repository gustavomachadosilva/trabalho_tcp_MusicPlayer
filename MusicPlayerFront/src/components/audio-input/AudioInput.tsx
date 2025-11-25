import React, { useState } from "react";
import { AudioInputText, DefaultMargin, TitleAudioHeader } from "./style";
import { TitleContainer, BorderWrapper } from "../style";
import FileUploader from "../file-uploader/FileUploader";

interface IProps {
  title: string;
  placeholder: string;
  setTypedMusic: (value: string) => void;
}

const AudioInput: React.FC<React.PropsWithChildren<IProps>> = ({
  title,
  placeholder,
  setTypedMusic,
}) => {
  const [fileContent, setFileContent] = useState("");

  const updateMusic = (value: string) => {
    setFileContent(value);
    setTypedMusic(value);
  };

  return (
    <BorderWrapper>
      <DefaultMargin>
        <TitleAudioHeader>
          <TitleContainer>{title}</TitleContainer>
          <FileUploader setFileContent={updateMusic} />
        </TitleAudioHeader>
        <AudioInputText
          value={fileContent}
          onChange={(e) => setFileContent(e.target.value)}
          onBlur={() => setTypedMusic(fileContent)} 
          placeholder={placeholder}
        />
      </DefaultMargin>
    </BorderWrapper>
  );
};

export default AudioInput;
