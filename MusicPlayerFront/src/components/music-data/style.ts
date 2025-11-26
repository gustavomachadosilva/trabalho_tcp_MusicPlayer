import styled from "styled-components";
import { LuMusic2, LuInfo } from "react-icons/lu";

export const MusicDataIcon = styled(LuMusic2)`
  font-size: 0.5rem;
  font-weight: 100;
  min-width: 20px;
  min-height: 20px;
  background-color: transparent;
  color: black;
  margin-right: 0.5rem;
`;

export const MusicInfoIcon = styled(LuInfo)`
  font-size: 0.5rem;
  font-weight: 100;
  min-width: 20px;
  min-height: 20px;
  background-color: transparent;
  color: black;
  margin-right: 0.5rem;
`;

export const TitleGeneratedMusicContainer = styled.span`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: large;
`;

export const TitleHeader = styled.div<{
  marginTop?: string;
}>`
  display: flex;
  justify-content: start;
  align-items: center;
  width: 100%;
  margin-top: ${({ marginTop }) => marginTop || "0px"};
`;

export const NoDataFoundWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 100%;
`;

export const NoDataFoundContainer = styled.div`
  /* background-color: red; */
  width: 100%;
  height: 70%;
  display: flex;
  align-items: center;
  /* justify-content: center; */
  flex-direction: column;

  @media (max-width: 769px) {
    width: 80%;
  }
`;

export const NoDataFoundIcon = styled(LuMusic2)`
  font-size: 0.5rem;
  font-weight: 100;
  min-width: 50px;
  min-height: 50px;
  width: 5%;
  background-color: transparent;
  color: rgba(183, 183, 183, 1);
  margin-right: 0.2rem;
  margin-bottom: 1rem;
`;

export const NoDataFoundTitle = styled.span`
  text-align: center;
  color: rgba(183, 183, 183, 1);
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: 1.2rem;
`;

export const NoDataFoundSubtitle = styled.span`
  text-align: center;
  color: rgba(183, 183, 183, 1);
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: 1rem;
`;

export const SubtitleMusicInfoContainer = styled.div`
  display: flex;
  width: 100%;
  height: 4%;
  /* background-color: red; */
`;

export const SubtitleMusicInfo = styled.div`
  display: flex;
  align-items: center;
  color: rgba(136, 136, 136, 1);
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: 1rem;
  margin-right: 1rem;

  span {
    padding-left: 0.3rem;
  }
`;

export const GeneratedMusicLogWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  margin-top: 1rem;
  height: 10%;
  width: 100%;
`;

export const GeneratedMusicLogContainer = styled.div`
  display: flex;
  flex-direction: column;
  text-align: center;
  align-items: center;
  justify-content: center;
  width: 14%;
  height: 80%;
`;

export const GeneratedMusicLogData = styled.span`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: x-large;
`;

export const GeneratedMusicLogSubtitle = styled.span`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: small;
`;

export const NotesDetailsContainer = styled.div`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: 600;
  font-size: large;
  margin-top: 0.5rem;
  display: flex;
  flex-direction: column;
  max-height: 400px;
  overflow-y: auto;
  padding-right: 0.5rem;

  &::-webkit-scrollbar {
    width: 6px;
  }

  &::-webkit-scrollbar-track {
    background: transparent;
  }

  &::-webkit-scrollbar-thumb {
    background: #ccc;
    border-radius: 3px;

    &:hover {
      background: #999;
    }
  }
`;

export const NoteDetailItem = styled.div`
  margin-top: 0.5rem;
  display: flex;
  align-items: center;
  gap: 1rem;
  min-height: 70px;
  padding: 0.75rem 1rem;
  background: #f5f5f5;
  border-radius: 0.5rem;
  border: 1px solid #e0e0e0;
  transition: all 0.2s ease;

  &:hover {
    background: #f0f0f0;
    border-color: #d0d0d0;
  }
`;

export const NoteLabel = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 60px;
  height: 30px;
  background: #000;
  color: #fff;
  font-weight: bold;
  font-size: 0.8rem;
  border-radius: 0.37rem;
`;

export const NoteInfo = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  flex: 1;
  gap: 1rem;
`;

export const NoteText = styled.span`
  font-size: 1rem;
  color: #999;
  min-width: 30px;
`;

export const NoteMetrics = styled.div`
  display: flex;
  justify-content: space-around;

  @media (min-width: 769px) {
    justify-content: space-between;
    gap: 2rem;
    flex: 1;
  }

  span {
    font-size: 0.875rem;
    color: #666;
    text-align: center;
    /* &:last-child {
      text-align: right;
    } */
  }
`;

export const MusicOptionsToggle = styled.div`
  position: absolute;
  right: 10px;
  top: 1rem;

  min-width: 60px;
  min-height: 50px;

  display: flex;
  align-items: center;
  justify-content: center;

  .icon {
    font-size: 35px;
    cursor: pointer;
  }
`;

export const AudioPlayer = styled.audio`
  width: 100%; 
  height: 60px;
  zoom: 1.3; 
  border-radius: 8px;
  margin-bottom: 0.5rem;
`;

export const MusicLogAndButtonSpaceBetween = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  width: 100%;
  height: 100%;
`

export const DownloadAndPlayerContainer = styled.div`
  padding-bottom: 2rem;
  height: 30%;
  display: flex;
  flex-direction: column;
  justify-content: start;

`
export const GuideContainer = styled.div`
  padding-top: 20px;
  display: flex;
  flex-direction: column;
  height: 90%;
  width: 100%;
  border-left: 1px solid #e5e5e5;
  background: #fafafa;
`;

export const GuideScrollArea = styled.div`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: large;
  flex: 1;
  overflow-y: auto;
`;

export const GuideSection = styled.div`
  margin-bottom: 28px;
`;

export const GuideTitle = styled.h3`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: large;
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 18px;
  margin-bottom: 10px;
`;


export const GuideCodeBox = styled.pre`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: large;
  background: #fff;
  padding: 15px;
  border: 1px solid #c9c9c9;
  overflow-x: auto;
  border-radius: 8px;
`;

export const GuideItemContainer = styled.div`
  display: flex;
  align-items: center;
  margin-bottom: 10px;
`;
export const GuideItemBlock = styled.div<{ width?: string }>`
  display: flex;
  align-items: center;
  justify-content: center;
  min-width: 25px;
  min-height: 25px;

  width: ${({ width }) => (width ? width : "")};

  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: bolder;
  font-size: medium;
  border: 1px solid black;
  border-radius: 6px;
`;

export const GuideItemInfoText = styled.span`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
  font-size: medium;
  margin-left: 40px;
`;