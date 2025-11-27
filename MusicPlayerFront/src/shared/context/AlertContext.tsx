import React, { createContext, useState, useEffect, useRef } from "react";

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

  const autoCloseTimer = useRef<number | null>(null);
  const animationTimer = useRef<number | null>(null);

  const clearTimers = () => {
    if (autoCloseTimer.current) {
      window.clearTimeout(autoCloseTimer.current);
      autoCloseTimer.current = null;
    }
    if (animationTimer.current) {
      window.clearTimeout(animationTimer.current);
      animationTimer.current = null;
    }
  };

  const scheduleClose = (delay = 5000) => {
    clearTimers();
    autoCloseTimer.current = window.setTimeout(() => {
      setIsClosing(true);
      animationTimer.current = window.setTimeout(() => {
        setIsAlertOpen(false);
        setIsClosing(false);
        animationTimer.current = null;
      }, 500);
      autoCloseTimer.current = null;
    }, delay);
  };

  const closeAlert = () => {
    if (!isAlertOpen || isClosing) return;

    clearTimers();
    setIsClosing(true);
    animationTimer.current = window.setTimeout(() => {
      setIsAlertOpen(false);
      setIsClosing(false);
      animationTimer.current = null;
    }, 500);
  };

  const setAlert = (msg: string, type: "error" | "success" | "other") => {
    setMessage(msg);
    setAlertType(type);
    setIsAlertOpen(true);
    setIsClosing(false);

    scheduleClose(5000);
  };

  useEffect(() => {
    return () => clearTimers();
  }, []);
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
