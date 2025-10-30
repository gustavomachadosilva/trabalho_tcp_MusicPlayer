import styled from "styled-components";

export const BorderWrapper = styled.div`
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;

  border: 1px solid rgba(3, 3, 3, 15%);
  border-radius: 8px;

  @media (max-width: 769px) {
    height: 100%;
  }
`;

export const TitleContainer = styled.h3`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-weight: normal;
`;

export const SelectElement = styled.select`
  width: 100%;
  padding: 10px 14px;
  border: 1px solid #d1d5db;
  border-radius: 10px;
  background-color: #eeeeeeff;
  color: #111827;
  font-size: 0.95rem;
  font-weight: 500;
  outline: none;
  transition: all 0.2s ease;

  &:hover {
    background-color: #f3f4f6;
  }

  &:focus {
    border-color: #0077ff;
    box-shadow: 0 0 0 3px rgba(99, 102, 241, 0.2);
    background-color: #fff;
  }
`;

export const OptionElement = styled.option`
  background-color: #fff;
  color: #111827;
`;

export const MediumLabel = styled.label`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-size: medium;
  font-weight: 500;
`;

export const SmallSpan = styled.span`
  font-family: system-ui, Avenir, Helvetica, Arial, sans-serif;
  font-size: small;
  font-weight: 400;
  color: #3d3d3dff;
`;

export const ButtonContainer = styled.div`
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 10%;
`;

export const Button = styled.button`
  width: 60%;
  height: 48px;
  background: #030314;
  color: #ffffff;
  border: none;
  border-radius: 12px;
  font-size: 1rem;
  font-weight: 600;

  display: flex;
  align-items: center;
  justify-content: center;
  gap: 8px;

  cursor: pointer;
  transition: all 0.2s ease;

  svg {
    font-size: 1.1rem;
  }

  &:hover {
    background: #0a0a18;
    transform: translateY(-1px);
  }

  &:active {
    background: #000000;
    transform: translateY(0);
  }
`;
