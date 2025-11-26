import React, { createContext, useState, useEffect } from "react";

interface AlertContextType {
  isAlertOpen: boolean;
  alertType: "error" | "success" | "other";
  message: string;
  setAlert: (message: string, alertType: "error" | "success" | "other") => void;
  closeAlert: () => void;
  isClosing: boolean;
}

// eslint-disable-next-line react-refresh/only-export-components
export const AlertContext = createContext<AlertContextType>(
  {} as AlertContextType
);

export const AlertProvider: React.FC<React.PropsWithChildren> = ({
  children,
}) => {
  const [isAlertOpen, setIsAlertOpen] = useState(false);
  const [isClosing, setIsClosing] = useState(false);
  const [alertType, setAlertType] = useState<"error" | "success" | "other">(
    "error"
  );
  const [message, setMessage] = useState("");

  const setAlert = (
    message: string,
    alertType: "error" | "success" | "other"
  ) => {
    setMessage(message);
    setAlertType(alertType);
    setIsAlertOpen(true);
    setIsClosing(false);
  };

  const closeAlert = () => {
    setIsClosing(true);
    setTimeout(() => {
      setIsAlertOpen(false);
      setIsClosing(true);
    }, 500);
  };

  useEffect(() => {
    if (isAlertOpen && !isClosing) {
      const timer = setTimeout(() => {
        closeAlert();
      }, 5000);

      return () => clearTimeout(timer);
    }
  }, [isAlertOpen, isClosing]);

  return (
    <AlertContext.Provider
      value={{
        isAlertOpen,
        alertType,
        message,
        setAlert,
        closeAlert,
        isClosing,
      }}
    >
      {children}
    </AlertContext.Provider>
  );
};