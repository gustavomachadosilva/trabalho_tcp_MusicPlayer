import { useContext } from "react";
import { MusicContext } from "../context/MusicContext";
import type { IResultOfAction } from "../services/interceptors";

type MusicContextType = {
  text: string;
  bpm: number;
  octave: number;
  volume: number;
  isMusicAvailable: boolean;
  setIsMusicAvailable: (value: boolean) => void;
  setText: (value: string) => void;
  setBpm: (value: number) => void;
  setOctave: (value: number) => void;
  setVolume: (value: number) => void;
  postGeneratedMusic: () => Promise<IResultOfAction<string>>;
};

export const useMusic = (): MusicContextType => {
  const context = useContext(MusicContext);
  if (!context) {
    throw new Error("useMusic must be used within MusicProvider");
  }

  return context;
};
