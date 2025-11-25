import React from "react";
import { HeaderTitleContainer, HeaderWrapper, MusicIcon, MusicTitle } from "./styles";
interface IProps {
  subtitle?: string;
  title?: string;
}

const Header: React.FC<React.PropsWithChildren<IProps>> = ({
  subtitle,
  title,
  children,
}) => {
  return (
    <HeaderWrapper>
      <HeaderTitleContainer>
        <MusicIcon />
        <MusicTitle>{title ? title : children}</MusicTitle>
      </HeaderTitleContainer>
      {subtitle && <h2>{subtitle}</h2>}
    </HeaderWrapper>
  );
};

export default Header;
