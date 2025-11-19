import MusicData from "../../music-data/MusicData";
import { BorderWrapper } from "../../style";
import { ColumnRightWrapper, MusicOptionsToggle } from "./style";


const ColumnRight = () => {
  return (
    <ColumnRightWrapper>
      <MusicOptionsToggle />
      <BorderWrapper>
        <MusicData />

      </BorderWrapper>
    </ColumnRightWrapper>
  );
};

export default ColumnRight;
