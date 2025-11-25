import MusicData from "../../music-data/MusicData";
import { BorderWrapper } from "../../style";
import { ColumnRightWrapper } from "./style";


const ColumnRight = () => {
  return (
    <ColumnRightWrapper>
      <BorderWrapper>
        <MusicData />

      </BorderWrapper>
    </ColumnRightWrapper>
  );
};

export default ColumnRight;
