import { Api } from "../../axios-config";
import { type IResultOfAction } from "../../interceptors";

export interface IGenerateAudioRequest {
  input: string;
  bpm: number;
  volume: number;
  octave: number;
}

export interface ILogRegisterResponse {
  instrument: string;
  note: string;
  octave: number;
}

export interface IGeneratedAudioResponse {
  duration: number;
  logRegister: ILogRegisterResponse[];
  midi: string;
  numNotes: number;
  numPauses: number;
}

const postAudio = async (
  data: IGenerateAudioRequest
): Promise<IResultOfAction<IGeneratedAudioResponse>> => {
  try {
    const request = await Api().post("audio", data, {
      headers: {
        "Content-Type": "application/json",
      },
    });

    const response: IResultOfAction<IGeneratedAudioResponse> = {
      success: true,
      message: "Áudio gerado com sucesso!",
      data: request.data,
    };

    return response;
  } catch (error) {
    return error as IResultOfAction<IGeneratedAudioResponse>;
  }
};

export const AudioService = {
  postAudio,
};
