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
  const handleUpdateTypedMusic = () => {
    setTypedMusic(fileContent);
  };

  return (
    <BorderWrapper>
      <DefaultMargin>
        <TitleAudioHeader>
          <TitleContainer>{title}</TitleContainer>
          <FileUploader setFileContent={setFileContent} />
        </TitleAudioHeader>
        <AudioInputText
          onKeyDown={(e) => {
            if (e.key === "Enter") {
              // e.preventDefault();
            }
          }}
          onBlur={handleUpdateTypedMusic}
          value={fileContent}
          onChange={(e) => setFileContent(e.target.value)}
          placeholder={placeholder}
        />
      </DefaultMargin>
    </BorderWrapper>
  );
};

export default AudioInput;
