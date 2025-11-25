import Header from "./header/Header";
import ColumnContainer from "./columns/column-container/ColumnContainer";
import { AlertProvider } from "../shared/context/AlertContext";
import Alert from "./alert/Alert";

const App = () => {
  return (
    <AlertProvider>
      <Alert />
      <Header
        subtitle="Digite um texto e converta-o em uma sequência de notas musicais usando parâmetros personalizáveis"
        children="Gerador de Música a partir de Texto"
      />

      <ColumnContainer />
    </AlertProvider>
  );
};

export default App;
