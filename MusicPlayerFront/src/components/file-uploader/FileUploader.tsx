import type { ChangeEvent } from "react";
import { FileUploaderContainer, UploadButton, UploadIcon } from "./style";

interface IProps {
  setFileContent: (value: string) => void;
  buttonText?: string;
}

const FileUploader: React.FC<React.PropsWithChildren<IProps>> = ({
  setFileContent,
  buttonText,
}) => {
  const handleFileUpload = (event: ChangeEvent<HTMLInputElement>) => {
    const file = event.currentTarget.files?.[0];
    if (file && file.type === "text/plain") {
      const reader = new FileReader();
      reader.onload = () => {
        setFileContent(reader.result as string);
      };
      reader.readAsText(file);
    } else {
      alert("Por favor, envie um arquivo de texto.");
    }
  };

  const handleFileExplorerPopUp = () => {
    document.getElementById("fileInput")?.click();
  };

  return (
    <FileUploaderContainer>
      <input
        type="file"
        accept=".txt"
        onChange={handleFileUpload}
        style={{ display: "none" }}
        id="fileInput"
      />
      <UploadButton onClick={() => handleFileExplorerPopUp()}>
        {buttonText ? buttonText : <UploadIcon />}
      </UploadButton>
    </FileUploaderContainer>
  );
};

export default FileUploader;
