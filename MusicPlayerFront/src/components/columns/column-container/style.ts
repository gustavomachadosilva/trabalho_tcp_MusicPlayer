import styled from "styled-components";

export const ColumnContainerWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100%;
  height: 75%;

  @media (max-width: 769px) {
    height: 200vh;
  }
`;

export const ColumnContaineSideHolder = styled.div`
  display: flex;
  justify-content: space-between;
  width: 81%;
  height: 100%;

  @media (max-width: 769px) {
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
  }
`;
