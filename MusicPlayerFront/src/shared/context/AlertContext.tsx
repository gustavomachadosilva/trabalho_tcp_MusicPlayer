import React, { createContext, useState } from "react";

interface AlertContextType {
  isAlertOpen: boolean;
  alertType: "error" | "success" | "other";
  message: string;
  setAlert: (message: string, alertType: "error" | "success" | "other") => void;
  closeAlert: () => void;
}

// eslint-disable-next-line react-refresh/only-export-components
export const AlertContext = createContext<AlertContextType>(
  {} as AlertContextType
);

// Provider para o AlertContext
export const AlertProvider: React.FC<React.PropsWithChildren> = ({
  children,
}) => {
  const [isAlertOpen, setIsAlertOpen] = useState(false);
  const [alertType, setAlertType] = useState<"error" | "success" | "other">(
    "error"
  );
  const [message, setMessage] = useState("");

  // Função para definir o alerta
  const setAlert = (
    message: string,
    alertType: "error" | "success" | "other"
  ) => {
    setMessage(message);
    setAlertType(alertType);
    setIsAlertOpen(true);
  };

  // Função para fechar o alerta
  const closeAlert = () => {
    setIsAlertOpen(false);
  };

  return (
    <AlertContext.Provider
      value={{ isAlertOpen, alertType, message, setAlert, closeAlert }}
    >
      {children}
    </AlertContext.Provider>
  );
};
