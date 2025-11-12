import React, { useState } from "react";
import { AudioInputText, AudioInputMargin, TitleHeader } from "./style";
import { TitleContainer, BorderWrapper } from "../style";
import FileUploader from "../file-uploader/FileUploader";

interface IProps {
  title: string;
  placeholder: string;
}

const AudioInput: React.FC<React.PropsWithChildren<IProps>> = ({
  title,
  placeholder,
}) => {
  const [fileContent, setFileContent] = useState("");

  return (
    <BorderWrapper>
      <AudioInputMargin>
        <TitleHeader>
          <TitleContainer>{title}</TitleContainer>
          <FileUploader setFileContent={setFileContent} />
        </TitleHeader>
        <AudioInputText
          value={fileContent}
          onChange={(e) => setFileContent(e.target.value)}
          placeholder={placeholder}
        />
      </AudioInputMargin>
    </BorderWrapper>
  );
};

export default AudioInput;
