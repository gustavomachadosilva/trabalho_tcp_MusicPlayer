import styled from "styled-components";
import { GoGear } from "react-icons/go";

export const MusicDetailsWrapper = styled.div`
  height: 100%;
  width: 100%;
`;
export const MusicDetailsTitleContainer = styled.div`
  display: flex;
  align-items: center;
`;

export const GearIcon = styled(GoGear)`
  font-size: 2rem;
  min-width: 10px;
  min-height: 10px;
  width: 5%;
  margin-right: 5px;
`;

export const MusicDetailsContainer = styled.div`
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 88%;
  margin-left: 6%;
`;


export const RangeInputContainer = styled.div`
  display: flex;
  flex-direction: column;
  width: 100%;
  min-height: 18%;
  margin-bottom: 1rem;
`;

export const RangeInformationContainer = styled.div`
  display: flex;
  justify-content: space-between;
  width: 100%;
`;



export const RangeInput = styled.input.attrs({ type: "range" })`
  width: 100%;
  accent-color: #ff0000;
  margin: 10px 0;
  appearance: none;
  height: 6px;
  border-radius: 4px;
  background: #e5e7eb;
  outline: none;
  cursor: pointer;

  &::-webkit-slider-runnable-track {
    background: #000;
    height: 6px;
    border-radius: 4px;
  }

  &::-webkit-slider-thumb {
    appearance: none;
    width: 16px;
    height: 16px;

    background: #e5e7eb;
    border-radius: 50%;
    border: 1px solid black;
    cursor: pointer;
    margin-top: -5px;
    transition: transform 0.1s ease;
  }

  &::-webkit-slider-thumb:hover {
    transform: scale(1.1);
  }
`;
