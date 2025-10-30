import ColumnLeft from "../column-left/ColumnLeft";
import ColumnRight from "../column-right/ColumnRight";
import { ColumnContainerWrapper, ColumnContaineSideHolder } from "./style";

const ColumnContainer = () => {
  return (
    <ColumnContainerWrapper>
      <ColumnContaineSideHolder>
        <ColumnLeft />
        <ColumnRight />
      </ColumnContaineSideHolder>
    </ColumnContainerWrapper>
  );
};

export default ColumnContainer;
