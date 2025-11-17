import { useContext } from "react";
import { AlertContext } from "../context/AlertContext";

interface AlertContextType {
  isAlertOpen: boolean;
  alertType: "error" | "success" | "other";
  message: string;
  setAlert: (message: string, alertType: "error" | "success" | "other") => void;
  closeAlert: () => void;
}
// Hook para acessar o contexto de alerta
export const useAlert = (): AlertContextType => {
  const context = useContext(AlertContext);
  if (!context) {
    throw new Error("useAlert must be used within an AlertProvider");
  }
  return context;
};
