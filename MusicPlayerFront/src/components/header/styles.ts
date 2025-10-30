import styled from "styled-components";
import { IoMdMusicalNotes } from "react-icons/io";

export const HeaderTitleContainer = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const MusicIcon = styled(IoMdMusicalNotes)`
  font-size: 2.2rem;
  min-width: 50px;
  min-height: 50px;
  width: 5%;

  @media (max-width: 769px) {
    width: 100vw;
  }
`;

export const HeaderWrapper = styled.header`
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  padding: 2rem 0 2rem 0;
  color: #333;

  @media (max-width: 769px) {
    padding: 1rem 0 1rem 0;
  }

  h1 {
    font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
    font-size: 2rem;
    margin-bottom: 0.5rem;

    @media (max-width: 769px) {
      display: none;
    }
  }

  h2 {
    font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
    font-size: 1.2rem;
    font-weight: 400;
    color: #555;

    @media (max-width: 769px) {
      display: none;
    }
  }
`;
