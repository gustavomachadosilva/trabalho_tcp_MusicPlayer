import React from "react";
import { HeaderTitleContainer, HeaderWrapper, MusicIcon } from "./styles";
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
        <h1>{title ? title : children}</h1>
      </HeaderTitleContainer>
      {subtitle && <h2>{subtitle}</h2>}
    </HeaderWrapper>
  );
};

export default Header;
