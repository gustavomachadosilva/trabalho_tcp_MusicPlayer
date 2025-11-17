import type React from "react";
import {
  AlertBox,
  AlertErrorIcon,
  AlertExit,
  AlertMessage,
  AlertOtherIcon,
  AlertSuccessIcon,
} from "./style";
import { useAlert } from "../../shared/hook/useAlert";

interface IProps {
  message?: string;
  alertType?: "error" | "success" | "other";
}

const Alert: React.FC<IProps> = ({ message, alertType }) => {
  const {
    isAlertOpen,
    alertType: globalAlertType,
    message: globalMessage,
    closeAlert,
  } = useAlert();

  // Usa a mensagem e o tipo de alerta das props, se fornecido, ou do contexto se não
  const currentMessage = message || globalMessage;
  const currentAlertType = alertType || globalAlertType;

  const getIcon = (alertType: "error" | "success" | "other") => {
    switch (alertType) {
      case "error":
        return <AlertErrorIcon />;
      case "success":
        return <AlertSuccessIcon />;
      case "other":
        return <AlertOtherIcon />;
      default:
        return <AlertOtherIcon />;
    }
  };

  return (
    <>
      {isAlertOpen && (
        <AlertBox alertType={currentAlertType}>
          {getIcon(currentAlertType)}
          <AlertMessage alertType={currentAlertType}>
            {currentMessage}
          </AlertMessage>
          <AlertExit onClick={closeAlert} />
        </AlertBox>
      )}
    </>
  );
};

export default Alert;
