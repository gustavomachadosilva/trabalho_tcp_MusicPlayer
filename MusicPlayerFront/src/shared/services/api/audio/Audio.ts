import { Api } from "../../axios-config";
import { type IResultOfAction } from "../../interceptors";

interface IGenerateAudioRequest {
  input: string;
  bpm: number;
  volume: number;
  octave: number;
}

const postAudio = async (
  data: IGenerateAudioRequest
): Promise<IResultOfAction<string>> => {
  try {
    const request = await Api().post("audio", data, {
      headers: {
        "Content-Type": "application/json",
      },
    });

    const response: IResultOfAction<string> = {
      success: true,
      message: "Áudio gerado com sucesso!",
      data: request.data,
    };
    
    return response;
  } catch (error) {
    return error as IResultOfAction<string>;
  }
};

export const AudioService = {
  postAudio,
};
