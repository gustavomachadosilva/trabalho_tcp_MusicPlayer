// No seu componente Alert.tsx (ou similar)
import { useAlert } from "../../shared/hook/useAlert";
import {
  AlertBox,
  AlertMessage,
  AlertErrorIcon,
  AlertSuccessIcon,
  AlertOtherIcon,
  AlertExit,
} from "./style";

const Alert = () => {
  const { isAlertOpen, alertType, message, closeAlert, isClosing} = useAlert();

  if (!isAlertOpen) return null;

  const getIcon = () => {
    switch (alertType) {
      case "error":
        return <AlertErrorIcon />;
      case "success":
        return <AlertSuccessIcon />;
      case "other":
        return <AlertOtherIcon />;
    }
  };

  return (
    <AlertBox alertType={alertType} className={isClosing ? "fade-out" : "fade-in"}>
      {getIcon()}
      <AlertMessage alertType={alertType}>{message}</AlertMessage>
      <AlertExit onClick={closeAlert} />
    </AlertBox>
  );
};

export default Alert;
