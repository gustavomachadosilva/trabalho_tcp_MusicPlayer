import styled from "styled-components";
import { LuMusic2 } from "react-icons/lu";

export const MusicDataIcon = styled(LuMusic2)`
  font-size: 0.5rem;
  font-weight: 100;
  min-width: 20px;
  min-height: 20px;
  width: 5%;
  background-color: transparent;
  color: black;
  margin-right: 0.2rem;
`;

export const TitleHeader = styled.span`
  display: flex;
  justify-content: start;
  align-items: center;
  width: 100%;
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
