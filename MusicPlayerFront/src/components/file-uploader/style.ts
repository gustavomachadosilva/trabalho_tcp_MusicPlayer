import styled from "styled-components";
import { MdDriveFolderUpload } from "react-icons/md";

export const FileUploaderContainer = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

export const UploadButton = styled.button`
  border: none;
  border-radius: 5px;
  cursor: pointer;
`;

export const UploadIcon = styled(MdDriveFolderUpload)`
  font-size: 0.5rem;
  font-weight: 100;
  min-width: 40px;
  min-height: 40px;
  width: 5%;
  background-color: transparent;
  color: black;
`;
