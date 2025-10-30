import styled from "styled-components";

export const AudioInputMargin = styled.div`
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 88%;
  margin-left: 6%;

`;

export const AudioInputText = styled.textarea`
  width: 100%;
  height: 70%;
  padding: 1rem;
  font-size: 1rem;
  font-family: system-ui, sans-serif;
  line-height: 1.4;
  color: #333;
  resize: none;
  border: 1px solid #ccc;
  border-radius: 6px;
  box-sizing: border-box;
  vertical-align: top; /* garante o texto no topo */
  text-align: left;
  outline: none;
  transition: border-color 0.2s ease;

  &::placeholder {
    color: #888;
  }

  &:focus {
    border-color: #0077ff;
  }
`;
