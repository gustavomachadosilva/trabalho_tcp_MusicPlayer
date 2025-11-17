import { type ChangeEvent } from "react";
import { FileUploaderContainer, UploadButton, UploadIcon } from "./style";
import { useAlert } from "../../shared/hook/useAlert";

interface IProps {
  setFileContent: (value: string) => void;
  buttonText?: string;
}

const FileUploader: React.FC<React.PropsWithChildren<IProps>> = ({
  setFileContent,
  buttonText,
}) => {
  const { setAlert, closeAlert } = useAlert();

  const handleFileUpload = (event: ChangeEvent<HTMLInputElement>) => {
    const inputEl = event.currentTarget;
    const file = inputEl.files?.[0];

    if (file && file.type === "text/plain") {
      const reader = new FileReader();
      reader.onload = () => {
        const content = reader.result as string;
        setFileContent("");
        setTimeout(() => setFileContent(content), 0);

        setAlert("Arquivo indexado com sucesso!", "success");
        inputEl.value = "";
      };
      reader.readAsText(file);
    } else {
      setAlert("Por favor, envie um arquivo de texto (.txt)", "error");
      inputEl.value = "";
    }
  };

  const handleFileExplorerPopUp = () => {
    closeAlert();
    const el = document.getElementById("fileInput") as HTMLInputElement | null;
    if (el) el.value = "";
    el?.click();
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
