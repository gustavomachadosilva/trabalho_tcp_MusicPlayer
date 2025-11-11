import React, { useEffect, useRef, useState } from "react";
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
  const inputRef = useRef<HTMLTextAreaElement>(null);
  const [fileContent, setFileContent] = useState("");

  useEffect(() => {
    if (inputRef.current) {
      inputRef.current.value = fileContent;
    }
  }, [fileContent]);

  return (
    <BorderWrapper>
      <AudioInputMargin>
        <TitleHeader>
          <TitleContainer>{title}</TitleContainer>
          <FileUploader
            setFileContent={setFileContent}
          />
        </TitleHeader>
        <AudioInputText ref={inputRef} placeholder={placeholder} />
      </AudioInputMargin>
    </BorderWrapper>
  );
};

export default AudioInput;
