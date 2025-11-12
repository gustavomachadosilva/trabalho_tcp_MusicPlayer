import styled, { keyframes } from "styled-components";
import { FaRegCheckCircle } from "react-icons/fa";
import { AiOutlineExclamationCircle } from "react-icons/ai";
import { MdError } from "react-icons/md";
import { GrFormClose } from "react-icons/gr";

const fadeIn = keyframes`
  0% {
    opacity: 0;
    transform: translateX(50px);
  }
  100% {
    opacity: 1;
    transform: translateX(0);
  }
`;

const fadeOut = keyframes`
  0% {
    opacity: 1;
    transform: translateX(0);
  }
  100% {
    opacity: 0;
    transform: translateX(50px);
  }
`;

export const AlertBox = styled.div<{
  alertType: "error" | "success" | "other";
}>`
  display: flex;
  align-items: center;
  position: fixed;
  top: 20px;
  right: 20px;
  min-width: 450px;
  max-width: 600px;
  min-height: 90px;
  background-color: ${({ alertType }) =>
    alertType === "error"
      ? "#ffdfe3"
      : alertType === "success"
      ? "#CEFFE7"
      : "#FDFFC6"};
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-size: small;

  animation: ${fadeIn} 0.5s ease-out;

  &.fade-out {
    animation: ${fadeOut} 0.5s ease-in forwards;
  }

  @media (max-width: 769px) {
    top: 10px;
    right: 10px;
    min-width: 50px;
    max-width: 300px;
  }
`;

export const AlertMessage = styled.span<{
  alertType: "error" | "success" | "other";
}>`
  margin-left: 0.5rem;
  width: 80%;
  color: ${({ alertType }) =>
    alertType === "error"
      ? "#c0071f"
      : alertType === "success"
      ? "#0A8846"
      : "#A57124"};
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-size: 20px;
  font-weight: 600;

  max-height: 60px;
  overflow-y: auto;
  word-wrap: break-word;

  @media (max-width: 769px) {
    max-height: 60px;
    overflow-y: none;
    word-wrap: break-word;
  }

  &::-webkit-scrollbar {
    width: 8px;
  }

  &::-webkit-scrollbar-track {
    background-color: #f1f1f1;
    border-radius: 10px;
  }

  &::-webkit-scrollbar-thumb {
    background-color: ${({ alertType }) =>
      alertType === "error"
        ? "#fe0142"
        : alertType === "success"
        ? "#18cb6d"
        : "#e6bc36"};
    border-radius: 10px;
    border: 2px solid #f1f1f1;
  }

  &::-webkit-scrollbar-thumb:hover {
    cursor: grab;
    background-color: ${({ alertType }) =>
      alertType === "error"
        ? "#c0071f"
        : alertType === "success"
        ? "#0A8846"
        : "#A57124"};
  }
`;

export const AlertErrorIcon = styled(MdError)`
  margin-left: 0.5rem;
  color: #fe0142;
  width: 40px;
  height: 40px;
`;

export const AlertSuccessIcon = styled(FaRegCheckCircle)`
  margin-left: 0.5rem;
  color: #18cb6d;
  width: 40px;
  height: 40px;
`;

export const AlertOtherIcon = styled(AiOutlineExclamationCircle)`
  margin-left: 0.5rem;
  color: #e6bc36;
  width: 40px;
  height: 40px;
`;

export const AlertExit = styled(GrFormClose)`
  position: absolute;
  top: 10px;
  right: 8px;
  font-size: 35px;
  color: #494b52ff;
  cursor: pointer;

  transition: color 0.3s ease;
  &:hover {
    color: #c0071f;
  }

  @media (max-width: 769px) {
    top: 5px;
    right: 5px;
  }
`;
