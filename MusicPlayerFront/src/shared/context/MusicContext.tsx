import React, { createContext, useState } from "react";
import {
  AudioService,
  type IGeneratedAudioResponse,
} from "../services/api/audio/Audio";
import type { IResultOfAction } from "../services/interceptors";

type MusicContextType = {
  text: string;
  bpm: number;
  octave: number;
  volume: number;
  isMusicAvailable: boolean;
  musicInfo: IGeneratedAudioResponse;
  setIsMusicAvailable: (value: boolean) => void;
  setText: (value: string) => void;
  setBpm: (value: number) => void;
  setOctave: (value: number) => void;
  setVolume: (value: number) => void;
  postGeneratedMusic: () => Promise<IResultOfAction<IGeneratedAudioResponse>>;
};

// eslint-disable-next-line react-refresh/only-export-components
export const MusicContext = createContext<MusicContextType>(
  {} as MusicContextType
);

export const MusicProvider: React.FC<{ children: React.ReactNode }> = ({
  children,
}) => {
  const [text, setText] = useState<string>("");
  const [bpm, setBpm] = useState<number>(120);
  const [octave, setOctave] = useState<number>(4);
  const [volume, setVolume] = useState<number>(80);
  const [isMusicAvailable, setIsMusicAvailable] = useState<boolean>(false);
  const [musicInfo, setMusicInfo] = useState({} as IGeneratedAudioResponse);
  const { postAudio } = AudioService;

  const postGeneratedMusic = async () => {
    const request = await postAudio({
      input: text,
      bpm: bpm,
      octave: octave,
      volume: volume,
    });

    if (request.success) {
      setIsMusicAvailable(true);
      setMusicInfo(request.data);
      return request;
    }

    setMusicInfo({} as IGeneratedAudioResponse);

    return request;
  };

  return (
    <MusicContext.Provider
      value={{
        isMusicAvailable,
        text,
        bpm,
        octave,
        volume,
        musicInfo,
        setIsMusicAvailable,
        setText,
        setBpm,
        setOctave,
        setVolume,
        postGeneratedMusic,
      }}
    >
      {children}
    </MusicContext.Provider>
  );
};
